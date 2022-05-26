package com.example.shaleenslec.entity;

import com.example.shaleenslec.enums.ConsumerType;
import com.example.shaleenslec.enums.PriorityTypes;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
@TypeDef(name = "json",typeClass = JsonStringType.class)
public class Post {
    @Id
    @Column(name = "propertyId",length = 45)
    private String propertyId;

    @Column(name = "title",length = 250)
    private String title;

    @Type(type = "json")
    @Column(name = "keywords",columnDefinition = "json")
    private ArrayList keywords;

    @Column(name = "short_description",length = 250)
    private String shortDescription;

    @Column(name = "published_date", columnDefinition = "DATETIME", nullable = false)
    private Date publishedDate;

    @Column(name = "priority_type", nullable = false)
    @NotNull(message = "Priority Type is Mandatory")
    @Enumerated(EnumType.STRING)
    private PriorityTypes priorityType;

    @Type(type = "json")
    @Column(name = "source_links",columnDefinition = "json")
    private ArrayList sourceLinks;

    @Type(type = "json")
    @Column(name = "description",columnDefinition = "json")
    private ArrayList description;

    @Column(name = "consumer_type", nullable = false)
    @NotNull(message = "Consumer Type is Mandatory")
    @Enumerated(EnumType.STRING)
    private ConsumerType consumerType;

    @Column(name = "property_availability", columnDefinition = "TINYINT", nullable = false)
    private boolean propertyAvailability;

    @Type(type = "json")
    @Column(name = "other_data",columnDefinition = "json")
    private ArrayList otherData;
}
