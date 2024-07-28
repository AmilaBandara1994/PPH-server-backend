package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Family;
import lk.earth.earthuniversity.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FamilyDao extends JpaRepository<Family,Integer> {

    @Query("select f from Family f where f.mobile = :number")
    Family findByMobileNumber(@Param("number") String number);
    @Query("select f from Family f where f.name = :name")
    Family findByName(@Param("name") String name);
    @Query("select f from Family f where f.id = :id")
    Family findByMyId(@Param("id") Integer id);



}

