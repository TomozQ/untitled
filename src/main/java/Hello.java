// パッケージのimport
import java.math.BigDecimal;
import java.time.*;

public class Hello {
    public static void main(String[] args) {
//        標準API = クラスライブラリ
       /*
       *    日付時刻
       */
        var time = java.time.LocalDate.now();
        System.out.println(time);   // 2022-10-10
        var time1 = java.time.LocalTime.now();
        System.out.println(time1);  // 15:04:39.835798700
        var time2 = java.time.LocalDateTime.now();
        System.out.println(time2);  // 2022-10-10T15:07:22.227698900

        /*
        *   java.time.LocalDate
        *   java.time ... パッケージ名
        *   LocalDate ... クラス名
        */

        var date = LocalDateTime.now();
        System.out.println(date);

        // 日付時刻の操作
        var now = LocalDateTime.now();
        var daysLater = now.plusDays(3);    // 3日後
        System.out.println(now);
        System.out.println(daysLater);
        var daysBefore = now.minusDays(3);  // 3日前
        System.out.println(daysBefore);
        var nextWeek = now.plusWeeks(1);    // 1週間後
        System.out.println(nextWeek);
        var nextTime = now.plusHours(3);
        System.out.println(nextTime);                   //  3時間後

        // 指定した日付時刻
        var java17Release = LocalDate.of(2021, 9,14);
        System.out.println(java17Release);
        var java17Time = LocalTime.of(14, 30);  // 引数を増やして秒やナノ秒まで指定することもできる
        System.out.println(java17Time);
        var java17DateTime = LocalDateTime.of(java17Release, java17Time);   // 日付と時刻を組み合わせてDateTime / 引数を5つ渡して生成することもできる。
        System.out.println(java17DateTime);

        // 日付時刻の整形
        var t = "%tm月".formatted(now);
        System.out.println(t);
        var ft = "%tH時%tM分".formatted(now, now);
        System.out.println(ft);
        var ftoday = "%tY年%<tm月%<td日".formatted(now);
        System.out.println(ftoday);

        // staticメソッドとインスタンスメソッド
        /*
         *  LocalDate.now, LocalDate.of ... staticメソッド*
         *  クラス名を指定してからの呼び出し*
         *  クラス名.メソッド名（引数）*
         **
         *  toUpperCase / plusDays など ... インスタンスメソッド*
         *  値.メソッド名（引数）*
         */


        /*
        *   BigDecimal*
        */
        // 実数計算の誤差
        var num = 579 * 0.05;
        System.out.println(num);    // 28.950000000000003
        // double型での実数は内部的にはコンピュータにとって効率的な2進数で扱われているので、10進数で表したものと比べると誤差が出ることがある。

        var cnum = BigDecimal.valueOf(579).multiply(BigDecimal.valueOf(0.05));      // 長い
        System.out.println(cnum);   // 28.95

        var b579 = BigDecimal.valueOf(579);
        var b005 = BigDecimal.valueOf(0.05);
        System.out.println(b579.multiply(b005));    // 28.95

        // newによるBigDecimalオブジェクトの生成
        var pi = Math.PI;
        System.out.println(pi);     // 3.141592653589793 小数点以下15桁まで
        // 小数点以下18桁以上を扱いたいとき
        var cpi = BigDecimal.valueOf(3.141592653589793238);
        System.out.println(cpi);    // 3.141592653589793 15桁以上の精度は扱えない
        // 文字列を渡すと
        var correctPi = new BigDecimal("3.141592653589793238");
        System.out.println(correctPi);  // 3.141592653589793238
        /*
        *   BigDecimalでは仕様上少なくとも10億桁程度の精度を扱える
        */

        // オブジェクト
        /*
        *   コンストラクタによって生成される、クラスの値のことをオブジェクトという。
        *   intなどのプリミティブ型の値はオブジェクトではなく、それ以外の値は全てオブジェクトになる。
        */
    }
}
