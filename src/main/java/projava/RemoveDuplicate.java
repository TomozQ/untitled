package projava;

public class RemoveDuplicate {
    /*
        処理の難しさの段階
        ループの難しさの段階
     */
    public static void main(String[] args) {
//        他のデータを参照するループ
        var data = "abcccbaabcc";

        var builder = new StringBuilder();      // 結果の文字列を構築する。どんどん値を追加して文字列を構築していくときに使うクラス
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);           // 文字列から文字を取り出す
            if (i > 0 && ch == data.charAt(i - 1)){
                continue;
            }
            builder.append(ch);
        }

        var result = builder.toString();    // StringBuilderオブジェクトに構築された文字列を取得する
        System.out.println(data);       // abcccbaabcc
        System.out.println(result);     // abcbabc

        // 拡張for文に変更
        // ⇓

        char prev = 0;                          // データに現れない数値として0を割り当てる
        var builder2 = new StringBuilder();
        for(char ch : data.toCharArray()){      // 文字列を格納した配列を取得
            if (ch == prev) {
                continue;
            }
            builder2.append(ch);
            prev = ch;
        }

        var result2 = builder2.toString();
        System.out.println(result2);        // abcbabc
    }
}
