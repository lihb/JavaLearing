/**
 * ClassName:     Nibolan
 * description:  逆波兰表达式求值
 * Author:        lhb
 * Date:         2014-05-05 19:52:41
 * Version:		 1.0
 *
 */
 
public class  Nibolan {
    String str = null;
    int i = 0;
    String[] input;
    public static void main(String[] args){
        Nibolan nbl = new Nibolan();
        nbl.str = "* + 11.0 12.0 + 24.0 35.0";	
        nbl.input = nbl.str.split(" ");
        System.out.println(nbl.expr());  

    }

    private float expr(){
        if(i >= input.length)
            return 0;
        String s = input[i++];
        switch(s.charAt(0)){
            case '*':return expr() * expr();
            case '/':return expr() / expr();
            case '+':return expr() + expr();
            case '-':return expr() - expr();
            default :return Float.parseFloat(s);
        }
    }
} 

