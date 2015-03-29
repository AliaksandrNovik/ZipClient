package rfe.by.novik.run;

import java.io.IOException;


import rfe.by.novik.ftp.FtpWork;
import rfe.by.novik.gui.Gui;

public class RunAplication {
	public static void main(String[] args) throws IOException{
		FtpWork ftp = new FtpWork();
		ftp.printComandInform();
		Gui gui = new Gui(ftp);
		gui.RunGui("/");
	}
}

