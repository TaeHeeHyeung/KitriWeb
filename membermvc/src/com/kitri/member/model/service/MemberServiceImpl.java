package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImple;

import sun.security.jca.GetInstance;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl memberServiceImpl;

	static {
		memberServiceImpl = new MemberServiceImpl();
	}

	private MemberServiceImpl() {
	}

	public static MemberServiceImpl GetInstance() {
		return memberServiceImpl;
	}

	@Override
	public String idCheck(String id) {
		int cnt = MemberDaoImple.getMemberDaoImple().idCheck(id);
		System.out.println("cnt:" + cnt);
		String result = "";
		result += "<idcount>";
		result += "<cnt>" + cnt + "</cnt>";
		result += "</idcount>";
		return result;
	}

	@Override
	public String zipSearch(String doro) {
		String result = "";

		List<ZipcodeDto> list = MemberDaoImple.getMemberDaoImple().zipSearch(doro);

		result += "<ziplist>\n";
		for (ZipcodeDto zipDto : list) {
			result += "<zip>\n";
			result += "<zipcode>" + zipDto.getZipcode() + "</zipcode>\n";
			result += "<address><![CDATA[" + zipDto.getSido() + " " + zipDto.getGugun() + " " + zipDto.getUpmyon() + " "
					+ zipDto.getDoro() + " " + zipDto.getSigugun_building_name() + "]]></address>\n";
			result += "</zip>\n";
		}
		result += "</ziplist>";
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto detailDto) {
		return MemberDaoImple.getMemberDaoImple().registerMember(detailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return MemberDaoImple.getMemberDaoImple().loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(int memberid) {
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto detailDto) {
		return 0;
	}

	@Override
	public int deleteMember(int memberid) {
		return 0;
	}

}
