import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    static BigInteger n;
    static long arr[] = {11, 111, 11111, 1111111, 11111111111L, 1111111111111L, 11111111111111111L};
    static BigInteger ans;

    public static void recur(int cur, BigInteger mul, int cnt){
        if(cur == 7){
            if(cnt % 2 == 0) ans = ans.subtract(n.divide(mul));
            else ans = ans.add(n.divide(mul));

            return;
        }

        recur(cur + 1, mul.multiply(new BigInteger("" + arr[cur])), cnt + 1);
        recur(cur + 1, mul, cnt);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = new BigInteger(sc.next());

        ans = n;

        recur(0, new BigInteger("1"), 0);

        System.out.print(ans);
    }
}
