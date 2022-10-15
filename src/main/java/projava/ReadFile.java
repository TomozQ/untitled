package projava;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        var p = Path.of("test.txt");
        // 例外
//        var p = Path.of("test.txta");       // Exception in thread "main" java.nio.file.NoSuchFileException: test.txta
        String s = Files.readString(p);
        System.out.println(s);

        // try句で例外に対処する
        try {
            Path pp = Path.of("testa.txt");
            String ss = Files.readString(pp);
            System.out.println(ss);
        } catch (NoSuchFileException e) {
            System.out.println("ファイルが見つかりません: " + e.getFile());     // ファイルが見つかりません: testa.txt
        } finally {     // 例外が発生してもしなくても実行したい処理
            System.out.println("finally");
        }
    }
}
