package com.skt.poc.bizcommon.service.code;

import com.skt.poc.bizcommon.model.code.CmmnClCode;
import com.skt.poc.bizcommon.model.code.CmmnClCodeVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * 공통분류코드에 관한 서비스 인터페이스 클래스를 정의한다
 */
@Transactional
public interface CcmCmmnClCodeManageService {

	/**
	 * 공통분류코드 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 * @return int(공통분류코드 총 갯수)
	 */
	int selectCmmnClCodeListTotCnt(CmmnClCodeVO searchVO) throws Exception;

	/**
	 * 공통분류코드 목록을 조회한다.
	 * @param searchVO
	 * @return List(공통분류코드 목록)
	 * @throws Exception
	 */
	List<CmmnClCodeVO> selectCmmnClCodeList(CmmnClCodeVO searchVO) throws Exception;

	 /**
	  *  공통분류코드 상세항목을 조회한다.
	  * @param cmmnClCode
	  * @return CmmnClCode(공통분류코드)
	  *  @throws Exception
	  */
	CmmnClCode selectCmmnClCodeDetail(CmmnClCodeVO cmmnClCodeVO) throws Exception;

	/**
	 * 공통분류코드를 등록한다.
	 * @param cmmnClCodeVO
	 * @throws Exception
	 */
	void insertCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception;
	
	/**
	 * 공통분류코드를 삭제한다.
	 * @param cmmnClCodeVO
	 * @throws Exception
	 */
	void deleteCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception;
	
	/**
	 * 공통분류코드를 수정한다.
	 * @param cmmnClCodeVO
	 * @throws Exception
	 */
	void updateCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception;

}
