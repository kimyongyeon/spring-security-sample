package com.skt.poc.bizcommon.mapper.auth;

import com.skt.poc.bizcommon.model.auth.GroupManage;
import com.skt.poc.bizcommon.model.auth.GroupManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 그룹관리에 대한 DAO 클래스를 정의한다.
 */

@Component
@Mapper
public interface GroupManageMapper {

	/**
	 * 검색조건에 따른 그룹정보를 조회
	 * @param groupManageVO GroupManageVO
	 * @return GroupManageVO
	 * @exception Exception
	 */
	public GroupManageVO selectGroup(GroupManageVO groupManageVO) throws Exception ;

	/**
	 * 시스템사용 목적별 그룹 목록 조회
	 * @param groupManageVO GroupManageVO
	 * @return GroupManageVO
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GroupManageVO> selectGroupList(GroupManageVO groupManageVO) throws Exception ;

	/**
	 * 그룹 기본정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장
	 * @param groupManage GroupManage
	 * @exception Exception
	 */
	public void insertGroup(GroupManage groupManage) throws Exception ;

	/**
	 * 화면에 조회된 그룹의 기본정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
	 * @param groupManage GroupManage
	 * @exception Exception
	 */
	public void updateGroup(GroupManage groupManage) throws Exception ;
	
	/**
	 * 불필요한 그룹정보를 화면에 조회하여 데이터베이스에서 삭제
	 * @param groupManage GroupManage
	 * @exception Exception
	 */
	public void deleteGroup(GroupManage groupManage) throws Exception ;

    /**
	 * 롤목록 총 갯수를 조회한다.
	 * @param groupManageVO GroupManageVO
	 * @return int
	 * @exception Exception
	 */
    public int selectGroupListTotCnt(GroupManageVO groupManageVO) throws Exception ;
}