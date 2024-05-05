package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Clinictype {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "clinictype")
    private Collection<Clinic> clinics;

    @JsonIgnore
    @OneToMany(mappedBy = "clinictype")
    private Collection<Doctorclinictype> doctorclinictypes;
    public Clinictype(){}
    public Clinictype(Integer id){
        this.id = id;
    }
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

        Clinictype that = (Clinictype) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(Collection<Clinic> clinics) {
        this.clinics = clinics;
    }

    public Collection<Doctorclinictype> getDoctorclinictypes() {
        return doctorclinictypes;
    }

    public void setDoctorclinictypes(Collection<Doctorclinictype> doctorclinictypes) {
        this.doctorclinictypes = doctorclinictypes;
    }
}
