package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Symptomsdiagnosis {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
//    @ManyToOne
//    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
//    private Diagnosis diagnosis;
    @ManyToOne
    @JoinColumn(name = "symptoms_id", referencedColumnName = "id", nullable = false)
    private Symptoms symptoms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symptomsdiagnosis)) return false;
        Symptomsdiagnosis that = (Symptomsdiagnosis) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getSymptoms(), that.getSymptoms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSymptoms());
    }
}
