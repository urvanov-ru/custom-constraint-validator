package ru.urvanov.javaexamples.customconstraintvalidator.domain;

import ru.urvanov.javaexamples.customconstraintvalidator.validator.person.UniqueItn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@UniqueItn
public class Person {


    private  Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 13)
    private String itn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItn() {
        return itn;
    }

    public void setItn(String itn) {
        this.itn = itn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itn='" + itn + '\'' +
                '}';
    }
}
