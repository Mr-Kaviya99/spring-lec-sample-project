package com.example.shaleenslec.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {

    private ArrayList keywords;
    private String shortDescription;
    private Date publishedDate;
    private String priorityType;
    private ArrayList sourceLinks;
    private ArrayList description;
    private String consumerType;
    private ArrayList otherData;
}
