package main.java.pl.Aevise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t --> 0){
            long n = Long.parseLong(read.readLine());

            if(new Solution().isPowerofTwo(n) == true){
                System.out.println("YES");
            }else System.out.println("NO");
        }
    }
}
