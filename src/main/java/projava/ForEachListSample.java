package projava;

import java.util.List;

public class ForEachListSample {
    public static void main(String[] args) {
        /*
        *   データ構造を拡張for文で扱う
        */
        // 基本for分でのListの要素の処理

        var strs = List.of("apple", "banana", "grape");
        for (int i = 0; i < strs.size(); i++) {
            var str = strs.get(i);
            System.out.println(str);
        }

        // 拡張for文によるListの要素の処理
        // for (var 変数: 配列やList)
        for (String str : strs) {
            System.out.println(str);
        }

    }
}
