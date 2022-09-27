package com.attrecto.academy.java.courseapp.service;

import org.springframework.stereotype.Service;

import com.attrecto.academy.java.courseapp.model.dto.LoginDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;

@Service
public class AccountService {

	public String generateJwtToken(LoginDto loginDto) {
		return "test";
	}

	public MinimalUserDto getLoggedUser() {
		MinimalUserDto minimalUserDto = new MinimalUserDto();
		minimalUserDto.setId(1);
		minimalUserDto.setName("Kovis97");
		minimalUserDto.setEmail("semmi@an.hf");
		return minimalUserDto;
	}

}
