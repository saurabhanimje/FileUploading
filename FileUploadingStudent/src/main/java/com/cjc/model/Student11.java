package com.cjc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student11
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private String studentCity;
	private long studentMobNo;
	@Lob
	@Column(length = 999999999)
	private byte[] studentImage;
	@Lob
	@Column(length = 999999999)
	private byte[] studentSign;
	@Lob
	@Column(length = 999999999)
	private byte[] studentIdCard;
		
}
