package soccer.deploy.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.dto.UpdateUserDto;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.service.UserService;

@Slf4j
@Controller
public class profileController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/user/{userId}/modify/updateProfile")
	public String registProfile(@PathVariable Long userId , @RequestParam MultipartFile updateProfile,RedirectAttributes redirectAttributes, HttpSession session) {
		String ranName = UUID.randomUUID().toString();
		String storedFileName = ranName + "_" + updateProfile.getOriginalFilename();
		Optional<User> user = userService.findUser(userId);
		if(user.get().getImgFileName() != null) {
			File file = new File("/images/profile/" + user.get().getImgFileName());
			file.delete();
		}
		try {
			updateProfile.transferTo(new File(storedFileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		userService.imgUpdate(userId, storedFileName);
		session.setAttribute("loginUser", user.get());
		redirectAttributes.addAttribute("userId", userId);
		return "redirect:/user/{userId}/modify";
	}
	
}
