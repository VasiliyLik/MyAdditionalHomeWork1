// класс наследник от класса Персона

import java.time.LocalDate;

public class Professor extends Person {
    //private Date birthDate;
    private final Subjects subjectTeacher;
    private final LocalDate birthDate;

    public Professor(String firstName, String surName, LocalDate birthDate, Subjects subjectTeacher) {
        super(firstName, surName);
        this.birthDate = birthDate;
        this.subjectTeacher = subjectTeacher;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "firstName='" + getFirstName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                "birthDate='" + getBirthDate() + '\'' +
                ", subjectTeacher=" + subjectTeacher +
                '}';
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
