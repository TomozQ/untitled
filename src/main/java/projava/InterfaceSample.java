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
    }

    /*
        implements ... でインターフェイスを実装
     */
    record Student(String name, int score) implements Named {}
    record Teacher(String name, String subject) implements Named {}

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

    }
}
