import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int t;
        long ans;
        long x;

        t = Integer.parseInt(br.readLine());
        while(t-->0){
            while(!pq.isEmpty()){
                pq.poll();
            }

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            ans = 0;
            while(pq.size() > 1){
                x = pq.poll();
                ans += x + pq.peek();
                pq.add(x + pq.poll());
            }

            System.out.println(ans);
        }
    }
}
