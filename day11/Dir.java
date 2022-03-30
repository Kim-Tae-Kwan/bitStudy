import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dir {

	public static void main(String[] args) {
//		String path = "D:\\Development\\javawork\\day11";
		String path = "C:";
		path = args[0];
		
		File root = new File(path);
		String[] list = root.list();
//		System.out.println(Arrays.deepToString(list));
		
		for (int i = 0; i < list.length; i++) {
			File file = new File(path + "\\" + list[i]);
			Date date = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
			String msg = sdf.format(date);
			System.out.print(msg + "\t");
			if(file.isDirectory()) {
				System.out.print("<DIR>\t\t");
			}else {
				System.out.print("\t" + file.length() + "\t");
			}
			System.out.println(list[i]);
		}
		
	}

}
