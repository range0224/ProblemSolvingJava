import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static ArrayList<Integer> v1 = new ArrayList<>();
    static ArrayList<Integer> v2 = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        long ans = 0;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            x = sc.nextInt();

            if(x == 1) ans++;
            else if(x <= 0) v1.add(x);
            else v2.add(x);
        }

        Collections.sort(v1);
        Collections.sort(v2);

        for(int i = 0; i < v1.size(); i += 2){
            if(i + 1 < v1.size()) ans += 1L * v1.get(i) * v1.get(i + 1);
            else ans += v1.get(i);
        }

        for(int i = v2.size() - 1; i >= 0; i -= 2){
            if(i - 1 >= 0) ans += 1L * v2.get(i) * v2.get(i - 1);
            else ans += v2.get(i);
        }

        System.out.print(ans);
    }
}
