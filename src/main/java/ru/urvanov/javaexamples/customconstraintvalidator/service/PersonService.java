package ru.urvanov.javaexamples.customconstraintvalidator.service;

import ru.urvanov.javaexamples.customconstraintvalidator.domain.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> findByItn(String itn);
}
