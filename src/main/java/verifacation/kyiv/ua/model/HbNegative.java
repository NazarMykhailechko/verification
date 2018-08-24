package verifacation.kyiv.ua.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HB_NEGATIVE")
public class HbNegative extends GeneralId {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hbNegative")
    private List<ClientCar> clientCars = new ArrayList<>();

    public HbNegative() {
    }

    public HbNegative(String type) {
        super(type);
    }

}