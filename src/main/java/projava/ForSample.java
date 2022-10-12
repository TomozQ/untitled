package projava;

public class ForSample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i ++;
        }

        // continueとbreak
        for (int ii = 0; ii < 5; ii++) {
            if( ii == 2) {
                System.out.println("skip");
                continue;
            }
            System.out.println(ii);
        }

        for (int iii = 0; iii < 5; iii++) {
            if(iii == 2) {
                System.out.println("finish");
                break;
            }
            System.out.println(iii);
        }
    }
}
