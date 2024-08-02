package lk.earth.earthuniversity.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Drugadverseeffect {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
//    @JoinColumn(name = "drug_id", referencedColumnName = "id", nullable = false)
//    private Drug drug;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adverseeffects_id", referencedColumnName = "id", nullable = false)
    private Adverseeffect adverseeffect;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adverseeffect getAdverseeffect() {
        return adverseeffect;
    }

    public void setAdverseeffect(Adverseeffect adverseeffect) {
        this.adverseeffect = adverseeffect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drugadverseeffect)) return false;
        Drugadverseeffect that = (Drugadverseeffect) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAdverseeffect(), that.getAdverseeffect());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdverseeffect());
    }
}
