package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Degree;
import lk.earth.earthuniversity.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeDao extends JpaRepository<Degree,Integer> {

}

