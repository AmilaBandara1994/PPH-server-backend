package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Patientriskfactor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "riskfactor_id", referencedColumnName = "id", nullable = false)
    private Riskfactor riskfactor;

//    @ManyToOne
//    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
//    private Patient patient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Riskfactor getRiskfactor() {
        return riskfactor;
    }

    public void setRiskfactor(Riskfactor riskfactor) {
        this.riskfactor = riskfactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patientriskfactor)) return false;
        Patientriskfactor that = (Patientriskfactor) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRiskfactor(), that.getRiskfactor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRiskfactor());
    }
}
