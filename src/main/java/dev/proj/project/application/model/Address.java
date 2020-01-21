package dev.proj.project.application.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = Address.GET_ADDRESSES, query = Address.QUERY_GET_ADDRESSES),
        @NamedQuery(name = Address.GET_ADDRESSES_BY_USERID, query = Address.QUERY_GET_ADDRESSES_BY_USERID),
})

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    public static final String GET_ADDRESSES_BY_USERID = "Addresses.get_addresses_by_userid";
    public static final String QUERY_GET_ADDRESSES_BY_USERID = "select a from Address a where a.user.id = :user_id";
    public static final String GET_ADDRESSES = "Address.get_addresses";
    public static final String QUERY_GET_ADDRESSES = "select a from Address a";


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name="street")
    private String street;

    @Column(name="house")
    private String house;

    @Column(name="flat")
    private String flat;

    @Column(name="code")
    private String code;

    @Column(name="city")
    private String city;

    @JoinColumn(name = "user_id",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToOne(mappedBy="address", cascade = CascadeType.MERGE)
    @JsonIgnore
    private Home home;
}
