package br.com.helisson.resilientsdi.usersservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "sdi_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FeatureResource> featureResources;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<App> apps;
}
