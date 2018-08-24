package verifacation.kyiv.ua.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User extends GeneralId {

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ClientCar> clientCars = new ArrayList<>();

    public User() {
    }



    public User(String type, String password) {
        super(type);
        this.password = password;
    }

    public User(String type) {
        super(type);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
