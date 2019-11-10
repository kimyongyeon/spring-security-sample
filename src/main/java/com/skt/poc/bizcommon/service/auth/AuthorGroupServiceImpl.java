package com.skt.poc.bizcommon.service.auth;

import com.skt.poc.bizcommon.mapper.auth.AuthorGroupMapper;
import com.skt.poc.bizcommon.model.auth.AuthorGroup;
import com.skt.poc.bizcommon.model.auth.AuthorGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 권한그룹에 관한 ServiceImpl 클래스를 정의한다.
 */

@Service("egovAuthorGroupService")
public class AuthorGroupServiceImpl implements AuthorGroupService {
	
	@Autowired
	private AuthorGroupMapper authorGroupMapper;


	/**
	 * 그룹별 할당된 권한 목록 조회
	 * @param authorGroupVO AuthorGroupVO
	 * @return List<AuthorGroupVO>
	 * @exception Exception
	 */
	public List<AuthorGroupVO> selectAuthorGroupList(AuthorGroupVO authorGroupVO) throws Exception{
		return authorGroupMapper.selectAuthorGroupList(authorGroupVO);
	}
	
	/**
	 * 그룹에 권한정보를 할당하여 데이터베이스에 등록
	 * @param authorGroup AuthorGroup
	 * @exception Exception
	 */
	public void insertAuthorGroup(AuthorGroup authorGroup) throws Exception{
		authorGroupMapper.insertAuthorGroup(authorGroup);
	}
	
	/**
	 * 화면에 조회된 그룹권한정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
	 * @param authorGroup AuthorGroup
	 * @exception Exception
	 */
	public void updateAuthorGroup(AuthorGroup authorGroup) throws Exception{
		authorGroupMapper.updateAuthorGroup(authorGroup);
	}

	/**
	 * 그룹별 할당된 시스템 메뉴 접근권한을 삭제
	 * @param authorGroup AuthorGroup
	 * @exception Exception
	 */
	public void deleteAuthorGroup(AuthorGroup authorGroup) throws Exception {
		authorGroupMapper.deleteAuthorGroup(authorGroup);
	}
	
    /**
	 * 목록조회 카운트를 반환한다
	 * @param authorGroupVO AuthorGroupVO
	 * @return int
	 * @exception Exception
	 */
	public int selectAuthorGroupListTotCnt(AuthorGroupVO authorGroupVO) throws Exception {
		return authorGroupMapper.selectAuthorGroupListTotCnt(authorGroupVO);
    }
	
}