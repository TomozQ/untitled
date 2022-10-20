package projava;

import java.util.Objects;

public class ClassSample {
    /*
        ネステッドクラス
        クラスについたfainalは継承できないことを表す。
        クラスの中でクラスを定義するときにはstaticをつける。
     */
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

        /*
            フィールド
            オブジェクトに関する情報を保持
            フィールドはプライベートにすることが多く、クラスの外から使う場合には読み書き用のメソッドを定義する。
         */
        // finalをつけると変更できないフィールド、つけないと変更できるフィールド
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

    /*
        アクセッサメソッド
        クラスの外から値を読めるけど変更はクラスの中だけでしか出来ないといったアクセス制限をするフィールドの宣言方法はない。
        そういった制御をしたい場合にはフィールドをprivateにして、読み込み用のメソッドだけpublicなものを作る
     */
    private String name2;

    public String getName2(){
        return name2;
    }
    // 読み書きが行える場合も、値の設定時に内容の検査などの処理を行えるように、フィールドをprivateにしておいてメソッドを介することがよくある。
    private String name3;

    public String getName3() {
        return name3;
    }
    public void setName3(String name3){
        this.name3 = name3;
    }
    /*
        フィールドにアクセスするためのメソッドを書くときには、getNameメソッドやsetNameメソッドのように、getまたはsetに続けてフィールド名の先頭を大文字で始めた名前にする。
        このようなメソッドをそれぞれゲッター、セッターといい、まとめてアクセッサと呼ぶ。
     */

    /*
        名前付き定数
        staticかつfinalなフィールド
        定数の変数名は大文字で、アンダースコア区切りにする。
        finalをつけると誤って値を変更することがなく、コードを見るときも意図がわかりやすくなる。
        殆どの場合、どこからでも使えるようにpublicにする。
     */
    public static final int TYPE_INT_RGB = 1;
    public static final int TYPE_INT_ARGB = 2;
}
