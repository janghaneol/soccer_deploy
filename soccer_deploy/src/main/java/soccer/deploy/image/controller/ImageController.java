package soccer.deploy.image.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/image")
public class ImageController {
	
	@Value("${spring.servlet.multipart.location}") 
	private String location;
	
	@GetMapping("/{fileName}")
	public ResponseEntity<Resource> imgFile(@PathVariable String fileName) throws IOException {
		log.info("이미지파일{}",fileName);
		Path path = Paths.get(location + "/" + fileName);
		// 만약 디비연결이면
		String contentType = Files.probeContentType(path);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new FileSystemResource(path);
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
}
