package com.KRJS.DAO;

import java.util.List;

import com.KRJS.model.Member;
import com.KRJS.model.MemberDetails;

public interface MemberDAO {
	
	void insertMember(Member mem);
	Member getMember(String memberId);
	void updateMember(String memberId);
	void deleteMember(String memId);
	List<Member> selectAll();
	List<Member> searchByDistrict(String district);
	List<Member> searchByTaluk(String taluk);
	List<Member> searchByPincode(int pincode);
	List<MemberDetails> searchByMobileNo(long phone);
	Member searchByApplicatioNo(int appno);

}
