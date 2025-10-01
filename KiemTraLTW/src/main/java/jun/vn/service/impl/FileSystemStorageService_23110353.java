package jun.vn.service.impl;

import jun.vn.service.IStorageService_23110353;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileSystemStorageService_23110353 implements IStorageService_23110353 {

	// Lấy đường dẫn từ application.properties
	@Value("${storage.location}")
	private String storageLocation;

	@Override
	public String store(MultipartFile file) throws IOException {
	    if (file.isEmpty()) {
	        throw new IOException("File upload rỗng!");
	    }

	    Path uploadDir = Paths.get(storageLocation);
	    if (!Files.exists(uploadDir)) {
	        Files.createDirectories(uploadDir);
	    }

	    String originalFilename = file.getOriginalFilename();
	    String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
	    String newFilename = UUID.randomUUID().toString() + ext;

	    Path dest = uploadDir.resolve(newFilename);
	    file.transferTo(dest.toFile());

	    return newFilename;
	}
}
