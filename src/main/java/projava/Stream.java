package projava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        /*
        *   Stream
        *   値の集合に対する処理を使いまわす仕組み
        */
        // IntelliJ IDEAによるStreamへの変換
        var data = List.of("yamamoto", "kis", "sugiyama");
        var result1 = new ArrayList<String>();
        // collect
        for (var s : data) {
            if(s.length() >= 5){
                result1.add(s);
            }
        }

        // ⇓

        result1 = data.stream().filter(s -> s.length() >= 5).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result1);


        // count
        var result2 = 0;
        for (var s : data) {
            if (s.length() >= 5){
                result2 ++;
            }
        }

        // ⇓

        result2 = 0;
        result2 += data.stream().filter(s -> s.length() >= 5).count();
        System.out.println(result2);

        // Streamの構成
        var result = (int) data.stream()            // Streamのソース
                .filter(s -> s.length() >= 5)       // 中間処理（値を操作する）
                .count();                           // 終端処理（値をまとめる）

        // Streamソース
        var names = List.of("yamamoto", "kis", "sugiyama");
        System.out.println(names);                              // [yamamoto, kis, sugiyama]
        var stream = names.stream().toList();
        System.out.println(stream);                             // [yamamoto, kis, sugiyama]

        var starray = new String[]{"test", "hello", "world"};
        System.out.println(Arrays.toString(starray));           // [test, hello, world]
        var arStream = Arrays.stream(starray).toList();
        System.out.println(arStream);                           // [test, hello, world]


        // 終端処理
        // allMatchとその仲間
       var bool =  names.stream().allMatch(s -> s.contains("y"));   // 全ての要素が条件を満たすか
        System.out.println(bool);       // false

        bool = names.stream().anyMatch(s -> s.contains("y"));
        System.out.println(bool);      // true

        bool = names.stream().noneMatch(s -> s.contains("y"));
        System.out.println(bool);       // false

        bool = names.stream().noneMatch(s -> s.contains("n"));
        System.out.println(bool);       // true

        // collectors
        var res = names.stream().collect(Collectors.joining());
        System.out.println(res);        // yamamotokissugiyama

        res = names.stream().collect(Collectors.joining("/"));
        System.out.println(res);        // yamamoto/kis/sugiyama

        var res2 = names.stream().collect(Collectors.toList());
        System.out.println(res2);       // [yamamoto, kis, sugiyama]

        // forEach
        names.stream().forEach(s -> System.out.println(s));
        // yamamoto
        // kis
        // sugiyama

        names.forEach(s -> System.out.println(s));

        // 中間処理
        // 要素に対する処理
        var res3 = names.stream().filter(s -> s.length() > 5).toList();
        System.out.println(res3);

        res3 = names.stream().map(s -> s.toUpperCase()).toList();
        System.out.println(res3);

        // 全体に対する処理
        res3 = names.stream().skip(1).toList();
        System.out.println(res3);       // [kis, sugiyama]

        res3 = names.stream().limit(2).toList();
        System.out.println(res3);       // [yamamoto, kis]

        res3 = names.stream().sorted().toList();
        System.out.println(res3);       // [kis, sugiyama, yamamoto]

        var als = List.of("abc", "cde", "abc");
        var res4 = als.stream().distinct().toList();
        System.out.println(res4);       // [abc, cde]

        // Optional
        var res5 = names.stream().findAny();    // 見つかった値がOptionalに格納される。
        System.out.println(res5);       // Optional[yamamoto]
        var empty = List.of();
        var res6 = empty.stream().findAny();
        System.out.println(res6);       // Optional.empty   要素がない場合はemptyが返ってくる

        var o = Optional.of("test");
        System.out.println(o);      // Optional[test]
        var res7 = o.get();
        System.out.println(res7);       // test

//        var res8 = Optional.empty().get();  // Exception in thread "main" java.util.NoSuchElementException: No value present

        var res8 = Optional.empty().orElse("無");
        System.out.println(res8);           // 無
        res8 = o.orElse("無");
        System.out.println(res8);           // test
        res8 = o.map(s -> s.toUpperCase()).orElse("無");
        System.out.println(res8);           // TEST
        var res9 = o.isPresent();
        System.out.println(res9);           // true
        res9 = o.isEmpty();
        System.out.println(res9);           // false
        o.ifPresent(s -> System.out.println(s));        // test     値があるときだけ処理を行う

        /*
        *   基本型のStream処理
        */
        // IntStreamで整数の処理
        var numbers = new int[]{2, 5, 3};
        System.out.println(Arrays.toString(numbers));       // [2, 5, 3]
        var res10 = IntStream.of(numbers).sum();
        System.out.println(res10);  // 10
        var numArray = IntStream.range(0, 10).toArray();    // 始まり値と終わり値を指定。終わり値の1つ前の値まで生成される。toArrayメソッドで配列を生成
        System.out.println(Arrays.toString(numArray));      // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        numArray = IntStream.rangeClosed(0, 10).toArray();  // 終わり値を含む
        System.out.println(Arrays.toString(numArray));      // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        numArray = IntStream.iterate(0, i -> i < 10, i -> i + 1).toArray();     // iterateメソッドは引数に初期値、繰り返し条件、次の値を得る計算を指定し、for文のように利用できる。
        System.out.println(Arrays.toString(numArray));      // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        numArray = IntStream.iterate(123, i -> (i * 211 + 2111) % 1000).limit(10).toArray();
        System.out.println(Arrays.toString(numArray));      // [123, 64, 615, 876, 947, 928, 919, 20, 331, 952]

        // 中間処理
        numArray = IntStream.of(numbers).map(number -> number * 2).toArray();
        System.out.println(Arrays.toString(numArray));      // [4, 10, 6]
        numArray = IntStream.of(numbers).filter(n -> n < 5).toArray();
        System.out.println(Arrays.toString(numArray));      // [2, 3]
        numArray = IntStream.of(numbers).sorted().toArray();
        System.out.println(Arrays.toString(numArray));      // [2, 3, 5]

        // StreamとIntStreamの行き来
        var numbersArray = IntStream.of(numbers).mapToObj(n -> "*".repeat(n)).toList();     // mapToObj ... IntStreamからオブジェクトのStreamを得る
        System.out.println(numbersArray);                   // [**, *****, ***]
        var namesArray = names.stream().mapToInt(s -> s.length()).toArray();
        System.out.println(Arrays.toString(namesArray));    // [8, 3, 8]

        /*
        *   JavaではStreamとIntStreamなどを意識して使い分ける必要がある。
        *   基本型とオブジェクト型はしっかり区別する。
        */
    }
}
