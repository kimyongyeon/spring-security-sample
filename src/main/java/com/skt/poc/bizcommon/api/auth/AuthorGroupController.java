package com.skt.poc.bizcommon.api.auth;


import com.skt.poc.bizcommon.model.auth.AuthorGroup;
import com.skt.poc.bizcommon.model.auth.AuthorGroupVO;
import com.skt.poc.bizcommon.model.auth.AuthorManageVO;
import com.skt.poc.bizcommon.service.auth.AuthorGroupService;
import com.skt.poc.bizcommon.service.auth.AuthorManageService;
import com.skt.poc.bizcommon.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 권한그룹에 관한 controller 클래스를 정의한다.
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/auth"})
public class AuthorGroupController {

    
	@Autowired
    private AuthorGroupService authorGroupService;
	
	@Autowired
    private AuthorManageService authorManageService;
	
	/**
	 * 그룹별 할당된 권한 목록 조회
	 * @param authorGroupVO AuthorGroupVO
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 * 
	 * @deprecated
	 * => TODO
	 * 	- [전자정부 기반] 쿼리에, COMTNGNRLMBER[일반회원], COMTNENTRPRSMBER[기업회원], COMTNEMPLYRINFO[업무사용자정보] 테이블을 참고하지만, 해당 테이블 사용 안함.
	 *  - 화면 및 테이블 설계에 맞게 변경 필요
	 *
	 */
	@GetMapping(value = {"/auth-group"})
	public Map<String, Object> selectAuthorGroupList(@ModelAttribute("authorGroupVO") AuthorGroupVO authorGroupVO,
			                            @ModelAttribute("authorManageVO") AuthorManageVO authorManageVO,
			                             ModelMap model) throws Exception {

		Map<String, Object> retMap = new HashMap<String, Object>();
		List<AuthorGroupVO> authGroupList = authorGroupService.selectAuthorGroupList(authorGroupVO);
		List<AuthorManageVO> authorManageList = authorManageService.selectAuthorAllList(authorManageVO);
		retMap.put("authorGroupList", authGroupList);
		retMap.put("authorManageList", authorManageList);
		
		return retMap;
		
	}

	/**
	 * 그룹에 권한정보를 할당하여 데이터베이스에 등록
	 * @param userIds String
	 * @param authorCodes String
	 * @param regYns String
	 * @param authorGroup AuthorGroup
	 * @return String
	 * @exception Exception
	 */
	@PostMapping(value = {"/auth-group"})
	public ResponseEntity<Object> insertAuthorGroup(@RequestParam("userIds") String userIds,
                                                   @RequestParam("authorCodes") String authorCodes,
                                                   @RequestParam("regYns") String regYns,
                                                   @RequestParam("mberTyCodes") String mberTyCodes,// 2011.08.04 수정 부분
                                                   @ModelAttribute("authorGroup") AuthorGroup authorGroup,
                                                   ModelMap model) throws Exception {
		
    	String [] strUserIds = userIds.split(";");
    	String [] strAuthorCodes = authorCodes.split(";");
    	String [] strRegYns = regYns.split(";");
    	String [] strMberTyCodes = mberTyCodes.split(";");// 2011.08.04 수정 부분
    	
    	for(int i=0; i<strUserIds.length;i++) {
    		authorGroup.setUniqId(strUserIds[i]);
    		authorGroup.setAuthorCode(strAuthorCodes[i]);
    		authorGroup.setMberTyCode(strMberTyCodes[i]);// 2011.08.04 수정 부분
    		if(strRegYns[i].equals("N"))
    		    authorGroupService.insertAuthorGroup(authorGroup);
    		else 
    		    authorGroupService.updateAuthorGroup(authorGroup);
    	}

    	return ReturnUtil.returnOk();
	}

	/**
	 * 그룹별 할당된 시스템 메뉴 접근권한을 삭제
	 * @param userIds String
	 * @param authorGroup AuthorGroup
	 * @return String
	 * @exception Exception
	 */ 
	@DeleteMapping(value = {"/auth-group"})
	public ResponseEntity<Object> deleteAuthorGroup(@RequestParam("userIds") String userIds,
                                                   @ModelAttribute("authorGroup") AuthorGroup authorGroup,
                                                   ModelMap model) throws Exception {
		
    	String [] strUserIds = userIds.split(";");
    	for(int i=0; i<strUserIds.length;i++) {
    		authorGroup.setUniqId(strUserIds[i]);
    		authorGroupService.deleteAuthorGroup(authorGroup);
    	}
    	
    	return ReturnUtil.returnOk();
	}

}