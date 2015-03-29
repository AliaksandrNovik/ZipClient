package rfe.by.novik.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;






import javax.swing.plaf.metal.MetalIconFactory;

import rfe.by.novik.checkbox.*;
import rfe.by.novik.ftp.FtpWork;
@SuppressWarnings("serial")
public class Gui extends JFrame {
	public boolean isDoubleClicked = false;
	private JFrame frame = new JFrame("ZipClient");
	private JList<?> northList;
	private FtpWork ftpWork;
	public String folderClicked = "";
	public String parentFolder  = "";

	private JPanel mainPanel = new JPanel();
	private JButton downAndZip = new JButton("Download and add to Zip");
	private JButton backFolder = new JButton("Back");
	private CheckBoxListRenderer checkList = new CheckBoxListRenderer();
	private ArrayList<String> listFolders = new ArrayList<String>();
	Map<Object, Icon> icons = new HashMap<Object, Icon>();

	public Gui(FtpWork ftpWork){
		this.ftpWork = ftpWork;
		downAndZip.addActionListener(new ParameterActionListener("/" + folderClicked.toString(), this, ftpWork));
		backFolder.addActionListener(new BackActionListener(this, parentFolder, folderClicked.toString()));
	}
	
	
	public void RunGui(String fileName) throws IOException{
	//	icons.put(fileName, 
		//		MetalIconFactory.getCheckBoxIcon());
		
		ftpWork.connectToFtp();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		addInList("/" + fileName);
		northList = new JList<Object>(listFolders.toArray());
		northList.addMouseListener(mouseListener);
		JScrollPane northScroll = new JScrollPane(northList);
		northList.setLayoutOrientation(JList.VERTICAL);
		northList.setVisibleRowCount(0);
		northScroll.setPreferredSize(new Dimension(100, 100));
		mainPanel.removeAll();
		mainPanel.add(northScroll);
		mainPanel.add(downAndZip);
		mainPanel.add(backFolder);
		frame.getContentPane().add(mainPanel);
		frame.setPreferredSize(new Dimension(500, 450));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		northList.setCellRenderer(checkList);
		//northList.setCellRenderer(new IconListRenderer(icons));
	}
	
	MouseListener mouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent mouseEvent) {

			try{ 
				JList<?> theList = (JList<?>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						
						folderClicked +=  theList.getModel().getElementAt(index).toString() + "/" ;
						parentFolder += folderClicked.replaceAll(theList.getModel().getElementAt(index).toString() + "/", "");
						System.out.println("Double-clicked on: " + folderClicked.toString()
								+ "last folder  =" + parentFolder );
						RunGui(folderClicked);
					}
				}
			}catch(IOException io){

			}
		}
	};

	public void  addInList(String currentName) throws IOException{
		listFolders = ftpWork.listDirectoryReturn("", "/" + currentName);
	}

	public ArrayList<String> getListFolders() {
		return listFolders;
	}
	public void resetFolderClicked(){
		folderClicked = "/";
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
	
	public String getFolderClicked() {
		return folderClicked;
	}
}
