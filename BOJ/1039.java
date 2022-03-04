import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static boolean visited[] = new boolean[1000010];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;
        Queue<Integer> que = new LinkedList<>();
        int size;
        String cur;
        String nxt;
        int x;
        int mx;

        n = sc.nextInt();
        m = sc.nextInt();

        que.add(n);
        while(m-->0){
            for(int i = 0; i < 1000010; i++) visited[i] = false;

            size = que.size();
            while(size-->0){
                cur = "" + que.poll();

                for(int i = 0; i < cur.length(); i++){
                    for(int j = i + 1; j < cur.length(); j++){
                        if(i == 0 && cur.charAt(j) == '0') continue;

                        nxt = "";
                        for(int k = 0; k < i; k++){
                            nxt += cur.charAt(k);
                        }
                        nxt += cur.charAt(j);
                        for(int k = i + 1; k < j; k++){
                            nxt += cur.charAt(k);
                        }
                        nxt += cur.charAt(i);
                        for(int k = j + 1; k < cur.length(); k++){
                            nxt += cur.charAt(k);
                        }

                        x = Integer.parseInt(nxt);

                        if(visited[x]) continue;

                        que.add(x);
                        visited[x] = true;
                    }
                }
            }
        }

        mx = -1;
        for(int i = 0; i < 1000010; i++){
            if(visited[i]) mx = i;
        }

        System.out.print(mx);
    }
}
