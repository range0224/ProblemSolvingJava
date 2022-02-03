import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static ArrayList<int[]> v = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        n = Integer.parseInt(bf.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bf.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            v.add(new int[]{a, b});
        }

        Collections.sort(v, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });

        pq.add(v.get(0)[1]);
        for(int i = 1; i < n; i++){
            if(pq.peek() <= v.get(i)[0]) pq.poll();

            pq.add(v.get(i)[1]);
        }

        System.out.print(pq.size());
    }
}
