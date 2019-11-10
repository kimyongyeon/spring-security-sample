package com.skt.poc.bizcommon.api.auth;

import com.skt.poc.bizcommon.model.auth.AuthorRoleManage;
import com.skt.poc.bizcommon.model.auth.AuthorRoleManageVO;
import com.skt.poc.bizcommon.service.auth.AuthorRoleManageService;
import com.skt.poc.bizcommon.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 권한별 롤관리에 관한 controller 클래스를 정의한다.
 * 
 * [참고] 전자정부 EgovAuthorRoleController.java Class 참고
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/auth"})
public class AuthorRoleManageController {

    @Autowired
    private AuthorRoleManageService authRoleService;
    
    /**
	 * 권한별 할당된 롤 목록 조회
	 * 
	 * @param authorRoleManageVO AuthorRoleManageVO
	 * @return String
	 * @exception Exception
	 */
    @GetMapping(value = {"/auth-role"})
	public List<AuthorRoleManageVO> selectAuthorRoleList(@ModelAttribute("authorRoleManageVO") AuthorRoleManageVO authorRoleManageVO,
			                            ModelMap model) throws Exception {

    	return authRoleService.selectAuthorRoleList(authorRoleManageVO);
    	
	}
    
    /**
	 * 권한정보에 롤을 할당하여 데이터베이스에 등록
	 * 
	 * TODO 화면을 어떤식으로 구성할 것인가에 따라서 구현 방법 달라짐.
	 * 
	 * @param authorCode String
	 * @param roleCodes String
	 * @param regYns String
	 * @param authorRoleManage AuthorRoleManage
	 * @return String
	 * @exception Exception
	 */
    @Deprecated
    @PostMapping(value = {"/auth-role-deprecated"})
	public ResponseEntity<Object> insertAuthorRole_Original(@RequestParam("authorCode") String authorCode,
                                                           @RequestParam("roleCodes") String roleCodes,
                                                           @RequestParam("regYns") String regYns,
                                                           @RequestParam Map<?, ?> commandMap,
                                                           @ModelAttribute("authorRoleManage") AuthorRoleManage authorRoleManage,
                                                           ModelMap model) throws Exception {
		
		String [] strRoleCodes = roleCodes.split(";"); String [] strRegYns =
		regYns.split(";");
		  
		authorRoleManage.setRoleCode(authorCode);
		  
			for(int i=0; i<strRoleCodes.length;i++) {
    		
    		authorRoleManage.setRoleCode(strRoleCodes[i]);
    		authorRoleManage.setRegYn(strRegYns[i]);
    		if(strRegYns[i].equals("Y")){
    			authRoleService.deleteAuthorRole(authorRoleManage);//2011.09.07
    			authRoleService.insertAuthorRole(authorRoleManage);
    		}else {
    			authRoleService.deleteAuthorRole(authorRoleManage);
    		}
    	}
		
		authRoleService.insertAuthorRole(authorRoleManage);
		
		return ReturnUtil.returnOk();

	}
    
    /**
	 * 권한정보에 롤을 할당하여 데이터베이스에 등록
	 * 
	 * TODO 화면을 어떤식으로 구성할 것인가에 따라서 구현 방법 달라짐.
	 * 
	 * @param authorCode String
	 * @param roleCodes String
	 * @param regYns String
	 * @param authorRoleManage AuthorRoleManage
	 * @return String
	 * @exception Exception
	 */
    @PostMapping(value = {"/auth-role"})
	public ResponseEntity<Object> insertAuthorRole(@ModelAttribute("authorRoleManageVO") AuthorRoleManageVO authorRoleManageVO,
                                                  ModelMap model) throws Exception {
		
		authRoleService.insertAuthorRole(authorRoleManageVO);
		
		return ReturnUtil.returnOk();

	} 
	
	/**
	 * 권한별 할당된 롤 목록 조회
	 * 
	 * @param authorRoleManageVO AuthorRoleManageVO
	 * @return String
	 * @exception Exception
	 */
	@DeleteMapping(value = {"/auth-role"})
	public ResponseEntity<Object> deleteAuthorRole(@ModelAttribute("authorRoleManageVO") AuthorRoleManageVO authorRoleManageVO,
                                                  ModelMap model) throws Exception {

    	authRoleService.deleteAuthorRole(authorRoleManageVO);

    	return ReturnUtil.returnOk();
    	
	}
    
    
}