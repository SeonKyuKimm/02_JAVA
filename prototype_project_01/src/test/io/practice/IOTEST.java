package test.io.practice;

import java.io.File;

public class IOTEST {

			
	
	
	public void method() {
		
		
	
		File directory = new File("/io_test/20240222");
		
		System.out.println("존재여부 true /false : " + directory.exists());
	
		if (!directory.exists()) {
			
			System.out.println("파일이 존재하지 않습니다");
			System.out.println(directory.getName());
			System.out.println(directory.getParent()); //"/io_test/20240222"
			
		}
	
	}
	
	public void method3() {
		
		File directory = new File("\\workspace\\02_java\\12_IO");
		
		File[] files = directory.listFiles();
		
		
		for (File f : files) {
			
			String fileName = f.getName();
			
			long lastModified = f.lastModified();
			
			}
			
		}
	}

