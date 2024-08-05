package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Bank;
import lk.earth.earthuniversity.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDao extends JpaRepository<Meal,Integer> {

}

