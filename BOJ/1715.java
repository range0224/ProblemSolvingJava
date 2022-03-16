import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int x;
        int ans;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            pq.add(sc.nextInt());
        }

        ans = 0;
        while(pq.size() > 1){
            x = pq.poll();
            x += pq.poll();

            ans += x;
            pq.add(x);
        }

        System.out.print(ans);
    }
}
