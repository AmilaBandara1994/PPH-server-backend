package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Doctor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Collection<Clinic> clinics;

    @OneToMany(mappedBy = "doctor")
    private Collection<Doctorclinictype> doctorclinictypes;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "doctor_id")
    private Collection<Doctordegree> doctordegrees;

    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "slmcregno")
    private String slmcregno;
    @Basic
    @Column(name = "doslmcregisterd")
    private Date doslmcregisterd;
    @Basic
    @Column(name = "foreigntraining")
    private String foreigntraining;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "doctorgrade_id", referencedColumnName = "id", nullable = false)
    private Doctorgrade doctorgrade;
    @ManyToOne
    @JoinColumn(name = "foreigntrainedcountry_id", referencedColumnName = "id")
    private Country country;

    public Doctor(){}

    public Doctor(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getId(), doctor.getId()) && Objects.equals(getClinics(), doctor.getClinics()) && Objects.equals(getDoctorclinictypes(), doctor.getDoctorclinictypes()) && Objects.equals(getDoctordegrees(), doctor.getDoctordegrees()) && Objects.equals(getDescription(), doctor.getDescription()) && Objects.equals(getSlmcregno(), doctor.getSlmcregno()) && Objects.equals(getDoslmcregisterd(), doctor.getDoslmcregisterd()) && Objects.equals(getForeigntraining(), doctor.getForeigntraining()) && Objects.equals(getEmployee(), doctor.getEmployee()) && Objects.equals(getDoctorgrade(), doctor.getDoctorgrade()) && Objects.equals(getCountry(), doctor.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClinics(), getDoctorclinictypes(), getDoctordegrees(), getDescription(), getSlmcregno(), getDoslmcregisterd(), getForeigntraining(), getEmployee(), getDoctorgrade(), getCountry());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", clinics=" + clinics +
                ", doctorclinictypes=" + doctorclinictypes +
                ", doctordegrees=" + doctordegrees +
                ", description='" + description + '\'' +
                ", slmcregno='" + slmcregno + '\'' +
                ", doslmcregisterd=" + doslmcregisterd +
                ", foreigntraining='" + foreigntraining + '\'' +
                ", employee=" + employee +
                ", doctorgrade=" + doctorgrade +
                ", country=" + country +
                '}';
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

    public Collection<Doctordegree> getDoctordegrees() {
        return doctordegrees;
    }

    public void setDoctordegrees(Collection<Doctordegree> doctordegrees) {
        this.doctordegrees = doctordegrees;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlmcregno() {
        return slmcregno;
    }

    public void setSlmcregno(String slmcregno) {
        this.slmcregno = slmcregno;
    }

    public Date getDoslmcregisterd() {
        return doslmcregisterd;
    }

    public void setDoslmcregisterd(Date doslmcregisterd) {
        this.doslmcregisterd = doslmcregisterd;
    }

    public String getForeigntraining() {
        return foreigntraining;
    }

    public void setForeigntraining(String foreigntraining) {
        this.foreigntraining = foreigntraining;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Doctorgrade getDoctorgrade() {
        return doctorgrade;
    }

    public void setDoctorgrade(Doctorgrade doctorgrade) {
        this.doctorgrade = doctorgrade;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
