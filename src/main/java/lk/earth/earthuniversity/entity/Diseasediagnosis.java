package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Diseasediagnosis {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
//    @ManyToOne
//    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
//    private Diagnosis diagnosis;
    @ManyToOne
    @JoinColumn(name = "disease_id", referencedColumnName = "id", nullable = false)
    private Disease disease;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diseasediagnosis)) return false;
        Diseasediagnosis that = (Diseasediagnosis) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDisease(), that.getDisease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDisease());
    }
}
