import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ProfessorBase implements LessonsSchedule {
    private final Professor[] professorsBase = new Professor[7];
    private final Schedule[] schedule = new Schedule[5];

    public void createProfessorsBase() {
        //создаем базу профессоров
        professorsBase[0] = new Professor("John", "Smith", LocalDate.of(1972, 3, 1), Subjects.ECONOMY);
        professorsBase[1] = new Professor("Sem", "Bon", LocalDate.of(1983, 5, 17), Subjects.HIGHER_MATHEMATICS);
        professorsBase[2] = new Professor("Piter", "Polish", LocalDate.of(1965, 11, 22), Subjects.HISTORY_RB);
        professorsBase[3] = new Professor("Will", "Rox", LocalDate.of(1981, 10, 22), Subjects.JURISPRUDENCE);
        professorsBase[4] = new Professor("Nick", "Socks", LocalDate.of(1969, 11, 12), Subjects.STATISTICS);
        professorsBase[5] = new Professor("Jack", "Fox", LocalDate.of(1977, 7, 6), Subjects.WORLD_PHILOSOPHY);
        professorsBase[6] = new Professor("Jet", "Li", LocalDate.of(1981, 3, 25), Subjects.ZOOLOGY);
        System.out.println("Professor's base: " + Arrays.toString(professorsBase));
    }

    public void searchSubjectsProfessor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the subject:");
        String searchSubjectsProfessor = scanner.nextLine().toUpperCase();
        for (Professor searchProfessor : professorsBase) {
            if (searchSubjectsProfessor.equals(searchProfessor.getSubjectTeacher().toString())) {
                for (int i = 0; i < professorsBase.length; i++) {
                    professorsBase[i] = new Professor(professorsBase[i].firstName, professorsBase[i].surName,
                            professorsBase[i].getBirthDate(), professorsBase[i].getSubjectTeacher());
                }
                System.out.println(searchProfessor);
            } else {
                System.out.println("Incorrect input of subject!");
            }
            break;
        }
    }

    @Override
    public void createLessonsSchedule() {
        //создаем расписание по дням недели
        schedule[0] = new Schedule(WorkDays.MONDAY, Subjects.ECONOMY, Subjects.HISTORY_RB);
        schedule[1] = new Schedule(WorkDays.TUESDAY, Subjects.ZOOLOGY, Subjects.HIGHER_MATHEMATICS);
        schedule[2] = new Schedule(WorkDays.WEDNESDAY, Subjects.WORLD_PHILOSOPHY, Subjects.JURISPRUDENCE);
        schedule[3] = new Schedule(WorkDays.THURSDAY, Subjects.STATISTICS, Subjects.ECONOMY);
        schedule[4] = new Schedule(WorkDays.FRIDAY, Subjects.JURISPRUDENCE, Subjects.ZOOLOGY);
    }

    //метод для поиска расписания по дню недели
    public void searchScheduleDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the day: ");
        String day = scanner.nextLine().toUpperCase();
        //Schedule searchDaySchedule = null;
        for (Schedule searchDaySchedule : schedule) {
            if (day.equals(searchDaySchedule.weekDay().toString())) {
                for (int i = 0; i < schedule.length; i++) {
                    schedule[i] = new Schedule(schedule[i].weekDay(), schedule[i].subjects(), schedule[i].subjects1());
                }
                System.out.println(searchDaySchedule);
            } else {
                System.out.println("Incorrect name of day!");
            }
            break;
        }
    }
}

