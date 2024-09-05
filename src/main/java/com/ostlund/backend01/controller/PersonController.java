package com.ostlund.backend01.controller;

import com.ostlund.backend01.model.Person;
import com.ostlund.backend01.repository.PersonRepository;
import com.ostlund.backend01.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/saveperson")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
    }
    @GetMapping("/getpersons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
        return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
    }

    @PutMapping("/updateperson/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        return new ResponseEntity<Person>(personService.updatePerson(person, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return new ResponseEntity<String>("PERSON DELEEEETED", HttpStatus.OK);
    }

    @GetMapping("/sortpersonsasc")
    public List<Person> sortPersonsAsc() {
        return personRepository.findByNameOrderByAgeAsc("Jerry");
    }

    @GetMapping("/sortpersonsdesc")
    public List<Person> sortPersonsDesc() {
        return personRepository.findByNameOrderByAgeDesc("Jerry");
    }

}
