package com.example.shaleenslec.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAvailablePostsDTO {
    private String propertyId;
    private String title;
    private String shortDescription;
    private Date publishedDate;
    private String priorityType;
}
