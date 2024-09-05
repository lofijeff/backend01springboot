package com.ostlund.backend01.service;

import com.ostlund.backend01.exception.RecourceNotFoundException;
import com.ostlund.backend01.model.Person;
import com.ostlund.backend01.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceRepository{

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new RecourceNotFoundException();
        }
    }

    @Override
    public Person updatePerson(Person person, int id) {
        Person p = personRepository.findById(id).orElseThrow(() -> new RecourceNotFoundException());
        p.setName(person.getName());
        p.setAge(person.getAge());
        p.setEmail(person.getEmail());
        personRepository.save(p);
        return p;
    }

    @Override
    public void deletePerson(int id) {
        personRepository.findById(id).orElseThrow(()-> new RecourceNotFoundException());
        personRepository.deleteById(id);
    }

    @Override
    public boolean selectExistsByEmail(String email) {
        return false;
    }
}
