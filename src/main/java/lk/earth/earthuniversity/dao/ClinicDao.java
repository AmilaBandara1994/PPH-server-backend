package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClinicDao extends JpaRepository<Clinic,Integer> {

    @Query("select c FROM Clinic c where c.id=:id")
    Clinic  findByMyId( Integer id);
}

