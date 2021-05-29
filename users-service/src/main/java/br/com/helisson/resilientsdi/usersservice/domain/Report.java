package br.com.helisson.resilientsdi.usersservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn
    private App app;
}
