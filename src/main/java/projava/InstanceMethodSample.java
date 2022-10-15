package projava;

public class InstanceMethodSample {
    // String型のname, int型のenglishScore, mathScoreというコンポーネントを持ったレコードを定義
//    record Student (String name, int englishScore, int mathScore) {}
//
//    public static void main(String[] args) {
//        var kis = new Student ("kis", 60, 80);
//        var a = average(kis);
//        System.out.println("平均点は%d点です。".formatted(a));      // 平均点は70点です。
//    }
//
//    static int average(Student s) {
//        return (s.englishScore() + s.mathScore()) / 2;
//    }

    // インスタンスメソッドを宣言する
    record Student(String name, int englishScore, int mathScore) {
        int average() {
//            return (this.englishScore() + this.mathScore()) / 2;    // このthisはメソッドが呼びだされたオブジェクト自身を表す。
            // 省略可能
            return (englishScore() + mathScore()) / 2;
        }

        public int maxScore() {
            return Math.max(englishScore(), mathScore());
        }
    }

    public static void main(String[] args) {
        var kis = new Student("kis", 60, 80);
        // averageメソッドの引数がなくなって、受け取った引数sの代わりにthisに対してengrishScoreメソッドなどを呼びだしている。
        var a = kis.average();
        // 「averageメソッドにkisを渡す」が「kisのaverageメソッドを呼び出す」になっている。
        System.out.println("平均点は%d点です".formatted(a));   // 平均点は70点です

        // IntelliJ IDEAにメソッドを宣言してもらう
        int max = kis.maxScore();
        System.out.println("最高点は%d点です。".formatted(max));    // 最高点は80点です。
        /*
        *   「メソッドが欲しいな」というのは呼びだしコード側コードを書いているときが多いので、
        *   先に呼び出し側コードを書いてメソッド宣言を行うというのは、
        *   実際にメソッドを考えるときの順番にも会って合っている。
        */
    }

    /*
    *   ラムダ式とメソッド参照
    */
    int twice(int x) {
        return x * 2;
    }
    // ⇓    メソッド宣言からメソッド名と戻り値の型を取り除き、引数の閉じカッコと処理開始の中カッコの間に -> を入れたものがラムダ式
//    (int x) {
//        return x * 2;
//    }
    // ⇓
//    (int x) -> {
//        return x * 2;
//    }
    // ⇓
//    (int x) -> { return x * 2};
    // ⇓    処理が一行の時には処理の中カッコは省略できる
//    (int x) -> x * 2
    // ⇓    引数の型は省略できる
//    (x) -> x * 2
    // ⇓    引数が1つの時カッコを省略できる。その時型も省略する。
//    x -> x * 2;

}
