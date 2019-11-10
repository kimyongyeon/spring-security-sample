package com.skt.poc.bizcommon.api.code;

import com.skt.poc.bizcommon.model.code.CmmnCode;
import com.skt.poc.bizcommon.model.code.CmmnCodeVO;
import com.skt.poc.bizcommon.service.code.CcmCmmnCodeManageService;
import com.skt.poc.bizcommon.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
*
* 공통코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
*/

@RestController
@Slf4j
@RequestMapping(value = {"/api/code"})
public class CcmCmmnCodeManageController {
	
	@Autowired
    private CcmCmmnCodeManageService cmmnCodeManageService;
	
	
	/**
	 * 공통분류코드 목록을 조회한다.
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeList"
	 * @throws Exception
	 */
	@GetMapping(value = {"/codes"})
	public List<?> selectCmmnCodeList(@ModelAttribute("searchVO") CmmnCodeVO searchVO, ModelMap model)
			throws Exception {
		
		return cmmnCodeManageService.selectCmmnCodeList(searchVO);

	}
	
	/**
	 * 공통코드 상세항목을 조회한다.
	 * 
	 * @param loginVO
	 * @param cmmnCodeVO
	 * @param model
	 * @return "egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeDetail"
	 * @throws Exception
	 */
	@GetMapping(value = {"/code"})
	public CmmnCodeVO selectCmmnCodeDetail(CmmnCodeVO cmmnCodeVO, ModelMap model) throws Exception {
		
		return cmmnCodeManageService.selectCmmnCodeDetail(cmmnCodeVO);
		
	}
		
	/**
     * 공통코드를 등록한다.
     * 
     * @param CmmnCodeVO
     * @param CmmnCodeVO
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
	@PostMapping(value = {"/code"})
    public ResponseEntity<Object> insertCmmnCode(@ModelAttribute("searchVO") @Valid CmmnCodeVO cmmnCode, @ModelAttribute("cmmnCodeVO") CmmnCodeVO cmmnCodeVO,
                                                 BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {

		if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
		
		CmmnCode vo = cmmnCodeManageService.selectCmmnCodeDetail(cmmnCode);
		if(vo != null){
			//TODO Messaing 처리
			return ResponseEntity.badRequest().build();
		}
	
		//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
    	//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
		cmmnCodeVO.setFrstRegisterId("admin");
		cmmnCodeManageService.insertCmmnCode(cmmnCodeVO);
	
		return ReturnUtil.returnOk();
    }
        
    /**
     * 공통코드를 삭제한다.
     * 
     * @param cmmnCodeVO
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
	@Secured("ROLE_ADMIN")
	@DeleteMapping(value = {"/code"})
    public ResponseEntity<Object> deleteCmmnCode(@ModelAttribute("cmmnCodeVO") CmmnCodeVO cmmnCodeVO,
                                                 BindingResult bindingResult, ModelMap model) throws Exception {

		//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
		//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
	
		cmmnCodeVO.setLastUpdusrId("admin");
		cmmnCodeManageService.deleteCmmnCode(cmmnCodeVO);

		return ReturnUtil.returnOk();
    }
    
    
    /**
     * 공통코드를 수정한다.
     * 
     * @param cmmnCodeVO
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
	@PutMapping(value = {"/code"})
    public ResponseEntity<Object> updateCmmnCode(@ModelAttribute("searchVO") @Valid CmmnCodeVO cmmnCode, @ModelAttribute("cmmnCodeVO") CmmnCodeVO cmmnCodeVO,
                                                 BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {

		if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
		
    	//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
    	//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
    	
    	//TODO Validation
	
		cmmnCodeVO.setLastUpdusrId("admin");
		cmmnCodeManageService.updateCmmnCode(cmmnCodeVO);
		
		return ReturnUtil.returnOk();

    }
	
}