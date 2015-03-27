package rfe.by.novik.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rfe.by.novik.checkbox.*;
import rfe.by.novik.ftp.FtpWork;
@SuppressWarnings("serial")
public class Gui extends JFrame {
	public boolean isDoubleClicked = false;
	JFrame frame = new JFrame("ZipClient");
	JList northList = new JList();

	JPanel mainPanel = new JPanel();
	Object folderClicked = null;
	private JButton downAndZip = new JButton("Download and add to Zip");
	CheckBoxListRenderer checkList = new CheckBoxListRenderer();




	ArrayList listFolders = new ArrayList();
	public Gui(){}
	
	public void  addInList(String currentName){
		listFolders.add(currentName);
	}

	public void updateGUI(MouseListener mouse){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		northList = new JList(listFolders.toArray());
		northList.addMouseListener(mouse);
		JScrollPane northScroll = new JScrollPane(northList);
		northList.setLayoutOrientation(JList.VERTICAL);
		northList.setVisibleRowCount(0);
	
		northScroll.setPreferredSize(new Dimension(100, 100));
		mainPanel.removeAll();
		mainPanel.add(northScroll);
		mainPanel.add(downAndZip);
		frame.getContentPane().add(mainPanel);
		frame.setPreferredSize(new Dimension(500, 450));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		northList.setCellRenderer(checkList);
						
	}
	
      
	

	public JButton getDownAndZip() {
		return downAndZip;
	}

	public CheckBoxListRenderer getCheckList() {
		return checkList;
	}
	
	public JList getNorthList() {
		return northList;
	}

	public JFrame getFrame() {
		return frame;
	}

}
