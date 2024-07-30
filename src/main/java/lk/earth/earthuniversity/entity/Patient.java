package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Patient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "dob")
    private Date dob;
    @Basic
    @Column(name = "nic")
    private String nic;
    @Basic
    @Column(name = "photo")
    private byte[] photo;
    @Basic
    @Column(name = "contactnumber")
    private String contactnumber;

    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "patientstatus_id", referencedColumnName = "id", nullable = false)
    private Patientstatus patientstatus;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "bloodgroup_id", referencedColumnName = "id", nullable = false)
    private Bloodgroup bloodgroup;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "family_id", referencedColumnName = "id", nullable = false)
    private Family family;
    @ManyToOne
    @JoinColumn(name = "relationship_id", referencedColumnName = "id", nullable = false)
    private Relationship relationship;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Collection<Patientriskfactor> patientriskfactors;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Collection<Appointment> appointments;

    public Collection<Patientriskfactor> getPatientriskfactors() {
        return patientriskfactors;
    }

    public void setPatientriskfactors(Collection<Patientriskfactor> patientriskfactors) {
        this.patientriskfactors = patientriskfactors;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patientstatus getPatientstatus() {
        return patientstatus;
    }

    public void setPatientstatus(Patientstatus patientstatus) {
        this.patientstatus = patientstatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Bloodgroup getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(Bloodgroup bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getId(), patient.getId()) && Objects.equals(getName(), patient.getName()) && Objects.equals(getDob(), patient.getDob()) && Objects.equals(getNic(), patient.getNic()) && Arrays.equals(getPhoto(), patient.getPhoto()) && Objects.equals(getContactnumber(), patient.getContactnumber()) && Objects.equals(getEmail(), patient.getEmail()) && Objects.equals(getDescription(), patient.getDescription()) && Objects.equals(getPatientstatus(), patient.getPatientstatus()) && Objects.equals(getGender(), patient.getGender()) && Objects.equals(getBloodgroup(), patient.getBloodgroup()) && Objects.equals(getEmployee(), patient.getEmployee()) && Objects.equals(getFamily(), patient.getFamily()) && Objects.equals(getRelationship(), patient.getRelationship()) && Objects.equals(getPatientriskfactors(), patient.getPatientriskfactors()) && Objects.equals(getAppointments(), patient.getAppointments());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getDob(), getNic(), getContactnumber(), getEmail(), getDescription(), getPatientstatus(), getGender(), getBloodgroup(), getEmployee(), getFamily(), getRelationship(), getPatientriskfactors(), getAppointments());
        result = 31 * result + Arrays.hashCode(getPhoto());
        return result;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }
}
