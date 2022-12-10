package com.example;
import java.lang.reflect.*;

/**
 * Hello world!
 *
 */
public class ReflectionTest 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Person p1 = new Person();
        System.out.println( "Hello World!" );
        Class personClass = p1.getClass();
        //1. Print out all methods declared in class Person (notice, declared methods only), including the 
        //number of input parameters and all input parameter types. 
        System.out.println("\nPerson class declared methods.");
        Method[] personMethods = personClass.getDeclaredMethods();
        for (Method method: personMethods)
        {
             System.out.println(method.getName());
        }
        //2. 2. Print out all methods available to class Address (notice, all methods), including the number 
        //of input parameters and all input parameter types.
        System.out.println("\nAddress class all methods and parameters and parameter types.");
        Address a1 = new Address(0, null, null, null, null);
        Class addressClass = a1.getClass();
        Method[] addressMethods = addressClass.getMethods();
        for (Method method: addressMethods)
        {
            // System.out.println(method.toString());
             String methodName = method.getName();
             Class[] parameters = method.getParameterTypes();

             if (parameters.length == 0)
             {
                System.out.println(methodName+"() has 0 parameters.");  
             }
             else
             {
                System.out.println(methodName + "() has " + parameters.length + " parameter(s) of the following types:");
             }
             for (Class p : parameters)
             {
                System.out.println("\t" + p.getName());
             }
        }
        //3. Print out all fields declared in class Address (notice, declared fields only), including the 
        //access modifier and the type of the field. 
        Field[] addressFields = Address.class.getDeclaredFields();
        System.out.println("\n Address field names, access modifier and types");
        for(Field field: addressFields){
            System.out.println(field.toString());
        }
        //4. Instantiate 3 new instances of class Person. This should also involve instantiating the Address 
        //class using reflection
        Person Joe = new Person("Joe", "Smith", 46, "123456431", null, "Male", 134.0);
        Person Jim = new Person("Jim", "Dill", 23, "354361546", null, "male", 154.2);
        Person Margaret = new Person("Margaret", "Thatcher", 54, "23462367", null, "female", 128.3);
        Address joeAddress = new Address(2547, "Good Fellow Ave.", "San Jose", "95123", "california");
        Address jimAddress = new Address(2567, "1st Ave.", "San Jose", "95412", "california");
        Address marAddress = new Address(6835, "2nd Str.", "San Jose", "52356", "california");
        
        Class joeClass = Joe.getClass();
        Class jimClass = Jim.getClass();
        Class margClass = Margaret.getClass();

        try {
            Method setAddressMethod = joeClass.getDeclaredMethod("setAddress", Address.class);
            setAddressMethod.invoke(Joe, joeAddress);
            System.out.println("\n"+Joe.toString());  
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Warning: Problems invoking the method.");
        }

        try {
            Method setAddressMethod = jimClass.getDeclaredMethod("setAddress", Address.class);
            setAddressMethod.invoke(Jim, jimAddress);
            System.out.println("\n"+Jim.toString());  
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Warning: Problems invoking the method.");
        }

        try {
            Method setAddressMethod = margClass.getDeclaredMethod("setAddress", Address.class);
            setAddressMethod.invoke(Margaret, marAddress);
            System.out.println("\n"+Margaret.toString());  
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Warning: Problems invoking the method.");
        }

        //5. Use Java reflection to invoke setFirstName(), setLastName() and setAge() in one or more 
        //instance(s) of Person class. 

        try {
            Method setNameMethod = joeClass.getDeclaredMethod("setFirstName", String.class);
            setNameMethod.invoke(Joe, "Joshua");
            System.out.println("\n"+Joe.toString());  
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Warning: Problems invoking the method.");
        }

        try {
            Method setLnameMethod = jimClass.getDeclaredMethod("setLastName", String.class);
            setLnameMethod.invoke(Jim, "Dang");
            System.out.println("\n"+Jim.toString());  
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Warning: Problems invoking the method.");
        }

        try {
            Method setAgeMethod = margClass.getDeclaredMethod("setAge", int.class);
            setAgeMethod.invoke(Margaret, 53);
            System.out.println("\n"+Margaret.toString());  
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Warning: Problems invoking the method.");
        }
    }
}
