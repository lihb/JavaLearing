/**
 * ClassName:     GCD
 * description:  欧几里德算法求最大公约数 ------gcd(m, n) = gcd(n, m%n)《算法设计与分析基础》
 * Author:        lhb
 * Date:         2014-05-13 19:39:10
 * Version:		 1.0
 *
 */

import java.util.*;

 public class  GCD {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int temp = 0;
        while(n != 0){
            temp = m % n;
            m = n;
            n = temp;
        }
        System.out.println(m);  

    } 	
} 

