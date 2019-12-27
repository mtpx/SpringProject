package dev.proj.project.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = User.GET_USER_BY_ID, query = User.QUERY_GET_USER_BY_ID),
        @NamedQuery(name = User.GET_USERS, query = User.QUERY_GET_USERS),
        @NamedQuery(name = User.CHECK_USER, query = User.QUERY_CHECK_USER),

        //@NamedQuery(name = "User.retriveUsers", query = "FROM User"),
        //@NamedQuery(name = "User.retriveUser", query = "FROM User WHERE id = :ID")
})
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    public static final String GET_USER_BY_ID = "User.get_user_by_id";
    public static final String QUERY_GET_USER_BY_ID = "select u from User u where u.id = :id";
    public static final String GET_USERS = "User.get_users";
    public static final String QUERY_GET_USERS = "select u from User u";
    public static final String CHECK_USER = "User.check_user";
    public static final String QUERY_CHECK_USER = "select u from User u where u.email = :email and u.password = :pass";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
