package com.app.poslovnaBanka.kontroler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.poslovnaBanka.modeli.Klijent;
import com.app.poslovnaBanka.service.impl.KlijentServiceImpl;

@RestController
@RequestMapping(value = "/log")
public class LoginKontroler {

	@Autowired
	KlijentServiceImpl klijentService;
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @PostMapping("/login")
    public ResponseEntity<?> login( HttpServletRequest request, @RequestBody Klijent klijent) {
    	Klijent logged = klijentService.findByEmail(klijent.getEmail());
    	if(logged == null) {
    		return new ResponseEntity<>("Wrong username or password", HttpStatus.BAD_REQUEST);
    	}
    	if(!logged.getPassword().equals(klijent.getPassword())) {
    		return new ResponseEntity<>("Wrong username or password", HttpStatus.BAD_REQUEST);
    	}
//
    	
    	//CurrentUser cu = new CurrentUser(logged);
    	request.getSession().setAttribute("user", logged);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
