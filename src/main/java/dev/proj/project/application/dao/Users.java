package dev.proj.project.application.dao;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="FIRSTNAME")
    private String firstname;

    @Column(name="LASTNAME")
    private String lastname;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;
}
