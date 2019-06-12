package Najdolga_opagacka_sekvenca;

import java.util.Scanner;


public class LDS {


	/*private static int najdolgaOpagackaSekvenca(int[] a) {
		int i1,j1;
        int mom_max = 1,mom = 0,flag=1,mom_ele = 0;
        for(int i=0;i<a.length;i++){
            if(flag == 1){
            	flag = 0;
                mom_ele = a[i];
                mom++;
            }else{
                if(a[i] < mom_ele){
                	mom++;
                    mom_ele = a[i];
                }else if(a[i] == mom_ele){
     		   		continue;
                }else{
                    if(mom > mom_max){
                    	mom_max = mom;
                        mom = 0;
                        flag = 1;
                        i--;
                    }else{
                    	mom = 0;
                        flag = 1;
                        i--;
                    }
                }
            }
        }
        return mom_max;
	}*/

    private static int najdolgaOpagackaSekvenca(int[] a) {
        int max = 0,mom = 0;
        for(int i=0;i<a.length;i++) {
            mom = 0;
            int j = i;
            while(j+1 < a.length) {
                if(a[j] < a[j+1]) {
                    break;
                }else if(a[j] == a[j+1]){
                    continue;
                }else {
                    j++;
                    mom++;
                }
            }

            if(mom > max) {
                max = mom;
            }
        }


        return max;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
        stdin.close();
    }


}
