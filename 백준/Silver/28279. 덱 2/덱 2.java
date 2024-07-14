import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int cmd = 0, value = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() > 1){
                st = new StringTokenizer(str, " ");
                cmd = Integer.parseInt(st.nextToken());
                value = Integer.parseInt(st.nextToken());
            } else {
                cmd = Integer.parseInt(str);
            }

            switch (cmd){
                case 1 : {
                    q.push(value);
                    break;
                }
                case 2 : {
                    q.offer(value);
                    break;
                }
                case 3 : {
                    if (!q.isEmpty()){
                        sb.append(q.poll()).append("\n");
                    } else sb.append(-1).append("\n");
                    break;
                }
                case 4 : {
                    if (!q.isEmpty()){
                        sb.append(q.pollLast()).append("\n");
                    } else sb.append(-1).append("\n");
                    break;
                }
                case 5 : {
                    sb.append(q.size()).append("\n");
                    break;
                }
                case 6 : {
                    if (q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                }
                case 7 : {
                    if (q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                }
                case 8 : {
                    if (q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peekLast()).append("\n");
                    break;
                }
            }

        }
        System.out.println(sb);
        br.close();
    }
}