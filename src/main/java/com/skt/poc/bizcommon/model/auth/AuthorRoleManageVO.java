package com.skt.poc.bizcommon.model.auth;

import java.util.List;

/**
 * 권한별 롤 관리에 대한 Vo 클래스를 정의한다.
 *
 * </pre>
 */

public class AuthorRoleManageVO extends AuthorRoleManage {

//	private static final long serialVersionUID = 1L;

	List <AuthorRoleManageVO> authorRoleList;
	
	/**
	 * authorRoleList attribute 를 리턴한다.
	 * @return List<AuthorRoleManageVO>
	 */
	public List<AuthorRoleManageVO> getAuthorRoleList() {
		return authorRoleList;
	}

	/**
	 * authorRoleList attribute 값을 설정한다.
	 * @param authorRoleList List<AuthorRoleManageVO> 
	 */
	public void setAuthorRoleList(List<AuthorRoleManageVO> authorRoleList) {
		this.authorRoleList = authorRoleList;
	}



}