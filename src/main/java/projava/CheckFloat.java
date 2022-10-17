package projava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFloat {
    // 状態を表す値をenumとして用意
    // enum ... プログラム中で利用する値をまとめて扱えるようにする型
    enum FloatState {
        START, INT, FRAC_START, FRAC, ZERO
    }
//    static boolean check(String data){
//        var state = FloatState.START;
//        for(char ch : data.toCharArray()){
//            switch (state) {
//                case START -> {
//                    if (ch == '0'){
//                        state = FloatState.ZERO;
//                    } else if (ch >= '1' && ch <= '9') {
//                        state = FloatState.INT;
//                    }else{
//                        return false;
//                    }
//                }
//                case ZERO -> {
//                    if (ch == '.'){
//                        state = FloatState.FRAC_START;
//                    }else{
//                        return false;
//                    }
//                }
//                case INT -> {
//                    if(ch >= '0' && ch <= '9'){
//                        state = FloatState.INT;
//                    } else if (ch == '.') {
//                        state = FloatState.FRAC_START;
//                    }else{
//                        return false;
//                    }
//                }
//                case FRAC_START, FRAC -> {
//                    if(ch >= '0' && ch <= '9') {
//                        state = FloatState.FRAC;
//                    }else{
//                        return false;
//                    }
//                }
//            }
//        }
//        return switch (state){
//            case ZERO, INT, FRAC -> true;
//            default -> false;
//        };
//    }

    // ⇓

    // 正規表現に書き換え
    // Patern.compileメソッドで正規表現を解析して、文字列解釈用のステートマシンを管理するPatternオブジェクトを取得する
    static Pattern pat = Pattern.compile("(0|[1-9][0-9]*)(\\.[0-9]+)?");
    static boolean check(String data) {
        // Paternオブジェクトに対してmatcherメソッドで文字列を渡すと、文字列を解釈する過程を管理するMatcherオブジェクトが得られる。
        // (一文字ずつがどのような状態か、文字の処理がどこまで進んだかを管理)
        Matcher mat = pat.matcher(data);
        // 文字列全体が正規表現に適合するかを判定
        return mat.matches();
    }

    public static void main(String[] args) {
        System.out.println(check(""));          // false
        System.out.println(check("012"));       // false
        System.out.println(check(".12"));       // false
        System.out.println(check("12."));       // false
        System.out.println(check("1.2.3"));     // false
        System.out.println(check("1..3"));      // false
        System.out.println(check("0"));         // true
        System.out.println(check("12"));        // true
        System.out.println(check("12.3"));      // true
        System.out.println(check("0.3"));       // true
        System.out.println(check("12.30"));     // true
    }
}
