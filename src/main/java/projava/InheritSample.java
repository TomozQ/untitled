package projava;

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

    public static void main(String[] args) {

    }
}
