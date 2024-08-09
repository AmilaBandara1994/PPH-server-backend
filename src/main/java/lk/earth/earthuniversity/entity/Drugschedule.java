package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Drugschedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "drugschedule")
    @JsonIgnore
    private Collection<Prescriptiondrug> prescriptiondrugs;
    @Basic
    @Column(name = "value")
    private Integer value;

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drugschedule)) return false;
        Drugschedule that = (Drugschedule) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPrescriptiondrugs(), that.getPrescriptiondrugs()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrescriptiondrugs(), getValue());
    }
}
