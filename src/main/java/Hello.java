public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");
//        文字列のフォーマット
        System.out.println("test%s".formatted(12+3));   // %s →　書式指定子
        System.out.println("%sと%s".formatted("test", "sample"));    // formattedメソッドには書式指定子を満たすだけの引数を与える必要がある
//        整数についても%sで埋め込めるが、%dを使うほうが適切
        System.out.println("%d+%d=%d".formatted(2, 3, 2+3));
//        %dを使用することで数値ならではの形式が指定できる。
        System.out.println("消費税抜き%,d円は消費税混みで%,d円".formatted(1000, 1100));   // << %,d >> と入力することで3桁区切りでカンマが入る
    }
}
