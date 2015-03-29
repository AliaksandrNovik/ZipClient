package rfe.by.novik.checkbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import java.util.zip.ZipOutputStream;
import rfe.by.novik.ftp.FtpWork;
import rfe.by.novik.gui.Gui;
import rfe.by.novik.zip.ZipArch;

public class ParameterActionListener implements ActionListener {

	private Gui guiAction ;
	private FtpWork ftpAction ;
	private List<?> listSelectedFiles;

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			ZipArch zip = new ZipArch();
			FileOutputStream fos = new FileOutputStream("Output.zip");
			ZipOutputStream zos = new ZipOutputStream(fos);
			if(e.getActionCommand().equals("Download and add to Zip")){
				
				listSelectedFiles = guiAction.getNorthList().getSelectedValuesList();
				
				for(int i = 0; i < listSelectedFiles.size(); i++){
					ftpAction.downloadFileFromFtp(guiAction.getFolderClicked(), listSelectedFiles.get(i).toString());
				}
				
				for(int i = 0; i < listSelectedFiles.size(); i++){
					zip.addToZipFile(listSelectedFiles.get(i).toString(), zos);
				}
			}
			zos.close();
			fos.close();
		}catch(FileNotFoundException fn){
			
		}catch(IOException fn){
			
		}
	}

	public ParameterActionListener(String parentDir,  Gui gui, FtpWork ftpAction){
		this.guiAction = gui;
		this.ftpAction = ftpAction;
	}


}
