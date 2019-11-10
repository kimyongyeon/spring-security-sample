package com.skt.poc.bizcommon.mapper.code;

import com.skt.poc.bizcommon.model.code.CmmnClCode;
import com.skt.poc.bizcommon.model.code.CmmnClCodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
*
* 공통분류코드에 대한 데이터 접근 클래스를 정의한다
*/
@Component
@Mapper
public interface CmmnClCodeManageMapper {
	
	   /**
		 * 공통분류코드 총 갯수를 조회한다.
	     * @param searchVO
	     * @return int(공통분류코드 총 갯수)
	     */
	    public int selectCmmnClCodeListTotCnt(CmmnClCodeVO searchVO) throws Exception ;
	    
	    /**
		 * 공통분류코드 목록을 조회한다.
	     * @param searchVO
	     * @return List(공통분류코드 목록)
	     * @throws Exception
	     */
	    public List<CmmnClCodeVO> selectCmmnClCodeList(CmmnClCodeVO searchVO) throws Exception ;
	    
	    /**
		 * 공통분류코드 상세항목을 조회한다.
		 * @param cmmnClCode
		 * @return CmmnClCode(공통분류코드)
		 */
		public CmmnClCode selectCmmnClCodeDetail(CmmnClCode cmmnClCode) throws Exception ;
		
		/**
		 * 공통분류코드를 등록한다.
		 * @param cmmnClCodeVO
		 * @throws Exception
		 */
		public void insertCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception;

		/**
		 * 공통분류코드를 삭제한다.
		 * @param cmmnClCodeVO
		 * @throws Exception
		 */
		public void deleteCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception ;
		
		/**
		 * 공통분류코드를 수정한다.
		 * @param cmmnClCodeVO
		 * @throws Exception
		 */
		public void updateCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception;

}
