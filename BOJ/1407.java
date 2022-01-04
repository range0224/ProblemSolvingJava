import java.util.Scanner;

public class Main {
    static long a, b;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long ans = 0;

        a = sc.nextLong();
        b = sc.nextLong();

        for(long i = 1; i <= b; i *= 2){
            ans += i * (b / i - b / (2 * i));
            ans -= i * ((a - 1) / i - (a - 1) / (2 * i));
        }

        System.out.print(ans);
    }
}
