package dev.proj.project.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamedQueries({
//        @NamedQuery(name = Address.GET_ADDRESS_BY_ID, query = Address.QUERY_GET_USER_BY_ID),
//        @NamedQuery(name = Address.GET_ADDRESS, query = Address.QUERY_GET_ADDRESS),

})
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

//    public static final String GET_USER_BY_ID = "User.get_user_by_id";
//    public static final String QUERY_GET_USER_BY_ID = "select u from User u where u.id = :id";
//    public static final String GET_USERS = "User.get_users";
//    public static final String QUERY_GET_USERS = "select u from User u";

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Column(name="street")
    private String street;

    @NotNull
    @Column(name="house")
    private String house;

    @NotNull
    @Column(name="flat")
    private String flat;

    @NotNull
    @Column(name="code")
    private String code;

    @NotNull
    @Column(name="city")
    private String city;

    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToOne(mappedBy="address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Home home;
}
