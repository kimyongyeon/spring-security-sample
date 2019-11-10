package com.skt.poc.bizcommon.service.code;

import com.skt.poc.bizcommon.mapper.code.CmmnCodeManageMapper;
import com.skt.poc.bizcommon.model.code.CmmnCode;
import com.skt.poc.bizcommon.model.code.CmmnCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* 공통코드에 대한 서비스 구현클래스를 정의한다

*/

@Service("CmmnCodeManageService")
public class CcmCmmnCodeManageServiceImpl implements CcmCmmnCodeManageService{

    @Autowired
	private CmmnCodeManageMapper cmmCodeMapper;
    
	/**
	 * 공통코드 총 갯수를 조회한다.
	 */
	@Override
	public int selectCmmnCodeListTotCnt(CmmnCodeVO searchVO) throws Exception {
        return cmmCodeMapper.selectCmmnCodeListTotCnt(searchVO);
	}

	/**
	 * 공통코드 목록을 조회한다.
	 */
	@Override
	public List<?> selectCmmnCodeList(CmmnCodeVO searchVO) throws Exception {
		return cmmCodeMapper.selectCmmnCodeList(searchVO);
	}

	/**
	 * 공통코드 상세항목을 조회한다.
	 */
	@Override
	public CmmnCodeVO selectCmmnCodeDetail(CmmnCodeVO cmmnCodeVO) throws Exception{
		CmmnCodeVO ret = cmmCodeMapper.selectCmmnCodeDetail(cmmnCodeVO);
    	return ret;
	}

	/**
	 * 공통코드를 수정한다.
	 */
	@Override
	public void updateCmmnCode(CmmnCodeVO cmmnCodeVO) throws Exception {
		cmmCodeMapper.updateCmmnCode(cmmnCodeVO);
	}

	/**
	 * 공통코드를 등록한다.
	 */
	@Override
	public void insertCmmnCode(CmmnCode cmmnCode) throws Exception {
		cmmCodeMapper.insertCmmnCode(cmmnCode);
		
	}

	/**
	 * 공통코드를 삭제한다.
	 */
	@Override
	public void deleteCmmnCode(CmmnCode cmmnCode) throws Exception {
		cmmCodeMapper.deleteCmmnCode(cmmnCode);
	}

}
