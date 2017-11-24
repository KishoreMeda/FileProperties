package main.java.com.ds.filescan;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

import main.java.com.ds.util.PropertiesHandler;

public class FileProperties {

	PropertiesHandler proprities;
	String fileDir;
	File[] fileList;
	
	String mimeType;
	String fileName;
	String fileExt;
	long fileSize;
	int fileCount;
	// Constructor to read Directory info from config.properties
	public FileProperties(){
		proprities = new PropertiesHandler();
		fileDir = System.getProperty("user.dir") + "/src" + proprities.getProperty("sourcedir");
	}
	
	public void ScanFileForProperties(){
		File dir = new File(fileDir);
		
		// Verify configured source directory is exists
		if(!isDirectory(dir)){
			System.out.println(dir + " is not a Directory");
			System.exit(0);
		}
		
		fileList = dir.listFiles();
		
		// Scan through the each file and display its properties
		for(int i = 0; i < fileList.length; i++){
			File file = fileList[i];
			if (file.isFile() && (file.getName().endsWith(".csv") || file.getName().endsWith(".xls"))){
				fileCount++;
				fileName = file.getName();
				fileSize = file.length();
				fileExt =  fileName.substring(fileName.lastIndexOf('.') + 1);
				mimeType = new MimetypesFileTypeMap().getContentType(file);
				System.out.println("FileName: " + fileName);
				System.out.println("FileSize: " + fileSize);
				System.out.println("FileExtension: " + fileExt);
				System.out.println("File Mime Type: " + mimeType);
			}
		}
		if (fileCount > 0)
			System.out.println("No. Of Files:" + fileCount);
	}

	public int getFileCount(){
		return fileCount;
	}
	
	public boolean isDirectory(File file){
		return (file.isDirectory());
	}

	public String getFileDir(){
		return fileDir;
	}
	
	public File[] getFileList(){
		return fileList;
	}
	
	public static void main(String args[]){
		FileProperties scanDir = new FileProperties();
		scanDir.ScanFileForProperties();
	}
}

