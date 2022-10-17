package projava;

public class TraverseDeep {
    /*
        再帰による深さ有線探索
     */
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, },
                {1, 0, 1, 0, 0, 0, 1, },
                {1, 0, 0, 0, 1, 1, 1, },
                {1, 0, 1, 0, 0, 2, 1, },
                {1, 1, 1, 1, 1, 1, 1, },
        };

        traverse(map, 1, 1);
        char[] ch = {'.', '*', 'G', 'o'};

        for (int[] row : map) {
            for (int cell : row){
                System.out.print(ch[cell]);
            }
            System.out.println();
        }
    }

    static boolean traverse(int[][] map, int curX, int curY) {
        switch (map[curY][curX]){
            case 0: break;          // 通路なので続きの処理   switch文のbreakはループを抜けるのではなく、switch文を抜ける
            case 2: return true;    // ゴール
            default: return false;  // 通れない
        }
        // 処理が進むときは後戻り防止のために、既に通った場所であることを示す3を割り当てる
        map[curY][curX] = 3;        // 通った印
        if(   // 右、左、下、上に移動して、同じ処理を行うようtraverseメソッドを再帰
                traverse(map, curX + 1, curY)
                || traverse(map, curX - 1, curY)
                || traverse(map, curX, curY + 1)
                || traverse(map, curX, curY - 1)
        ){
            // どれかの方向のtraverseメソッド呼び出しでゴールに到達したことを表すtrueが返ってくれば、そのままゴールに到達したとしてtrueを返す
            return true;
        }
        map[curY][curX] = 0;          // ゴールにたどり着かなかったので通った印を戻す
        return false;
    }
}
