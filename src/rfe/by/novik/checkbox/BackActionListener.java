package rfe.by.novik.checkbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import rfe.by.novik.gui.Gui;

public class BackActionListener implements ActionListener {

	private Gui guiAction ;
	@Override
	public void actionPerformed(ActionEvent e) {
		try{	
			if(e.getActionCommand().equals("Back")){
				guiAction.resetFolderClicked();
				guiAction.RunGui("/");
			}
		}catch(IOException io){

		}
	}

	public  BackActionListener(Gui gui, String parentFolder, String currentFolder) {
		this.guiAction = gui;
	}


}
