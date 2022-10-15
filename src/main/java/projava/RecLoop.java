package projava;

public class RecLoop {
    public static void main(String[] args) {
        /*
        *   再帰によるループ
        *   再帰... メソッドの中でそのメソッド自身を呼びだすこと
        *   通常のループより再帰によるループの方が多様な形の繰り返しに対応できるようになっている。
        */
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // ⇓ 再帰に書き換える

        loop(0);
    }

    static void loop(int i) {
        if(i >= 5) {
            return;
        }
        System.out.println(i);
        loop(i + 1);
    }
}
