package org.hibernate.DTO;

import javax.persistence.Embeddable;

@Embeddable   // Used to embed this object in USerDetails object
public class Address {
    private String street;
    private String city;
    private String pincode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }


    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

}
