package com.skt.poc.bizcommon.mapper.auth;

import com.skt.poc.bizcommon.model.auth.AuthorGroup;
import com.skt.poc.bizcommon.model.auth.AuthorGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 권한그룹에 대한 Mapper 클래스를 정의한다.
 */

@Component
@Mapper
public interface AuthorGroupMapper {
	
	/**
	 * 그룹별 할당된 권한 목록 조회
	 * @param authorGroupVO AuthorGroupVO
	 * @return List<AuthorGroupVO>
	 * @exception Exception
	 */
	public List<AuthorGroupVO> selectAuthorGroupList(AuthorGroupVO authorGroupVO) throws Exception ;
	
	/**
	 * 그룹에 권한정보를 할당하여 데이터베이스에 등록
	 * @param authorGroup AuthorGroup
	 * @exception Exception
	 */
	public void insertAuthorGroup(AuthorGroup authorGroup) throws Exception ;
	
	/**
	 * 화면에 조회된 그룹권한정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
	 * @param authorGroup AuthorGroup
	 * @exception Exception
	 */
	public void updateAuthorGroup(AuthorGroup authorGroup) throws Exception ;
	
	/**
	 * 그룹별 할당된 시스템 메뉴 접근권한을 삭제
	 * @param authorGroup AuthorGroup
	 * @exception Exception
	 */
	public void deleteAuthorGroup(AuthorGroup authorGroup) throws Exception ;

    /**
	 * 그룹권한목록 총 갯수를 조회한다.
	 * @param authorGroupVO AuthorGroupVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorGroupListTotCnt(AuthorGroupVO authorGroupVO) throws Exception ;
}