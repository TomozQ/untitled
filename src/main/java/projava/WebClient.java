package projava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WebClient {
    public static void main(String[] args) throws IOException {
        /*
            example.comの80番ポートに接続
            文字列を3行送信
            受け取った文字列の18行分を表示する
         */
        var domain = "example.com";
        try(
                var soc = new Socket(domain, 80);
                /*
                    ReaderとWriter
                    HTTPは文字列で通信を行うプロトコル。
                    文字列を扱うとき、文字をどのようにデータとして表すかという文字エンコーディングが問題になる。
                    現在では世界中の文字を統一的に扱えるUnicodeという文字集合が主流
                    ファイルのほぞにゃネットワークでのやりとりをするときは、データの無駄なく扱えるUTF-8が使われる。
                    一方Javaで内部的に使っている文字エンコーディングは、Unicodeを効率よく処理できるUTF-16
                    データを送信するときはUTF-16からUTF-8、データを受信するときはUTF-8からUTF-16へ変換する必要がある。

                    そういった文字エンコーディングの変換を行ってくれるのがReadeerクラスとWriterクラス

                    実際には1行単位での入出力ができるBufferdReaderクラスとPrintWriterクラスを多くの場合使う
                 */
                // 出力
                var pw = new PrintWriter(soc.getOutputStream());
                // 入力
                // BufferdReaderオブジェクトを生成するが、InputStreamからBufferdReaderオブジェクトを直接生成することができないので、InputStreamオブジェクトを経由している。
                var isr = new InputStreamReader(soc.getInputStream());
                var bur = new BufferedReader(isr)
        ){
            // PrintWiterオブジェクトに対してprintlnメソッドで1行単位の出力が行える
            pw.println("GET /index.html HTTP/1.1");     // HTTPメソッド リソース HTTP/バージョン
            pw.println("Host: " + domain);              // リクエストヘッダー
            /*
                Host:       アクセスしているドメイン
                User-Agent: ブラウザ種別
                Referer:    リンク元

                Hostヘッダーは必ず指定しなくてはならない

                1つのWebサーバーで複数のドメイン名のサイトを処理することがある。
                TCP/IPの仕組み上、どのドメイン名でアクセスされたのかサーバー側からはわからないので、クライアントからHostヘッダーでドメイン名を指定する必要がある。
             */
            pw.println();
            /*
                ソケットへの出力は、ある程度まとまってから一気に行うという仕組みになっているので、printlnメソッドを呼びだした時点ですぐに送信されるわけではない。
                flushメソッドで強制的に送信を行っている。
             */
            pw.flush();
            // linesメソッドで文字列のStreamを得ている。
            bur.lines()
                    .limit(18)
                    .forEach(System.out::println);
        }

//        HTTP/1.1 200 OK                                   // HTTP/バージョン ステータスコード メッセージ
                                                            /*
                                                                ステータスコード
                                                                200         正常に終了
                                                                403         閲覧許可がない
                                                                404         情報が見つからない
                                                                301, 302    リダイレクト
                                                                500         内部エラー
                                                             */
        /*
            レスポンスヘッダー
         */
//        Accept-Ranges: bytes
//        Age: 130869
//        Cache-Control: max-age=604800
//        Content-Type: text/html; charset=UTF-8                // ドキュメントの種類    ブラウザはこのヘッダーを元にファイルの処理方法を決める。この時に指定するのはMIMEタイプという形式で 「text/html」 のようになる。
        /*
            MIME ... Multipurpose Internet Mail Extension
            多目的メール拡張
            もともとはメールにファイルを添付するための規格だったが、ファイル種別指定方式がMIMEタイプとしてメール以外でも使われるようになった。
            空行でレスポンスヘッダーが終わって、そのあとからがドキュメント本体にはる。
         */
//        Date: Sat, 15 Oct 2022 10:57:22 GMT
//        Etag: "3147526947+gzip"
//        Expires: Sat, 22 Oct 2022 10:57:22 GMT
//        Last-Modified: Thu, 17 Oct 2019 07:18:26 GMT          // 最終更新日時
//        Server: ECS (sab/56BC)
//        Vary: Accept-Encoding
//        X-Cache: HIT
//        Content-Length: 1256                                  // データサイズ
//
//                <!doctype html>
//<html>
//<head>
//    <title>Example Domain</title>

    }
}
