package com.skt.poc.bizcommon.service.code;

import com.skt.poc.bizcommon.mapper.code.CmmnClCodeManageMapper;
import com.skt.poc.bizcommon.model.code.CmmnClCode;
import com.skt.poc.bizcommon.model.code.CmmnClCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* 공통분류코드에 대한 서비스 구현클래스를 정의한다
*/
@Service("CmmnClCodeManageService")
public class CcmCmmnClCodeManageServiceImpl implements CcmCmmnClCodeManageService {
	
    @Autowired
	private CmmnClCodeManageMapper cmmnClCodeManageMapper;
    
	
	/**
	 * 공통분류코드 총 갯수를 조회한다.
	 */
	@Override
	public int selectCmmnClCodeListTotCnt(CmmnClCodeVO searchVO) throws Exception {
        return cmmnClCodeManageMapper.selectCmmnClCodeListTotCnt(searchVO);
	}
	
	/**
	 * 공통분류코드 목록을 조회한다.
	 */
	@Override
	public List<CmmnClCodeVO> selectCmmnClCodeList(CmmnClCodeVO searchVO) throws Exception {
        return cmmnClCodeManageMapper.selectCmmnClCodeList(searchVO);
	}
	
	/**
	 * 공통분류코드 상세항목을 조회한다.
	 */
	@Override
	public CmmnClCode selectCmmnClCodeDetail(CmmnClCodeVO cmmnClCodeVO) throws Exception {
    	CmmnClCode ret = cmmnClCodeManageMapper.selectCmmnClCodeDetail(cmmnClCodeVO);
    	return ret;
	}
	
	/**
	 * 공통분류코드를 등록한다.
	 */
	@Override
	public void insertCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception {
		System.out.println("TEST4 : 등록 Serviceimpl");
    	cmmnClCodeManageMapper.insertCmmnClCode(cmmnClCodeVO);
	}
	
	/**
	 * 공통분류코드를 삭제한다.
	 */
	@Override
	public void deleteCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception {
		cmmnClCodeManageMapper.deleteCmmnClCode(cmmnClCodeVO);
	}
	
	/**
	 * 공통분류코드를 수정한다.
	 */
	@Override
	public void updateCmmnClCode(CmmnClCodeVO cmmnClCodeVO) throws Exception {
		cmmnClCodeManageMapper.updateCmmnClCode(cmmnClCodeVO);
		
	}

}
