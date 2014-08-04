/**
 * ClassName:     RedAndBlack
 * description:  递归法的好处
 *               大大的啊，要掌握啊，多做几个题目。   
 * Author:        lhb
 * Date:         2014-05-05 20:33:11
 * Version:		 1.0
 *
 */

/* 问题 ：红与黑
 * 问题描述
 * 有一间长方形的房子,地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一
 * 块黑色的瓷砖上,只能向相邻的黑色瓷砖移动。请写一个程序,计算你总共能够到达多
 * 少块黑色的瓷砖。
 * 输入数据
 * 包括多个数据集合。每个数据集合的第一行是两个整数 W 和 H,分别表示 x 方向
 * 和 y 方向瓷砖的数量。W 和 H 都不超过 20。在接下来的 H 行中,每行包括 W 个字符。
 * 每个字符表示一块瓷砖的颜色,规则如下
 * 1)
 * ‘.’:黑色的瓷砖;
 * 2)
 * ‘#’:白色的瓷砖;
 * 3)
 * ‘@’:黑色的瓷砖,并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。
 * 当在一行中读入的是两个零时,表示输入结束。
 * 输出要求
 * 对每个数据集合,分别输出一行,显示你从初始位置出发能到达的瓷砖数(记数时
 * 包括初始位置的瓷砖)。
 *
 * 输入样例:
 * 6 9
 * ....#.
 * .....#
 * ......
 * ......
 * ......
 * ......
 * ......
 * #@...#
 * .#..#.
 * 0 0
 *
 * 输出样例
 * 45
 *
 *
 */
 
import java.util.*;
import java.io.*;

public class RedAndBlack {

    static int row,col;
    static char[][] input; 
    public static void main(String[] args) throws IOException{
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String   line = bufr.readLine();
        String[] data = line.split(" ");
        RedAndBlack rb = new RedAndBlack();
        row = Integer.parseInt(data[1]);
        col = Integer.parseInt(data[0]);
        input = new char[row][col];
       // String[] input = new String[row];
        for(int i = 0; i < row;  i++){
           input[i] = bufr.readLine().toCharArray();
        }
        for(int m = 0; m < row; m++){
            for(int n = 0; n < col; n++){
                char ch = input[m][n];
                if(ch == '@'){输出样例
45
                    System.out.println(digui(m, n));  
                }
            }
        }
    } 	

    public static int digui(int x, int y){
        if(x < 0||x >=row||y < 0 || y >=col){
            return 0;
        }
        if(input[x][y] == '#'){
            return 0;
        }
        else{
            input[x][y] = '#';
            return 1 + digui(x - 1, y) + digui(x + 1, y) + digui(x, y - 1) + digui(x, y + 1);
        }
    }
} 

