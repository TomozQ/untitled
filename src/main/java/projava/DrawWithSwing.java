package projava;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawWithSwing {
    public static void main(String[] args) {
        var f = new JFrame("drawing");
        f.setVisible(true);

        var label = new JLabel("test");
        f.add(label);
        f.pack();   // 配置されたコンポーネントに合わせてウィンドウが拡張される

        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);    // 画像の幅・高さ・種類を指定。種類は色情報をどのように扱うかの指定。

        label.setIcon(new ImageIcon(image));    // ラベルにiconとしてimageを指定
        f.pack();

        var g = image.createGraphics();
        g.drawLine(0, 0, 600, 400);     // 引数 -> 始点x, 始点y, 終点x, 終点y
        label.repaint();
        g.setColor(Color.RED);
        g.fillRect(300, 200, 150, 100);
        label.repaint();
    }
}
