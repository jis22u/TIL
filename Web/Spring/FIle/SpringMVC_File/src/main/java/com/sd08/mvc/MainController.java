package com.sd08.mvc;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@Autowired
	private ServletContext servletContext;
	
	
	
	/**
	 * 프로젝트를 실행시키면 index.jsp 파일 띄워주기 
	 * [ 요청 ] http://localhost:8080/mvc/ (GET 방식으로 전달)
	 * [ 응답 ] index.jsp 페이지를 띄워준다.
	 * @return "index"
	 */
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	
	
	
	/**
	 * 요청으로부터 넘겨받은 파일을 서버에 저장하기
	 * 톰캣 서버를 이용하고 있기 때문에 업로드한 파일은 톰캣 서버 정보 파일들에서 확인할 수 있다.
	 * 해당 구현은 파일을 1개만 업로드할 수 있다. 
	 * 여라개 업로드를 하기 위해선 MultipartFile을 배열로 받아야 한다.
	 * @param upload_file
	 * @param model
	 * @return "result"
	 */
	@PostMapping("upload")
	public String upload(MultipartFile upload_file, Model model) {
		// 업로드 경로와 파일이름 준비
		String uploadPath = servletContext.getRealPath("/file");
		String fileName = upload_file.getOriginalFilename();
		
		// webapp 영역에 file 이라는 폴더가 없다면(/file 이라는 경로가 없다면) 만들어라
		if(!new File(uploadPath).exists()) {
			new File(uploadPath).mkdir();
		}

		// File 객체를 생성
		File target = new File(uploadPath, fileName);
		
		// 파일 저장
		try {
			// upload_file를 Byte 배열로 받아서 target에 저장하겠다
			FileCopyUtils.copy(upload_file.getBytes(), target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 결과창으로 페이지이동
		// 이때 파일 이름을 결과페이지에 같이 띄워주겠다. 이때 Model 바구니가 필요하다
		model.addAttribute("fileName", fileName);
		return "result";
	}
	
	

	
	/**
	 * 톰캣 서버에 업로드해둔 파일을 다운로드한다.
	 * BeanNameViewResolver 덕분에 fileDownLoadView(FileDownLoadView.java)로 찾아간다.
	 * view name의 앞글자를 대문자로 바꿔 적절한 View Resolver를 찾아가도록 하는 것
	 * @param model
	 * @param fileName
	 * @return 뷰이름
	 */
	@GetMapping("download")
	public String download(Model model, String fileName) {
		Map<String, Object> fileInfo = new HashMap<>();
		fileInfo.put("fileName", fileName);
		model.addAttribute("downloadFile", fileInfo);
		
		return "fileDownLoadView";
	}
	
}
