package com.iie.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iie.dto.ApplicationFormDTO;
import com.iie.dto.FormDTO;
import com.iie.model.Examination;
import com.iie.model.UserRegister;
import com.iie.service.EmailService;
import com.iie.service.UserService;

@RestController
public class AppController {

	@Autowired
	private final UserService userService;
	@Autowired
	private EmailService emailService;

	public AppController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		System.out.println("home.html");
		int id = 0;
		mv.addObject("id", id);
		return mv;
	}

	@GetMapping("home/{id}")
	public ModelAndView homePage(@PathVariable("id") int id) {
		if (id == 0) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("home.html ");
			System.out.println("home.html");
			mv.addObject("id", id);
			return mv;
		} else {
			ModelAndView modelAndView = new ModelAndView("redirect:/index.html");
			Optional<UserRegister> user = userService.useriD(id);// useriD
			UserRegister userRegister = null;
			if (user.isPresent()) {
				userRegister = user.get();
				System.out.println("person : " + userRegister);
			}

			modelAndView.addObject("id", userRegister.getId());
			modelAndView.addObject("username", userRegister.getName());
			modelAndView.setViewName("home.html");
			System.out.println("success login");
			return modelAndView; // Redirect to home page on successful login
		}
	}

	@GetMapping("loginPage/{id}")
	public ModelAndView loginPage(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.html");
		System.out.println("login.html");
		mv.addObject("id", id);
		return mv;
	}

//	@PostMapping("/signup")
//	public ResponseEntity<UserRegister> registerUser(@RequestBody UserRegister userRegister) {
//		System.out.println("signup");
//		UserRegister registeredUser = userService.registerUser(userRegister);
//		System.out.println(userRegister);
//		return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
//	}

	@GetMapping("/signup/{id}")
	public ModelAndView reguser(UserRegister userreg) {
		System.out.println("inside reg");
		System.out.println(userreg);
		UserRegister registeredUser = userService.registerUser(userreg);

		System.out.println(registeredUser);
		ModelAndView mv = new ModelAndView();
		mv.addObject("test", registeredUser);
		mv.setViewName("login.html");
		return mv;
	}

	@PostMapping("/login")
	public Object loginUser(@RequestParam String username, @RequestParam String password) {
		if (userService.validateUser(username, password)) {
			ModelAndView modelAndView = new ModelAndView("redirect:/index.html");
			Optional<UserRegister> user = userService.user(username, password);// useriD
			UserRegister userRegister = null;
			if (user.isPresent()) {
				userRegister = user.get();
				System.out.println("person : " + userRegister);
			}

			modelAndView.addObject("id", userRegister.getId());
			modelAndView.addObject("username", userRegister.getName());
			modelAndView.setViewName("home.html");
			System.out.println("success login");
			return modelAndView; // Redirect to home page on successful login
		} else {
			System.out.println("error response");
			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED); // Return 401 with error
																							// message on failed login
		}
	}

	@PostMapping("/submitFormsample")
	public String submitForm() {
		String subject = "New Form Submission";
		String text = "hii mail checker";

		emailService.sendSimpleMessage("sheethu0001@gmail.com", subject, text);
		return "Form submitted successfully";
	}

	@PostMapping("/examsubmit")
	public Examination submitExamination(@RequestBody Examination examination) {
		Examination savedSubmission = emailService.examDateMail(examination);

		// Send email
		String to = "recipient@example.com";
		String subject = "New Form Submission";
		String text = "New form submission received:\n" + "Name: " + examination.getName() + "\n"
				+ "Application Number: " + examination.getApplicationNumber() + "\n" + "Course: "
				+ examination.getCourse() + "\n" + "Stream: " + examination.getStream() + "\n" + "Examination Date: "
				+ examination.getExamDate();
		emailService.sendSimpleMessage(to, subject, text);

		return savedSubmission;
	}

	 @PostMapping("/submitApplicationForm")
	    public String submitApplicationForm(@RequestBody ApplicationFormDTO form) {
	        // Process the form data
	        String subject = "New Form Submission";
	        String text = "Course: " + form.getFirstName() + " " +"Name: " + form.getFirstName() + " " + form.getMiddleName() + " " + form.getLastName() + "\n"
	                + "Date of Birth: " + form.getDateOfBirth() + "\n"
	                + "Phone Number: " + form.getPhoneNumber() + "\n"
	                + "WhatsApp Number: " + form.getWhatsappNumber() + "\n"
	                + "Alternative Number: " + form.getAlternativeNumber() + "\n"
	                + "Email: " + form.getEmail() + "\n"
	                + "Residential Address: " + form.getResidentialAddress() + "\n"
	                + "State: " + form.getState() + "\n"
	                + "District: " + form.getDistrict() + "\n"
	                + "Pincode: " + form.getPincode() + "\n"
	                + "Nationality: " + form.getNationality() + "\n"
	                + "Educational Qualification: " + form.getEducationalQualification() + "\n"
	                + "Work Experience: " + form.getWorkExperience() + "\n"
	                + "Working Sector: " + form.getWorkingSector() + "\n"
	                + "Current Working Country: " + form.getCurrentWorkingCountry() + "\n"
	                + "Course Opting For: " + form.getCourseOptingFor() + "\n"
	                + "Stream: " + form.getStream() + "\n"
	                + "Referral: " + form.getReferral() + "\n";

	        // Assuming you have an emailService to send emails
	        emailService.sendSimpleMessage("sheethu0001@gmail.com", subject, text);

	        return "Form submitted successfully";
	    }
	    
	@PostMapping("/submitForm")
	public String submitForm(@RequestBody FormDTO form) {
		String subject = "New Form Submission";
		String text = "Name: " + form.getName() + "\n" + "Phone: " + form.getPhone() + "\n" + "Email: "
				+ form.getEmail() + "\n" + "Course: " + form.getCourse() + "\n" + "Message: " + form.getMessage();

		emailService.sendSimpleMessage("sheethu0001@gmail.com", subject, text);
		return "Form submitted successfully";
	}
}