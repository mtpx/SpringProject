package dev.proj.project.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = Home.GET_HOME_BY_ID, query = Home.QUERY_GET_HOME_BY_ID),
//        @NamedQuery(name = Home.GET_USERS, query = Home.QUERY_GET_USERS),
//        @NamedQuery(name = Home.CHECK_USER, query = Home.QUERY_CHECK_USER),

})
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "home",uniqueConstraints = {@UniqueConstraint(columnNames = {"address_id"})})
public class Home {

    public static final String GET_HOME_BY_ID = "User.get_home_by_id";
    public static final String QUERY_GET_HOME_BY_ID = "select h from Home h where h.id = :id";
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
    private int price;

    @NotNull
    @Column(name="type")
    private String type;

    @JoinColumn(name = "address_id", unique = true)
    @OneToOne (cascade = CascadeType.MERGE)
    private Address address;
}
