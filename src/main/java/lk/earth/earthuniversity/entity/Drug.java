package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Drug {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "strength")
    private BigDecimal strength;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "photo")
    private byte[] photo;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "qoh")
    private Integer qoh;
    @Basic
    @Column(name = "rop")
    private Integer rop;
    @Basic
    @Column(name = "sprice")
//    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Invalid Price")
    private BigDecimal sprice;
    @Basic
    @Column(name = "pprice")
//    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Invalid price")
    private BigDecimal pprice;
    @Basic
    @Column(name = "dointroduced")
    private Timestamp dointroduced;
    @ManyToOne
    @JoinColumn(name = "generic_id", referencedColumnName = "id", nullable = false)
    private Generic generic;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "drugform_id", referencedColumnName = "id", nullable = false)
    private Drugform drugform;
    @ManyToOne
    @JoinColumn(name = "drugroute_id", referencedColumnName = "id", nullable = false)
    private Drugroute drugroute;
    @ManyToOne
    @JoinColumn(name = "drugstatus_id", referencedColumnName = "id", nullable = false)
    private Drugstatus drugstatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

//    @OneToMany(mappedBy = "drug",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "drug_id")
    private Collection<Drugadverseeffect> drugadverseeffects;


    //    @OneToMany(mappedBy = "drug",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "drug_id")
    private Collection<Drugcontraindication> drugcontraindications;

    //    @OneToMany(mappedBy = "drug",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "drug_id")
    private Collection<Drugindication> drugindications;
    @OneToMany(mappedBy = "drug")
    @JsonIgnore
    private Collection<Prescriptiondrug> prescriptiondrugs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getStrength() {
        return strength;
    }

    public void setStrength(BigDecimal strength) {
        this.strength = strength;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQoh() {
        return qoh;
    }

    public void setQoh(Integer qoh) {
        this.qoh = qoh;
    }

    public Integer getRop() {
        return rop;
    }

    public void setRop(Integer rop) {
        this.rop = rop;
    }

    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public Timestamp getDointroduced() {
        return dointroduced;
    }

    public void setDointroduced(Timestamp dointroduced) {
        this.dointroduced = dointroduced;
    }

    public Generic getGeneric() {
        return generic;
    }

    public void setGeneric(Generic generic) {
        this.generic = generic;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Drugform getDrugform() {
        return drugform;
    }

    public void setDrugform(Drugform drugform) {
        this.drugform = drugform;
    }

    public Drugroute getDrugroute() {
        return drugroute;
    }

    public void setDrugroute(Drugroute drugroute) {
        this.drugroute = drugroute;
    }

    public Drugstatus getDrugstatus() {
        return drugstatus;
    }

    public void setDrugstatus(Drugstatus drugstatus) {
        this.drugstatus = drugstatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Collection<Drugadverseeffect> getDrugadverseeffects() {
        return drugadverseeffects;
    }

    public void setDrugadverseeffects(Collection<Drugadverseeffect> drugadverseeffects) {
        this.drugadverseeffects = drugadverseeffects;
    }

    public Collection<Drugcontraindication> getDrugcontraindications() {
        return drugcontraindications;
    }

    public void setDrugcontraindications(Collection<Drugcontraindication> drugcontraindications) {
        this.drugcontraindications = drugcontraindications;
    }

    public Collection<Drugindication> getDrugindications() {
        return drugindications;
    }

    public void setDrugindications(Collection<Drugindication> drugindications) {
        this.drugindications = drugindications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug)) return false;
        Drug drug = (Drug) o;
        return Objects.equals(getId(), drug.getId()) && Objects.equals(getStrength(), drug.getStrength()) && Objects.equals(getCode(), drug.getCode()) && Objects.equals(getName(), drug.getName()) && Arrays.equals(getPhoto(), drug.getPhoto()) && Objects.equals(getDescription(), drug.getDescription()) && Objects.equals(getQoh(), drug.getQoh()) && Objects.equals(getRop(), drug.getRop()) && Objects.equals(getSprice(), drug.getSprice()) && Objects.equals(getPprice(), drug.getPprice()) && Objects.equals(getDointroduced(), drug.getDointroduced()) && Objects.equals(getGeneric(), drug.getGeneric()) && Objects.equals(getBrand(), drug.getBrand()) && Objects.equals(getDrugform(), drug.getDrugform()) && Objects.equals(getDrugroute(), drug.getDrugroute()) && Objects.equals(getDrugstatus(), drug.getDrugstatus()) && Objects.equals(getEmployee(), drug.getEmployee()) && Objects.equals(getDrugadverseeffects(), drug.getDrugadverseeffects()) && Objects.equals(getDrugcontraindications(), drug.getDrugcontraindications()) && Objects.equals(getDrugindications(), drug.getDrugindications());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getStrength(), getCode(), getName(), getDescription(), getQoh(), getRop(), getSprice(), getPprice(), getDointroduced(), getGeneric(), getBrand(), getDrugform(), getDrugroute(), getDrugstatus(), getEmployee(), getDrugadverseeffects(), getDrugcontraindications(), getDrugindications());
        result = 31 * result + Arrays.hashCode(getPhoto());
        return result;
    }

    public Collection<Prescriptiondrug> getPrescriptiondrugs() {
        return prescriptiondrugs;
    }

    public void setPrescriptiondrugs(Collection<Prescriptiondrug> prescriptiondrugs) {
        this.prescriptiondrugs = prescriptiondrugs;
    }
}
