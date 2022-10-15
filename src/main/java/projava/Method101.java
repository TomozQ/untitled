package projava;

public class Method101 {
    public static void main(String[] args) {
        /*
        *   メソッドの宣言
        */
        // 基本的なメソッド
        message();
        greeting("kis");
        var n = twice(2);
        System.out.println(n);      // 4
    }
    static void message() {
        System.out.println("Hello");
    }

    static void greeting(String name) {
        System.out.println("Hello" + name);
    }

    /*
    *   戻り値のあるメソッドの宣言
    *
    *   戻り値の型 メソッド名 (引数の型 処理中で使う変数  ) {
    *       ...処理...
    *   }
    */
    static int twice(int x) {
        return x * 2;
    }
}
