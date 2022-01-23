import java.util.Scanner;
import java.util.TreeSet;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static long a, b, ea, eb;
    static TreeSet<Long> s = new TreeSet<>();
    static Queue<Long[]> que = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y;
        long nx, ny;
        long temp;
        int size;
        int d;

        a = sc.nextLong();
        b = sc.nextLong();
        ea = sc.nextLong();
        eb = sc.nextLong();

        d = 0;
        s.add(0L);
        que.add(new Long[]{0L, 0L});
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0) {
                x = que.peek()[0];
                y = que.peek()[1];
                que.poll();

                if (x == ea && y == eb) {
                    System.out.print(d);
                    return;
                }

                nx = 0;
                ny = y;
                if (!s.contains(nx * (b + 1) + ny)) {
                    s.add(nx * (b + 1) + ny);
                    que.add(new Long[]{nx, ny});
                }

                nx = a;
                ny = y;
                if (!s.contains(nx * (b + 1) + ny)) {
                    s.add(nx * (b + 1) + ny);
                    que.add(new Long[]{nx, ny});
                }

                nx = x;
                ny = 0;
                if (!s.contains(nx * (b + 1) + ny)) {
                    s.add(nx * (b + 1) + ny);
                    que.add(new Long[]{nx, ny});
                }

                nx = x;
                ny = b;
                if (!s.contains(nx * (b + 1) + ny)) {
                    s.add(nx * (b + 1) + ny);
                    que.add(new Long[]{nx, ny});
                }

                temp = Math.min(x, b - y);
                nx = x - temp;
                ny = y + temp;
                if (!s.contains(nx * (b + 1) + ny)) {
                    s.add(nx * (b + 1) + ny);
                    que.add(new Long[]{nx, ny});
                }

                temp = Math.min(a - x, y);
                nx = x + temp;
                ny = y - temp;
                if (!s.contains(nx * (b + 1) + ny)) {
                    s.add(nx * (b + 1) + ny);
                    que.add(new Long[]{nx, ny});
                }
            }
            d++;
        }

        System.out.print(-1);
    }
}
