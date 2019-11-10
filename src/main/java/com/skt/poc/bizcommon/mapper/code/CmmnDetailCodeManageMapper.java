package com.skt.poc.bizcommon.mapper.code;

import com.skt.poc.bizcommon.model.code.CmmnDetailCode;
import com.skt.poc.bizcommon.model.code.CmmnDetailCodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
*
* 공통상세코드에 대한 데이터 접근 클래스를 정의한다
*/

@Component
@Mapper
public interface CmmnDetailCodeManageMapper {

    /**
	 * 공통상세코드 총 갯수를 조회한다.
     * @param searchVO
     * @return int(공통상세코드 총 갯수)
     */
    public int selectCmmnDetailCodeListTotCnt(CmmnDetailCodeVO searchVO) throws Exception ;
    
    /**
	 * 공통상세코드 목록을 조회한다.
     * @param searchVO
     * @return List(공통상세코드 목록)
     * @throws Exception
     */
    public List<?> selectCmmnDetailCodeList(CmmnDetailCodeVO searchVO) throws Exception ;

	/**
	 * 공통상세코드 상세항목을 조회한다.
	 * @param cmmnDetailCodeVO
	 * @return CmmnDetailCodeVO(공통상세코드)
	 */
	public CmmnDetailCode selectCmmnDetailCodeDetail(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;
	
	/**
	 * 공통상세코드를 삭제한다.
	 * @param cmmnDetailCodeVO
	 * @throws Exception
	 */
	public void deleteCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;

	/**
	 * 공통상세코드를 등록한다.
	 * @param cmmnDetailCodeVO
	 * @throws Exception
	 */
	public void insertCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;

	/**
	 * 공통상세코드를 수정한다.
	 * @param cmmnDetailCodeVO
	 * @throws Exception
	 */
	public void updateCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception;
    
}
