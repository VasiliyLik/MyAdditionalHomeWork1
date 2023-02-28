import java.util.Date;

//класс База оценок
public record ScoreBase(Subjects subjects, int scores, Date date) {

    @Override
    public String toString() {
        return "ScoreBase{" +
                "subjects=" + subjects +
                ", scores=" + scores +
                ", date=" + date +
                '}';
    }
}
