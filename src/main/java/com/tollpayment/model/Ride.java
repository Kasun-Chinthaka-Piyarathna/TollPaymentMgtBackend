package com.tollpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rides")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
    @Id
    private String rideId;
    private String userId;
    private String entryTime;
    private String exitTime;
    private double distance;
    private double speed;
    private double rideFee;
    private double fine;

}
