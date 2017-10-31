package ru.urvanov.javaexamples.customconstraintvalidator;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.urvanov.javaexamples.customconstraintvalidator.domain.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
            context.load("classpath:applicationContext.xml");
            context.refresh();
            Validator validator = (Validator) context.getBean("validator");
            Person person = new Person();
            person.setName("Vasya");
            person.setItn("duplicate itn");
            Set<ConstraintViolation<Person>> constraintViolationSet = validator.validate(person);
            for (ConstraintViolation<Person> constraintViolation : constraintViolationSet) {
                System.out.println("constraintViolation.message = " + constraintViolation.getMessage());
                System.out.println("constraintViolation.field = " + constraintViolation.getPropertyPath());
            }
        }
    }
}
