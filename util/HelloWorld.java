//package name.cct.www;
package util;
import java.util.*;
import java.text.*;

public class HelloWorld {
	public HelloWorld(){
		;
	}
	public static void main(String[] args){
		HelloWorld hw = new HelloWorld();
		hw.output();
	}
	public void output(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(date);
		System.out.println("Hello World:" + now);
	}
}