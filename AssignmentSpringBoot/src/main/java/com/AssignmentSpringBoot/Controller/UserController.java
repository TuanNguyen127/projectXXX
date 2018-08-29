package com.AssignmentSpringBoot.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.AssignmentSpringBoot.Entity.User;
import com.AssignmentSpringBoot.Model.UserModel;
import com.AssignmentSpringBoot.Repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Environment env;
	
	//hiển thị
	@RequestMapping("/admin/user")
	public String adminUser(Model model) {
		model.addAttribute("ListUser", userRepository.findAll(Sort.by(Direction.DESC, "iduser")));
		return "adminUser";
	}
	//load font thêm
	@RequestMapping("/admin/addnew-user")
	public String adminAddNewUser(Model model) {
		model.addAttribute("UserNew", new UserModel());
		return "addNewUser";
	}
	//thêm user
	@RequestMapping(value= "/admin/saveUser", method=RequestMethod.POST)
	public String doSaveUser(@ModelAttribute("UserNew") UserModel userModel, Model model) {
		try {
			MultipartFile multipartFile = userModel.getMultipartFile();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File(this.getFolderUpload(), fileName);
			multipartFile.transferTo(file);
			userModel.getUser().setAvatar(fileName);
			//mã hóa password
			userModel.getUser().setPassword(passwordEncoder.encode(userModel.getUser().getPassword()));
			userRepository.save(userModel.getUser());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/user";
	}
	
	//vị trí ảnh lưu
	public File getFolderUpload() {
		File folderUpload = new File(env.getProperty("vitriluufile"));
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
	//load ảnh lên hiển thị
	@RequestMapping("/avatar/{filename}")
	public @ResponseBody byte[] getImage(@PathVariable("filename") String filename) {
		File file = new File(env.getProperty("vitriluufile") + "/" + filename);
		try {
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	//xóa user
	@RequestMapping("/admin/del-user/{iduser}")
	public String DelUser(@PathVariable int iduser) {
		userRepository.deleteById(iduser);
		return "redirect:/admin/user";
	}
	//get id into font edit
	@RequestMapping("/admin/edit-user/{iduser}")
	public String editUser(@PathVariable int iduser, Model model) {
		Optional<User> user = userRepository.findById(iduser);
		UserModel userModel = new UserModel();
		if (user.isPresent()) {
			userModel.setUser(user.get());
			model.addAttribute("userModel", userModel);
		}
		return "adminEditUser";
	}
	//Lưu lại sau khi đã edit
	@RequestMapping("/admin/EditUser")
	public String doEditUser(@ModelAttribute("userModel") UserModel userModel, Model model) {
		Optional<User> user = userRepository.findById(userModel.getUser().getIduser());
		if(userModel.getMultipartFile().isEmpty()) {
			String oldAvatarName = user.get().getAvatar();
			userModel.getUser().setAvatar(oldAvatarName);
			userRepository.save(userModel.getUser());
		}else {
			try {
				MultipartFile multipartFile = userModel.getMultipartFile();
				String fileName = multipartFile.getOriginalFilename();
				File file = new File(this.getFolderUpload(), fileName);
				multipartFile.transferTo(file);
				userModel.getUser().setAvatar(fileName);
				userRepository.save(userModel.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/user";
	}
	
	//load font sign up
	@RequestMapping("/sign-up")
	public String signUp(Model model) {
		model.addAttribute("UserSignUp", new User());
		return "signUp";
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	//sign up
	@RequestMapping(value= "/saveSignUp", method=RequestMethod.POST)
	public String doSignUp(@ModelAttribute("UserSignUp") User user, Model model) {
		if(!userRepository.findByUsername(user.getUsername()).isEmpty()) {
			model.addAttribute("error","người dùng đã tồn tại");
			return "signUp";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("user");
		userRepository.save(user);
		
		return "redirect:/sign-in";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {
		model.addAttribute("user", userRepository.findByUsername(principal.getName()).get(0));
		return "admin";
	}
	
	@RequestMapping("/default")
	public String chooseWhereToGoAfterLoginSuccessfully(HttpServletRequest request) {
		if(request.isUserInRole("ROLE_admin")) {
			return "redirect:/admin";
		}
		return "redirect:/";
	}
}
