package com.skt.poc.bizcommon.service.code;

import com.skt.poc.bizcommon.mapper.code.CmmnDetailCodeManageMapper;
import com.skt.poc.bizcommon.model.code.CmmnDetailCode;
import com.skt.poc.bizcommon.model.code.CmmnDetailCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* 공통상세코드에 대한 서비스 구현클래스를 정의한다

*/
@Service("CmmnDetailCodeManageService")
public class CcmCmmnDetailCodeManageServiceImpl implements CcmCmmnDetailCodeManageService{
	
    
    @Autowired
	private CmmnDetailCodeManageMapper cmmDetailCodeMapper;
    
	/**
	 * 공통상세코드 총 갯수를 조회한다.
	 */
	@Override
	public int selectCmmnDetailCodeListTotCnt(CmmnDetailCodeVO searchVO) throws Exception {
        return cmmDetailCodeMapper.selectCmmnDetailCodeListTotCnt(searchVO);
	}
	
	/**
	 * 공통상세코드 목록을 조회한다.
	 */
	@Override
	public List<?> selectCmmnDetailCodeList(CmmnDetailCodeVO searchVO) throws Exception {
        return cmmDetailCodeMapper.selectCmmnDetailCodeList(searchVO);
	}

	/**
	 * 공통상세코드 상세항목을 조회한다.
	 * @throws Exception 
	 */
	@Override
	public CmmnDetailCode selectCmmnDetailCodeDetail(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception {
		CmmnDetailCode ret = cmmDetailCodeMapper.selectCmmnDetailCodeDetail(cmmnDetailCodeVO);
    	return ret;
	}

	/**
	 * 공통상세코드를 삭제한다.
	 * @throws Exception 
	 */
	@Override
	public void deleteCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception {
		cmmDetailCodeMapper.deleteCmmnDetailCode(cmmnDetailCodeVO);
		
	}

	/**
	 * 공통상세코드를 등록한다.
	 */
	@Override
	public void insertCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception {
		cmmDetailCodeMapper.insertCmmnDetailCode(cmmnDetailCodeVO);
		
	}

	/**
	 * 공통상세코드를 수정한다.
	 */
	@Override
	public void updateCmmnDetailCode(CmmnDetailCodeVO cmmnDetailCodeVO) throws Exception {
		cmmDetailCodeMapper.updateCmmnDetailCode(cmmnDetailCodeVO);
		
	}
	
}
