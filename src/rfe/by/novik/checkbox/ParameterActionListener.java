package rfe.by.novik.checkbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rfe.by.novik.ftp.FtpWork;
import rfe.by.novik.gui.Gui;

public class ParameterActionListener implements ActionListener {
	
	private String currentDir;
	private String parentDir;
	private Gui guiAction ;
	private FtpWork ftpAction = new FtpWork();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(guiAction.getNorthList().getSelectedValue());
        if (guiAction.getCheckList().isSelected()) {
        	
            JOptionPane.showMessageDialog(new JFrame(), "JCheckBox is selected");
           /* try {
				ftpAction.downloadFileFromFtp("ftp.mozilla.org/pub/zz/", guiAction.getNorthList().getSelectedValue().toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
         
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "JCheckBox is NOT selected");
        }
    }
		
	
	public ParameterActionListener(String parentDir,  Gui gui){
		this.parentDir = parentDir;
		this.guiAction = gui;
	}


}
