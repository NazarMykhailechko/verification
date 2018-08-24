package verifacation.kyiv.ua.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CLIENTS_CARS")
public class ClientCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "INN", nullable = false, length = 10)
    private String inn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NEG_ID", referencedColumnName = "id", nullable = false)
    private HbNegative hbNegative;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHECK_KB_ID", referencedColumnName = "id", nullable = false)
    private HbCheckKb hbCheckKb;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHECK_PROF_ID", referencedColumnName = "id", nullable = false)
    private HbCheckProfit hbCheckProfit;

    @Column(name = "COMMENTARY")
    private String commentary;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RESULT_ID", referencedColumnName = "id", nullable = false)
    private HbResult hbResult;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "id", nullable = false)
    private HbType hbType;

    @Column(name = "ENTRY_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    //@Type(type="date")
    private Date entryDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "id", nullable = false)
    private User user;

    public ClientCar() {
    }

    public ClientCar(String name, String inn, HbNegative hbNegative,
                     HbCheckKb hbCheckKb, HbCheckProfit hbCheckProfit,
                     String commentary, String description,
                     HbResult hbResult, HbType hbType, Date entryDate, User user) {
        this.name = name;
        this.inn = inn;
        this.hbNegative = hbNegative;
        this.hbCheckKb = hbCheckKb;
        this.hbCheckProfit = hbCheckProfit;
        this.commentary = commentary;
        this.description = description;
        this.hbResult = hbResult;
        this.hbType = hbType;
        this.entryDate = entryDate;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public HbNegative getHbNegative() {
        return hbNegative;
    }

    public void setHbNegative(HbNegative hbNegative) {
        this.hbNegative = hbNegative;
    }

    public HbCheckKb getHbCheckKb() {
        return hbCheckKb;
    }

    public void setHbCheckKb(HbCheckKb hbCheckKb) {
        this.hbCheckKb = hbCheckKb;
    }

    public HbCheckProfit getHbCheckProfit() {
        return hbCheckProfit;
    }

    public void setHbCheckProfit(HbCheckProfit hbCheckProfit) {
        this.hbCheckProfit = hbCheckProfit;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HbResult getHbResult() {
        return hbResult;
    }

    public void setHbResult(HbResult hbResult) {
        this.hbResult = hbResult;
    }

    public HbType getHbType() {
        return hbType;
    }

    public void setHbType(HbType hbType) {
        this.hbType = hbType;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ClientCar{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", hbNegative=" + hbNegative +
                ", hbCheckKb=" + hbCheckKb +
                ", hbCheckProfit=" + hbCheckProfit +
                ", commentary='" + commentary + '\'' +
                ", description='" + description + '\'' +
                ", hbResult=" + hbResult +
                ", hbType=" + hbType +
                ", entryDate=" + entryDate +
                ", user=" + user +
                '}';
    }
}
