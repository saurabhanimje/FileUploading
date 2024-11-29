package com.cjc.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.model.Student11;
import com.cjc.service.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService ss;
	
	private static final Logger Log=LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping("/saveStudentss")
	public ResponseEntity<Student11> saveStudent(@RequestPart("data") String studata,@RequestPart("sImage") MultipartFile
			 stuImage,@RequestPart("sSign") MultipartFile stuSign,@RequestPart("sIdCard") MultipartFile stuIdCard)
	{
		Student11 studentData=ss.saveStudentData(studata,stuImage,stuSign,stuIdCard);
		return new ResponseEntity<Student11>(studentData,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<Iterable<Student11>> getAllStudent()
	{
		Iterable<Student11> studentData=ss.getStudents();
		return new ResponseEntity<Iterable<Student11>>(studentData,HttpStatus.OK);
	}
	
	
	@GetMapping("/getSingleStudent/{id}")
	public ResponseEntity<Student11> getASingleStudent(@PathVariable int id)
	{
		Student11 studentData=ss.getSingleStudent(id);
		return new ResponseEntity<Student11>(studentData,HttpStatus.OK);
	}
	
	
	
	
	
	
}
