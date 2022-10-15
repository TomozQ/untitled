package projava;

public class MethodSample {
    /*
    *   mainメソッドもstaticメソッド
    *   staticメソッドから呼びだす同じクラス内のメソッドはstaticメソッドにする必要がある。
    *   同じクラス内のstaticメソッドの呼び出しではクラス名を省略できる。
    */
    public static void main(String[] args) {
        var result = twice(3);
        System.out.println(result);     // 6
    }

    static int twice (int x) {
        return x * 2;
    }

    /*
    *   mainメソッドの正体
    *   public ... どこのクラス空でも呼び出し可能
    *   Stringの配列を引数に取って戻り値を返さないmainという名前のstaticメソッド
    *   引数にString配列を取っているが、これはコマンドラインから呼び出した時に指定したパラメータが入る。
    *   受け取ったパラメータは変数argsで扱えるようにしている。
    */
}
