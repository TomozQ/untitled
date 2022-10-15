package projava;

import java.time.LocalTime;

/*
*   メソッドの使いこなし
*/
public class Overload {
    public static void main(String[] args) {
        /*
        *   引数の組み合わせの違う同じ名前のメソッドを複数定義することをオーバーロードという
        *   オーバーロードを行う場合は、引数の省略として考えて、動作は同じになるようにする。
        *   下記のように一番引数の多いメソッドに集約されていく形がよい
        */
//        LocalTime of (int hour, int minute) {
//            return of(hour, minute, 0);
//        }
//
//        LocalTime of (int hour, int minute, int second) {
//            return of(hour, minute, second, 0);
//        }
//
//        LocalTime of (int hour, int minute, int second, int nanoOfSecond) {
//            実際にLocalTimeオブジェクトを生成する処理
//        }
    }
}
