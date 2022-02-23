import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    static int n;
    static int arr[] = new int[10010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        PriorityQueue<Integer> mn = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mx = new PriorityQueue<>();

        t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            mn.clear();
            mx.clear();

            System.out.println(n / 2 + 1);
            mn.add(arr[0]);
            for(int i = 1; i <= n; i++){
                if(i % 2 == 1){
                    System.out.print(mn.peek() + " ");
                    if(i % 20 == 19 && i != n) System.out.println("");
                }

                if(arr[i] > mn.peek()) mx.add(arr[i]);
                else mn.add(arr[i]);

                while(mn.size() > mx.size() + 1){
                    mx.add(mn.poll());
                }
                while(mn.size() <= mx.size()){
                    mn.add(mx.poll());
                }
            }
            System.out.println("");
        }
    }
}
