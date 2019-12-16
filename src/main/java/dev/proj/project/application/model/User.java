package dev.proj.project.application.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@NamedQuery(name = "User.retriveUsers", query = "FROM User")
@NamedQuery(name = "User.retriveUser", query = "FROM User WHERE id = :ID")
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="FIRSTNAME")
    private String firstname;

    @Column(name="LASTNAME")
    private String lastname;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASS")
    private String password;
}
