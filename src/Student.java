//класс наследник от класса Персона

import java.util.Arrays;
import java.util.Date;

public class Student extends Person {
    private final Faculties faculty;

    private final Date birthDate;

    private final ScoreBase[] subjectsScore;  //создание и инициализация массива

    public Student(String firstName, String surName, Date birthDate, Faculties faculty, ScoreBase[] subjectsScore) {
        super(firstName, surName);
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.subjectsScore = subjectsScore;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                "faculty=" + faculty +
                ", subjectsScore=" + Arrays.toString(subjectsScore) +
                '}';
    }
}
