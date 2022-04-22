package com.cares.boot3.member;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;

	private MemberFilesVO memberFilesVO;



}