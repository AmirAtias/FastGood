package acs.data;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import acs.boundaries.UserBoundary;

@Component
public class UserEntityConverter {
	private ObjectMapper jackson;
	
	@PostConstruct
	public void setup() {
		this.jackson = new ObjectMapper();
	}
	
	
	public UserEntity toEntity(UserBoundary user) {
		UserEntity entity=new UserEntity();
		if(user.getEmail()!=null) {
			entity.setEmail(user.getEmail());
		}
		UserRole type=user.getRole();
		if(type!=null && type==UserRole.ADMIN||type==UserRole.MANAGER||type==UserRole.PLAYER) {
			entity.setRole(type);
		}
		if(user.getAvatar()!=null) {
			entity.setAvatar(user.getAvatar());
		}
		if(user.getUsername()!=null) {
			entity.setUsername(user.getUsername());
		}
		return entity;
		
	}
	
}
