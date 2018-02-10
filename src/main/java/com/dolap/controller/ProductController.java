package com.dolap.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolap.entity.Image;
import com.dolap.entity.Product;
import com.dolap.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;

	private static String UPLOADED_FOLDER = "C:\\Users\\umutates\\git\\dolap\\src\\main\\resources\\static\\images\\home\\";
	private static String PARENT_FOLDER = "images/home/";
	
	@PostMapping("/save")
	public String save(@ModelAttribute Product product, @RequestParam("files") MultipartFile[] file, RedirectAttributes redirectAttributes) {
		Set<Image> images=new HashSet<>();
		for (MultipartFile multipartFile : file) {
			String fileName=singleFileUpload(multipartFile, redirectAttributes);

			
			Image image=new Image();
			image.setFileName(fileName);
			image.setImagePath(PARENT_FOLDER+fileName);
			images.add(image);
		}
		product.setImages(images);
		productService.insert(product);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "redirect:/";
	}

	public String singleFileUpload(MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
			path=Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
             
			return path.toFile().getName();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

		
	}

}
