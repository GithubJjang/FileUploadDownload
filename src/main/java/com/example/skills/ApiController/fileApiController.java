package com.example.skills.ApiController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.skills.Service.fileService;

 

@RestController
public class fileApiController {
	
	@Autowired
	private fileService fileService;

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		
		// 1. 넘어온 파일에 UUID를 부여해서 DB에 저장을 하고,
		// 2. 선택된 경로에 저장을 한다.
		fileService.saveFile(file);
		
		// 3. 만약 여러개의 파일을 보낸 경우, 위 과정을 iterate한다.
		for(MultipartFile multifile: files) {
			fileService.saveFile(multifile);
		}
		
		return "success";
		
	}
	
}
