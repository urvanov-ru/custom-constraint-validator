package ru.urvanov.javaexamples.customconstraintvalidator.service;

import ru.urvanov.javaexamples.customconstraintvalidator.domain.Person;

import java.util.Optional;

public class PersonServiceImpl implements PersonService {

    @Override
    public Optional<Person> findByItn(String itn) {
        if ("duplicate itn".equals(itn)) {
            Person person = new Person();
            person.setId(1L);
            person.setName("Ivanov");
            person.setItn("duplicate itn");
            return Optional.ofNullable(person);
        }
        return Optional.empty();
    }
}
