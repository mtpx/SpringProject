package dev.proj.project.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
//        @NamedQuery(name = Home.GET_USER_BY_ID, query = Home.QUERY_GET_USER_BY_ID),
//        @NamedQuery(name = Home.GET_USERS, query = Home.QUERY_GET_USERS),
//        @NamedQuery(name = Home.CHECK_USER, query = Home.QUERY_CHECK_USER),

})
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "home")
public class Home {

//    public static final String GET_USER_BY_ID = "User.get_user_by_id";
//    public static final String QUERY_GET_USER_BY_ID = "select u from User u where u.id = :id";
//    public static final String GET_USERS = "User.get_users";
//    public static final String QUERY_GET_USERS = "select u from User u";
//    public static final String CHECK_USER = "User.check_user";
//    public static final String QUERY_CHECK_USER = "select u from User u where u.email = :email and u.password = :password";

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Column(name="area")
    private String area;

    @NotNull
    @Column(name="price")
    private String price;

    @NotNull
    @Column(name="type")
    private String type;

    @OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
