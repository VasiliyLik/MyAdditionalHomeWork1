import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

//класс для реализации методов интерфейсов
public class StudentBase implements ConsoleInputStudents, AverageScore {
    private Student[] base = null;
    private ScoreBase[] subjectsScore = null;

    @Override
    public void createStudents(int count) throws ParseException {
//создаем студентов
        base = new Student[count];
        for (int i = 0; i < base.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input firstname");
            final String firstName = scanner.nextLine();
            System.out.println("input surname");
            final String surName = scanner.nextLine();
            System.out.println("input birthdate: yyy.mm.dd");
            final String birthDate = scanner.nextLine();
            String pattern = "yyyy.MM.dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date newBirthDate = simpleDateFormat.parse(birthDate);
            Faculties faculty;
            System.out.println("input faculty");
            final String faculties = scanner.nextLine();
            faculty = switch (faculties) {
                case "biology" -> Faculties.BIOLOGY;
                case "economics" -> Faculties.ECONOMICS;
                case "history" -> Faculties.HISTORY;
                case "law" -> Faculties.LAW;
                default -> Faculties.PHILOSOPHY;
            };
            final ScoreBase[] scoreBase = createScoreBase(2);
            base[i] = new Student(firstName, surName, newBirthDate, faculty, scoreBase);
        }
        System.out.println(Arrays.toString(base));
    }

    //создаем массив из оценки, предмета и даты оценки
    public ScoreBase[] createScoreBase(int count) throws ParseException {
        subjectsScore = new ScoreBase[count];
        for (int i = 0; i < subjectsScore.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input date of score");
            final String scoreDate = scanner.nextLine();
            String pattern = "YYYY.mm.dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date dateScore = simpleDateFormat.parse(scoreDate);
            Subjects subjects;
            System.out.println("input subject");
            final String addsubject = scanner.nextLine();
            subjects = switch (addsubject) {
                case "economy" -> Subjects.ECONOMY;
                case "HM" -> Subjects.HIGHER_MATHEMATICS;
                case "HRB" -> Subjects.HISTORY_RB;
                case "JP" -> Subjects.JURISPRUDENCE;
                case "WP" -> Subjects.WORLD_PHILOSOPHY;
                case "statistic" -> Subjects.STATISTICS;
                default -> Subjects.ZOOLOGY;
            };
            System.out.println("input score on the givven subject");
            final int score = scanner.nextInt();

            subjectsScore[i] = new ScoreBase(subjects, score, dateScore);
        }
        return subjectsScore;
    }

    @Override
    public void calculateAverageScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the student's surname to search for");
        String searchSurName = scanner.nextLine();
        double averageScore = 0;
        for (Student searchstudent : base) {
            if (searchSurName.equals(searchstudent.getSurName())) {
                //обратиться к значению оценок и предметов в массиве студентов
                for (ScoreBase scoreBase : subjectsScore) {
                    averageScore += scoreBase.scores() / (double) subjectsScore.length;
                }
                System.out.println("name of student: " + searchstudent.getSurName() + ", average score is: " + averageScore);
            }
        }
    }

    @Override
    public void viewSubjectScores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the student's surname to search for");
        String searchSurName = scanner.nextLine();
        for (Student searhStudent : base) {
            if (searchSurName.equals(searhStudent.getSurName())) {
                for (int i = 0; i < subjectsScore.length; i++) {
                    subjectsScore[i] = new ScoreBase(subjectsScore[i].subjects(), subjectsScore[i].scores(), subjectsScore[i].date());
                }
                System.out.println("Student: " + searchSurName + " has the following scores: " + Arrays.toString(subjectsScore));
            }
        }
    }
}

