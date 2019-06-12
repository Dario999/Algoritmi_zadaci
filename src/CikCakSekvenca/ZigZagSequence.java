package CikCakSekvenca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka

        int max_sekvenca = 0,mom_sekvenca=0,flag = 0,flag_poz = 1;

        for(int i=0;i<a.length;i++){

            if(flag == 0){					//ako pocnuva nova sekvenca
                if(a[i] > 0){
                    flag_poz = 1;
                    flag = 1;
                    mom_sekvenca = 1;
                }

                if(a[i] < 0){
                    flag_poz = 0;
                    flag = 1;
                    mom_sekvenca = 1;
                }
                if(i >= 1){
                    if(a[i] < 0 && a[i-1] > 0){
                        mom_sekvenca++;
                    }

                    if(a[i] > 0 && a[i-1] < 0){
                        mom_sekvenca++;
                    }
                }


            }else{				//ako veke e pocnata nova sekvenca
                if(flag_poz == 1){		//ako prviot od momentalnata sekvenca e pozitiven
                    if(a[i] < 0){
                        mom_sekvenca++;
                        flag_poz = 0;
                    }else if(a[i] > 0){
                        flag = 0;
                        if(mom_sekvenca > max_sekvenca){
                            max_sekvenca = mom_sekvenca;
                        }
                        mom_sekvenca = 0;
                    }else{
                        flag = 0;
                        if(mom_sekvenca > max_sekvenca){
                            max_sekvenca = mom_sekvenca;
                        }
                        mom_sekvenca = 0;
                    }
                }else{
                    if(a[i] > 0){
                        mom_sekvenca++;
                        flag_poz = 1;
                    }else if(a[i] < 0){
                        flag = 0;
                        if(mom_sekvenca > max_sekvenca){
                            max_sekvenca = mom_sekvenca;
                        }
                        mom_sekvenca = 0;
                    }else {
                        flag = 0;
                        if(mom_sekvenca > max_sekvenca){
                            max_sekvenca = mom_sekvenca;
                        }
                        mom_sekvenca = 0;
                    }
                }
            }


        }
        if(mom_sekvenca > max_sekvenca){
            max_sekvenca = mom_sekvenca;
        }

        return max_sekvenca;
    }

    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
