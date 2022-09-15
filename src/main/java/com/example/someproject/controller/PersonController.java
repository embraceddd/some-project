package com.example.someproject.controller;

import com.example.someproject.entity.PersonEntity;
import com.example.someproject.model.PersonDto;
import com.example.someproject.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    /**
     * @return all persons from database
     */
    @Operation(description = "get all persons from database")
    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    /**
     * @param personEntity - updated person
     * @return return updated password
     */
    @Operation(description = "updating password of person")
    @PatchMapping("/update")
    public String updatePerson(@RequestBody PersonEntity personEntity) {
        return personService.updatePerson(personEntity);
    }

    /**
     * @param personEntity - object to place in database
     * @return returning person itself
     */
    @Operation(description = "creating new person and insert it into database")
    @PostMapping("/create")
    public PersonEntity createPerson(@RequestBody PersonEntity personEntity) {
        return personService.createPerson(personEntity);
    }

    /**
     * @param id - id of person to delete
     * @return returning id of deleted person
     */
    @Operation(description = "delete person from database by id")
    @DeleteMapping("/delete")
    public String deletePerson(@RequestParam("id") Long id) {
        return personService.deletePerson(id);
    }
}
