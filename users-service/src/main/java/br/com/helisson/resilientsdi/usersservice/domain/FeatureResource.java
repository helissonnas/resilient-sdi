package br.com.helisson.resilientsdi.usersservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity(name = "feature_resource")
public class FeatureResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String feature;

    @Column(nullable = false)
    private Boolean enableReplacement;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private App app;
}
