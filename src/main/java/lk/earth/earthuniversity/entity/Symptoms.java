package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Symptoms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "symptoms")
    @JsonIgnore
    private Collection<Symptomsdiagnosis> symptomsdiagnoses;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symptoms symptoms = (Symptoms) o;

        if (id != null ? !id.equals(symptoms.id) : symptoms.id != null) return false;
        if (name != null ? !name.equals(symptoms.name) : symptoms.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Symptomsdiagnosis> getSymptomsdiagnoses() {
        return symptomsdiagnoses;
    }

    public void setSymptomsdiagnoses(Collection<Symptomsdiagnosis> symptomsdiagnoses) {
        this.symptomsdiagnoses = symptomsdiagnoses;
    }
}
