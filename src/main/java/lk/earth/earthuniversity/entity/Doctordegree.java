package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Doctordegree {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "year")
    private Date year;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id", nullable = false)
    private Degree degree;
    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id", nullable = false)
    private University university;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Doctordegree() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctordegree that = (Doctordegree) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (university != null ? !university.equals(that.university) : that.university != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
}
