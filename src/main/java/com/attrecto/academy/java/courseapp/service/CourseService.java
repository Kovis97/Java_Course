package com.attrecto.academy.java.courseapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.attrecto.academy.java.courseapp.model.dto.CourseDto;
import com.attrecto.academy.java.courseapp.model.dto.CreateCourseDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;

@Service
public class CourseService {
	private MinimalUserDto firstUser;
	private MinimalUserDto secondUser;
	private CourseDto firstCourse;
	private CourseDto secondCourse;
	
	public CourseService() {
		firstUser = new MinimalUserDto();
		firstUser.setId(1);
		firstUser.setName("FirstUser");
		firstUser.setEmail("firstUser@attrecto.com");
		
		firstCourse = new CourseDto();
		firstCourse.setStudents(new ArrayList<>(Arrays.asList(firstUser)));
		
		secondUser = new MinimalUserDto();
		secondUser.setId(1);
		secondUser.setName("secondUser");
		secondUser.setEmail("secondUser@attrecto.com");
		
		secondCourse = new CourseDto();
		secondCourse.setStudents(new ArrayList<>(Arrays.asList(secondUser)));
	}
	
	public List<CourseDto> listAllCourses() {
		return new ArrayList<>(Arrays.asList(firstCourse, secondCourse));
	}
	
	public CourseDto getCourseById(Integer id) {
		return firstCourse;
	}

	public CourseDto createCourse(CreateCourseDto createCourseDto) {
		CourseDto newCourseDto = new CourseDto();
		newCourseDto.setStudents(createCourseDto.getStudentIds().stream().map(id -> {
			MinimalUserDto minimalUserDto = new MinimalUserDto();
			minimalUserDto.setId(id);
			minimalUserDto.setName("user" + id);
			minimalUserDto.setEmail(String.format("user%semail@attrecto.com", id));
			return minimalUserDto;
		}).collect(Collectors.toList()));

		return newCourseDto;
	}

	public CourseDto updateCourse(Integer id, CreateCourseDto createCourseDto) {
		CourseDto updatedCourseDto = new CourseDto();
		updatedCourseDto.setStudents(new ArrayList<>(Arrays.asList(firstUser, secondUser)));
		return updatedCourseDto;
	}

	public void deleteCourse(Integer id) {
	}
}
