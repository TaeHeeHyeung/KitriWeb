package com.kitri.admin.model.service;

import java.util.*;

import com.kitri.admin.model.dao.AdminDaoImple;
import com.kitri.admin.model.service.AdminService;
import com.kitri.member.model.MemberDetailDto;

public class AdminServiceImple implements AdminService {
	private static AdminServiceImple adminServiceImple;

	static {
		adminServiceImple = new AdminServiceImple();
	}

	private AdminServiceImple() {
	}

	public static AdminServiceImple getAdminServiceImple() {
		return adminServiceImple;
	}

	@Override
	public String getMemberList(String key, String word) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		List<MemberDetailDto> list = AdminDaoImple.getAdminDao().getMemberList(map);

		String result = "<?xml version =\"1.0\" encoding=\"utf-8\"?>\n";
		result += "<memberlist>\n";
		for (MemberDetailDto memberDetailDto : list) {
			result += "	<member>\n";
			result += "		<id>"+memberDetailDto.getId()+"</id>\n";
			result += "		<name>"+memberDetailDto.getName()+"</name>\n";
			result += "		<email>"+memberDetailDto.getEmailid()+"@"+memberDetailDto.getEmaildomain()+"</email>\n";
			result += "		<tel>"+memberDetailDto.getTel1()+"-"+memberDetailDto.getTel1()+"-"+ "</tel>\n";
			result += "		<address><![CDATA["+memberDetailDto.getAddress()+" "+ memberDetailDto.getAddressDetail()+"]]></address>\n";
			result += "		<joindate>"+memberDetailDto.getJoindate()+"</joindate>\n";
			result += "	</member>\n";
		}
		result += "</memberlist>\n";
		
		System.out.println(result);
		return result;
	}

}
