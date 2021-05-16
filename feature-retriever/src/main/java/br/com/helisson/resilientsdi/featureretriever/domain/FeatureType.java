package br.com.helisson.resilientsdi.featureretriever.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
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

    @Column
    private String serviceId;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private BigDecimal area;

    @Column
    private Integer featuresOfService;

    @Column
    private BigDecimal xMin;

    @Column
    private BigDecimal yMin;

    @Column
    private BigDecimal xMax;

    @Column
    private BigDecimal yMax;
}
