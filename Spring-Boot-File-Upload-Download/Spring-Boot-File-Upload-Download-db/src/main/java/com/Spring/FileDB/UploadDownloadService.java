package com.Spring.FileDB;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class UploadDownloadService {
	@Autowired
	private UploadDownloadRepository fileDBRepository;

	public UploadDownloadModel store(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename(); // String fileName =
														// StringUtils.cleanPath(file.getOriginalFilename());
		UploadDownloadModel fileDB = new UploadDownloadModel(fileName, file.getContentType(), file.getBytes());

		return fileDBRepository.save(fileDB);
	}

	public UploadDownloadModel getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	public Stream<UploadDownloadModel> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}

}
