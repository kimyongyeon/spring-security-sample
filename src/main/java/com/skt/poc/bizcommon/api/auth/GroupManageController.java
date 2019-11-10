package com.skt.poc.bizcommon.api.auth;

import com.skt.poc.bizcommon.model.auth.GroupManage;
import com.skt.poc.bizcommon.model.auth.GroupManageVO;
import com.skt.poc.bizcommon.service.auth.GroupManageService;
import com.skt.poc.bizcommon.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 그룹관리에 관한 controller 클래스를 정의한다.
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/auth"})
public class GroupManageController {
	
	@Autowired
    private GroupManageService groupManageService;
    
	/**
	 * 시스템사용 목적별 그룹 목록 조회
	 * @param groupManageVO GroupManageVO
	 * @return String
	 * @exception Exception
	 */
	@GetMapping(value = {"/groups"})
	public List<GroupManageVO> selectGroupList(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO,
                                              ModelMap model) throws Exception {
    	return groupManageService.selectGroupList(groupManageVO);
	}

	/**
	 * 검색조건에 따른 그룹정보를 조회
	 * @param groupManageVO GroupManageVO
	 * @return String
	 * @exception Exception
	 */
	@GetMapping(value = {"/group"})
	public GroupManageVO selectGroup(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO,
                                    @ModelAttribute("groupManage") GroupManage groupManage,
                                    ModelMap model) throws Exception {

	    return groupManageService.selectGroup(groupManageVO);
	}

	/**
	 * 그룹 기본정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장
	 * @param groupManage GroupManage
	 * @param groupManageVO GroupManageVO
	 * @return String
	 * @exception Exception
	 */ 
	@PostMapping(value = {"/group"})
	public ResponseEntity<Object> insertGroup(@ModelAttribute("groupManage") @Valid GroupManage groupManage,
                                             @ModelAttribute("groupManageVO") GroupManageVO groupManageVO,
                                             BindingResult bindingResult, Errors errors,
                                             ModelMap model) throws Exception {
    	
    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	//TODO ID Generation 루틴 필요.
    	//TODO 하드코딩 => 향후 ID Generation 루틴으로 변경 필요.
    	String groupId = "GROUP_90000000000000";
//    		==> egovframework.rte / egovframework.rte.fdl.idgnr maven 포함시, Log4j Error 발생. 
//	    	EgovTableIdGnrServiceImpl idGenSerive = new EgovTableIdGnrServiceImpl();	//전자정부 context-idgn-Group.xml에 선언됨.
//	    	groupId = idGenSerive.getNextStringId();
//	    	log.debug("=> groupId : "+groupId);
	    	
    	groupManage.setGroupId(groupId);	
        groupManageVO.setGroupId(groupManage.getGroupId());
        
        groupManageService.insertGroup(groupManage, groupManageVO);
        
        return ReturnUtil.returnOk();
	}
	
	/**
	 * 화면에 조회된 그룹의 기본정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영
	 * @param groupManage GroupManage
	 * @return String
	 * @exception Exception
	 */     
	@PutMapping(value = {"/group"})
	public ResponseEntity<Object> updateGroup(@ModelAttribute("groupManage") @Valid GroupManage groupManage,
                                             BindingResult bindingResult, Errors errors,
                                             Model model) throws Exception {
    	
    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	groupManageService.updateGroup(groupManage);
    	
    	return ReturnUtil.returnOk();
	}	
	
	/**
	 * 불필요한 그룹정보를 화면에 조회하여 데이터베이스에서 삭제
	 * @param groupManage GroupManage
	 * @return String
	 * @exception Exception
	 */
	@DeleteMapping(value = {"/group"})
	public ResponseEntity<Object> deleteGroup(@ModelAttribute("groupManage") GroupManage groupManage,
                                             Model model) throws Exception {
		
		groupManageService.deleteGroup(groupManage);
		
		return ReturnUtil.returnOk();
	}

	/**
	 * 불필요한 그룹정보 목록을 화면에 조회하여 데이터베이스에서 삭제
	 * @param groupIds String
	 * @param groupManage GroupManage
	 * @return String
	 * @exception Exception
	 */   
	@DeleteMapping(value = {"/groups"})
	public ResponseEntity<Object> deleteGroupList(@RequestParam("groupIds") String groupIds,
                                                 @ModelAttribute("groupManage") GroupManage groupManage,
                                                 Model model) throws Exception {
    	
		String [] strGroupIds = groupIds.split(";");
    	for(int i=0; i<strGroupIds.length;i++) {
    		groupManage.setGroupId(strGroupIds[i]);
    		groupManageService.deleteGroup(groupManage);
    	}

    	return ReturnUtil.returnOk();
	}
	    
	/**
	 * 시스템사용 목적별 그룹 목록 조회
	 * 
	 * TODO 상위 selectGroupList 함수와 차이점 판단 필요.
	 * 
	 * @param groupManageVO GroupManageVO
	 * @return String
	 * @exception Exception
	 */
	@GetMapping(value = {"/groups-1"})
	public List<GroupManageVO> selectGroupSearchList(@ModelAttribute("groupManageVO") GroupManageVO groupManageVO,
                                                    ModelMap model) throws Exception {
    	
    	return groupManageService.selectGroupList(groupManageVO);
	}
}