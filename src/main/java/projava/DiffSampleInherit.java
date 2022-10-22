package projava;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;


public class DiffSampleInherit {
    public static void main(String[] args) {
        var f = new JFrame("差分プログラミング");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var img = new BufferedImage(600, 400,BufferedImage.TYPE_INT_RGB);
        var g = img.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0,0,600,400);
        g.drawImage(lineImage(), 10,10,f);
        g.drawImage(rectImage(), 300, 80, f);
//        g.drawImage(testImage(), 200, 100, f);
        var label = new JLabel(new ImageIcon(img));
        f.add(label);
        f.pack();
        f.setVisible(true);
    }

//    static BufferedImage lineImage() {
//        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
//        var graphics = image.createGraphics();
//        graphics.drawLine(10, 10, 400, 300);
//        return image;
//        return new LineDrawer().createImage();
//    }

    /*
        匿名クラス
     */
//    static BufferedImage lineImage(){
//        return new ImageDrawer(){
//            @Override
//            public void draw(Graphics2D g){
//                g.drawLine(10, 10, 400, 300);
//            }
//        }.createImage();
//    }
    // ↓
    // ImageDrawerインターフェイスに対する匿名クラスはラムダ式に変更できる
    // ↓
//    static BufferedImage lineImage() {
//        ImageDrawer drawer = g -> g.drawLine(10, 10, 220, 180);
//        return drawer.createImage();
//    }

    static BufferedImage lineImage() {
        return createImage(g -> g.drawLine(10, 10, 400, 300));
    }

//    static BufferedImage rectImage() {
//        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
//        var graphics = image.createGraphics();
//        graphics.drawRect(10, 10, 400, 300);
//        return image;
//        return new RectDrawer().createImage();
//    }
//    static BufferedImage rectImage() {
//        ImageDrawer drawer = g -> g.drawRect(10, 10, 400, 300);
//        return drawer.createImage();
//    }

    static BufferedImage rectImage() {
        return createImage(g -> g.drawRect(10, 10, 400, 300));
    }

    /*
        継承による差分プログラミング
        lineImageメソッドとrectImageメソッドで違う部分はdrawLineで線を引いているか、drawRectで四角を書いているかで、その前後の処理は共通
        異なる部分を抽象メソッドdrawとして持つようにして、共通部分からその抽象メソッドを呼びだすようなcreateImageメソッドを持ったImageDrawerクラスを作る
     */

//    static abstract class ImageDrawer {
//        BufferedImage createImage() {
//            var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
//            var graphics = image.createGraphics();
//            draw(graphics);
////            test(graphics);
//            return image;
//        }
//
//        abstract void draw(Graphics2D g);
//
////        abstract void test(Graphics2D g);
//    }

    /*
        ImageDrawerクラスはフィールドを持たないのでインターフェイスにすることができる
     */
//    @FunctionalInterface    // 関数型インターフェイスとして使うインターフェイスには@FunctionalInterfaceアノテーションを付けておくほうが、ラムダ式が使えるということがわかりやすくなる。
//    interface ImageDrawer {
//        // 実装のあるメソッドにはdefaultをつける
//        default BufferedImage createImage() {
//            var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
//            var graphics = image.createGraphics();
//            draw(graphics);
////            test(graphics);
//            return image;
//        }
//
//        // defaultもprivateもついていないメソッドはabstractになるのでabstractは省略
//        void draw(Graphics2D g);
//    }

    static BufferedImage createImage(Consumer<Graphics2D> drawer) {
        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        var graphics = image.createGraphics();
        drawer.accept(graphics);    // 受け取った関数型インターフェイスのメソッドを呼びだす。Consumerインターフェイスを使っているのでacceptメソッドになる
        return image;
    }

    /*
        ImageDrawerクラスを継承したクラスLineDrawerクラスを作って、drawメソッドをオーバーライドして直線を引く処理を実装する。
     */
//    static class LineDrawer extends ImageDrawer {
//        @Override
//        void draw(Graphics2D g) {
//            g.drawLine(10, 10, 400, 300);
//        }

//        @Override
//        void test(Graphics2D g){
//            g.drawLine(20, 10, 400, 300);
//        }
//    }

    /*
        rectImageメソッドに対しても同様にRectDrawerクラスを作ってdrawerメソッドを実装してrectImageメソッドで使う
     */
//    static class RectDraer extends ImageDrawer {
//        @Override
//        void draw(Graphics2D g){
//            g.drawRect(10, 10, 400, 300);
//        }

//        @Override
//        void test(Graphics2D g){
//            g.drawRect(20, 20,400, 300);
//        }
//    }

}
