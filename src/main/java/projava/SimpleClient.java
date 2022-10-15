package projava;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        /*
            Sockerオブジェクトを生成するときのコンストラクタに、接続先のドメイン名かIPアドレスと、ポート番号を指定する。
            localhost -> プログラムを動かしているのと同じコンピュータを示す。今回はサーバーが1600番ポートで待ち受けているので、同じポート番号を指定する。
            サーバーに接続できると、サーバーと通信するためのSocketオブジェクトが返る。そうするとサーバー/クライアントとも相手と通信するためのSocketオブジェクトを得るので、データの送受信を行える状態となる。
        */
//        var soc = new Socket("localhost", 1600);
//        /*
//        *   Javaでデータを入出力するにはInputStreamクラスとOutputStreamクラスを使用する。
//        *   ソケットに対しデータを送信するときにgetOutputStreamメソッドでOutputStreamオブジェクトを得る
//        */
//        OutputStream output = soc.getOutputStream();
//        // writeメソッドでデータを送信
//        output.write(234);
//        // 通信が終わったらclose()
//        output.close();
//        // 通信が終わったらソケットを閉じるためにcloseメソッドを呼びだす。
//        soc.close();

        // Waiting...
        // connect from /127.0.0.1
        // 234

        // ⇓ try-with-resources

        try (
                var soc = new Socket("localhost", 1600);
                OutputStream is = soc.getOutputStream()
        ){
            is.write(234);
        }
    }
}
