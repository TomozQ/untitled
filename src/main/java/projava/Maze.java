package projava;

import java.io.IOException;

public class Maze {
    public static void main(String[] args) throws IOException {     // throws IOExeption ... 「このメソッドで例外が発生するので呼び出し側で処理するように」という印
        record  Position(int x, int y){}
        int[][] map = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
        };

        var current = new Position(1, 1);
        var goal = new Position(4, 3);

        for(;;) {       // 処理を無限に繰り返す
            // 迷路の表示
            for (int y = 0; y < map.length; y ++) {         // mapの長さ分繰り返す
                for (int x = 0; x < map[y].length; x ++){    // mapの要素の長さ分繰り返す
                    if(x == current.x() && y == current.y()) {  // xもyもcurrentと同じ場合はoで現在位置を表す
                        System.out.print("o");
                    } else if (map[y][x] == 1) {
                        System.out.print("*");
                    }else{
                        System.out.print(".");
                    }
                }
                System.out.println();
            }

            // ゴール判定
            if (current.equals(goal)){
                System.out.println("GOAL!!!");
                break;
            }

            // キー入力処理
            int ch = System.in.read();
            // 押された方向の座標を得る
            var next = switch (ch) {
                case 'a' -> new Position(current.x() - 1, current.y());
                case 'w' -> new Position(current.x(), current.y() - 1);
                case 's' -> new Position(current.x() + 1, current.y());
                case 'z' -> new Position(current.x(), current.y() + 1);
                default -> current;
            };

            // 押された方向が通路なら進む
            if (map[next.y()][next.x()] == 0) {
                current = next;
            }

            // Enterキーの入力を捨てる
            System.in.read();   // Enterキーが入力されるので読み込んで無視する（何もしない）
        }
    }
}
