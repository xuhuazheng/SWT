package com.xhz.test;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;

public class StackLayoutExample {

	public StackLayoutExample() {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(500, 375);
		shell.setText("StackLayout实例");
		// 在shell应用网格式布�?，把shell容器设置�?2�?
		shell.setLayout(new GridLayout(2, false));
		// 定义了Stacklayout对象
		final StackLayout stacklayout = new StackLayout();
		// 定义了面板容�?
		final Composite composite = new Composite(shell, SWT.BORDER);
		// 使用GriData控制布局，使面板双向充满容器
		GridData gridData = new GridData(GridData.FILL_BOTH);
		// 使composite1水平抢占2�?
		gridData.horizontalSpan = 2;
		composite.setLayoutData(gridData);
		// 在composite1上应用stacklayout
		composite.setLayout(stacklayout);

		Composite composite1 = new Composite(composite, SWT.BORDER);
		composite1.setBackground(display.getSystemColor(SWT.COLOR_GREEN));

		Composite composite2 = new Composite(composite, SWT.BORDER);
		composite2.setBackground(display.getSystemColor(SWT.COLOR_RED));

		final Button button1 = new Button(shell, SWT.NONE);
		button1.setText("单击显示文本");
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// 用topControl使文本框（text）显示在堆栈的顶�?
				stacklayout.topControl = composite1;
				composite.layout();
			}
		});
		final Button button2 = new Button(shell, SWT.NONE);
		button2.setText("单击显示按钮");
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stacklayout.topControl = composite2;
				composite.layout();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new StackLayoutExample();
	}
}
