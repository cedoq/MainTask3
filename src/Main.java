import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '=',' '};
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String a = br.readLine();
        char[] c = a.toCharArray();
        int k;
        boolean f = true;

        for(k=0;k<c.length;k++){
            boolean lock = false;
            for (char aChar : chars) {
                if (aChar == c[k]) {
                    lock = true;
                    break;
                }
            }
            if(List.of(c).contains('=')){lock = false;}
            if(!lock){
                System.out.println("error");
                f=false;
                break;
            }
        }
        if(f) {
            System.out.println("line correct");
            char[] end = new char[c.length];
            for(int i = 0; i<c.length;i++){
                if(c[i]!=' '){
                    end[i] = c[i];
                }
            }
            int i = 0;
            char move = ' ';
            String num = "";
            String num1 = "";
            int sum = 0;
            boolean first = true;
            while(true){
                if(end[i] == '='){
                    if(move == '+' && !first){
                        sum = sum + Integer.parseInt(num1);
                    }
                    else if(move == '+'){
                        sum = sum + Integer.parseInt(num1)+Integer.parseInt(num);
                    }
                    else if (move == '-' && !first){
                        sum = sum - Integer.parseInt(num1);}
                        else if (move == '-'){
                        sum = sum - Integer.parseInt(num1)+Integer.parseInt(num);
                        }

                    else if (move == '*'){
                        sum = sum + Integer.parseInt(num) * Integer.parseInt(num1);
                    } else if (move == '/'){
                        sum = sum + Integer.parseInt(num) / Integer.parseInt(num1);
                    }
                    break;
                }
                if(end[i] != '+' && end[i] != '-' && end[i] != '/' && end[i] != '*'){
                    num = num + end[i];
                }
                else if(move == ' '){num1 = num; num = "";move = end[i];}
                else {
                    first = false;
                    if(move == '+'){
                        sum = sum + Integer.parseInt(num) + Integer.parseInt(num1);
                        num = "";
                        move = end[i];
                    } else if (move == '-'){
                        sum = sum + Integer.parseInt(num) - Integer.parseInt(num1);
                        num = "";
                        move = end[i];
                }
                    else if (move == '*'){
                        sum = sum + Integer.parseInt(num) * Integer.parseInt(num1);
                        num = "";
                        move = end[i];
            } else if (move == '/'){
                        sum = sum + Integer.parseInt(num) / Integer.parseInt(num1);
                        num = "";
                        move = end[i];
                    }
                }

                i++;
                }
            System.out.println(sum);
        }
    }}