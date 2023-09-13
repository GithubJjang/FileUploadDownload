package com.example.skills.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.skills.Domain.FileEntity;
import com.example.skills.Repository.fileRepository;

@Service
public class fileService {
	
	@Autowired
	private String fileDir;
	
	@Autowired
	private fileRepository fileRepository;
	
	public int saveFile(MultipartFile files) throws IllegalStateException, IOException {
		// file을 이름과 경로로 분리
		// 이름 -> UUID -> 로컬PC와 DB에 저장
		// 경로 ->         로컬PC와 DB에 저장
		
        if (files.isEmpty()) {
            return -1;
        }

        // 원래 파일 이름 추출
        String origName = files.getOriginalFilename();

        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();

        // 확장자 추출(ex : .png)
        String extension = origName.substring(origName.lastIndexOf("."));

        // uuid와 확장자 결합
        String savedName = uuid + extension;

        // 파일을 불러올 때 사용할 파일 경로
        String savedPath = fileDir + savedName;

        // 1. 파일 엔티티 생성 -> DB에 저장하기 위한 목적
        FileEntity file = new FileEntity();
        file.setOrgNm(origName);
        file.setSavedNm(savedName);
        file.setSavedPath(savedPath);

        // 2. 실제로 로컬에 uuid를 파일명으로 저장 -> 실제 경로에 저장하기 위한 목적
        files.transferTo(new File(savedPath));

        // 데이터베이스에 파일 정보 저장 
        FileEntity savedFile = fileRepository.save(file);

        return savedFile.getId();
		
		
		
		
	}

}
