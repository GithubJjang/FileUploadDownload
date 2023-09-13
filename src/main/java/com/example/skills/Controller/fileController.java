package com.example.skills.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fileController {

	@GetMapping({"/",""})
	public String fileUpload() {
		return "upload";
	}
	
}
