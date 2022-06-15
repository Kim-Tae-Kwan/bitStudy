package com.bit.sts09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	String uplaodPath = "D:/Development/bitStudy/spring/fileOI02/src/upload/";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		file.transferTo(new File(uplaodPath + filename));
		req.setAttribute("origin",file.getOriginalFilename());
		req.setAttribute("filename",filename);
		return "down";
	}
	
	// Controller를 통한 다운로드.
		@RequestMapping("/down")
		public void download(@RequestParam("file") String filename, @RequestParam String origin, HttpServletResponse res) throws IOException {
			
			File file = new File(uplaodPath + filename);
			
			// 이진 데이터.
			res.setContentType("application/octet-stream");
			// 브라우저에 표현하지 않고 다운로드.
			res.setHeader("Content-Disposition", "attachment; filename=\""+ origin + "\"");
			
			OutputStream os = res.getOutputStream();
			InputStream is = new FileInputStream(file);
			
			while(true) {
				int su = is.read();
				if(su == -1) break;
				os.write(su);
			}
			is.close();
		}
	
}
