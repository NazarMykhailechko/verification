package verifacation.kyiv.ua.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class GeneralId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "TYPE", nullable = false)
    private String type;

    public GeneralId() {
    }

    public GeneralId(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralId)) return false;

        GeneralId generalId = (GeneralId) o;

        return getId() == generalId.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return "GeneralId{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
