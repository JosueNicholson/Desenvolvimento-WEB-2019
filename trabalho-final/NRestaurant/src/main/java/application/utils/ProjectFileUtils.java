package application.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ProjectFileUtils {

	public static void salvarImagem(String path, MultipartFile imagem) {
		File file = new File(path);
		
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
