package lk.earth.earthuniversity.report.dao;

import lk.earth.earthuniversity.report.entity.CountByDesignation;
import lk.earth.earthuniversity.report.entity.DoctorCountBySpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorCountBySpecialityDao extends JpaRepository<CountByDesignation,Integer> {

//    @Query("SELECT new DoctorCountBySpeciality(ct.name, COUNT(d)) " +
//            "FROM Doctor d , Doctorclinictype dc" +
//            "JOIN d.doctorclinictypes ct " +
//            "GROUP BY ct.name")
//    List<DoctorCountBySpeciality> countBySpeciality();

    @Query("SELECT NEW DoctorCountBySpeciality (ct.clinictype.name, COUNT(*)) FROM Doctor d, Employee e, Doctorclinictype ct WHERE d.employee.id = e.id and ct.doctor.id = d.id  GROUP BY ct.id")
    List<DoctorCountBySpeciality> countBySpeciality();

}

