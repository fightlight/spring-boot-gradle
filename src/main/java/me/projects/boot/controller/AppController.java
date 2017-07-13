package me.projects.boot.controller;

import me.projects.boot.entity.Person;
import me.projects.boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    private final PersonRepository personRepository;

    @Autowired
    public AppController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person created = personRepository.save(person);
        return ResponseEntity.ok(created); // todo: http 201 needed
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long personId) {
        Person fetched = personRepository.getOne(personId);
        return ResponseEntity.ok(fetched);
    }
}
