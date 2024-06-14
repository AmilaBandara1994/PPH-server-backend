package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorDao extends JpaRepository<Doctor,Integer> {

    @Query("select d from Doctor d join Doctorclinictype dc on  dc.doctor.id = d.id join Clinictype  c on dc.clinictype.id = c.id where c.id = :id")
    List<Doctor> findAllDoctorsByCategoryId(@Param("id")Integer id);
}

