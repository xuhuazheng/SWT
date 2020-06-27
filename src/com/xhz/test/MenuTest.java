package com.xhz.test;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuTest {
	static Display display = new Display();
	static Shell shell = new Shell(display);
	/*
	 * �����༶�˵�, ����SWT.CASCADE��ʽֵ���Լ����Ӳ˵�,����SWT.PUSH��ʽֵ�����Լ����Ӳ˵�
	 */
	public static void createMenu() {
		shell.setSize(500, 500);
		shell.setText("menu test window");
		//shell.setImage(new Image(display, "images/Home.png"));
		// ͨ��shell�����SWT.BAR��ʽֵ������һ���˵���
		Menu menu = new Menu(shell, SWT.BAR);
		// �ڲ˵����Ļ���֮�ϴ���һ��File�Ĳ˵�
		MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("&File");
		// ����Shell�ϴ���һ��������Ȼ����������ӵ�File�˵���
		Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		file.setMenu(filemenu);
		// ���������ϴ����˵���Open
		final MenuItem openItem = new MenuItem(filemenu, SWT.CASCADE);
		openItem.setText("&Open");
		// ��shell�ϴ���һ��������,�������ӵ�open�˵���
		Menu childmenu = new Menu(shell, SWT.DROP_DOWN);
		openItem.setMenu(childmenu);
		// ��open�˵��ϴ���һ���Ӳ˵�child
		final MenuItem childItem = new MenuItem(childmenu, SWT.PUSH);
		childItem.setText("&Child");
		// ��open�˵��ϴ���һ���Ӳ˵�dialog
		final MenuItem dialogItem = new MenuItem(childmenu, SWT.PUSH);
		dialogItem.setText("&Dialog");
		// �ڲ˵���֮�䴴��һ���ָ���
		new MenuItem(filemenu, SWT.SEPARATOR);
		// ���������ϴ����˵���Exit
		MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
		exitItem.setText("&Exit");
		// ����edit�˵�
		MenuItem edit = new MenuItem(menu, SWT.CASCADE);
		edit.setText("&Edit");
		Menu editmenu = new Menu(shell, SWT.DROP_DOWN);
		edit.setMenu(editmenu);
		MenuItem cutItem = new MenuItem(editmenu, SWT.PUSH);
		cutItem.setText("&Cut/tCTRL+X");
		// ���ÿ�ݼ�
		cutItem.setAccelerator(SWT.CTRL + 'X');
		// �ڲ˵���֮�䴴��һ���ָ���
		new MenuItem(editmenu, SWT.SEPARATOR);
		MenuItem copyItem = new MenuItem(editmenu, SWT.PUSH);
		copyItem.setText("&Copy/tCTRL+C");
		// ���ÿ�ݼ�
		copyItem.setAccelerator(SWT.CTRL + 'C');
		// �ڲ˵���֮�䴴��һ���ָ���
		new MenuItem(editmenu, SWT.SEPARATOR);
		MenuItem pasteItem = new MenuItem(editmenu, SWT.PUSH);
		pasteItem.setText("&Paste/tCTRL+V");
		// ���ÿ�ݼ�
		pasteItem.setAccelerator(SWT.CTRL + 'V');
		// ����window�˵�
		MenuItem window = new MenuItem(menu, SWT.CASCADE);
		window.setText("&Window");
		Menu windowmenu = new Menu(shell, SWT.DROP_DOWN);
		window.setMenu(windowmenu);
		final MenuItem maxItem = new MenuItem(windowmenu, SWT.PUSH);
		maxItem.setText("&Max");
		// �ڲ˵���֮�䴴��һ���ָ���
		new MenuItem(windowmenu, SWT.SEPARATOR);
		MenuItem minItem = new MenuItem(windowmenu, SWT.PUSH);
		minItem.setText("&Min");
		// ����help�˵�
		MenuItem help = new MenuItem(menu, SWT.CASCADE);
		help.setText("&Help");
		Menu helpmenu = new Menu(shell, SWT.DROP_DOWN);
		help.setMenu(helpmenu);
		MenuItem aboutItem = new MenuItem(helpmenu, SWT.PUSH);
		aboutItem.setText("&About");
		// ���һ��option�˵���������ӵ�ѡ�˵��͸�ѡ�˵�
		MenuItem option = new MenuItem(menu, SWT.CASCADE);
		option.setText("&Option");
		Menu optionmenu = new Menu(shell, SWT.DROP_DOWN);
		option.setMenu(optionmenu);
		MenuItem checkItem1 = new MenuItem(optionmenu, SWT.CHECK);
		checkItem1.setText("Check1");
		MenuItem checkItem2 = new MenuItem(optionmenu, SWT.CHECK);
		checkItem2.setText("Check2");
		// ����Ĭ��Ϊѡ��
		checkItem2.setSelection(true);
		// ���÷ָ���
		new MenuItem(optionmenu, SWT.SEPARATOR);
		MenuItem radioItem1 = new MenuItem(optionmenu, SWT.RADIO);
		radioItem1.setText("Radio1");
		// ����Ĭ��Ϊѡ��
		radioItem1.setSelection(true);
		MenuItem radioItem2 = new MenuItem(optionmenu, SWT.RADIO);
		radioItem2.setText("Radio2");
		// Ϊ�˵������Ӧ���¼�
		childItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Shell parent = (Shell) maxItem.getParent().getParent()
						.getParent();
				Shell child = new Shell(parent, SWT.RESIZE | SWT.MAX);
				child.setText("child item has been clicked");
				child.setImage(new Image(display, "images/Alert.png"));
				child.setSize(400, 100);
				child.open();
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		// ���˵�����ӵ�shell��
		shell.setMenuBar(menu);
		// �����Ҽ��˵�
		shell.setMenu(createEditPopup());
		shell.open();
		while (!shell.isDisposed()) {
			if (display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	/*
	 * ����һ���Ҽ��˵� ͨ����ʽֵSWT.POP_UP������һ���Ҽ������˵�
	 */
	public static Menu createEditPopup() {
		Menu popMenu = new Menu(shell, SWT.POP_UP);
		MenuItem cutItem = new MenuItem(popMenu, SWT.PUSH);
		cutItem.setText("&Cut");
		MenuItem copyItem = new MenuItem(popMenu, SWT.PUSH);
		copyItem.setText("&Copy");
		MenuItem pasteItem = new MenuItem(popMenu, SWT.PUSH);
		pasteItem.setText("&Paste");
		cutItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println("cut");
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		pasteItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println("paste");
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		copyItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println("copy");
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		return popMenu;
	}
	public static void main(String[] args) {
		MenuTest.createMenu();
	}
}
