public class Hello {
    public static void main(String[] args) {
        // var 変数名 = 値
        var t = "test";
        System.out.println(t);

        /*
        *   変数を定義しておくことで
        *   ・間違いを見つけてくれる
        *   ・入力が楽になる
        *   ・何を扱っているのかわかりやすくなる
        *   ・具体的な値を覚えておく必要がなくなる
        *   ・変更を一か所にまとめることができる
        *   ・使う値の一覧を作ることができる
        */

//        t = 5;  // java: 不適合な型: intをjava.lang.Stringに変換できません:
//        変数を最初に定義したときに暗黙的にstringとなっているため数値である「5」を代入することができない

        var i = 123;
        System.out.println(i * 3);
        i = 5;  // 同じ型の再定義なので可能
        System.out.println(i * 3);

        /*
        *   型の種類
        *   int     整数
        *   double  実数
        *   boolean 論理値
        *   char    文字
        *   String  文字列
        *
        *   Stringのみ大文字始まりになっている
        *   小文字で始まっているintやdoubleは基本型（プリミティブ型）という
        *   Stringはクラスで参照型と呼ばれる
        *
        *   参照型はメソッドを持つが、基本型にはメソッドがない。
        */

//        変数の型を指定
//        型 変数名 = 値
        String u = "miyane";
        System.out.println(u);

//        型を指定する場合には初期値を割り当てる必要がない
        int j;
        j = 5;
        System.out.println(j);

//        char型
        char ch = 48;
//        char型は0から65535までの整数を扱う型だがそれぞれの数値に割り当てられた文字を表現するために使用される
        System.out.println(ch); // "0"
//        48は「0」という文字を表す

        /*
         * 数値の型変換
         */

//    整数と実数での変換
        int i1 = 234;
        double d = i1;
        System.out.println(d);  // 234.0

        double d2 = 234.0;
//        int i2 = d2; // java: 不適合な型: 精度が失われる可能性があるdoubleからintへの変換

//        キャスト
        int ij = (int)d2;   // (型) 値
        System.out.println(ij);

//        文字列→数値
//        int a = "3";    //  java: 不適合な型: java.lang.Stringをintに変換できません:
//        int a = (int)"3";   //  java: 不適合な型: java.lang.Stringをintに変換できません:
        /*
        *   Javaでキャストによって値の変換ができるのは数値型の間だけで、他の型の値の変換にはキャストではなく「変換処理」を行う必要がある。
        *
        *   文字列 → int型
        *   Integer.parseInt()
        */
        int a = Integer.parseInt("3");
        System.out.println(a);
        /*
        *   文字列 → double型
        *   Double.parseDouble()
        */
        double dou = Double.parseDouble("12.3");
        System.out.println(dou);

        // 数値を文字列に変換
//        String s = 123;     // java: 不適合な型: intをjava.lang.Stringに変換できません:
        String s = 123 + "";    // +演算子のどちらかの辺が文字列の時には文字列の連結が行われる
        System.out.println(s);
//        実行速度に厳しいプログラムを作る場合
//        String.valueOfメソッドを使用
        var ss = String.valueOf(123);
        System.out.println(ss);
//        カンマ区切り
        var cs = "%,d".formatted(12345);
        System.out.println(cs);
//        カンマ区切り + 実行速度
        var fast = java.text.NumberFormat.getInstance()
                .format(12345);
        System.out.println(fast);
    }
}
