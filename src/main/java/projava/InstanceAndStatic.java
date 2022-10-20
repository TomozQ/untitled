package projava;

public class InstanceAndStatic {
    /*
        インスタンスフィールドとstaticフィールド
        インスタンスフィールドはインスタンスごとに領域が用意されるが、staticフィールドはクラスに1つだけ領域が用意される。
     */
    static class A { String s; }
    static class B { static String t; }
    public static void main(String[] args) {
        var a1 = new A();
        System.out.println(a1);     // projava.InstanceAndStatic$A@776ec8df
        var a2 = new A();
        System.out.println(a2);     // projava.InstanceAndStatic$A@4eec7777

        a1.s = "Hello";
        a2.s = "World";
        System.out.println(a1.s + a2.s);    // HelloWorld

        var b1 = new B ();
        System.out.println(b1);     // projava.InstanceAndStatic$B@6d311334
        var b2 = new B ();
        System.out.println(b2);     // projava.InstanceAndStatic$B@682a0b20

        b1.t = "Hello";
        System.out.println(b1.t);   // Hello
        System.out.println(b2.t);   // Hello    b2は代入していないのに「Hello」が出力される。

        b2.t = "World";
        System.out.println(b1.t);   // World    b1も同じく代入していないのに「World」が出力される。

    }
}
