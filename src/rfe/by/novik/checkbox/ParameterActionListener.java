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

public class ParameterActionListener implements ActionListener {

	private String parentDir;
	private Gui guiAction ;
	private FtpWork ftpAction ;
	private ArrayList<String> inputName;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!inputName.contains(guiAction.getNorthList().getSelectedValue())){
			try {

				ftpAction.downloadFileFromFtp(parentDir, guiAction.getNorthList().getSelectedValue().toString());
				inputName.add(guiAction.getNorthList().getSelectedValue().toString());
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
