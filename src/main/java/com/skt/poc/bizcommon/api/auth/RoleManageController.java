package com.skt.poc.bizcommon.api.auth;

import com.skt.poc.bizcommon.model.auth.AuthorManageVO;
import com.skt.poc.bizcommon.model.auth.RoleManage;
import com.skt.poc.bizcommon.model.auth.RoleManageVO;
import com.skt.poc.bizcommon.service.auth.RoleManageService;
import com.skt.poc.bizcommon.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 롤관리에 관한 controller 클래스를 정의한다.
 * [참고] 전자정부 EgovRoleManageController.java Class 참고
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/auth"})
public class RoleManageController {

    @Autowired
    private RoleManageService roleService;
    
    /**
	 * 등록된 롤 정보 목록 조회
	 * 
	 * TODO 연결만 시켜놓음. 필요시 조정 필요.
	 * 
	 * @param roleManageVO RoleManageVO
	 * @return String
	 * @exception Exception
	 */
    @GetMapping(value = {"/roles"})
    public List<RoleManageVO> selectRoleList(@ModelAttribute("roleManageVO") RoleManageVO roleManageVO,
            ModelMap model) throws Exception {
    	
    	log.debug("== [roleManageVO] ==>"+roleManageVO);
    	
    	return roleService.selectRoleList(roleManageVO);
    }
    
    /**
	 * 등록된 롤 정보 조회
	 * @param roleCode String
	 * @param roleManageVO RoleManageVO
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */
    @GetMapping(value = {"/role"})
	public RoleManageVO selectRole(@RequestParam("roleCode") String roleCode,
	                         @ModelAttribute("roleManageVO") RoleManageVO roleManageVO,
	                         @ModelAttribute("authorManageVO") AuthorManageVO authorManageVO,
		                      ModelMap model) throws Exception {

    	//TODO [전자정부 대비 판단 필요] 모든 auth list를 조회할 필요가 있는가?
    	
        return roleService.selectRole(roleManageVO);
	}
    
    /**
	 * 시스템 메뉴에 따른 접근권한, 데이터 입력, 수정, 삭제의 권한 롤을 등록
	 * @param roleManage RoleManage
	 * @param roleManageVO RoleManageVO
	 * @return String
	 * @exception Exception
	 */
    @PostMapping(value = {"/role"})
	public ResponseEntity<Object> insertRole(@ModelAttribute("roleManage") @Valid RoleManage roleManage,
                                            @ModelAttribute("roleManageVO") @Valid RoleManageVO roleManageVO,
                                            Errors errors,
                                            ModelMap model) throws Exception {

    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	roleService.insertRole(roleManage, roleManageVO);
    	
    	return ReturnUtil.returnOk();
	}
    
    /**
	 * 시스템 메뉴에 따른 접근권한, 데이터 입력, 수정, 삭제의 권한 롤을 수정
	 * @param roleManage RoleManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */
    @PutMapping(value = {"/role"})
	public ResponseEntity<Object> updateRole(@ModelAttribute("roleManage") @Valid RoleManage roleManage,
                                            Errors errors,
                                            ModelMap model) throws Exception {

    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	roleService.updateRole(roleManage);
    	
    	return ReturnUtil.returnOk();
    	
	}
    
    /**
	 * 불필요한 롤정보를 화면에 조회하여 데이터베이스에서 삭제
	 * @param roleManage RoleManage
	 * @return String
	 * @exception Exception
	 */
    @DeleteMapping(value = {"/role"})
	public ResponseEntity<Object> deleteRole(@ModelAttribute("roleManage") RoleManage roleManage,
                                            ModelMap model) throws Exception {
    	
    	roleService.deleteRole(roleManage);

    	return ReturnUtil.returnOk();
	}
    
    /**
	 * 불필요한 그룹정보 목록을 화면에 조회하여 데이터베이스에서 삭제
	 * @param roleCodes String
	 * @param roleManage RoleManage
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value="/sec/rmt/EgovRoleListDelete.do")
	public ResponseEntity<Object> deleteRoleList(@RequestParam("roleCodes") String roleCodes,
                                                @ModelAttribute("roleManage") RoleManage roleManage,
                                                Model model) throws Exception {
    	
		String [] strRoleCodes = roleCodes.split(";");
    	for(int i=0; i<strRoleCodes.length;i++) {
    		roleManage.setRoleCode(strRoleCodes[i]);
    		roleService.deleteRole(roleManage);
    	}

    	return ReturnUtil.returnOk();
	}
    
}