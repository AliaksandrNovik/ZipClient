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
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import rfe.by.novik.checkbox.*;
@SuppressWarnings("serial")
public class Gui extends JFrame {
	public boolean isDoubleClicked = false;
	private JFrame frame = new JFrame("ZipClient");
	private JList<?> northList = new JList<Object>();

	private JPanel mainPanel = new JPanel();
	private JButton downAndZip = new JButton("Download and add to Zip");
	private CheckBoxListRenderer checkList = new CheckBoxListRenderer();
	private ArrayList<String> listFolders = new ArrayList<String>();
	public Gui(){}
	
	public void  addInList(String currentName){
		listFolders.add(currentName);
	}

	public void updateGUI(MouseListener mouse){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


		northList = new JList<Object>(listFolders.toArray());
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
	
	public JList<?> getNorthList() {
		return northList;
	}

	public JFrame getFrame() {
		return frame;
	}

}
