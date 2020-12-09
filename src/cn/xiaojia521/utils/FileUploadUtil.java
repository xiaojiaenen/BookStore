package cn.xiaojia521.utils;

import javax.servlet.http.Part;

public class FileUploadUtil {
	public static String getFileName(Part part) {
		if (part == null) {
			return null;
		}
		String filename = part.getHeader("content-disposition");
		if (filename.lastIndexOf("=") + 2 == filename.length() - 1) {
			return null;
		}
		return filename.substring(filename.lastIndexOf("=") + 2, filename.length() - 1);
	}
}
