package rfe.by.novik.gui;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rfe.by.novik.checkbox.*;;
@SuppressWarnings("serial")
public class Gui extends JFrame{
	public boolean isDoubleClicked = false;
	JFrame frame = new JFrame("ZipClient");
	JPanel mainPanel = new JPanel();
	Object folderClicked = null;
	private JButton downAndZip = new JButton("Download and add to Zip");

	
	@SuppressWarnings("rawtypes")
	ArrayList listFolders = new ArrayList();
	public Gui(){}
	@SuppressWarnings("unchecked")
	
	public void  addInList(String currentName){
		listFolders.add(currentName);
	}

	@SuppressWarnings("unchecked")
	public void updateGUI(MouseListener mouse){
		JPanel boxesPanel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JList northList = new JList(listFolders.toArray());
		northList.setCellRenderer(new CheckBoxListRenderer());
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
	}
		

      
	public boolean getDoubleClicked() {
		System.out.println(isDoubleClicked);
		return isDoubleClicked;
	}

	
}
