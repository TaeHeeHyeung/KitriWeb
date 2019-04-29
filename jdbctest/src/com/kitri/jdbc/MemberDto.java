package com.kitri.jdbc;

import java.sql.Date;

import javax.xml.crypto.Data;

public class MemberDto {
	private int no;
	private String name;
	private String id;
	private Date joindate;

	public MemberDto(int no, String name, String id, Date joindate) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.joindate = joindate;
	}

	public MemberDto() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {

		java.util.Date curDate = new Date(System.currentTimeMillis());
		System.out.println("오늘 날짜:" + curDate);


		return "회원정보 [no=" + no + ", name=" + name + ", id=" + id + ", joindate=" + joindate.toString() + "]";
	}

}
