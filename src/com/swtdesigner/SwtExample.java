package com.swtdesigner;// ����
 
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

	/**
	* created by kongxiaohan on Dec 12, 2014 Detailled comment
	*
	*/
public class SwtExample {

    /**
      * Launch the application.
      * 
      * @param args
      */
    public static void main(String[] args) {
         // ����һ�����͵�SWTӦ�ó���Ĳ���
         // display�������ʵ��ѭ���Ϳ���UI�̺߳������߳�֮���ͨ��
        Display display = Display.getDefault(); // 1.����һ��Display
        Shell shell = new Shell();//2.����һ�����߶��Shell(shell�ǳ����������)
        shell.setSize(450, 300);// 3.����Shell�Ĳ���(���������ڵĴ�С)
        shell.setText("SWT Application");
         // 4.����Shell�е����(���������û�м������,ֻ��һ���մ���)
        shell.open();// 5.��Open()������Shell���� ��shell������
        shell.layout();// shellӦ�ý��沼��
         // 6.дһ���¼�ת��ѭ��.
        while (!shell.isDisposed()) {// ���������û�йر�,��һֱѭ��
            if (!display.readAndDispatch()) {// ���display��æ
                display.sleep();// display����
            }
        }
    }
}