package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Doctor;
import lk.earth.earthuniversity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorDao extends JpaRepository<Doctor,Integer> {
    @Query(value = "select d from Doctor d where d.id = :id")
    Doctor findByMyId(@Param("id") Integer id);

    Doctor findByEmployee(Employee employee);


    @Query(value = "select d from Doctor d join Doctorclinictype dc on  dc.doctor.id = d.id join Clinictype  c on dc.clinictype.id = c.id where c.id = :id")
    List<Doctor> findAllDoctorsByCategoryId(@Param("id") Integer id);

    @Query(value = "SELECT d.id FROM Doctor d where d.employee.id = :id")
    Doctor findDoctorByEmployeeId(@Param("id") int id);

}