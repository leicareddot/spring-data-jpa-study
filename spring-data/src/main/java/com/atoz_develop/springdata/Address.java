package com.atoz_develop.springdata;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    //@Column
    private String street;

    //@Column
    private String city;

    //@Column
    private String state;

    //@Column
    private String zipCode;
}
