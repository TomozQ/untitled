package projava;

import java.util.Objects;

public class ClassSample {
    static final class Student {
        /*
            クラスのメンバー
            クラスの要素となるもの
            ・コンストラクタ
            ・フィールド
            ・メソッド
            ・ネステッドクラス
         */

        /*
            アクセス修飾子
            private ... 同じクラス
            指定なし ... 同じパッケージ
            public ... 制限なし
            protected ... 同じパッケージか、継承したクラス
         */

        private final String name;
        private final int score;

        /*
            コンストラクタ
            オブジェクトを生成するときに呼びだされる特別なメソッド
            クラスと同じ名前で定義する
            必ずそのクラスのオブジェクトを返すため、戻り値は指定しない。

            デフォルトコンストラクタ
            何もコンストラクタを定義しない場合は、引数無しで何もしないコンストラクタが自動的に定義される。
            1つでもコンストラクタを定義すると、デフォルトコンストラクタは定義されなくなる。
         */
        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String name() {
            return name;
        }

        public int score() {
            return score;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Student) obj;
            return Objects.equals(this.name, that.name) &&
                    this.score == that.score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score);
        }

        @Override
        public String toString() {
            return "Student[" +
                    "name=" + name + ", " +
                    "score=" + score + ']';
        }
    }

    public static void main(String[] args) {
        var s = new Student("kis", 89);
        System.out.println(s);      // Student[name=kis, score=89]
    }
}
