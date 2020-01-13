package dev.proj.project.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = User.GET_USER_BY_ID, query = User.QUERY_GET_USER_BY_ID),
        @NamedQuery(name = User.GET_USERS, query = User.QUERY_GET_USERS),
        @NamedQuery(name = User.CHECK_USER, query = User.QUERY_CHECK_USER),
})
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    public static final String GET_USER_BY_ID = "User.get_user_by_id";
    public static final String QUERY_GET_USER_BY_ID = "select u from User u where u.id = :id";
    public static final String GET_USERS = "User.get_users";
    public static final String QUERY_GET_USERS = "select u from User u";
    public static final String CHECK_USER = "User.check_user";
    public static final String QUERY_CHECK_USER = "select u from User u where u.email = :email and u.password = :password";

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int id;

    @NotNull
    @Column(name="firstname")
    private String firstname;

    @NotNull
    @Column(name="lastname")
    private String lastname;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> address;
}
