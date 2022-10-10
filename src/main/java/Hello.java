// パッケージのimport
import java.math.BigDecimal;
import java.time.*;

public class Hello {
    public static void main(String[] args) {
        /*
        *   論理型
        */
        var bool = "test".contains("es");   // contains() 文字列が含まれているか判定
        System.out.println(bool);
        var bool2 = "test".contains("a");
        System.out.println(bool2);

        /*
        *   オブジェクトの大小比較
        *   比較演算子での比較ができるのはプリミティブ型だけ。
        *   文字列などのオブジェクトでは比較演算子での比較はできない。
        */

//        var sbool = "apple" > "grape";  // java: 二項演算子'>'のオペランド型が不正です
//        System.out.println(sbool);

//        文字列などのオブジェクトを比較するときにはcompareToメソッドを使用
        var sbool = "apple".compareTo("banana");
        System.out.println(sbool);      // -1
        /*
        *   compareToメソッドでは、「 < 」が成り立つような関係では負の値、「 > 」が成り立つような関係では正の値、等しいとみなせる場合には0が返る
        */

        // 日付のcompareTo
        var today = LocalDate.now();
        var java17 = LocalDate.of(2021, 9,14);
        var dbool = today.compareTo(java17);
        System.out.println(dbool);  // 1

        // isBefore isAfter
        System.out.println(today.isAfter(java17));      // true
        System.out.println(today.isBefore(java17));     // false

        /*
        *   オブジェクトが等しいかどうかの比較
        */
        var eqbool = "test" == "test";  // true
        var eqbool2 = "test" == "TEST"; // false
        System.out.println(eqbool);
        System.out.println(eqbool2);

        var str = "TEST".toLowerCase();
        System.out.println(str);                // test
        System.out.println(str == "test");      // false
        /*
        *   変数strが test という値を保持しているのに ==演算子での比較では false が返ってくる。
        *   == や != は「同じオブジェクトであるか」という比較であり、「同じ値であるか」という比較ではない。
        *   オブジェクトの示す値が等しいかどうかを判定するには
        *   equals
        *   を使う
        */
        System.out.println(str.equals("test")); // true

        /*
        *   論理演算子
        */
        var a = 5;
        System.out.println(a);
        var abool= 3 <= a && a <= 7;
        System.out.println(abool);

        a = 1;
        var abool2 = 3 <= a && a <= 7;
        System.out.println(abool2);

        /*
        *   条件演算子
        */
        var aa = 3;
        System.out.println(aa);                                 // 3
        var aabool = aa < 5 ? "small" : "big";
        System.out.println(aabool);                             // small
        aa = 7;
        System.out.println(aa);                                 // 7
        aabool = aa < 3? "low" : aa < 7 ?  "middle" : "high";   // 3より小さい→low / 3以上7より小さい→middle / それ以外→high
        System.out.println(aabool);                             // high
    }
}
