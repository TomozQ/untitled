package projava;

import javax.swing.*;

public class Swing {
    public static void main(String[] args) {
        /*
        *   Swing
        */
        // ウィンドウを表示
        var f = new JFrame("test");     // JFrameというクラスでウィンドウを表す
        System.out.println();
        System.out.println(f);  // javax.swing.JFrame[frame0,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=test,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]

        f.setVisible(true); // trueで表示
        f.setSize(600, 400);        // window size
        f.setLocation(200, 200);        //  window 表示位置

        var location = f.getLocation();
        System.out.println(location);   // java.awt.Point[x=200,y=200]

        // 入力領域の配置
        var t = new JTextField();
        f.add("North", t);  // 入力領域をウィンドウに配置
        f.validate();   // タイトル部分を加味
        t.setText("Hello"); // 入力領域にHelloを表示
        var val = t.getText();
        System.out.println(val);    // Hello

        var t2 = new JTextField("");
        t.setText(t2.getText().toUpperCase());
        f.add("South", t2);
        f.validate();

        // ボタン
        var b = new JButton("Upper");
        f.add("Center", b);
        f.validate();
        b.addActionListener(ae -> t.setText(t2.getText().toUpperCase()));   // ae ... Action Event

        // 参照を扱う
        var tcopy = t;
        t.setText("Hello copy");
        tcopy.setText("Hello original");
        var value = t.getText();
        System.out.println(value);  // Hello original
        /*
        *   変数tと変数tcopyが同じオブジェクトを扱っている。
        *   オブジェクトを扱う変数は、オブジェクトの参照と言われるものを持つ。
        *   オブジェクトを扱う型を参照型という。
        *   int型などのプリミティブ型では参照にはならない
        */
    }
}
