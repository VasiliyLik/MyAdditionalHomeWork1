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
        professorsBase[2] = new Professor("Piter", "Voish", LocalDate.of(1965, 11, 22), Subjects.HISTORY_RB);
        professorsBase[3] = new Professor("Will", "Rox", LocalDate.of(1981, 10, 22), Subjects.JURISPRUDENCE);
        professorsBase[4] = new Professor("Nick", "Soks", LocalDate.of(1969, 11, 12), Subjects.STATISTICS);
        professorsBase[5] = new Professor("Jack", "Fox", LocalDate.of(1977, 7, 6), Subjects.WORLD_PHILOSOPHY);
        professorsBase[6] = new Professor("Jet", "Li", LocalDate.of(1981, 3, 25), Subjects.ZOOLOGY);

        System.out.println("Professor's base: " + Arrays.toString(professorsBase));  //return professorsBase;
    }

    public void searchSubjectsProfessor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the subject:");
        String searchSubjectsProfessor = scanner.nextLine();
        Professor searchProfessor = null;
        for (int i = 1; i < professorsBase.length; i++) {
            searchProfessor = switch (searchSubjectsProfessor) {
                case "economy" -> professorsBase[0];
                case "HM" -> professorsBase[1];
                case "HRB" -> professorsBase[2];
                case "JP" -> professorsBase[3];
                case "statistic" -> professorsBase[4];
                case "WP" -> professorsBase[5];
                default -> professorsBase[6];
            };
        }
        System.out.println(searchProfessor);
    }

    @Override
    public void createLessonsSchedule() {
        //создаем расписание по дням недели
        schedule[0] = new Schedule(WeekDays.MONDAY, Subjects.ECONOMY, Subjects.HISTORY_RB);
        schedule[1] = new Schedule(WeekDays.TUESDAY, Subjects.ZOOLOGY, Subjects.HIGHER_MATHEMATICS);
        schedule[2] = new Schedule(WeekDays.WEDNESDAY, Subjects.WORLD_PHILOSOPHY, Subjects.JURISPRUDENCE);
        schedule[3] = new Schedule(WeekDays.THURSDAY, Subjects.STATISTICS, Subjects.ECONOMY);
        schedule[4] = new Schedule(WeekDays.FRIDAY, Subjects.JURISPRUDENCE, Subjects.ZOOLOGY);

    }

    //метод для поиска расписания по дню недели
    public void searchScheduleDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the day: ");
        String day = scanner.nextLine();
        Schedule searchDaySchedule = null;
        for (int i = 0; i < schedule.length; i++) {
            searchDaySchedule = switch (day) {
                case "monday" -> schedule[0];
                case "tuesday" -> schedule[1];
                case "wednesday" -> schedule[2];
                case "thursday" -> schedule[3];
                default -> schedule[4];
            };
        }
        System.out.println(searchDaySchedule);
    }
}

