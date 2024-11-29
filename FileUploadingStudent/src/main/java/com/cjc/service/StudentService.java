package com.cjc.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;


import com.cjc.model.Student11;

public interface StudentService {

	public Student11 saveStudentData(String studata, MultipartFile stuImage, MultipartFile stuSign, MultipartFile stuIdCard);

	public Iterable<Student11> getStudents();

	public Student11 getSingleStudent(int id);

}
