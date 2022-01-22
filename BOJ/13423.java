import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t;
        int s, e;
        int mid;
        int cnt;

        t = Integer.parseInt(bf.readLine());
        while(t-->0){
            n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());

            v.clear();
            for(int i = 0; i < n; i++){
                v.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(v);

            cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    s = 0;
                    e = n - 1;
                    while(s <= e){
                        mid = (s + e) / 2;

                        if(v.get(mid) == v.get(j) + v.get(j) - v.get(i)){
                            cnt++;
                            break;
                        }else if(v.get(mid) > v.get(j) + v.get(j) - v.get(i)){
                            e = mid - 1;
                        }else{
                            s = mid + 1;
                        }
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
