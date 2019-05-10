package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;

public interface MemberService {
	//db는 boolean이 없다
	String idCheck(String id);
	String zipSearch(String zip);
	int registerMember(MemberDetailDto detailDto);
	MemberDto loginMember(String id, String pass);
	
	MemberDetailDto getMember(int memberid);
	int modifyMember(MemberDetailDto detailDto);
	int deleteMember(int memberid);
	

}
