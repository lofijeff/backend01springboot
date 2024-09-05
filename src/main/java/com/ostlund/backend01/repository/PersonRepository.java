package com.ostlund.backend01.repository;

import com.ostlund.backend01.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByNameOrderByAgeAsc(String name);
    List<Person> findByNameOrderByAgeDesc(String name);
}
