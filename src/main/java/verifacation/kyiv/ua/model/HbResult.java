package verifacation.kyiv.ua.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HB_RESULT")
public class HbResult extends GeneralId{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hbResult")
    private List<ClientCar> clientCars = new ArrayList<>();

    public HbResult() {
    }

    public HbResult(String type) {
        super(type);
    }
}