package br.com.helisson.servicefinder.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class FeatureType {
    @Id
    private String id;

    @Column
    private String title;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String keywords;

    @ManyToOne
    @JoinColumn
    private Service service;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private Double area;

    @Column(name = "features_of_service")
    private Integer featuresOfService;

    @Column(name = "x_min")
    private Double xMin;

    @Column(name = "y_min")
    private Double yMin;

    @Column(name = "x_max")
    private Double xMax;

    @Column(name = "y_max")
    private Double yMax;
}
