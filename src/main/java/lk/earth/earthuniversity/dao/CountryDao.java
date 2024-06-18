package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryDao extends JpaRepository<Country,Integer> {
}

