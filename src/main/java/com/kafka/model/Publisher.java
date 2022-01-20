package com.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Publisher {
    private Address address;
    private List<Object> identifyingCodes;
    private String nmftaCode;
    private String partyName;
    private String publicKey;
    private String taxReference1;
    private String taxReference2;
}
