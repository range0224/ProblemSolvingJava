import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n;
        ArrayList<Long> ans = new ArrayList<>();
        long x;

        n = sc.nextLong();

        x = n;
        for(long i = 2; i * i <= n; i++){
            while(x % i == 0){
                ans.add(i);
                x /= i;
            }
        }

        if(x != 1) ans.add(x);

        System.out.println(ans.size());
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
