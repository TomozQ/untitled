package projava;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        /*
        *   List
        *   同じ型の値をまとめて扱うデータ構造
        */
        var names = List.of("yamamoto", "kishida", "sugiyama");
        System.out.println(names);  // [yamamoto, kishida, sugiyama]

        // Listから値を取り出す
        var name1 = names.get(1);
        System.out.println(name1);  // kishida

        // 要素数を取得
        var size = names.size();
        System.out.println(size);       // 3

        /*
        *   変更のできるList
        */

        // add
//        names.add("test");      // List.ofで生成した配列にはaddできない

        var authors = new ArrayList<String>();
        System.out.println(authors);    // []

        authors.add("yamamoto");
        authors.add("kishida");
        System.out.println(authors);    // [yamamoto, kishida]
        authors.add("sugiyama");

        // set 要素の書き換え
        authors.set(1, "naoki");         // set(inddex, 値)
        System.out.println(authors);     // [yamamoto, naoki, sugiyama]

        /*
        *   ジェネリクスによる型検査
        */
//        authors.add(123);       // java: 不適合な型: intをjava.lang.Stringに変換できません:
        // 例外ではなく構文エラーになる。ジェネリクス型で型指定をすると、対応していない値を扱おうとしたときに構文エラーになる。プログラムを書いているときにエラーが見つかるので実行時エラーにならない。

        /*
        *   ジェネリクスの型推論
        */
        var authors2 = new ArrayList<>(names);  // namesの型から推論できるので<String>と書くところお省略して<>と書ける。 / <> → ダイヤモンドオペレータ
        System.out.println(authors2);

        /*
        *   ラッパークラス
        */
        var nums = List.of(1, 2, 3);
        System.out.println(nums);                   // [1, 2, 3]
        // int型ではなくInteger型。Listではプリミティブ型は使用できない。参照型（オブジェクトの型）を指定する必要がある。

        /*
        *   配列
        *   Listでは利用できなかったプリミティブ型が利用できる。
        */
        // 配列の初期化
        var scores = new int[3];
        System.out.println(Arrays.toString(scores));
        System.out.println(scores.length);  // 3

        int[] nums2 = {1, 2, 3};
        System.out.println(Arrays.toString(nums2));

        // 要素を設定した配列の初期化
        scores = new int[]{1, 2, 5};
        System.out.println(Arrays.toString(scores));

        // 配列の要素の利用
        var score = scores[1];
        System.out.println(score);
        System.out.println(Arrays.toString(scores));

        // 多次元配列
        var mat = new int[2][3];
        System.out.println(Arrays.deepToString(mat));   // [[0, 0, 0], [0, 0, 0]]
        mat[1][2] = 5;
        System.out.println(Arrays.deepToString(mat));   // [[0, 0, 0], [0, 0, 5]]
        var arr1 = mat[1];
        System.out.println(Arrays.toString(arr1));      // [0, 0, 5]

        /*
        *   レコードで違う種類の値を組み合わせる
        */
        // 違う種類の値をListでまとめて扱う
//        String型の受験者名、科目名、int型の点数をListで
        var exam = List.of("kis", "math", 80);
        System.out.println(exam);
        // レコード
        record Exam (String name, String subject, int score) {}     // record レコード名(コンポーネントの型 コンポーネントの名前, ...)
        // レコードのオブジェクトを作成
        var e1 = new Exam("kis", "math", 80);
        System.out.println(e1);         // Exam[name=kis, subject=math, score=80]
        var name = e1.name();
        System.out.println(name);   // kis

        /*
        *   Mapで辞書を作る
        */
        var jp = "apple";
        var en = switch(jp){
            case "apple" -> "りんご";
            case "grape" -> "ぶどう";
            default -> "見つからない";
        };

        // Map.of
        var fruits = Map.of("apple", "りんご", "grape", "ぶどう");
        System.out.println(fruits);             // {grape=ぶどう, apple=りんご}
        var grape = fruits.get("grape");
        System.out.println(grape);              // ぶどう
        var banana = fruits.get("banana");
        System.out.println(banana);             // null
        banana = fruits.getOrDefault("banana", "見つからない");   // 値が見つからない場合には「見つからない」を返す
        System.out.println(banana);             // 見つからない

        // 変更可能なMap
        // Map.ofで生成したMapも変更不能
        // HashMap
        var animals = new HashMap<String, String>();    // キーも値も文字列
        System.out.println(animals);    // {}
        // キーと値を格納
        animals.put("dog", "いぬ");
        animals.put("cat", "ねこ");
        System.out.println(animals);    // {cat=ねこ, dog=いぬ}
        var animal = animals.get("cat");
        System.out.println(animal);     // ねこ
        var none = animals.get("fox");
        System.out.println(none);       // null
        var result = animals.put("cat", "猫");
        System.out.println(result);     // ねこ　→　直前に格納されていた値が出力される
        System.out.println(animals);    // {cat=猫, dog=いぬ}

        // イミュータブル（不変）なオブジェクト
        /*
        *   格納した値の変更ができないもの→イミュータブル
        */
    }
}
