import java.text.ParseException;

// класс для тестирования программы
public class TestBase {
    public static void main(String[] args) throws ParseException {
        StudentBase studentBase = new StudentBase();

        studentBase.createStudents(1);

        studentBase.calculateAverageScore();

        studentBase.viewSubjectScores();

        ProfessorBase professorBase = new ProfessorBase();

        professorBase.createProfessorsBase();

        professorBase.searchSubjectsProfessor();

        professorBase.createLessonsSchedule();

        professorBase.searchScheduleDay();

    }
}
