package com.skt.poc.bizcommon.service.code;

import com.skt.poc.bizcommon.model.code.CmmnDetailCode;
import com.skt.poc.bizcommon.model.code.CmmnDetailCodeVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
*
* 공통상세코드에 관한 서비스 인터페이스 클래스를 정의한다
*/
@Transactional
public interface CcmCmmnDetailCodeManageService {
	/**
	 * 공통상세코드 총 갯수를 조회한다.
	 * @param searchVO
	 * @return int(공통상세코드 총 갯수)
	 */
	int selectCmmnDetailCodeListTotCnt(CmmnDetailCodeVO searchVO) throws Exception;
	
	/**
	 * 공통상세코드 목록을 조회한다.
	 * @param searchVO
	 * @return List(공통상세코드 목록)
	 * @throws Exception
	 */
	List<?> selectCmmnDetailCodeList(CmmnDetailCodeVO searchVO) throws Exception;

	/**
	 * 공통상세코드 상세항목을 조회한다.
	 * @param cmmnDetailCodeVO
	 * @return CmmnDetailCode(공통상세코드)
	 * @throws Exception
	 */
	CmmnDetailCode selectCmmnDetailCodeDetail(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;

	/**
	 * 공통상세코드를 삭제한다.
	 * @param cmmnDetailCodeVO
	 * @throws Exception
	 */
	void deleteCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;

	/**
	 * 공통상세코드를 등록한다.
	 * @param cmmnDetailCodeVO
	 * @throws Exception
	 */
	void insertCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;

	/**
	 * 공통상세코드를 수정한다.
	 * @param cmmnDetailCodeVO
	 * @throws Exception
	 */
	void updateCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;
	    
	    

}
