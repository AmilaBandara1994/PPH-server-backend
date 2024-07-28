package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class District {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "province_id", referencedColumnName = "id", nullable = false)
    private Province province;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private Collection<Family> families;

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

    public Collection<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Collection<Family> families) {
        this.families = families;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof District)) return false;
        District district = (District) o;
        return Objects.equals(getId(), district.getId()) && Objects.equals(getName(), district.getName()) && Objects.equals(getProvince(), district.getProvince()) && Objects.equals(getFamilies(), district.getFamilies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProvince(), getFamilies());
    }
}
