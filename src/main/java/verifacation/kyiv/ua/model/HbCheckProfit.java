package verifacation.kyiv.ua.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HB_CHECK_PROFIT")
public class HbCheckProfit extends GeneralId {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hbCheckProfit")
    private List<ClientCar> clientCars = new ArrayList<>();

    public HbCheckProfit() {
    }

    public HbCheckProfit(String type) {
        super(type);
    }
}