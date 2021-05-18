package br.com.helisson.resilientsdi.usersservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String name;

    @Column
    private String email;
}
