package com.cjc.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.model.Student11;
import com.cjc.repository.StudentRepository;
import com.cjc.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository sr;
	
	@Autowired
	private ObjectMapper objmapper;

	@Override
	public Student11 saveStudentData(String studata, MultipartFile stuImage, MultipartFile stuSign,
			MultipartFile stuIdCard) 
	{
		Student11 studentdata=null;
		try {
			studentdata = objmapper.readValue(studata, Student11.class);
			if(!stuImage.isEmpty())studentdata.setStudentImage(stuImage.getBytes());
			if(!stuSign.isEmpty())studentdata.setStudentSign(stuSign.getBytes());
			if(!stuIdCard.isEmpty())studentdata.setStudentIdCard(stuIdCard.getBytes());
			
			sr.save(studentdata);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentdata;
	}

	@Override
	public Iterable<Student11> getStudents() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Student11 getSingleStudent(int id) {
		// TODO Auto-generated method stubs
		return sr.findById(id).get();
	}

}
