import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n;
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans;
        int x, y;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            v.add(sc.nextInt());
        }

        Collections.sort(v, new Comparator<Integer>(){
          @Override
            public int compare(Integer a, Integer b){
              return Integer.compare(Math.abs(a), Math.abs(b));
          }
        });

        ans = 2000000000;
        x = 0;
        y = 0;
        for(int i = 1; i < v.size(); i++){
            if(ans > Math.abs(v.get(i) + v.get(i - 1))){
                ans = Math.abs(v.get(i) + v.get(i - 1));
                x = Math.min(v.get(i), v.get(i - 1));
                y = Math.max(v.get(i), v.get(i - 1));
            }
        }

        System.out.print(x + " " + y);
    }
}
