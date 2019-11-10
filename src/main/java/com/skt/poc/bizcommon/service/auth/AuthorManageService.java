package com.skt.poc.bizcommon.service.auth;

import com.skt.poc.bizcommon.model.auth.AuthorManage;
import com.skt.poc.bizcommon.model.auth.AuthorManageVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 권한관리에 관한 서비스 인터페이스 클래스를 정의한다.
  *
 */
@Transactional
public interface AuthorManageService {
    /**
	 * 모든 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<AuthorManageVO> selectAuthorAllList(AuthorManageVO authorManageVO) throws Exception;
	
	/**
	 * 시스템 사용자중 불필요한 시스템권한정보를 화면에 조회하여 데이터베이스에서 삭제
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
	public void deleteAuthor(AuthorManage authorManage) throws Exception;

	/**
	 * 사용자의 시스테접근권한를 화면에서 입력하여 입력항목의 정합성을 체크하고 데이터베이스에 저장
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
	public void insertAuthor(AuthorManage authorManage) throws Exception;

	/**
	 * 개별사용자에게 할당된 권한 조회
	 * @param authorManageVO AuthorManageVO
	 * @exception Exception
	 */
	public AuthorManageVO selectAuthor(AuthorManageVO authorManageVO) throws Exception;

	/**
	 * 개별사용자에게 할당된 권한리스트 조회
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<AuthorManageVO> selectAuthorList(AuthorManageVO authorManageVO) throws Exception;

	/**
	 * 화면에 조회된 사용자권한정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
 	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
	public void updateAuthor(AuthorManage authorManage) throws Exception;
	
    /**
	 * 목록조회 카운트를 반환한다
	 * @param authorManageVO AuthorManageVO
	 * @return int
	 * @exception Exception
	 */
	public int selectAuthorListTotCnt(AuthorManageVO authorManageVO) throws Exception;
	
}
