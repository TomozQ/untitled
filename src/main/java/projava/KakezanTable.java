package projava;

public class KakezanTable {
    public static void main(String[] args) {
        for (int i =  1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%2d | ", i * j); // printfは改行を行わない
            }
            System.out.println();
        }
    }
}
