package Matematicki_Izraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka
        Stack<String> stek = new Stack<>();

        char[] niza = expression.toCharArray();
        boolean firstFlag = true;
        boolean flag = true;
        String broj = "";
        for(int i=0;i<niza.length;i++){
            if(Character.isDigit(niza[i])){
                broj += niza[i];
            }else{
                if(firstFlag){
                    if(niza[i] == '+'){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    firstFlag = false;
                    stek.push(broj);
                    broj = "";
                }else{
                    if(flag){
                        stek.push(broj);
                    }else {
                        int b1 = Integer.parseInt(stek.pop());
                        int b2 = Integer.parseInt(broj);
                        int zbir = b1*b2;
                        stek.push(String.valueOf(zbir));
                    }
                    if(niza[i] == '+'){
                        flag = true;
                    }else{
                        flag = false;
                    }
                    broj = "";
                }
            }
        }
        if(flag){
            stek.push(broj);
        }else {
            int b1 = Integer.parseInt(stek.pop());
            int b2 = Integer.parseInt(broj);
            int zbir = b1*b2;
            stek.push(String.valueOf(zbir));
        }
        int sum = 0;
        while(!stek.isEmpty()){
            //System.out.println(stek.peek());
            sum += Integer.parseInt(stek.pop());
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(br.readLine()));
    }

}