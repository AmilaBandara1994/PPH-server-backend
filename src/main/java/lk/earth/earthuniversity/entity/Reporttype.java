package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Reporttype {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "value")
    private Integer value;
    @OneToMany(mappedBy = "reporttype")
    @JsonIgnore
    private Collection<Investigation> investigations;

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Collection<Investigation> getInvestigations() {
        return investigations;
    }

    public void setInvestigations(Collection<Investigation> investigations) {
        this.investigations = investigations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reporttype)) return false;
        Reporttype that = (Reporttype) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getValue(), that.getValue()) && Objects.equals(getInvestigations(), that.getInvestigations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getValue(), getInvestigations());
    }
}
