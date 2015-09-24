package controller;

//import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		//model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method=RequestMethod.GET)
	public void fileUploadForm() {
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public boolean processUpload(@RequestParam MultipartFile file, Model model,HttpServletResponse response,HttpServletRequest request) throws IOException {
		//model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
		System.out.println(file.getOriginalFilename());
		byte[] bytes = file.getBytes();
		String uploadDir = request.getSession().getServletContext().getRealPath("/upload/");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String sep = System.getProperty("file.separator");
		File dirPath = new File(uploadDir+sep+df.format(new Date()));
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		String savePath = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		File uploadedFile = new File(dirPath + sep+ savePath);
		FileCopyUtils.copy(bytes, uploadedFile);
		return true;
	}
	
}
