package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.earth.earthuniversity.util.RegexPattern;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    @Pattern(regexp = "^\\d{4}$", message = "Invalid Number")
    private String number;
    @Basic
    @Column(name = "fullname")
    @Pattern(regexp = "^([A-Z][a-z]*[.]?[\\s]?)*([A-Z][a-z]*)$", message = "Invalid Fullname")
    private String fullname;
    @Basic
    @Column(name = "callingname")
    @Pattern(regexp = "^([A-Z][a-z]+)$", message = "Invalid Calligname")
    private String callingname;
    @Basic
    @Column(name = "photo")
    private byte[] photo;
    @Basic
    @Column(name = "dobirth")
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    private Date dobirth;
    @Basic
    @Column(name = "nic")
    @Pattern(regexp = "^(([\\d]{9}[vVxX])|([\\d]{12}))$", message = "Invalid NIC")
    private String nic;
    @Basic
    @Column(name = "address")
    @Pattern(regexp = "^([\\w\\/\\-,\\s]{2,})$", message = "Invalid Address")
    private String address;
    @Basic
    @Column(name = "mobile")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Mobile Number")
    private String mobile;
    @Basic
    @Column(name = "land")
    @Pattern(regexp = "^\\d{0,10}$", message = "Invalid Landphone Number")
    private String land;
    @Basic
    @Column(name = "email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid Landphone Number")
    private String email;
    @Basic
    @Column(name = "doassignment")
    private Date doassignment;
    @Basic
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "emptype_id", referencedColumnName = "id", nullable = false)
    private Emptype emptype;
    @ManyToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "id", nullable = false)
    private Designation designation;
    @ManyToOne
    @JoinColumn(name = "empstatus_id", referencedColumnName = "id", nullable = false)
    private Empstatus empstatus;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Collection<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "nurse1")
    private Collection<Clinic> nurse1;

    @JsonIgnore
    @OneToMany(mappedBy = "nurse2")
    private Collection<Clinic> nurse2;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Collection<Clinic> employee;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Doctor> doctors;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Patient> patients;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Family> families;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Appointment> appointments;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Patientpayment> patientpayments;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Drug> drugs;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Diagnosis> diagnosesById;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Collection<Investigation> investigations;

    public Employee(){}

    public Employee(Integer id){
        this.id = id;
    }

    public Employee(Integer id, String callingname){
        this.id = id;
        this.callingname = callingname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCallingname() {
        return callingname;
    }

    public void setCallingname(String callingname) {
        this.callingname = callingname;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDobirth() {
        return dobirth;
    }

    public void setDobirth(Date dobirth) {
        this.dobirth = dobirth;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDoassignment() {
        return doassignment;
    }

    public void setDoassignment(Date doassignment) {
        this.doassignment = doassignment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Emptype getEmptype() {
        return emptype;
    }

    public void setEmptype(Emptype emptype) {
        this.emptype = emptype;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Empstatus getEmpstatus() {
        return empstatus;
    }

    public void setEmpstatus(Empstatus empstatus) {
        this.empstatus = empstatus;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Clinic> getNurse1() {
        return nurse1;
    }

    public void setNurse1(Collection<Clinic> nurse1) {
        this.nurse1 = nurse1;
    }

    public Collection<Clinic> getNurse2() {
        return nurse2;
    }

    public void setNurse2(Collection<Clinic> nurse2) {
        this.nurse2 = nurse2;
    }

    public Collection<Clinic> getEmployee() {
        return employee;
    }

    public void setEmployee(Collection<Clinic> employee) {
        this.employee = employee;
    }

    public Collection<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Collection<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Collection<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Patient> patients) {
        this.patients = patients;
    }

    public Collection<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Collection<Family> families) {
        this.families = families;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Collection<Patientpayment> getPatientpayments() {
        return patientpayments;
    }

    public void setPatientpayments(Collection<Patientpayment> patientpayments) {
        this.patientpayments = patientpayments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee1 = (Employee) o;
        return Objects.equals(getId(), employee1.getId()) && Objects.equals(getNumber(), employee1.getNumber()) && Objects.equals(getFullname(), employee1.getFullname()) && Objects.equals(getCallingname(), employee1.getCallingname()) && Arrays.equals(getPhoto(), employee1.getPhoto()) && Objects.equals(getDobirth(), employee1.getDobirth()) && Objects.equals(getNic(), employee1.getNic()) && Objects.equals(getAddress(), employee1.getAddress()) && Objects.equals(getMobile(), employee1.getMobile()) && Objects.equals(getLand(), employee1.getLand()) && Objects.equals(getEmail(), employee1.getEmail()) && Objects.equals(getDoassignment(), employee1.getDoassignment()) && Objects.equals(getDescription(), employee1.getDescription()) && Objects.equals(getGender(), employee1.getGender()) && Objects.equals(getEmptype(), employee1.getEmptype()) && Objects.equals(getDesignation(), employee1.getDesignation()) && Objects.equals(getEmpstatus(), employee1.getEmpstatus()) && Objects.equals(getUsers(), employee1.getUsers()) && Objects.equals(getNurse1(), employee1.getNurse1()) && Objects.equals(getNurse2(), employee1.getNurse2()) && Objects.equals(getEmployee(), employee1.getEmployee()) && Objects.equals(getDoctors(), employee1.getDoctors()) && Objects.equals(getPatients(), employee1.getPatients()) && Objects.equals(getFamilies(), employee1.getFamilies()) && Objects.equals(getAppointments(), employee1.getAppointments()) && Objects.equals(getPatientpayments(), employee1.getPatientpayments());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getNumber(), getFullname(), getCallingname(), getDobirth(), getNic(), getAddress(), getMobile(), getLand(), getEmail(), getDoassignment(), getDescription(), getGender(), getEmptype(), getDesignation(), getEmpstatus(), getUsers(), getNurse1(), getNurse2(), getEmployee(), getDoctors(), getPatients(), getFamilies(), getAppointments(), getPatientpayments());
        result = 31 * result + Arrays.hashCode(getPhoto());
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", fullname='" + fullname + '\'' +
                ", callingname='" + callingname + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", dobirth=" + dobirth +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", land='" + land + '\'' +
                ", email='" + email + '\'' +
                ", doassignment=" + doassignment +
                ", description='" + description + '\'' +
                ", gender=" + gender +
                ", emptype=" + emptype +
                ", designation=" + designation +
                ", empstatus=" + empstatus +
                ", users=" + users +
                ", nurse1=" + nurse1 +
                ", nurse2=" + nurse2 +
                ", employee=" + employee +
                ", doctors=" + doctors +
                ", patients=" + patients +
                ", families=" + families +
                ", appointments=" + appointments +
                ", patientpayments=" + patientpayments +
                '}';
    }

    public Collection<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(Collection<Drug> drugs) {
        this.drugs = drugs;
    }

    public Collection<Diagnosis> getDiagnosesById() {
        return diagnosesById;
    }

    public void setDiagnosesById(Collection<Diagnosis> diagnosesById) {
        this.diagnosesById = diagnosesById;
    }

    public Collection<Investigation> getInvestigations() {
        return investigations;
    }

    public void setInvestigations(Collection<Investigation> investigations) {
        this.investigations = investigations;
    }
}
