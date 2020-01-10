import java.util.ArrayList;
import java.util.List;

public class Student {
    // можно добавить дополнительные поля
    private String login;
    private List<String> subjects;

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getFirstSubject() {
        return subjects.get(0);
    }

    public String getSecondSubject() {
        return subjects.get(1);
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "\n" + login + " " + subjects;
    }



}










