/**
 * ClassName:     CoinsProblem
 * description:   贪心算法
 * Author:        lhb
 * Date:         2014-08-09 16:35:39
 * Version:		 1.0
 * 有1元，5元，10元，50元，100元，500元的硬币各A、B、C、D、E、F枚，现在用这些硬币来支付Z元，最少需要多少硬币？假定本题至少存在一种支付方案。
 * 其中A=3, B=2,C=1,D=3,E=0,F=2,Z=620
 */

import java.util.*;
import java.io.*;
 public class  CoinsProblem {
    public static void main(String[] args){

        final int[] coins = {1, 5, 10, 50, 100, 500};
        final int[] num = {3, 2, 1, 3, 0, 2};
        int[] res = new int[6];
        int Z = 620;
        int ans = 0;

        for(int i = coins.length-1; i >=0 ; i--){
             int temp = min((Z / coins[i]), num[i]);
             res[i] = temp;
             Z = Z - coins[i] * temp;
             ans += temp;            
        }
        System.out.println("ans = "+ ans);
        
        for(int j = 0; j < res.length; j++){
            System.out.println(res[j]);  
        }
    } 	

    private static int min(int x, int y){
        return ((x <=y)?x:y);
    }
} 

