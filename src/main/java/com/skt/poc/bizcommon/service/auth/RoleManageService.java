package com.skt.poc.bizcommon.service.auth;

import com.skt.poc.bizcommon.model.auth.RoleManage;
import com.skt.poc.bizcommon.model.auth.RoleManageVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 롤관리에 관한 서비스 인터페이스 클래스를 정의한다.
 */
@Transactional
public interface RoleManageService {

	/**
	 * 등록된 롤 정보 조회
	 * @param roleManageVO RoleManageVO
	 * @return RoleManageVO
	 * @exception Exception
	 */
	public RoleManageVO selectRole(RoleManageVO roleManageVO) throws Exception;

	/**
	 * 등록된 롤 정보 목록 조회
	 * @param roleManageVO RoleManageVO
	 * @return List<RoleManageVO>
	 * @exception Exception
	 */
	public List<RoleManageVO> selectRoleList(RoleManageVO roleManageVO) throws Exception;

	/**
	 * 불필요한 롤정보를 화면에 조회하여 데이터베이스에서 삭제
	 * @param roleManage RoleManage
	 * @exception Exception
	 */
	public void deleteRole(RoleManage roleManage) throws Exception;
	
	/**
	 * 시스템 메뉴에 따른 접근권한, 데이터 입력, 수정, 삭제의 권한 롤을 수정
	 * @param roleManage RoleManage
	 * @exception Exception
	 */
	public void updateRole(RoleManage roleManage) throws Exception;
	
	/**
	 * 시스템 메뉴에 따른 접근권한, 데이터 입력, 수정, 삭제의 권한 롤을 등록
	 * @param roleManage RoleManage
	 * @param roleManageVO RoleManageVO
	 * @return RoleManageVO
	 * @exception Exception
	 */
	public RoleManageVO insertRole(RoleManage roleManage, RoleManageVO roleManageVO) throws Exception;
	
    /**
	 * 목록조회 카운트를 반환한다
	 * @param roleManageVO RoleManageVO
	 * @return int
	 * @exception Exception
	 */
	public int selectRoleListTotCnt(RoleManageVO roleManageVO) throws Exception;
	
	/**
	 * 등록된 모든 롤 정보 목록 조회
	 * @param roleManageVO RoleManageVO
	 * @return List<RoleManageVO>
	 * @exception Exception
	 */
	public List<RoleManageVO> selectRoleAllList(RoleManageVO roleManageVO) throws Exception;

	
}