package rfe.by.novik.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

import javax.swing.JFrame;

import org.apache.commons.net.ftp.FTPClient;

import rfe.by.novik.ftp.FtpWork;
import rfe.by.novik.gui.Gui;
import rfe.by.novik.zip.ZipArch;


public class RunAplication {
	

	@SuppressWarnings({  "static-access" })
	public static void main(String[] args) throws IOException{
		Gui gui = new Gui();
		FileOutputStream fos = new FileOutputStream("Output.zip",true);
		ZipOutputStream zos = new ZipOutputStream(fos);
		
		FtpWork ftp = new FtpWork();
		FTPClient ftpClient = new FTPClient();
		ZipArch zip = new ZipArch();
		ftp.printComandInform();
		gui.createGUI();
		try {
			ftp.connectToFtp(ftpClient);
			String currentName = "";
			String path = "" ;
			do {
				
				currentName = ftp.readFromConsole(currentName);
				path += currentName + "/";
				if (ftp.isDirectory(ftpClient, path)) {
					System.out.println(currentName + " " + path);
					ftp.listDirectory(ftpClient, path, "");
				} else {
					ftp.downloadFileFromFtp(ftpClient, path, currentName);
					zip.addToZipFile(currentName, zos);
					break;
				}
			} while (!currentName.equals("Exit"));
		}  finally {
			ftp.disconnectFromFtp(ftpClient);
		}
		
	}
}

