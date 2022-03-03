import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static ArrayList<int[]> v = new ArrayList<>();
    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static int ans[] = new int[60];

    public static void check(int a, int b){
        ArrayList<Integer> dist = new ArrayList<>();
        int sum;

        for(int i = 0; i < n; i++){
            dist.add(Math.abs(a - v.get(i)[0]) + Math.abs(b - v.get(i)[1]));
        }

        Collections.sort(dist);

        sum = 0;
        for(int i = 0; i < n; i++){
            sum += dist.get(i);

            ans[i] = Math.min(ans[i], sum);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v.add(new int[]{a, b});
            x.add(a);
            y.add(b);
        }

        for(int i = 0; i < n; i++) ans[i] = 1 << 30;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                check(x.get(i), y.get(j));
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
