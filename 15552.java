import java.io.*;
import java.util.ArrayList;

public class practice{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        if(T>1000000) System.exit(0);

        for (int i = 0; i < T; i++){
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            bw.write((A+B)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}