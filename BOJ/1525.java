import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {
    static int arr[][] = new int[30][30];
    static int x, y;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static TreeMap<String, Boolean> visited = new TreeMap<>();

    public static boolean in_range(int x, int y){
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    public static void toArr(String s){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = s.charAt(3 * i + j) - '0';

                if(arr[i][j] == 0){
                    x = i;
                    y = j;
                }
            }
        }
    }

    public static String toStr(){
        String s = "";

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                s += arr[i][j];
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        Queue<String> que = new LinkedList<>();
        int size;
        int d;
        int nx, ny;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        s = toStr();
        d = 0;
        que.add(s);
        visited.put(s, true);
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0){
                s = que.poll();

                if(s.equals("123456780")){
                    System.out.print(d);
                    return;
                }

                toArr(s);

                for(int i = 0; i < 4; i++){
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if(!in_range(nx, ny)) continue;

                    arr[x][y] = arr[nx][ny];
                    arr[nx][ny] = 0;

                    s = toStr();

                    if(!visited.getOrDefault(s, false)){
                        que.add(s);
                        visited.put(s, true);
                    }

                    arr[nx][ny] = arr[x][y];
                    arr[x][y] = 0;
                }
            }
            d++;
        }

        System.out.print(-1);
    }
}
