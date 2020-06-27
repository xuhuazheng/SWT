package com.xhz.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Text1{

    public static void main(String[] args){
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Hello world");
        shell.setSize(300, 200);
        shell.setLocation(500, 300);
        shell.open();

        guiText1(shell);

        while(!shell.isDisposed())
            if (!display.readAndDispatch())
                display.sleep();

        display.dispose();
    }

    public static void guiText1(Shell shell)
    {
        // create a label
        Label label1 = new Label(shell, SWT.NONE);
        label1.setText("Name:");
        label1.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
        label1.setBounds(10, 10, 80, 25);

        // create a text box
        Text text = new Text(shell, SWT.BORDER);
        text.setBounds(100, 10, 153, 25);
        text.setTextLimit(10);

        text.addVerifyListener(new VerifyListener()
        {
            public void verifyText(VerifyEvent e)
            {
                String inStr = e.text;
                System.out.println(inStr);
                //if (inStr.length() > 0)
                //e.doit = NumberUtils.isDigits(inStr);// Apache Commons Lang
            }
        });
    }

}
