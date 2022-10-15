package projava;

import java.util.List;
import java.util.stream.IntStream;

public class MethodRefSample {
    public static void main(String[] args) {
        IntStream.range(0, 3)
                .map(MethodRefSample::twice)
//                .map(x -> MethodRefSample.twice(x))   // ラムダ式だとこう
                .forEach(System.out::println);
        //  0
        //  2
        //  4

        // InteliJ IDEAでラムダ式とメソッド参照の変換
        var names = List.of("yamamoto", "kis", "sugiyama");
        names.forEach(x -> System.out.println(x));
        names.forEach(System.out::println);
    }
    static int twice (int x) {
        return x * 2;
    }
}

/*
*   引数 -> 引数.メソッド()
*   ⇓
*   メソッドの属するクラス名::メソッド
*/