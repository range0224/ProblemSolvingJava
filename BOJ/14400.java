import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        long ans;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            x.add(a);
            y.add(b);
        }

        Collections.sort(x);
        Collections.sort(y);

        ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.abs(x.get(i) - x.get(n / 2));
            ans += Math.abs(y.get(i) - y.get(n / 2));
        }

        System.out.print(ans);
    }
}
