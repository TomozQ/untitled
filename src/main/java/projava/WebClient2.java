package projava;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebClient2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
            HttpClient API
         */
        // Http Clientの用意
        HttpClient client = HttpClient.newHttpClient(); // HttpClientの取得
        URI uri = URI.create("https://example.com/");   // URIクラスを使ってドメインを指定
        // Http Requestの用意
        HttpRequest req = HttpRequest.newBuilder(uri).build();
        // 用意したHttp Requestを送ってレスポンスの処理
        HttpResponse<String> response = client.send(        // HttpClientに対してsendメソッドでHttpRequestを送る
                req, HttpResponse.BodyHandlers.ofString()   // レスポンスの処理方法をBodyHandlerとして指定する
        );
        String body = response.body();                  // HttpResponseに対してbodyメソッドを呼びだすとデータ本体が得られる     BodyHandlers.ofString()としているので今回の場合はString型としてデータを取得
        body.lines()
                .limit(5)
                .forEach(System.out::println);
    }
}
