import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    static int n;
    static boolean visited[] = new boolean[1000010];
    static int prv[] = new int[1000010];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> ans = new Stack<>();

        n = sc.nextInt();

        que.add(n);
        prv[n] = -1;
        visited[n] = true;
        while(!que.isEmpty()){
            n = que.poll();

            if(n == 1){
                while(n != -1){
                    ans.add(n);
                    n = prv[n];
                }

                System.out.println(ans.size() - 1);
                while(!ans.isEmpty()){
                    System.out.print(ans.peek() + " ");
                    ans.pop();
                }

                return;
            }

            if(n % 3 == 0 && !visited[n / 3]){
                que.add(n / 3);
                visited[n / 3] = true;
                prv[n / 3] = n;
            }
            if(n % 2 == 0 && !visited[n / 2]){
                que.add(n / 2);
                visited[n / 2] = true;
                prv[n / 2] = n;
            }
            if(n > 0 && !visited[n - 1]){
                que.add(n - 1);
                visited[n - 1] = true;
                prv[n - 1] = n;
            }
        }
    }
}
