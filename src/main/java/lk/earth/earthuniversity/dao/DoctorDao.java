package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDao extends JpaRepository<Doctor,Integer> {

}

