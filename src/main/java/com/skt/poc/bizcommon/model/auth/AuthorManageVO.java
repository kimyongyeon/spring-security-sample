package com.skt.poc.bizcommon.model.auth;

import java.util.List;

/**
 * 권한관리에 대한 Vo 클래스를 정의한다.
 */

public class AuthorManageVO extends AuthorManage {

//	private static final long serialVersionUID = 1L;

	List <AuthorManageVO> authorManageList;


	/**
	 * authorManageList attribute 를 리턴한다.
	 * @return List<AuthorManageVO>
	 */
	public List<AuthorManageVO> getAuthorManageList() {
		return authorManageList;
	}

	/**
	 * authorManageList attribute 값을 설정한다.
	 * @param authorManageList List<AuthorManageVO> 
	 */
	public void setAuthorManageList(List<AuthorManageVO> authorManageList) {
		this.authorManageList = authorManageList;
	}



}