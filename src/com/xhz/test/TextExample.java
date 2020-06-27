package com.xhz.test;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
public class TextExample {
	public TextExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(370, 235);
		shell.setText("Text综合实例");
		
		final Text text = new Text(shell, SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.BORDER);
		text.setBounds(50, 55, 250, 90);
//		final Text t = new Text(shell, SWT.NONE | SWT.FULL_SELECTION | SWT.WRAP|SWT.V_SCROLL);
//		t.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		StringBuffer sb = new StringBuffer();
	    sb.append("www"+"\n");
	    sb.append(".runoob"+"\n");
	    sb.append(".com"+"\n");
	    sb.append(".com1"+"\n");
	    sb.append(".com2"+"\n");
	    System.out.println(sb.toString());
	    int n = sb.length();
	    int x=0;
	    
	    int i=0;
	    StringBuffer temp = new StringBuffer();
	    temp.append(sb.toString());
	    while(temp.indexOf("\n")!=-1) {
	    	temp.delete(0,temp.indexOf("\n")+1);
	    	i++;
	    }
	    System.out.println("出现次数"+i);
	    
	    for (int j = 0; j < i-2; j++) {
	    	sb.delete(0,sb.indexOf("\n")+1);
		}
	    
	    
//	    int f = sb.indexOf("\n");
//	    System.out.println("第一次出现"+f);
	    
//	    int l = sb.lastIndexOf("\n");
//	    System.out.println("第一次出现"+f);
	    
	    text.append(sb.toString());
//	    int li = text.getLineCount();
//	    System.out.println(sb.toString());
	    
//		if (text.getLineCount()>2) {
			
//			x = n / (text.getLineCount()-1);
//			sb.delete(0,f+1);
//			text.append(sb.toString());
//		}
	    
		System.out.println(sb.toString());
	    
	    int m = sb.capacity();
	    
	    
		
	    System.out.println(text.getLineCount());
//	    
	    System.out.println(n);
	    System.out.println(x);
		
		
		
		
	
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new TextExample();
	}
}
