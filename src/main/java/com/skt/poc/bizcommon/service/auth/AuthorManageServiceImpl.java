package com.skt.poc.bizcommon.service.auth;

import com.skt.poc.bizcommon.mapper.auth.AuthorManageMapper;
import com.skt.poc.bizcommon.model.auth.AuthorManage;
import com.skt.poc.bizcommon.model.auth.AuthorManageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 권한관리에 관한 ServiceImpl 클래스를 정의한다.

 *
 * </pre>
 */

@Service("AuthorManageService")
public class AuthorManageServiceImpl implements AuthorManageService {
    
	@Autowired
	private AuthorManageMapper authorMapper;

    /**
	 * 권한 목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
    public List<AuthorManageVO> selectAuthorList(AuthorManageVO authorManageVO) throws Exception {
        return authorMapper.selectAuthorList(authorManageVO);
    }
    
	/**
	 * 권한을 등록한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void insertAuthor(AuthorManage authorManage) throws Exception {
    	authorMapper.insertAuthor(authorManage);
    }

    /**
	 * 권한을 수정한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void updateAuthor(AuthorManage authorManage) throws Exception {
    	authorMapper.updateAuthor(authorManage);
    }

    /**
	 * 권한을 삭제한다.
	 * @param authorManage AuthorManage
	 * @exception Exception
	 */
    public void deleteAuthor(AuthorManage authorManage) throws Exception {
    	authorMapper.deleteAuthor(authorManage);
    }

    /**
	 * 권한을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return AuthorManageVO
	 * @exception Exception
	 */
    public AuthorManageVO selectAuthor(AuthorManageVO authorManageVO) throws Exception {
    	AuthorManageVO resultVO = authorMapper.selectAuthor(authorManageVO);
        if (resultVO == null)
            throw new Exception("info.nodata.msg");	//TODO messaging 처리 필요. info.nodata.msg <= 전자정부.
        return resultVO;
    }

    /**
	 * 권한 목록 카운트를 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return int
	 * @exception Exception
	 */
    public int selectAuthorListTotCnt(AuthorManageVO authorManageVO) throws Exception {
        return authorMapper.selectAuthorListTotCnt(authorManageVO);
    }    
    
    /**
	 * 모든 권한목록을 조회한다.
	 * @param authorManageVO AuthorManageVO
	 * @return List<AuthorManageVO>
	 * @exception Exception
	 */
	public List<AuthorManageVO> selectAuthorAllList(AuthorManageVO authorManageVO) throws Exception {
    	return authorMapper.selectAuthorAllList(authorManageVO);
    }      
}
