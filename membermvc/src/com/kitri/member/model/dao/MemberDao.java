package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.*;

public interface MemberDao {
	int idCheck(String id);
	List<ZipcodeDto> zipSearch(String zip);
	int registerMember(MemberDetailDto detailDto);
	MemberDto loginMember(Map<String,String> map);
	
	MemberDetailDto getMember(int memberid);
	int modifyMember(MemberDetailDto detailDto);
	int deleteMember(int memberid);
}
