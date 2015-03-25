package rfe.by.novik.gui;

import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Gui extends JFrame{
	public String  addInList(String currentName){
		return currentName;
	}
	public void createGUI(){
		
		JFrame frame = new JFrame("Test frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		  JPanel mainPanel = new JPanel();
          mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
 
          JList northList = new JList();
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
