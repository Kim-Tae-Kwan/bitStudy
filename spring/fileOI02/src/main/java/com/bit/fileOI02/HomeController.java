package com.bit.fileOI02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


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
	@RequestMapping("/down/{filename:.+}")
	public void download(@PathVariable String filename, HttpServletResponse res){
		res.setContentType("application/octet-stream");
		String origin = filename.split("_")[1];
		res.setHeader("Content-Disposition", "attachment; filename=\""+ origin + "\"");
		
		try(
				InputStream is = new FileInputStream(new File(uplaodPath + filename));
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = res.getOutputStream();
				){
				
				while(true) {
					int su = bis.read();
					if(su == -1) break;
					os.write(su);
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
