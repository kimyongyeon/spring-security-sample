package com.skt.poc.bizcommon.model.auth;

import java.util.List;

/**
 * 권한그룹에 대한 Vo 클래스를 정의한다.
 */

public class AuthorGroupVO extends AuthorGroup {

	private static final long serialVersionUID = 1L;

	List <AuthorGroupVO> authorGroupList;

	/**
	 * authorGroupList attribute 를 리턴한다.
	 * @return List<AuthorGroupVO>
	 */
	public List<AuthorGroupVO> getAuthorGroupList() {
		return authorGroupList;
	}
	/**
	 * authorGroupList attribute 값을 설정한다.
	 * @param authorGroupList List<AuthorGroupVO> 
	 */
	public void setAuthorGroupList(List<AuthorGroupVO> authorGroupList) {
		this.authorGroupList = authorGroupList;
	}
	

}