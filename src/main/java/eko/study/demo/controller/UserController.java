package eko.study.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eko.study.demo.model.User;
import eko.study.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path= {"greetings", "hello"}, method= {RequestMethod.GET})
	public String greetings() {
		return "Hello World";
	}
	
	@RequestMapping(path="user", method=RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User createdUser = userRepository.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("id", createdUser.getId().toString());
		return new ResponseEntity<User>(headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(path="user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable("id") String id){
		Optional<User> user = userRepository.findById(Long.valueOf(id));
		return new ResponseEntity<User>(user.get(),HttpStatus.OK);
	}
	
	@RequestMapping(path="user", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
		User updatedUser = userRepository.save(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
}
