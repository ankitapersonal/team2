package com.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Address {

	private String city;
    private String country;
    private String floor;
    private String name;
    private String postCode;
    private String stateRegion;
    private String street;
    private String streetNumber;

}
