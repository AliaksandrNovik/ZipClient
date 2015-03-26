package rfe.by.novik.gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	JFrame frame = new JFrame("Test frame");
	JPanel mainPanel = new JPanel();
	@SuppressWarnings("rawtypes")
	ArrayList listFolders = new ArrayList();
	public Gui(){}
	@SuppressWarnings("unchecked")
	public void  addInList(String currentName){
		listFolders.add(currentName);
	}
	@SuppressWarnings("unchecked")
	public void updateGUI(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		@SuppressWarnings("rawtypes")
		JList northList = new JList(listFolders.toArray());
		northList.setLayoutOrientation(JList.VERTICAL);
		northList.setVisibleRowCount(0);
		JScrollPane northScroll = new JScrollPane(northList);
		northScroll.setPreferredSize(new Dimension(100, 100));
		mainPanel.add(northScroll);
		frame.getContentPane().add(mainPanel);
		frame.setPreferredSize(new Dimension(330, 450));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


	}

}
