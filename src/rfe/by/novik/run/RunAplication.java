package rfe.by.novik.run;

import java.io.IOException;

import rfe.by.novik.ftp.FtpWork;

public class RunAplication {

	public static void main(String[] args) throws IOException{

		FtpWork ftp = new FtpWork();
		ftp.printComandInform();
		try {
			ftp.connectToFtp();
			String currentName = "";
			String path = "" ; 
			ftp.listDirectory(path, "/");
			currentName = ftp.readFromConsole(currentName);
		}  finally {
			ftp.disconnectFromFtp();
		}

	}
}

