package test.java.com.ds.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import main.java.com.ds.filescan.FileProperties;

public class FilePropertiesTest {

	FileProperties fp;
	
	File[] expectedFileList = {new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle1.csv"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle10.txt"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle11.csv"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle12.csv"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle13.xls"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle2.xls"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle3.xls"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle4.csv"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle5.csv"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle6.txt"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle7.csv"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle8.xls"),
								new File("C:\\Users\\dell\\workspace\\FileProperties\\src\\main\\java\\com\\ds\\resources\\files\\Vehicle9.xls")}; 
	
	@Before
	public void setUp(){
		fp = new FileProperties();
		fp.ScanFileForProperties();
	}
	
	@Test
	public void TestIsDirectory(){
		assertTrue(fp.isDirectory(new File(fp.getFileDir())));
	}
	
	@Test
	public void TestDirectoryNotNull(){
		int fCount = fp.getFileCount();
		assertEquals(11, fCount);
	}
	
	@Test
	public void TestFilesCount(){
		assertTrue(fp.getFileCount() > 0);
	}
	
	@Test
	public void TestFileNames(){
		assertArrayEquals(expectedFileList, fp.getFileList());
	}
	
}
