package com.skt.poc.bizcommon.api.auth;

import com.skt.poc.bizcommon.model.auth.AuthorManage;
import com.skt.poc.bizcommon.model.auth.AuthorManageVO;
import com.skt.poc.bizcommon.service.auth.AuthorManageService;
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
 * 권한관리에 관한 controller 클래스를 정의한다.
 * 
 * [참고] 전자정부 EgovAuthorManageController.java Class 참고
 */

@RestController
@Slf4j
@RequestMapping(value = {"/api/auth"})
public class AuthorManageController {

    @Autowired
    private AuthorManageService authService;
    
    /**
     * 모든 권한 세부정보를 조회한다.
     * @param authorManageVO
     * @param model
     * @return
     */
    @GetMapping(value = {"/authors"})
    public List<AuthorManageVO> selectAuthorList(@ModelAttribute("authorManageVO") AuthorManageVO authorManageVO, ModelMap model) {
    	
    	log.debug("=====> selectAuthorList");
    	log.debug("==>"+model.toString());
    	
		try {
			return authService.selectAuthorList(authorManageVO);
		} catch (Exception e) {
			log.error("### ERROR ###", e);
			return null;
		}
    }
    
    /**
     * 권한 세부정보를 조회한다.
     * @param authorCode
     * @param authorManageVO
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping(value = {"/author"})
    public AuthorManageVO selectAuthor(@RequestParam("authorCode") String authorCode,
            @ModelAttribute("authorManageVO") AuthorManageVO authorManageVO,
             ModelMap model) throws Exception {
    	
    	log.debug("=====> selectAuthor");
    	log.debug("[authorCode] ==>"+authorCode);
    	
    	return authService.selectAuthor(authorManageVO);
    	
	} 
    
    /**
	 * 권한 세부정보를 등록한다.
	 * @param authorManage AuthorManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */ 
    @PostMapping(value = {"/author"})
    public ResponseEntity<Object> insertAuthor(@ModelAttribute("authorManage") @Valid AuthorManage authorManage,
                                               BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {

    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	authService.insertAuthor(authorManage);
    	
		return ReturnUtil.returnOk();
	
	}
    
    /**
	 * 권한 세부정보를 수정한다.
	 * @param authorManage AuthorManage
	 * @param bindingResult BindingResult
	 * @return String
	 * @exception Exception
	 */  
    @PutMapping(value = {"/author"})
    public ResponseEntity<Object> updateAuthor(@ModelAttribute("authorManage") @Valid AuthorManage authorManage,
                                               BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {

    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	authService.updateAuthor(authorManage);
    	
		return ReturnUtil.returnOk();
	
	}
    
    /**
	 * 권한 세부정보를 삭제한다.
	 * @param authorManage AuthorManage
	 * @return String
	 * @exception Exception
	 */  
    @DeleteMapping(value = {"/author"})
    public ResponseEntity<Object> deleteAuthor(@ModelAttribute("authorManage") AuthorManage authorManage,
                                               BindingResult bindingResult, ModelMap model) throws Exception {

    	authService.deleteAuthor(authorManage);
    	
		return ReturnUtil.returnOk();
	
	}
    
    /**
	 * 권한목록을 삭제한다.
	 * @param authorCodes String
	 * @param authorManage AuthorManage
	 * @return String
	 * @exception Exception
	 */  
    @DeleteMapping(value = {"/authors"})
    public ResponseEntity<Object> deleteAuthorList(@RequestParam("authorCodes") String authorCodes,
                                                   @ModelAttribute("authorManage") AuthorManage authorManage,
                                                   Model model) throws Exception {

    	String [] strAuthorCodes = authorCodes.split(";");
    	for(int i=0; i<strAuthorCodes.length;i++) {
    		authorManage.setAuthorCode(strAuthorCodes[i]);
    		authService.deleteAuthor(authorManage);
    	}
    	
    	return ReturnUtil.returnOk();
    }  
    
}