package Opseg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Range {

    static int zbir(long a) {
        int zbir = 0;
        while(a != 0) {
            zbir += a%10;
            a /= 10;
        }
        return zbir;
    }

    static long proveri(long N, long A, long B) {
        if(B*B + zbir(B) + (200*B) == N) {
            return B;
        }
        for(long i = A;i <= B;i++) {
            if((i*i) > N) {
                break;
            }
            if((i*i)+ zbir(i) + (200*i) == N) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = proveri(N, A, B);
        System.out.println(res);

        br.close();

    }

}
