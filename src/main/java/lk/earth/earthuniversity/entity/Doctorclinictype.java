package lk.earth.earthuniversity.entity;

import javax.persistence.*;

@Entity
public class Doctorclinictype {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "clinictype_id", referencedColumnName = "id", nullable = false)
    private Clinictype clinictype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctorclinictype that = (Doctorclinictype) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Clinictype getClinictype() {
        return clinictype;
    }

    public void setClinictype(Clinictype clinictype) {
        this.clinictype = clinictype;
    }
}
