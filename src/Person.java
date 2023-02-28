
//создаем абстрактный класс Персона
public abstract class Person {

    protected final String firstName;
    protected final String surName;

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }
}
