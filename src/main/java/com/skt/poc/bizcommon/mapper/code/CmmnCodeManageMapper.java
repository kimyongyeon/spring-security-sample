package com.skt.poc.bizcommon.mapper.code;

import com.skt.poc.bizcommon.model.code.CmmnCode;
import com.skt.poc.bizcommon.model.code.CmmnCodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
*
* 공통코드에 대한 데이터 접근 클래스를 정의한다
*/
@Component
@Mapper
public interface CmmnCodeManageMapper {

   /**
	 * 공통코드 총 갯수를 조회한다.
     * @param searchVO
     * @return int(공통코드 총 갯수)
     */
	public int selectCmmnCodeListTotCnt(CmmnCodeVO searchVO) throws Exception;

   /**
	 * 공통코드 목록을 조회한다.
     * @param searchVO
     * @return List(공통코드 목록)
     * @throws Exception
     */
	public List<?> selectCmmnCodeList(CmmnCodeVO searchVO) throws Exception;

	/**
	 * 공통코드 상세항목을 조회한다.
	 * @param cmmnCode
	 * @return CmmnCode(공통코드)
	 */
	public CmmnCodeVO selectCmmnCodeDetail(CmmnCodeVO cmmnCodeVO) throws Exception;

	/**
	 * 공통코드를 수정한다.
	 * @param cmmnCode
	 * @throws Exception
	 */
	public void updateCmmnCode(CmmnCode cmmnCode) throws Exception;

	/**
	 * 공통코드를 등록한다.
	 * @param cmmnCode
	 * @throws Exception
	 */
	public void insertCmmnCode(CmmnCode cmmnCode) throws Exception;

	/**
	 * 공통코드를 삭제한다.
	 * @param cmmnCode
	 * @throws Exception
	 */
	public void deleteCmmnCode(CmmnCode cmmnCode);

}
