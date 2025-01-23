package org.jsp.jsp_gram.controller;

import org.jsp.jsp_gram.dto.Post;

//import org.jsp.jsp_gram.dto.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import com.razorpay.RazorpayException;
import org.jsp.jsp_gram.dto.User;
import org.jsp.jsp_gram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {

	@Autowired
	UserService service;

	@GetMapping({ "/", "/login" })
	public String loadLogin() {
		return "login.html";
	}

	@GetMapping("/register")
	public String loadRegister(ModelMap map, User user) {
		return service.loadRegister(map, user);
	}

	@PostMapping("/register")
	public String register(@Valid User user, BindingResult result, HttpSession session) {
		return service.register(user, result, session);
	}

	@GetMapping("/otp/{id}")
	public String loadOtpPage(@PathVariable int id, ModelMap map) {
		map.put("id", id);
		return "user-otp.html";
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int otp, @RequestParam int id, HttpSession session) {
		return service.verifyOtp(otp, id, session);
	}

	@GetMapping("/resend-otp/{id}")
	public String resendOtp(@PathVariable int id, HttpSession session) {
		return service.resendOtp(id, session);
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		return service.login(username, password, session);
	}

	@GetMapping("/home")
	public String loadHome(HttpSession session, ModelMap map) {
		return service.loadHome(session, map);
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		return service.logout(session);
	}

	@GetMapping("/profile")
	public String loadProfile(HttpSession session, ModelMap map) {
		return service.profile(session, map);
	}

	@GetMapping("/edit-profile")
	public String editProfile(HttpSession session) {
		return service.editProfile(session);
	}

	@PostMapping("/update-profile")
	public String updateProfile(HttpSession session, @RequestParam MultipartFile image, @RequestParam String bio) {
		return service.updateProfile(session, image, bio);
	}
	
	@GetMapping("/add-post")
	public String loadAddPost(ModelMap map, HttpSession session) {
		return service.loadAddPost(map, session);
	}
	
	@PostMapping("/add-post")
	public String addPost(Post post, HttpSession session) {
		return service.addPost(post, session);
	}
	
	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable int id, HttpSession session) {
		return service.deletePost(id, session);
	}
	@GetMapping("/suggestions")
	public String suggestions(HttpSession session,ModelMap map) {
		return service.viewSuggestions(session,map);
	}
	
	@GetMapping("/follow/{id}")
	public String follow(@PathVariable int id, HttpSession session) {
		return service.followUser(id, session);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, HttpSession session, ModelMap map) {
		return service.editPost(id, session, map);
	}
	
	@PostMapping("/update-post")
	public String updatePost(Post post, HttpSession session) throws Exception {
		return service.updatePost(post, session);
	}
	
	@GetMapping("/followers")
	public String getFollowers(HttpSession session, ModelMap map) {
		return service.getFollowers(session, map);
	}
	
	@GetMapping("/following")
	public String getFollowing(HttpSession session, ModelMap map) {
		return service.getFollowing(session, map);
	}
	
	@GetMapping("/unfollow/{id}")
	public String unfollow(@PathVariable int id, HttpSession session) {
		return service.unfollow(session, id);
	}
	
	@GetMapping("/view-profile/{id}")
	public String viewProfile(@PathVariable int id, HttpSession session, ModelMap map) {
		return service.viewProfile(id, session, map);
	}
	@GetMapping("/like/{id}")
	public String likePost(@PathVariable int id, HttpSession session) {
		return service.likePost(id, session);
	}
	
	@GetMapping("/dislike/{id}")
	public String dislikePost(@PathVariable int id, HttpSession session) {
		return service.dislikePost(id, session);
	}
	@GetMapping("/comment/{id}")
	public String loadCommentPage(@PathVariable int id, HttpSession session, ModelMap map) {
		return service.loadCommentPage(id, session, map);
	}
	@PostMapping("/comment/{id}")
	public String comment(@PathVariable int id, HttpSession session, @RequestParam String comment) {
		
		return service.comment(id, session, comment);
	}
	@GetMapping("/prime")
	public String prime(HttpSession session, ModelMap map) throws RazorpayException {
		return service.prime(session, map);
	}
	
	@PostMapping("/prime")
	public String prime(HttpSession session) throws RazorpayException {
		return service.prime(session);
	}
		
}