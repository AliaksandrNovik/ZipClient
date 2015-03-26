package rfe.by.novik.ftp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JList;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import rfe.by.novik.gui.Gui;

public class FtpWork {
	static Properties property = new Properties();
	public Gui gui = new Gui();
	public FTPClient ftpClient = new FTPClient();
	public String folderClicked = "";
	public  void printComandInform() {
		System.out.println("================================");
		System.out.println("Information about functions of program: ");
		System.out.println("/ - to the open head directory ");
		System.out.println("name of directory - to the open this directory");
		System.out.println("name of file - to the  download this file ");
		System.out.println("exit - to the exit from application ");
		System.out.println("================================");
	}
	public String readFromConsole(String currentName){
		Scanner scanner = new Scanner(System.in);
		currentName = scanner.nextLine();
		return currentName;
	}
	public static void loadProperty(){
		
	    try{
	    	FileInputStream file = new FileInputStream("src/rfe/by/novik/resource/config.properties");
	    	property.load(file);
	    	
	    }catch(IOException fn){
	    	System.out.println("Not find config.properties");
	    }
	}
	
	public  boolean isDirectory( String parentDir) throws IOException{
		int cntInnerFiles = 0;;
		FTPFile[] subFiles = ftpClient.listFiles(parentDir);

		if (subFiles != null && subFiles.length > 0) {
			for (FTPFile aFile : subFiles) {
				if (aFile.isDirectory() || aFile.isFile()) {
					cntInnerFiles++;
				}
			}
		}
		if (cntInnerFiles >= 1){
			return true;}
		else {
			System.out.println(parentDir);
			return false;} 
	}
    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
        try{ 
        	JList theList = (JList) mouseEvent.getSource();
          
        	if (mouseEvent.getClickCount() == 2) {
        	  int index = theList.locationToIndex(mouseEvent.getPoint());
              if (index >= 0) {
                folderClicked +=  theList.getModel().getElementAt(index).toString() + "/" ;
                
                System.out.println("Double-clicked on: " + folderClicked.toString());
                listDirectory("", "/" + folderClicked.toString());
              }
           
          }
        }catch(IOException io){
        	
        }
        }
      };
	
	public  void listDirectory( String parentDir,
			String currentDir) throws IOException {
		String dirToList = parentDir;
		if (!currentDir.equals("")) {
			dirToList += "/" + currentDir;
		}
		
		FTPFile[] subFiles = ftpClient.listFiles(dirToList);
			if (subFiles != null && subFiles.length > 0) {
				
			for (FTPFile aFile : subFiles) {
				String currentFileName = aFile.getName();
				if (currentFileName.equals(".")
						|| currentFileName.equals("....")) {
					continue;
				}
				if (aFile.isDirectory() || aFile.isFile()) {
					System.out.println(currentFileName);
					gui.addInList(currentFileName); 
				}
			}
			gui.updateGUI(mouseListener);
			gui.addInList("\n");
		}
		
	}
	public  void connectToFtp() throws IOException {
		loadProperty();
		gui.updateGUI(mouseListener);
		String server = property.getProperty("server");
		int port = Integer.parseInt(property.getProperty("port"));
		String user = property.getProperty("user");
		String pass = property.getProperty("pass");
		ftpClient.connect(server, port);
		ftpClient.enterLocalPassiveMode();
		int replyCode = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			System.out.println("Connection failed");
			return;
		}
		boolean success = ftpClient.login(user, pass);
		if (!success) {
			System.out.println("Could not login to to the server");
			return;
		}

	}
	@SuppressWarnings("unused")
	public  void downloadFileFromFtp( String path,
			String currentName)
			throws IOException {
		
		final int partStream = 4096;
		String remoteFile1 = path.substring(0, path.length() - 1);
		File downloadFile1 = new File(currentName);
		OutputStream outputStream2 = new BufferedOutputStream(
				new FileOutputStream(downloadFile1));
		InputStream inputStream = ftpClient.retrieveFileStream(remoteFile1);
		byte[] bytesArray = new byte[partStream];
		int bytesRead = -1;
		System.out.println("Load of " + currentName + "...");
		
		while ((bytesRead = inputStream.read(bytesArray)) != -1) {
			outputStream2.write(bytesArray, 0, bytesRead);
		}
		boolean success = ftpClient.completePendingCommand();
		if (success) {
			System.out.println("File " + currentName
					+ " has been downloaded successfully.");
		}
		outputStream2.close();
		inputStream.close();
	}
	public  void disconnectFromFtp(){
		try {
			if (ftpClient.isConnected()) {
				ftpClient.logout();
				ftpClient.disconnect();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
