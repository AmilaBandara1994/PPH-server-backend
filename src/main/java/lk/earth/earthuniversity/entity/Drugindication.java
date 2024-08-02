package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Drugindication {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
//    @JoinColumn(name = "drug_id", referencedColumnName = "id", nullable = false)
//    private Drug drug;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "indications_id", referencedColumnName = "id", nullable = false)
    private Indication indication;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Indication getIndication() {
        return indication;
    }

    public void setIndication(Indication indication) {
        this.indication = indication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drugindication)) return false;
        Drugindication that = (Drugindication) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getIndication(), that.getIndication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIndication());
    }
}
