package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Allergydiagnosis {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
//    @ManyToOne
//    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
//    private Diagnosis diagnosis;
    @ManyToOne
    @JoinColumn(name = "allergy_id", referencedColumnName = "id", nullable = false)
    private Allergy allergy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Allergydiagnosis)) return false;
        Allergydiagnosis that = (Allergydiagnosis) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAllergy(), that.getAllergy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAllergy());
    }
}
