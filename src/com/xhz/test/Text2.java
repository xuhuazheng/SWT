package com.xhz.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Text2{

    public static void main(String[] args){
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setSize(600, 600);
        shell.setLocation(500, 300);

        shell.setText("SWT.TextSample");
        					
        final Text content = new Text(shell, SWT.WRAP|SWT.V_SCROLL);
        								// 多行文本框，可自动换行 | 垂直滚动条
        content.setBounds(10, 8, 325, 210);
        								// （x, y, width, height）
        // 全选按钮
        Button selectAll = new Button(shell, SWT.CENTER);
        selectAll.setText("Select All");
        selectAll.setBounds(5, 225, 80, 25);
        								// （x, y, width, height）
        selectAll.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// 选中所有文本
        		content.selectAll();
        	}
        });
        // 取消选择按钮
        Button cancel = new Button(shell, SWT.CENTER);
        cancel.setText("Cancel Select");
        cancel.setBounds(90, 225, 80, 25);
        								// （x, y, width, height）
        cancel.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// 如果有选中的文本
        		if(content.getSelectionCount() > 0)
        								// 如选中文本长度不为零
        			content.clearSelection();
        								// 清楚选择
        	}
        });
        // 复制按钮
        Button copy = new Button(shell, SWT.CENTER);
        copy.setText("Copy");
        copy.setBounds(175, 225, 80, 25);
        								// （x, y, width, height）
        copy.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// 将选取的字符串复制到剪贴板
        		if(content.getSelectionCount() > 0)
        			content.copy();
        	}
        });
        // 粘贴按钮
        // 全选按钮
        Button paste = new Button(shell, SWT.CENTER);
        paste.setText("Paste");
        paste.setBounds(260, 225, 80, 25);
        								// （x, y, width, height）
        paste.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// 将剪贴板板的内容粘贴
        		content.paste();
        	}
        });
         
         
        shell.layout();
        shell.open();

        while(!shell.isDisposed())
            if (!display.readAndDispatch())
                display.sleep();

        display.dispose();
    }

    

}
