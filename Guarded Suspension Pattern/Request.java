/**
 * ClassName:     Request
 * description:  用来模拟请求操作的类。
 * Author:        lhb
 * Date:         2014-09-11 15:37:18
 * Version:		 1.0
 *
 */
 public class  Request {
    private final String name; 
    public Request(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "[ Request " + name + " ]";
    }
} 

