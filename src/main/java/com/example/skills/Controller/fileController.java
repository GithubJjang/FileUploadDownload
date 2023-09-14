package com.example.skills.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.example.skills.Domain.FileEntity;
import com.example.skills.Repository.fileRepository;
import com.example.skills.Service.fileService;

@Controller
public class fileController {
	
	@Autowired
	private fileService fileService;
	
	@Autowired
	private fileRepository fileRepository;

	@GetMapping({"/",""})
	public String fileUpload() {
		return "/upload";
	}
	
	@GetMapping("/view")
	public String fileDownload(Model model) {
		// 다운로드 목록 가져오기.
		// view 불러오기(DB에서 해당 파일정보와 함께 보냄)
		// view 페이지에서 각 파일에 대해서 링크 걸기
		// 해당 링크 누를 경우 다운로드 실행
		List<FileEntity> files = fileRepository.findAll();
        model.addAttribute("all",files);
		return "/view";
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		
		// 1. 넘어온 파일에 UUID를 부여해서 DB에 저장을 하고,
		// 2. 선택된 경로에 저장을 한다.
		fileService.saveFile(file);
		
		// 3. 만약 여러개의 파일을 보낸 경우, 위 과정을 iterate한다.
		for(MultipartFile multifile: files) {
			fileService.saveFile(multifile);
		}
		
		return "/success";
	}
	
	 @GetMapping("/attach/{id}")
	    public ResponseEntity<UrlResource> downloadAttach(@PathVariable int id) throws MalformedURLException {

	        FileEntity file = fileRepository.findById(id).orElse(null);

	        UrlResource resource = new UrlResource("file:" + file.getSavedPath());

	        String encodedFileName = UriUtils.encode(file.getOrgNm(), StandardCharsets.UTF_8);

	        // 파일 다운로드 대화상자가 뜨도록 하는 헤더를 설정해주는 것
	        // Content-Disposition 헤더에 attachment; filename="업로드 파일명" 값을 준다.
	        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
	    }
		
}
