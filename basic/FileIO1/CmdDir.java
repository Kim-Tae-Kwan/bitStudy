import java.io.*;
import java.text.*;
import java.util.*;

public class CmdDir {

	static SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd a HH:MM");
	static DecimalFormat decimalFormat = new DecimalFormat("###,###");
	
	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			args = new String[1];
			args[0] = ".";
		}
		File root = new File(args[0]).getCanonicalFile(); // 절대경로로 File 객체 생성.
		System.out.println("\n " + root.getPath() + " 디렉터리\n");

		if(root.exists() && root.isDirectory()) {
			int fileCnt = 0;
			long fileSize = 0L;
			int dirCnt = 0;
			String[] list = root.list();
			if(root.getParent() != null) {
				String[] temp = new String[list.length + 2];
				temp[0] = ".";
				temp[1] = "..";
				System.arraycopy(list, 0, temp, 2, list.length);
				list = temp;
			}
			
			for (int i = 0; i < list.length; i++) {
				String absolutePath = root.getPath() + "\\" + list[i];
				File file = new File(absolutePath);
				if(file.isHidden()) continue;
				
				if(file.isFile()) {
					fileCnt++;
					fileSize += file.length();
				}else dirCnt++;
				
				System.out.println(getInfo(file));
			}
			
			System.out.println(getFileInfo(fileCnt, fileSize));
			System.out.println(getDirInfo(dirCnt, root.getFreeSpace()));
		}else if(root.exists() && root.isFile()) {
			System.out.println(getInfo(root));
			System.out.println(getFileInfo(1, root.length()));
			System.out.println(getDirInfo(0, root.getFreeSpace()));
		}
		else System.out.println("볼륨에는 이름이 없습니다.");
	}
	public static String getFileInfo(int fileCnt, long fileSize) {
		int middleCnt = 20;
		int prefix = 12;
		StringBuilder sb = new StringBuilder();
		String totalFileSize = decimalFormat.format(fileSize);
		
		addSpace(sb, prefix);
		sb.append(fileCnt + "개 파일");
		addSpace(sb, middleCnt - totalFileSize.length());
		sb.append(totalFileSize + " 바이트");
		
		return sb.toString();
	}
	
	public static String getDirInfo(int dirCnt, long totalSpace) {
		int middleCnt = 16;
		int prefix = 12;
		StringBuilder sb = new StringBuilder();
		String totalDirSize = decimalFormat.format(totalSpace);
		
		addSpace(sb, prefix);
		sb.append(dirCnt + "개 디렉토리");
		addSpace(sb, middleCnt - totalDirSize.length());
		sb.append(totalDirSize + " 바이트 남음");
		
		return sb.toString();
	}
	
	public static String getInfo(File file) {
		StringBuilder sb = new StringBuilder();
		sb.append(dtFormat.format(new Date(file.lastModified())));
		if(file.isDirectory()) {
			sb.append("    <DIR>          ");
		}else {
			int middleLength = 17;
			String size = decimalFormat.format(file.length());
			addSpace(sb, middleLength - size.length() + 1);
			sb.append(size + " ");
		}
		sb.append(file.getName());
		return sb.toString();
	}
	
	public static void addSpace(StringBuilder sb, int num) {
		for (int i = 0; i < num; i++) {
			sb.append(" ");
		}
	}

}
