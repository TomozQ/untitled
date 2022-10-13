package projava;

public class ForEachArraySample {
    public static void main(String[] args) {
        // 拡張forによる配列の要素の処理
        var nums = new int[]{2, 3, 5, 7};
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
