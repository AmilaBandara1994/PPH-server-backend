package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dosage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "dosage")
    @JsonIgnore
    private Collection<Prescriptiondrug> prescriptiondrugs;
    @Basic
    @Column(name = "value")
    private BigDecimal value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Prescriptiondrug> getPrescriptiondrugs() {
        return prescriptiondrugs;
    }

    public void setPrescriptiondrugs(Collection<Prescriptiondrug> prescriptiondrugs) {
        this.prescriptiondrugs = prescriptiondrugs;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dosage)) return false;
        Dosage dosage = (Dosage) o;
        return Objects.equals(getId(), dosage.getId()) && Objects.equals(getName(), dosage.getName()) && Objects.equals(getPrescriptiondrugs(), dosage.getPrescriptiondrugs()) && Objects.equals(getValue(), dosage.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrescriptiondrugs(), getValue());
    }
}
