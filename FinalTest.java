/**
 * ClassName:     FinalTest
 * description:   解析final变量的意义，为什么在给匿名内部类变量赋值的时候要加
 *                final关键字
 * Author:        lihb
 * Date:         2015-02-05 10:18:32
 * Version:		 1.0
 *
 * 结论：final的作用是从语法上约束了实际上两个不同变量的一致性(表现为同一变量)。
 *
 */
import java.io.*;
import java.util.*;
import java.net.*;
public class  FinalTest {
    public static void main(String[] args){
        String str = "Hello";
        System.out.println(str.hashCode());
        test(str);

    public static void test(final String str){
        System.out.println("test函数开始");  
        ABSClass c = new ABSClass() {
            public void m() {
                int x = str.hashCode();
                System.out.println(x);  
            }
        };
        c.m();
        System.out.println("test函数完毕");  
    }
} 


abstract class ABSClass{
    public abstract void m();
}
