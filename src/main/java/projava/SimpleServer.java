package projava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        /*
            ネットワークでコンピュータの外の世界と関わる
         */
        // サーバーとクライアント
        var server = new ServerSocket(1600);
        System.out.println("Waiting...");

        // accept() ... クライアントからの接続を待ち受ける
//        Socket soc = server.accept();   // クライアントからの接続があった時に、そのクライアントとやりとりするためのSocketオブジェクトが返される。
//        System.out.println("connect from " + soc.getInetAddress());
//        // getInputStreamメソッドでInputStreamオブジェクトを得る
//        InputStream input = soc.getInputStream();
//        System.out.println(input.read());   // readメソッドでデータを受信する
//        // 通信が終わったらclose
//        input.close();
//        soc.close();

        // ⇓ try-with-resources

        try (
                Socket soc = server.accept();
                InputStream input = soc.getInputStream()
        ){
            System.out.println("connect from " + soc.getInetAddress());
            System.out.println(input.read());
        }


    }
}
