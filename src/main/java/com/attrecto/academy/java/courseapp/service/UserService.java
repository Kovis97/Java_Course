package com.attrecto.academy.java.courseapp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.attrecto.academy.java.courseapp.model.dto.CreateMinimalUserDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;

@Service
public class UserService {

	public List<MinimalUserDto> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public MinimalUserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public MinimalUserDto createUser(@Valid CreateMinimalUserDto createMinimalUserDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public MinimalUserDto updateCourse(Integer id, @Valid CreateMinimalUserDto createMinimalUserDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
