package com.yg.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	@Autowired
	private ServletContext application; // 절대경로
	
	@RequestMapping("/")
	public String home(Model model) {
		
		return "upload";
	}
	
	// MultipartRequest 제거 (스프링 MultipartFile 파라미터(@RequestParam("file1"))가 자동으로 바인딩)
	// 파일과 함께 넘어온 텍스트를 일반 텍스트와 동일하게 처리 (NOT multi.getParameter())
	@PostMapping("/upload")
	public String upload(@RequestParam("file1") MultipartFile file, @RequestParam("desc") String desc, Model model) {
		
				// 1. upload フォルダーを生成する(필요시)
				//ServletContext application = getServletContext(); // 절대경로
				String path = application.getRealPath("resources/upload"); // upload 폴더의 절대경로(C:/ 로 시작) 얻기.
				System.out.println("zettaikeiro: "+ path);
				
				File f = new File(path); //File객체: 파일 시스템 관련 처리
				if(!f.exists()) {
					f.mkdirs();	//해당 폴더를 생성함(필요시 상위폴더까지 한번에)
				}
				
				// 2. 폴더를 지정하고, 지정한 폴더에 파일 저장
				//파일 저장 = MultipartRequest 객체를 생성하는 순간!
				/*
				 * MultipartRequest multi = new MultipartRequest( request, //요청객체 path, //파일 저장
				 * 경로(절대경로) 100*1024*1024, // 파일의 최대크기 (byte단위) "UTF-8", //파일명 꺠짐 방지
				 * 
				 * new DefaultFileRenamePolicy() // 기본적인 rename 정책 ex) photo.jpg -> photo1.jpg
				 * );
				 */
				// 3. 저장된 파일에 대한 정보를 MultipartRequest 객체로부터 뽀바냄
			//	String filename = multi.getFilesystemName("file1");
			//	System.out.println("file name: "+ filename);
				// multi.getOri~(file객체) / / 웹브라우지에서 선택한 파일명
				// multi.getFile(file객체) //업로드한 파일 크기(byte단위)
				
				String filename = "";
				String filenameUUID = "";
				if(!file.isEmpty()) {
					filename = file.getOriginalFilename();
					int dotIdx = filename.lastIndexOf(".");
					filenameUUID = UUID.randomUUID().toString() + filename.substring(dotIdx);
					
					// 파일명 중복방지
					File saveFile = new File(path, filenameUUID);
					/*
					 * while(saveFile.exists()) { int dotIdx = filename.lastIndexOf("."); }
					 */
					
					try {
						file.transferTo(saveFile); //파일 저장.
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("saved file name: "+ filename);
					System.out.println("saved filename UUID: "+ filenameUUID);
				}
				
				// 주의 
				//( X )String desc = request.getParameter("desc");
				//String desc = multi.getParameter("desc");
				System.out.println(desc);
				
				model.addAttribute("filename", filename);
				model.addAttribute("filenameUUID", filenameUUID);
				model.addAttribute("desc", desc);
				//request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
				return "uploadResult";
	}
}
