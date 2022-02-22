import java.util.Scanner;
import java.util.TreeSet;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static int arr[] = new int[510];
    static TreeSet<Integer> v[] = new TreeSet[510];
    static int cnt[] = new int[510];
    static int ans[] = new int[510];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t;
        int a, b;
        Queue<Integer> que = new LinkedList<>();
        boolean dup;
        int cur, idx;

        t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();

            for(int i = 1; i <= n; i++) v[i] = new TreeSet<>();

            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    v[arr[i]].add(arr[j]);
                }
            }

            m = sc.nextInt();
            for(int i = 0; i < m; i++){
                a = sc.nextInt();
                b = sc.nextInt();

                if(v[a].contains(b)){
                    v[a].remove(b);
                    v[b].add(a);
                }else{
                    v[b].remove(a);
                    v[a].add(b);
                }
            }

            for(int i = 1; i <= n; i++) cnt[i] = 0;

            for(int i = 1; i <= n; i++){
                for(int j : v[i]){
                    cnt[j]++;
                }
            }

            que.clear();
            for(int i = 1; i <= n; i++){
                if (cnt[i] == 0) {
                    que.add(i);
                }
            }

            idx = 0;
            while(!que.isEmpty()){
                cur = que.poll();

                ans[idx++] = cur;

                for(int i : v[cur]){
                    cnt[i]--;

                    if(cnt[i] == 0) que.add(i);
                }
            }

            if(idx < n){
                System.out.println("IMPOSSIBLE");
            }else{
                for(int i = 0; i < n; i++){
                    System.out.print(ans[i] + " ");
                }
                System.out.println("");
            }
        }
    }
}
