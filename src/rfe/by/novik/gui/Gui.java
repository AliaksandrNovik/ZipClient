package rfe.by.novik.gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rfe.by.novik.ftp.FtpWork;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	public boolean isDoubleClicked = false;
	JFrame frame = new JFrame("ZipClient");
	JPanel mainPanel = new JPanel();
	Object folderClicked = null;

	
	@SuppressWarnings("rawtypes")
	ArrayList listFolders = new ArrayList();
	public Gui(){}
	@SuppressWarnings("unchecked")
	
	public void  addInList(String currentName){
		listFolders.add(currentName);
	}

	@SuppressWarnings("unchecked")
	public void updateGUI(MouseListener mouse){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	
		JList northList = new JList(listFolders.toArray());
		northList.addMouseListener(mouse);
		JScrollPane northScroll = new JScrollPane(northList);
		northList.setLayoutOrientation(JList.VERTICAL);
		northList.setVisibleRowCount(0);
		
		northScroll.setPreferredSize(new Dimension(100, 100));
		mainPanel.removeAll();
		mainPanel.add(northScroll);
		frame.getContentPane().add(mainPanel);
		frame.setPreferredSize(new Dimension(330, 450));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
		

      
	public boolean getDoubleClicked() {
		System.out.println(isDoubleClicked);
		return isDoubleClicked;
	}

	
}
