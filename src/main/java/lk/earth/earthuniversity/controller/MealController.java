package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.MealDao;
import lk.earth.earthuniversity.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/meals")
public class MealController {

    @Autowired
    private MealDao mealDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Meal> get() {

        List<Meal> meals = this.mealDao.findAll();

        meals = meals.stream().map(
                meal -> { Meal b = new Meal();
                    b.setId(meal.getId());
                    b.setName(meal.getName());
                    return b; }
        ).collect(Collectors.toList());

        return meals;

    }

}


