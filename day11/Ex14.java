import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Ex14 {
	// Filter Class
	public static void main(String[] args) {
		File file = new File("test11.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		long before, after;
		byte[] arr = new byte[(int)file.length()];
		int cnt = 0;
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); //객체 생성시 파일 내용 메모리로 올라옴.
			
			before = System.currentTimeMillis();
			while(true) {
				int su = bis.read();
				if(su == -1) break;
				arr[cnt++] = (byte)su;
			}
			
			bis.close();
			fis.close();
			after = System.currentTimeMillis();
			System.out.println(new String(arr) + ":" + (after - before) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
