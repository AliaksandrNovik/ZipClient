package rfe.by.novik.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ZipArch {
	final static int partHTTP = 1024;

	public  void addToZipFile(String fileName) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");
		FileOutputStream fos = new FileOutputStream("Output.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);
		
		byte[] bytes = new byte[partHTTP];
		
		int length;
		
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		zos.close();
		fis.close();
		fos.close();
		System.out.println(fileName + "' has been added to zip");
		JOptionPane.showMessageDialog(new JFrame(), "File " + file.getName() +" has been added to zip");
	} 
}
