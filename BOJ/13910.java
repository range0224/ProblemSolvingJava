import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static int arr[] = new int[110];
    static boolean visited[] = new boolean[10010];
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        int size;
        int d;
        int cur;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            v.add(arr[i]);
            for(int j = i + 1; j < m; j++){
                v.add(arr[i] + arr[j]);
            }
        }

        d = 0;
        que.add(0);
        visited[0] = true;
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0){
                cur = que.poll();

                if(cur == n){
                    System.out.print(d);
                    return;
                }

                for(int i = 0; i < v.size(); i++){
                    if(cur + v.get(i) > n || visited[cur + v.get(i)]) continue;

                    que.add(cur + v.get(i));
                    visited[cur + v.get(i)] = true;
                }
            }
            d++;
        }

        System.out.print(-1);
    }
}
