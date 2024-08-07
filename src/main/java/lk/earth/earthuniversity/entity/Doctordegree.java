package lk.earth.earthuniversity.entity;


import lk.earth.earthuniversity.util.RegexPattern;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Doctordegree {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @RegexPattern(reg = "^(19[0-9][1-9]|19[1-9][0-9]|20[0-9]{2}|21[0-4][0-9]|215[0-5])$", msg = "Invalid Enter Valid Year. Ex: 2004,1990")
    @Column(name = "year")
    private String year;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id", referencedColumnName = "id", nullable = false)
    private Degree degree;
    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id", nullable = false)
    private University university;

    public Doctordegree() {
    }

    public Doctordegree(Integer id) {
        this.id = id;
    }

    public Doctordegree(String year, Degree degree, University university) {
        this.year = year;
        this.degree = degree;
        this.university = university;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctordegree)) return false;
        Doctordegree that = (Doctordegree) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getYear(), that.getYear()) && Objects.equals(getDegree(), that.getDegree()) && Objects.equals(getUniversity(), that.getUniversity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getYear(), getDegree(), getUniversity());
    }
}




