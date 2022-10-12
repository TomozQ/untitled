package projava;

public class LoopStepSample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++ ) {
            for (int j = 0; j < i; j++) {
                System.out.printf("O");
            }
            System.out.println();
        }

        // 文字列を複数回繰り返すメソッド  repeat()
        for (int i = 1; i < 5; i++) {
            System.out.print("O".repeat(i));
            System.out.println();
        }

    }
}
