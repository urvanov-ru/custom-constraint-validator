package ru.urvanov.javaexamples.customconstraintvalidator.validator.person;

import org.springframework.beans.factory.annotation.Autowired;
import ru.urvanov.javaexamples.customconstraintvalidator.domain.Person;
import ru.urvanov.javaexamples.customconstraintvalidator.service.PersonService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueItnConstraintValidator implements ConstraintValidator<UniqueItn, Person> {

    @Autowired
    private PersonService personService;

    @Override
    public void initialize(UniqueItn uniqueItn) {

    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext ctx) {
        if (personService.findByItn(person.getItn()).map(p -> p.getId())
                .filter(id -> !id.equals(person.getId())).isPresent()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                    "{ru.urvanov.javaexamples.customconstraintvalidator.validation.unique.itn}")
                    .addPropertyNode("itn").addConstraintViolation();
            return false;
        }
        return true;
    }
}
