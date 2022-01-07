import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int n;
    static int arr[][] = new int[100][100];
    static boolean visited[][] = new boolean[100][100];
    static int dist[][] = new int[100][100];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x  < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        Deque<Integer> dq_x = new LinkedList<>();
        Deque<Integer> dq_y = new LinkedList<>();
        int x, y;
        int nx, ny, nd;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            str = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        dq_x.add(0);
        dq_y.add(0);
        while(!dq_x.isEmpty()){
            x = dq_x.peekFirst();
            y = dq_y.peekFirst();
            dq_x.pollFirst();
            dq_y.pollFirst();

            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(!in_range(nx, ny)) continue;

                if(arr[nx][ny] == 1) nd = dist[x][y];
                else nd = dist[x][y] + 1;

                if(!visited[nx][ny] || dist[nx][ny] > nd){
                    dist[nx][ny] = nd;
                    visited[nx][ny] = true;

                    if(arr[nx][ny] == 1){
                        dq_x.addFirst(nx);
                        dq_y.addFirst(ny);
                    }else{
                        dq_x.addLast(nx);
                        dq_y.addLast(ny);
                    }
                }
            }
        }

        System.out.print(dist[n - 1][n - 1]);
    }
}
