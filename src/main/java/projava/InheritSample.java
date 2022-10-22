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

    /*
        クラスを継承するときはextendsを付けて継承元のクラスを指定する。
        継承本野クラスをスーパークラス、継承先をサブクラスという。
     */

    /*
        抽象クラス
        UserクラスはStudentクラスやTeacherクラスを統一的に扱うためのクラスで、本来はオブジェクトを作って利用することは想定していない。
        クラスの前にabstractを付けると、クラスを抽象クラスにできる
     */
    static abstract class User {
        String name;

        /*
            継承でのコンストラクタ
            サブクラスでスーパークラスのフィールドを初期化するのはあまりよくない。
        */
        User(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }

        /*
            スーパークラスで定義されているメソッドをサブクラスで定義しなおして上書きすることをオーバーライドという。
            ユーザークラスはどこも継承していいないように見えるがJavaのObjectクラスを継承している。
            ObjectクラスのtoStringクラスをオーバーライドする。
         */
//        @Override
//        public String toString() {
//            return "%sの%s".formatted(getClass().getSimpleName(), getName());
//        }

        /*
            抽象メソッド
            このクラスを継承したサブクラスにこういうメソッドを持っていてほしいというものを定義する。
         */
        abstract String profile();

        @Override
        public String toString() {
            return profile();
        }
    }

    static class Student extends User {     // クラス 'Teacher' は abstract 宣言されるか、'User' の抽象メソッド 'profile()' を実装する必要があります
        int score;

        Student(String name, int score) {
            super( name );       // コンストラクタでスーパークラスのフィールドも初期化
//            this.name = name;
            this.score = score;
        }

        public int getScore () {
            return score;
        }

        @Override
        String profile() {
            return "学生 %s, %d点".formatted(getName(), getScore());
        }
    }

    static class Teacher extends User {     // クラス 'Teacher' は abstract 宣言されるか、'User' の抽象メソッド 'profile()' を実装する必要があります
        String subject;

        Teacher(String name, String subject) {
            super(name);
//            this.name = name;
            this.subject = subject;
        }

        public String getSubject() {
            return subject;
        }

        @Override
        String profile() {
            return "先生 %s, 教科 %s".formatted(getName(), getSubject());
        }
    }

    public static void main(String[] args) {
        List<User> people = List.of(        // Userクラスを継承しておりStudentクラスもTeacherクラスもUserクラスのサブクラスということになるのでUserのリストに格納できる
                new Student("kis", 80),
                new Teacher("hosoya", "Math"),
                /*
                    匿名クラス
                 */
                new User("匿名") {
                    @Override
                    String profile() {
                        return "ダミー";
                    }
                }
        );

        for(var p : people) {
            System.out.println("こんにちは%sさん".formatted(p.getName()));
            System.out.println(p);
        }
        // こんにちはkisさん
        // 学生 kis, 80点
        // こんにちはhosoyaさん
        // 先生 hosoya, 教科 Math
    }
}
