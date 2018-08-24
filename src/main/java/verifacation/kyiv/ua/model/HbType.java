package verifacation.kyiv.ua.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HB_TYPE")
public class HbType extends GeneralId {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hbResult")
    private List<ClientCar> clientCars = new ArrayList<>();

    public HbType() {
    }

    public HbType(String type) {
        super(type);
    }
}