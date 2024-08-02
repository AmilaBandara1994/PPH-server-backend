package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Drugcontraindication {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
//    @JoinColumn(name = "drug_id", referencedColumnName = "id", nullable = false)
//    private Drug drug;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contraindications_id", referencedColumnName = "id", nullable = false)
    private Contraindication contraindication;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contraindication getContraindication() {
        return contraindication;
    }

    public void setContraindication(Contraindication contraindication) {
        this.contraindication = contraindication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drugcontraindication)) return false;
        Drugcontraindication that = (Drugcontraindication) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getContraindication(), that.getContraindication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContraindication());
    }
}
