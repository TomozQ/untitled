package projava;

public class RunLengthCompression {
    public static void main(String[] args) {
        /*
            ランレングス圧縮
         */
        // final ... 変更のできない変数
        final var COUNTER_BASE = -1;                // 連続した個数から2を引いた数字を出力するので、1番目の文字を出力するとしたら-1
        var data = "abbcccbaaaabccccccccccccddd";

        var count = COUNTER_BASE;                   // 同じ文字が連続した数を数える変数 count
        char prev = 0;
        var builder = new StringBuilder();
        for(var ch : data.toCharArray()){
            if (prev == ch){
                // 同じ文字が続くとき
                // カウントを増やす
                count ++;
                if (count == 9) {
                    // 9まできたら出力
                    builder.append('9');
                    // 9を出力した後の文字は改めて出力をするためループ開始前の状態にする。
                    count = COUNTER_BASE;
                    prev = 0;
                }
            }else{
                // 違う文字が来た時
                if (count >= 0){
                    // 前の文字が連続してたので数字を出力
                    builder.append((char) ('0' + count));
                    // カウントを戻す
                    count = COUNTER_BASE;
                }
                builder.append(ch);
                prev = ch;
            }
        }
        // ループを抜けたときに最後の文字が連続していれば数字を出力
        if (count >= 0){
            builder.append((char) ('0' + count));
        }
        var result = builder.toString();
        System.out.println(data);                   // abbcccbaaaabccccccccccccddd
        System.out.println(result);                 // ab0c1ba2bc9cd1
    }
}
