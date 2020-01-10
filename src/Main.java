import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toCollection;

public class Main {

    public static void main(String[] args) {
        //TODO: найти студентов с уникальными предметами. Задачу решать с использованием stream API

        List<String> basicList = new ArrayList<>(createSubjectList());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            students.add(new Student("Студент №" + (i + 1), new ArrayList<>(createStudentSubjectList(basicList))));
        }

        System.out.println("Список студентов и их предметов:");
        System.out.println(students);
        System.out.println("\n");

        ArrayList<Student> uniqueStudentList = students.stream()
                    .filter(uniqueStudentsFinder(Student::getFirstSubject))
                    .collect(toCollection(ArrayList::new)).stream()
                    .filter(uniqueStudentsFinder(Student::getSecondSubject))
                    .collect(toCollection(ArrayList::new));

        System.out.println("Список студентов c уникальными предметами:");
        System.out.println(uniqueStudentList);
    }

    private static List<String>  createSubjectList() {
        List<String> subjectList  = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            subjectList.add("Предмет "+ (i + 1));
        }
        return subjectList;
    }

    private static List<String> createStudentSubjectList(List<String> someList) {

        int randomItem_1 = (int) (Math.random() * 4);
        int randomItem_2 = (int) (Math.random() * 4);

        List<String> studentSubjectList = new ArrayList<>();
        studentSubjectList.add(someList.get(randomItem_1));
        studentSubjectList.add(someList.get(randomItem_2));

        return studentSubjectList;
    }

    private static <T> Predicate<T> uniqueStudentsFinder (Function<? super T, ?> key) {
        Set<Object> duplicate = new HashSet<>();
        return s -> duplicate.add(key.apply(s));
    }

}