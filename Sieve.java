/**
 * ClassName:     Sieve
 * description:   《算法设计与分析基础》————“埃拉托色尼筛”
 * Author:        lhb
 * Date:         2014-05-13 20:27:06
 * Version:		 1.0
 *
 */
import  java.util.*;
 public class  Sieve {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int max = in.nextInt();
        int[] arr = new int[max];
        for(int i = 0; i < max; i++){
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

       for(int i = 2; i <= Math.sqrt(max); i++){
             if(arr[i] != 0){
                int temp = i * i;
                while(temp < max){
                    arr[temp] = 0;
                    temp += i;
                }   
            }
           
        }
        for(int i = 2; i < max; i++){
            if(arr[i]!=0){
                System.out.println(arr[i]);  
            }   
        }

        	
    } 	
} 

