package com.KRJS.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KRJS.DAO.MemberDAO;
import com.KRJS.model.Address;
import com.KRJS.model.Member;
import com.KRJS.model.MemberDetails;
import com.KRJS.model.MemberPayment;

public class MemberTest {

	private static AnnotationConfigApplicationContext context;
	private static MemberDAO memberDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.KRJS");
		context.refresh();
		memberDAO = (MemberDAO) context.getBean("memberdao");
	}

/*	@Test
	public void insertMemberTest() {

		Member m = new Member();
		m.setName("revanth");
		m.setFname("sreenu");
		m.setTitle("mr");
		m.setMemberId("Mem02");
		m.setDate(new Date());

		Address current = new Address();
		current.setAddress("25/10 1st main");
		current.setCity("indiranagar");
		current.setState("karnataka");
		current.setTaluk("bangalore");
		current.setDistrict("Bangalore");
		current.setPincode("560057");

		MemberDetails details = new MemberDetails();
		details.setOccupation("farmer");
		details.setMaritalStatus(true);
		details.setNoc(0);
		details.setVemanaVani(true);
		//details.setMember(m);
		details.setQualification("degree");

		MemberPayment payment = new MemberPayment();
		payment.setFeePaid(10000);
		payment.setRefNo("ref48943");
		payment.setMop("online");
		payment.setApplicationDate(new Date());
		//payment.setMember(m);
		
		m.setCurrentAddress(current);
		m.setDetails(details);
		m.setPayment(payment);
		
		assertEquals(true,memberDAO.insertMember(m));
*/
	}

