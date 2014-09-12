/**
 * ClassName:     ExceptionDemo2
 * description:   用命令行参数接收用户的输入的两个整数，然后做除法。要求用异常处理输入错误，和除数为0的错误。
 * Author:        lhb
 * Date:         2014-08-04 14:39:51
 * Version:		 1.0
 *
 */
 public class  ExceptionDemo2 {
    public static void main(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        
        duoble res = 0.0;
        try{
            res = num1 / num2;
        }catch(ArithmeticException ae){
            ae.printStacksTrace();
        }catch(Exception e){
            e.printStacksTrace();
        }
        System.out.println(res);  
        	
    } 	
} 

