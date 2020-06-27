package com.xhz.test;

public class Test{
	  public static void main(String args[]){
	    StringBuffer sb = new StringBuffer();
	    sb.append("www"+"\n");
	    sb.append(".runoob"+"\n");
//	    sb.append(".com"+"\n");
	    
	    int n = sb.length();
	    int m = sb.capacity();
	    
	    System.out.println(sb);
	    
	    System.out.println(n);
	    System.out.println(m);
	  }
	}
