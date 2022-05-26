package com.example.shaleenslec.dto;

import com.example.shaleenslec.enums.ConsumerType;
import com.example.shaleenslec.enums.PriorityTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String propertyId;
    private String title;
    private ArrayList keywords;
    private String shortDescription;
    private Date publishedDate;
    private PriorityTypes priorityType;
    private ArrayList sourceLinks;
    private ArrayList description;
    private ConsumerType consumerType;
    private boolean propertyAvailability;
    private ArrayList otherData;
}
