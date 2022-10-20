package projava;

import java.util.Arrays;

public class ParamSample {
    /*
        クラスとファイル
        Javaのソースファイルは拡張子.javaで保存する
        ソースファイルはパッケージ名に対応したフォルダに格納する必要がある
        projava.example.Basic -> projava/example/Basic.java

        ソースファイルの中では、publicなアウタークラスはファイル名と同名である必要がある。
        複数のアウタークラスを1つのソースファイルに書くことはできるが、publicにできるのはファイル名と同じ名前のクラスだけ。
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));      // []
    }
}

class Dummy {

}

// publicなのはParamClassなのでParamSample.javaという名前で保存する必要がある