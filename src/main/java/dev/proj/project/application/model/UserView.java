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
        @NamedQuery(name = UserView.GET_DATA_BY_USERID, query = UserView.QUERY_GET_DATA_BY_USERID),

})
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_view")
public class UserView {

    public static final String GET_DATA_BY_USERID = "UserView.get_data_by_userid";
    public static final String QUERY_GET_DATA_BY_USERID = "select u from UserView u where u.userId = :id";

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "user_id")
    public int userId;

    @Column(name = "address_id")
    public int addressId;

    @Column(name = "home_id")
    public int homeId;

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

    @Column(name="area")
    private String area;

    @Column(name="price")
    private String price;

    @Column(name="type")
    private String type;

// definicja widoku:
//    CREATE VIEW user_view    AS
//    SELECT ROW_NUMBER() OVER(ORDER BY user_id) AS id, user.id as user_id,address.id as address_id, home.id as home_id,
//    address.street,address.house, address.flat, address.code, address.city,
//    home.area, home.price,home.type
//    FROM user,address,home
//    WHERE (user.id = address.user_id) AND (address.id = home.address_id)

}
