package com.skt.poc.bizcommon.mapper.auth;

import com.skt.poc.bizcommon.model.auth.AuthorRoleManage;
import com.skt.poc.bizcommon.model.auth.AuthorRoleManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 권한별 롤관리에 대한 DAO 클래스를 정의한다.
 * 
 * [참고] 전자정부 egovframework.com.sec.ram.service.impl.AuthorRoleManageDAO.java 참고
 */

@Component
@Mapper
public interface AuthorRoleManageMapper {

	/**
	 * 권한 롤 관계정보를 조회
	 * @param authorRoleManageVO AuthorRoleManageVO
	 * @return AuthorRoleManageVO
	 * @exception Exception
	 */
	public AuthorRoleManageVO selectAuthorRole(AuthorRoleManageVO authorRoleManageVO) throws Exception;

	/**
	 * 권한 롤 관계정보 목록 조회
	 * @param authorRoleManageVO AuthorRoleManageVO
	 * @return List<AuthorRoleManageVO>
	 * @exception Exception
	 */
	public List<AuthorRoleManageVO> selectAuthorRoleList(AuthorRoleManageVO authorRoleManageVO) throws Exception;
	
	/**
	 * 권한 롤 관계정보를 화면에서 입력하여 입력항목의 정합성을 체크하고 데이터베이스에 저장
	 * @param authorRoleManage AuthorRoleManage
	 * @exception Exception
	 */
	public void insertAuthorRole(AuthorRoleManage authorRoleManage) throws Exception;

	/**
	 * 수정된 권한 롤 관계정보를 데이터베이스에 반영
	 * @param authorRoleManage AuthorRoleManage
	 * @exception Exception
	 */
	public void updateAuthorRole(AuthorRoleManage authorRoleManage) throws Exception;

	/**
	 * 권한 롤 관계정보를 화면에 조회하여 데이터베이스에서 삭제
	 * @param authorRoleManage AuthorRoleManage
	 * @exception Exception
	 */
	public void deleteAuthorRole(AuthorRoleManage authorRoleManage) throws Exception;

    /**
	 * 목록조회 카운트를 반환한다
	 * @param authorRoleManageVO AuthorRoleManageVO
	 * @return int
	 * @exception Exception
	 */
	public int selectAuthorRoleListTotCnt(AuthorRoleManageVO authorRoleManageVO) throws Exception;
    
}