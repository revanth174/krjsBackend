package com.KRJS.client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KRJS.DAO.MemberDAO;
import com.KRJS.model.Address;
import com.KRJS.model.Member;
import com.KRJS.model.MemberDetails;
import com.KRJS.model.MemberPayment;

public class Client {
	
	
	
	
	private static AnnotationConfigApplicationContext context;

	public static void main(String args[]) {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.KRJS");
		context.refresh();
		Random ran = new Random();
		MemberDAO d = (MemberDAO)context.getBean("memberdao");
		//for(int i=1;i<10;i++) {
			
			String memid = "M"+Integer.toString(ran.nextInt(100000));
			String app = "A" + memid;
			Member m = new Member();
			m.setAppNo(app);
			m.setMemberId(memid);
			m.setName("veena");
			m.setFname("sreenu");
			m.setTitle("mrs");
			int yyyy = 1996;
			int mm = 10;
			int date = 30;
			//year-month-date
			m.setDate(LocalDate.of(yyyy,mm, date));
		
		
		
		
			String city[] = {"Bangalore","Andhra Pradesh","chennai","delhi","mumbai"}; 
			int pincode[] = {560068,500068,500001,560075,520054,560012};
			
			
	
			Address current = new Address();
			current.setAddress("25/10 1st main");
			current.setCity("kormangla");
			current.setState("karnataka");
			current.setTaluk("bangalore");
			current.setDistrict(city[new Random().nextInt(5)]);
			current.setPincode(pincode[new Random().nextInt(5)]);
			
	
			MemberDetails details = new MemberDetails();
			details.setOccupation("farmer");
			details.setMaritalStatus(true);
			details.setNoc(0);
			details.setVemanaVani(true);
			details.setMember(m);
			
			details.setQualification("degree");
	
			MemberPayment payment = new MemberPayment();
			
			payment.setFeePaid(BigDecimal.valueOf(1000.0));
			String ref = "ref" + Integer.toString(new Random().nextInt(10000));
			payment.setRefNo("ref8325");
			payment.setMop("online");
			payment.setApplicationDate(new Date());
			payment.setMember(m);
			
			
			m.setCurrentAddress(current);
			m.setDetails(details);
			m.setPayment(payment);
			System.out.println("hello");
			
	       
	       
	        
	        d.insertMember(m);
			//}
      /* Member m = (Member)d.getMember("mem090");
        System.out.println("member details are: "+m);
        System.out.println("member address : "+m.getCurrentAddress());
        System.out.println("member personal details : " + m.getDetails());*/
        
        
        //d.deleteMember("mem080");
       // d.selectAll();
       /* List<Member> list = d.searchByPincode(560011);
        for(Member m : list)
        {
        	System.out.println(m);
        }
       // d.updateMember("mem090");
*/	}

}
