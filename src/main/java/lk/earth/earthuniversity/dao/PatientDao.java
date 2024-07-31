package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Employee;
import lk.earth.earthuniversity.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends JpaRepository<Patient,Integer> {

    @Query("select p from Patient p where p.contactnumber = :number")
    Patient findByContactNumber(@Param("number") String number);
    @Query("select p from Patient p where p.nic = :nic")
    Patient findByNic(@Param("nic") String nic);
    @Query("select p from Patient p where p.email = :email")
    Patient findByEmail(@Param("email") String email);

    @Query("select p from Patient p where p.id = :id")
    Patient findByMyId(@Param("id") Integer id);

}

