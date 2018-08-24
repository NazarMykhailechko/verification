package verifacation.kyiv.ua.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HB_CHECK_KB")
public class HbCheckKb extends GeneralId {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hbCheckKb")
    private List<ClientCar> clientCars = new ArrayList<>();

    public HbCheckKb() {
    }

    public HbCheckKb(String type) {
        super(type);
    }
}