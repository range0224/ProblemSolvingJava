import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            x = sc.nextInt();

            v.add(x);
        }

        Collections.sort(v);

        if(n % 2 == 0) System.out.print(v.get(n / 2 - 1));
        else System.out.print(v.get(n / 2));
    }
}
