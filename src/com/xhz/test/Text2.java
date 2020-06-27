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
        								// �����ı��򣬿��Զ����� | ��ֱ������
        content.setBounds(10, 8, 325, 210);
        								// ��x, y, width, height��
        // ȫѡ��ť
        Button selectAll = new Button(shell, SWT.CENTER);
        selectAll.setText("Select All");
        selectAll.setBounds(5, 225, 80, 25);
        								// ��x, y, width, height��
        selectAll.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// ѡ�������ı�
        		content.selectAll();
        	}
        });
        // ȡ��ѡ��ť
        Button cancel = new Button(shell, SWT.CENTER);
        cancel.setText("Cancel Select");
        cancel.setBounds(90, 225, 80, 25);
        								// ��x, y, width, height��
        cancel.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// �����ѡ�е��ı�
        		if(content.getSelectionCount() > 0)
        								// ��ѡ���ı����Ȳ�Ϊ��
        			content.clearSelection();
        								// ���ѡ��
        	}
        });
        // ���ư�ť
        Button copy = new Button(shell, SWT.CENTER);
        copy.setText("Copy");
        copy.setBounds(175, 225, 80, 25);
        								// ��x, y, width, height��
        copy.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// ��ѡȡ���ַ������Ƶ�������
        		if(content.getSelectionCount() > 0)
        			content.copy();
        	}
        });
        // ճ����ť
        // ȫѡ��ť
        Button paste = new Button(shell, SWT.CENTER);
        paste.setText("Paste");
        paste.setBounds(260, 225, 80, 25);
        								// ��x, y, width, height��
        paste.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e){
        		// ��������������ճ��
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
