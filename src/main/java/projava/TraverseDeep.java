package projava;

import java.io.PipedOutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

public class TraverseDeep {
    /*
        再帰による深さ有線探索
     */
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, },
                {1, 0, 1, 0, 0, 0, 1, },
                {1, 0, 0, 0, 1, 0, 1, },
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

//    static boolean traverse(int[][] map, int curX, int curY) {
//        switch (map[curY][curX]){
//            case 0: break;          // 通路なので続きの処理   switch文のbreakはループを抜けるのではなく、switch文を抜ける
//            case 2: return true;    // ゴール
//            default: return false;  // 通れない
//        }
//        // 処理が進むときは後戻り防止のために、既に通った場所であることを示す3を割り当てる
//        map[curY][curX] = 3;        // 通った印
//        if(   // 右、左、下、上に移動して、同じ処理を行うようtraverseメソッドを再帰
//                traverse(map, curX + 1, curY)
//                || traverse(map, curX - 1, curY)
//                || traverse(map, curX, curY + 1)
//                || traverse(map, curX, curY - 1)
//        ){
//            // どれかの方向のtraverseメソッド呼び出しでゴールに到達したことを表すtrueが返ってくれば、そのままゴールに到達したとしてtrueを返す
//            return true;
//        }
//        map[curY][curX] = 0;          // ゴールにたどり着かなかったので通った印を戻す
//        return false;
//    }

    /*
        メソッドの再帰呼び出しをスタックを使った処理に置き換える
        ↓
     */

    static boolean traverse(int[][] map, int curX, int curY) {
        // 引数で受け取った値をまとめてスタックに積む必要があるため、スタックに積むデータをまとめるためのレコードを用意する。
        record Position(int x, int y){} // mapは変更がないのでスタックに積む必要がないのでレコードに含まない

//        var stack = new ArrayDeque<Position>();     // スタックを使う場合に使用するクラス。両端キューとも呼ぶ。
        // キュー用に変更　↓
        Queue<Position> queue = new ArrayDeque<>();
//        stack.push(new Position(curX, curY));       // 最初のtraverse呼び出し時の引数をまとめてスタックに積む
        // キュー用に変更　↓
        queue.offer(new Position(curX, curY));

//        for (Position p; (p = stack.pollFirst()) != null ;){        // スタックからpollFirstメソッドで値を取り出すとともに、nullでないときに処理を続けるよう判定 変数に割り当てつつ値を判定
        // スタック → キュー pollFirst → pollLast
//        for (Position p; (p = stack.pollLast()) != null ;){           // 最後に追加した要素を取り出す
        for (Position p; (p = queue.poll()) != null ;){
            switch (map[p.y()][p.x()]){
                case 0: break;          // 通路なので続きの処理
                case 2: return true;    // ゴールなので終了
                // 続きの処理を飛ばしてループを繰り返す
                default: continue;      // 通れないので他のマスの処理
            }
            /*
                switch内のbreakとcontinue
                break ... switch文を抜ける
                continue ... その外側のfor文の続きの処理を行う
             */
            map[p.y()][p.x()] = 3;
//            stack.push(new Position(p.x() + 1, p.y()));
//            stack.push(new Position(p.x() - 1, p.y()));
//            stack.push(new Position(p.x(), p.y() + 1));
//            stack.push(new Position(p.x(), p.y() - 1));

            // キュー用に変更 ↓

            queue.offer(new Position(p.x() + 1, p.y()));
            queue.offer(new Position(p.x() - 1, p.y()));
            queue.offer(new Position(p.x(), p.y() + 1));
            queue.offer(new Position(p.x(), p.y() - 1));
        }
        return false;
    }
}
