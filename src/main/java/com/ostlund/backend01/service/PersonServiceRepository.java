package com.ostlund.backend01.service;

import com.ostlund.backend01.model.Person;

import java.util.List;

public interface PersonServiceRepository {

    Person savePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(int id);
    Person updatePerson(Person person, int id);
    void deletePerson(int id);
    boolean selectExistsByEmail(String email);

}
