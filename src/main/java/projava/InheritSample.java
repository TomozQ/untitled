package projava;

import java.util.List;

public class InheritSample {

    /*
        継承
        クラスの継承
     */
    interface Named {
       String name();
    }
    // インターフェイスはフィールドを持てないのでStudentIレコードでもTeacherIレコードでもそれぞれ内部でnameフィールドを持ってname()を実装している。
    record StudentI(String name, int score) implements Named{}
    record TeacherI(String name, String subject) implements Named{}
    /*
        クラスの継承とインタ―フェイスのimplementsの違いは、クラスの継承ではフィールドも受け継げるということ。
        レコードはクラスを継承できない
     */

    static class User {
        String name;

        public String getName() {
            return name;
        }
    }

    static class Student extends User {
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore () {
            return score;
        }
    }

    static class Teacher extends User {
        String subject;

        Teacher(String name, String subject) {
            this.name = name;
            this.subject = subject;
        }

        public String getSubject() {
            return subject;
        }
    }
    public static void main(String[] args) {
        List<User> people = List.of(
                new Student("kis", 80),
                new Teacher("hosoya", "Math")
        );

        for(var p : people) {
            System.out.println("こんにちは%sさん".formatted(p.getName()));
        }
        // こんにちはkisさん
        // こんにちはhosoyaさん
    }
}
