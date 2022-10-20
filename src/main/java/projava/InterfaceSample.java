package projava;

import java.util.List;

public class InterfaceSample {
    /*
        インターフェイス
        複数のクラスに共通の性質を示すための仕組み。
        共通の性質 ... 同じように呼び出せるメソッドを持っているかどうか
        つまり、複数のクラスが同じメソッドを持っていることを示す仕組み

        インターフェイスが欲しい状況というのは
        複数のクラスのメソッドを統一的に扱いたい場合
     */

    /*
        インターフェイスを定義
     */
    interface Named {
        String name();
        /*
            実装を持ったメソッドをインターフェイスに定義する
         */
        default String greeting() {
            return "こんにちは%sさん".formatted(name());
        }
        /*
            デフォルトメソッド
            オーバーライドすることができるが、実装を持ったメソッドはなるべくオーバーライドしないようにするほうが良い。
            インターフェイスでは他にも、staticメソッドやprivateメソッドも実装を持って定義できる。
         */

        /*
            インターフェイスにおけるアクセス制御
            publicかprivateを指定することができる。
            クラスの場合と違い、アクセス修飾子を省略するとpublicを指定したことになる。
            インターフェイスにフィールドを定義すると必ずpublic static finalになる。
         */
    }

    /*
        implements ... でインターフェイスを実装
     */
    record Student(String name, int score) implements Named {}
    record Teacher(String name, String subject) implements Named {}

    static class Passenger implements Named {   // クラス 'Passenger' は abstract 宣言されるか、'Named' の抽象メソッド 'name()' を実装する必要があります。
        @Override   // このメソッドがインターフェイスのメソッドを実装することを表す。
        /*
            インターフェイスで定義されたメソッドを実装することをオーバーライドという。
            @ で始まるのはアノテーションという構文だが、クラスやメソッドなどに何かの印をつける役割を持っている。なくてもかまわないがオーバーライドになっていないとき構文エラーとなってミスを見つけてくれる
         */
        public String name() {
            return "通りすがり";
        }
    }

    /*
        ラムダ式と関数型インターフェイス
        関数型インターフェイス ... 実装すべきメソッドが1つだけのインターフェイス
        ラムダ式は関数インターフェイスが必要なところに指定することができる
     */

    interface Named2 {
        String name();  // 実装すべきメソッドが1つだけのインターフェイス
    }

    // 関数型インターフェイスを引数に受けるmessageメソッド
    static void message(Named2 named2) {
        System.out.println("Hello" + named2.name());
    }

    @FunctionalInterface    // メソッドが一つでなくてもアノテーションをつけることでインターフェイスが関数型インターフェイスであることを明示することもできる。
    interface  Named3 {
        String name();
        default String greeting() {
            return "こんにちは%sさん".formatted(name());
        }
    }

    public static void main(String[] args) {
        var people = List.of(new Student("kis", 80), new Teacher("hosoya", "Math"));
        for (var p : people) {
            // 両方ともnameメソッドで名前を取り出すことができる。
            // instanceof ... オブジェクトが、ある型として扱えるかどうか判定する「演算子」。変数名を指定しておくとその変数に値が割り振られる。
            var n = p instanceof Student s ? s.name() : p instanceof Teacher t ? t.name() : "----";
            System.out.println("こんにちは%sさん".formatted(n));
        }
        /*
            for (var p: people) {
                System.out.println("こんにちは%sさん".formatted(p.name()));
            }
            どちらにもnameメソッドがあるが、同じメソッドがあるだけでは統一的に扱うことはできず、構文エラーとなる。
         */

        // ↓

        /*
            インターフェイスを実装したクラスのオブジェクトは、そのインターフェイスのオブジェクトとして扱える。
         */
        for (Named p : people) {
            var n = p.name();
            System.out.println("こんにちは%sさん".formatted(n));
        }

        var people2 = List.of(
                new Student("kis", 80),
                new Teacher("hosoya", "Math"),
                new Passenger()
        );

        for (Named p : people2) {
            var n = p.name();
            System.out.println("こんにちは%sさん".formatted(n));
        }

        message(() -> "no name");   // Hellono name
    }
}
