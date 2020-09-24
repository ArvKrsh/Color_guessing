package com.techprimers.security.springbootfacebookloginexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static String[] colors = {"WHITE","BLUE","RED","PINK","BLACK","YELLOW","GREEN","VIOLET","ORANGE"};
	
	@Autowired
	OAuth2ClientContext oAuth2ClientContext;

    @GetMapping
    public UserResponse getUser(Principal user) {
//    	Facebook facebook = new FacebookTemplate(oAuth2ClientContext.getAccessToken().getValue());
//        String[] fields = { "id", "email", "first_name", "last_name" };
//        User userInfo =  facebook.fetchObject("me", User.class, fields);
        UserResponse response = new UserResponse();
        response.setUser(user);
        Random random = new Random();
        response.setFav_color(colors[random.nextInt(colors.length)]);
        return response;
    }
    
    @GetMapping(value="/test")
    public UserResponse getUser() {
        Random random = new Random();
        UserResponse response = new UserResponse();
        response.setFav_color(colors[random.nextInt(colors.length)]);
        return response;
    }
}


class UserResponse {
	private Principal user;
	private String fav_color;
	
	public Principal getUser() {
		return user;
	}
	public void setUser(Principal user) {
		this.user = user;
	}
	public String getFav_color() {
		return fav_color;
	}
	public void setFav_color(String fav_color) {
		this.fav_color = fav_color;
	}
}
