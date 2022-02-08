import java.util.Scanner;

public class Main {
    public static long gcd(long a, long b){
        long temp;

        while(a % b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a, b;
        long x;
        long ans;

        a = sc.nextLong();
        b = sc.nextLong();

        x = b / a;

        ans = 1;
        for(int i = 1; i * i <= x; i++){
            if(x % i == 0 && gcd(i, x / i) == 1){
                ans = i;
            }
        }

        System.out.print(a * ans + " " + a * (x / ans));
    }
}
