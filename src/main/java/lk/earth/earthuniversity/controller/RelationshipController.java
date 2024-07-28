package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.RelationshipDao;
import lk.earth.earthuniversity.entity.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/relationships")
public class RelationshipController {

    @Autowired
    private RelationshipDao relationshipDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Relationship> get() {

        List<Relationship> relationships = this.relationshipDao.findAll();

        relationships = relationships.stream().map(
                relationship -> { Relationship d = new Relationship();
                    d.setId(relationship.getId());
                    d.setName(relationship.getName());
                    return d; }
        ).collect(Collectors.toList());

        return relationships;

    }

}


