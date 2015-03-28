package rfe.by.novik.checkbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rfe.by.novik.ftp.FtpWork;
import rfe.by.novik.gui.Gui;
import rfe.by.novik.zip.ZipArch;

public class ParameterActionListener implements ActionListener {

	private String parentDir;
	private Gui guiAction ;
	private FtpWork ftpAction ;
	private ArrayList<String> inputName;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(guiAction.getNorthList().getSelectedValue());
		String nameJOptionPane.showInputDialog(new JFrame(), "asd");
		  String name = JOptionPane.showInputDialog(frame, "What's your name?");

		    // get the user's input. note that if they press Cancel, 'name' will be null
		    System.out.printf("The user's name is '%s'.\n", name);
		if (!inputName.contains(guiAction.getNorthList().getSelectedValue())){
			try {
				ZipArch zip = new ZipArch();
				ftpAction.downloadFileFromFtp(parentDir, guiAction.getNorthList().getSelectedValue().toString());
				inputName.add(guiAction.getNorthList().getSelectedValue().toString());
				zip.addToZipFile(guiAction.getNorthList().getSelectedValue().toString());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Exception in path of file");
			}

		}
		
	}
	
	public ParameterActionListener(String parentDir,  Gui gui, FtpWork ftpAction, ArrayList<String> inputList){
		this.parentDir = parentDir;
		this.guiAction = gui;
		this.ftpAction = ftpAction;
		this.inputName = inputList;
	}
	

}
