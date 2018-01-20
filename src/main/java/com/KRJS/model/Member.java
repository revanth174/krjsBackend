package com.KRJS.model;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "member")
@DynamicUpdate
@Component

public class Member {
	
	//@GeneratedValue
	@Column(name = "app_no",unique= true)
	private String appNo;

	@Id
	@Column()
	private String memberId;
	
	@Transient
	private MultipartFile image;

	@Column(name = "membershipType")
	private String type;

	@Column(name = "member_title")
	private String title;

	private String gender;
	

	@Column(name = "member_name",length = 40)
	private String name;

	@Column(name = "member_fname")
	private String fname;

	@Column(name = "member_dateofbirth")
	private LocalDate dob;
    
	//@OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
	@AttributeOverrides(value = { 
			
			@AttributeOverride(column = @Column(name = "current_address"), name ="address"),
			@AttributeOverride(column = @Column(name = "current_city"), name = "city"),
			@AttributeOverride(column = @Column(name = "current_taluk"), name = "taluk"),
			@AttributeOverride(column = @Column(name = "current_district"), name = "district"),
			@AttributeOverride(column = @Column(name = "current_state"), name = "state"),
			@AttributeOverride(column = @Column(name = "current_pincode"), name = "pincode")
			})
	@Embedded
	private Address currentAddress;
	
	
	@AttributeOverrides(value = { 
		
			@AttributeOverride(column = @Column(name = "permanent_address"), name = "address"),
			@AttributeOverride(column = @Column(name = "permanent_city"), name = "city"),
			@AttributeOverride(column = @Column(name = "permanent_taluk"), name = "taluk"),
			@AttributeOverride(column = @Column(name = "permanent_district"), name = "district"),
			@AttributeOverride(column = @Column(name = "permanent_state"), name = "state"),
			@AttributeOverride(column = @Column(name = "permanent_pincode"), name = "pincode")
			})
	@Embedded
	private Address permanentAddress;

	
    
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private MemberDetails details;
	

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private MemberPayment payment;
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
	
	public MemberDetails getDetails() {
		return details;
	}

	public void setDetails(MemberDetails details) {
		this.details = details;
	}

	public String getAppNo() {
		return appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public LocalDate getDate() {
		return dob;
	}

	public void setDate(LocalDate date) {
		this.dob = date;
	}

	public MemberPayment getPayment() {
		return payment;
	}

	public void setPayment(MemberPayment payment) {
		this.payment = payment;
	}

	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	
	@Override
	public String toString() {
		return "Member [appNo=" + appNo + ", MemberId=" + memberId + ", Type=" + type + ", title=" + title + ", name="
				+ name + ", fname=" + fname + ", date=" +dob + ", currentAddress=" + currentAddress + ", details="
				+ details + ", payment=" + payment + "]";
	}

	

	

	

	

	
	

}
