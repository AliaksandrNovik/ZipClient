package rfe.by.novik.run;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;





import javax.swing.JList;

import rfe.by.novik.ftp.FtpWork;
import rfe.by.novik.zip.ZipArch;


public class RunAplication {

	@SuppressWarnings({  "static-access" })
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream("Output.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);

		FtpWork ftp = new FtpWork();
		ZipArch zip = new ZipArch();
		ftp.printComandInform();

		try {
			ftp.connectToFtp();
			
			String currentName = "";
			String path = "" ; 
			
			do {
			  ftp.listDirectory(path, "/");
				currentName = ftp.readFromConsole(currentName);
				path += currentName + "/";
				/*if (ftp.isDirectory( path)) {
					System.out.println(currentName + " " + path);
					ftp.listDirectory( path, "");
				} else { 
					ftp.downloadFileFromFtp( path, currentName);
					zip.addToZipFile(currentName, zos);
					break;
				}*/
			} while (!currentName.equals("Exit"));
		}  finally {
			ftp.disconnectFromFtp();
		}

	}
}

