package br.com.helisson.resilientsdi.usersservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "app")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "app")
    private List<Report> reports;
}
