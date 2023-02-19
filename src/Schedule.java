//(класс) рекорд Расписание
public record Schedule(WeekDays weekDay, Subjects subjects, Subjects subjects1) {

    @Override
    public String toString() {
        return "{" +
                "weekDay= " + weekDay +
                ", subjects: " + subjects +
                ", " + subjects1 +
                '}';
    }
}
