package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOpeUtil {

	private FileOpeUtil() {

	}

	public static List readFile(String pathName) {
		List list = new ArrayList();
		ObjectInputStream oin = null;
		try {
			File f = new File(pathName);
			if (f.exists()) {
				oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				list = (List) oin.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oin != null) {
					oin.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}

	public static void writeFile(String pathName, List list) {
		File f = new File(pathName);
		ObjectOutputStream oout = null;
		try {
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oout.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oout != null) {
					oout.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
