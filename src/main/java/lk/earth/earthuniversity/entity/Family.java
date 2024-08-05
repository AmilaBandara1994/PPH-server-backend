package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Family {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "doregister")
    private Timestamp doregister;
    @Basic
    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Calligname")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "mobile")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Mobile Number")
    private String mobile;
    @Basic
    @Column(name = "land")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Land Number")
    private String land;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "maplocation")
    private String maplocation;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "familystatus_id", referencedColumnName = "id", nullable = false)
    private Familystatus familystatus;
    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    private District district;
    @OneToMany(mappedBy = "family")
    @JsonIgnore
    private Collection<Patient> patients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDoregister() {
        return doregister;
    }

    public void setDoregister(Timestamp doregister) {
        this.doregister = doregister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaplocation() {
        return maplocation;
    }

    public void setMaplocation(String maplocation) {
        this.maplocation = maplocation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Familystatus getFamilystatus() {
        return familystatus;
    }

    public void setFamilystatus(Familystatus familystatus) {
        this.familystatus = familystatus;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Collection<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(getId(), family.getId()) && Objects.equals(getDoregister(), family.getDoregister()) && Objects.equals(getName(), family.getName()) && Objects.equals(getAddress(), family.getAddress()) && Objects.equals(getMobile(), family.getMobile()) && Objects.equals(getLand(), family.getLand()) && Objects.equals(getDescription(), family.getDescription()) && Objects.equals(getMaplocation(), family.getMaplocation()) && Objects.equals(getEmployee(), family.getEmployee()) && Objects.equals(getFamilystatus(), family.getFamilystatus()) && Objects.equals(getDistrict(), family.getDistrict()) && Objects.equals(getPatients(), family.getPatients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDoregister(), getName(), getAddress(), getMobile(), getLand(), getDescription(), getMaplocation(), getEmployee(), getFamilystatus(), getDistrict(), getPatients());
    }
}
