package br.com.helisson.servicefinder.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Service {
    @Id
    private String id;

    @Column
    private String wfsUrl;

    @Column
    private String wmsUrl;

    @Column
    private String serviceProcessed;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String publisher;

    @Column
    private String registerId;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private BigDecimal area;

    @Column
    private BigDecimal xMin;

    @Column
    private BigDecimal yMin;

    @Column
    private BigDecimal xMax;

    @Column
    private BigDecimal yMax;

    @OneToMany(mappedBy = "service")
    private List<FeatureType> features;
}
