package projava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    /*
        Webサーバーを作る
     */
    public static void main(String[] args) throws IOException {
        // 8880番ポートで待ち受けるソケットを用意
        var server = new ServerSocket(8880);
        // 何度も受け付ける為に処理自体は無限ループ
        for(;;){
            // try-with-resources
            try (/*
                    acceptメソッドで通信を待ち受ける
                    クライアントから接続を受け取ったら、その接続を管理するソケットからBufferedReaderとPrintWriterを取得
                */
                Socket soc = server.accept();
                var isr = new InputStreamReader(soc.getInputStream());
                var bur = new BufferedReader(isr);
                var w = new PrintWriter(soc.getOutputStream());
            ){
                System.out.println("connected from " + soc.getInetAddress());
                // 接続を受け取ったらリクエストヘッダーを読み込む
                // Streamを処理するtakeWhileメソッドを使って、リクエストヘッダー終了の合図である空行が来るまで出力処理を行う
                bur.lines()
                        .takeWhile(line -> !line.isEmpty())
                        .forEach(System.out::println);
                w.println("""
                        HTTP/1.1 200 OK
                        Content-Type: text/html
                        
                        <html><head><title>Hello</title></head>
                        <body><h1>Hello World</h1>It works!</body></html>
                        """);
            }
        }
    }
}
