package com.kafka.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class EventMessage {

	private String UNLocationCode;
    private String carrierServiceCode;
    private String carrierVoyageNumber;
    private String delayReasonCode;
    private String eventClassifierCode;
    private String eventDateTime;

    private EventLocation eventLocation;
    private FacilitySMDGCode facilitySMDGCode;
    private String facilityTypeCode;
    private String modeOfTransport;
    private String operationsEventTypeCode;
    private String portCallServiceTypeCode;
    private Publisher publisher;
    private String publisherRole;
    private String remark;
    private TimestampId timestampId;
    private int transportCallSequenceNumber;
    private String vesselIMONumber;
    private VesselPosition vesselPosition;
	

}
