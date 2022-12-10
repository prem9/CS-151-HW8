package com.example;

/**
 * Address class sets up Address for Person
 * @author  Prem Agarwal
 * @version 1.0
 * @since   10/3/2022
 */
public class Address
{
    private int streetNum;
    private String streetName;
    private String city;
    private String zip;
    private String state;
    public Address(int streetNum, String streetName, String city, String zip, String state)
    {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.zip = zip;
        this.state = state;

    }
    /**
     * @param streetNumSet sets the streetNum
     */
    public void setStreetNum(int streetNumSet)
    {
        streetNum = streetNumSet;
    }
    /**
     * @return retrieves streetNum
     */
    public int getStreetNum()
    {
        return streetNum;
    }
    /**
     * @param streetNameSet sets streetName
     */
    public void setStreetName(String streetNameSet)
    {
        streetName = streetNameSet;
    }
    /**
     * @return retrieves Street Name
     */
    public String getStreetName()
    {
        return streetName;
    }
    /**
     * @param citySet sets city
     */
    public void setCity(String citySet)
    {
        city = citySet;
    }
    /**
     * @return retrieves city
     */
    public String getCity()
    {
        return city;
    }
    /**
     * @param zipSet sets zip
     */
    public void setZip(String zipSet)
    {
        zip = zipSet;
    }
    /**
     * @return retrieves zip
     */
    public String getZip()
    {
        return zip;
    }
    /**
     * @param stateSet sets state
     */
    public void setState(String stateSet)
    {
        state = stateSet;
    }
    /**
     * @return retrieves state
     */
    public String getState()
    {
        return state;
    }
    /**
     * @return string of all info in address
     */
    public String toString()
    {
        String addressInfo =  streetNum +" " + streetName + " " + city + " " + state + " " + zip;
        return addressInfo;
    }
    
    
}

