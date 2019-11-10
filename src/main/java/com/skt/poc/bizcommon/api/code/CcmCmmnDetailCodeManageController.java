package com.skt.poc.bizcommon.api.code;

import com.skt.poc.bizcommon.model.code.CmmnDetailCode;
import com.skt.poc.bizcommon.model.code.CmmnDetailCodeVO;
import com.skt.poc.bizcommon.service.code.CcmCmmnDetailCodeManageService;
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
* 공통상세코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
*/

@RestController
@Slf4j
@RequestMapping(value = {"/api/code"})
public class CcmCmmnDetailCodeManageController {

	@Autowired
    private CcmCmmnDetailCodeManageService cmmnDetailCodeManageService;
	
   /**
	 * 공통상세코드 목록을 조회한다.
     * @param loginVO
     * @param searchVO
     * @param model
     * @throws Exception
     */
	@GetMapping(value = {"/details"})
	public List<?> selectCmmnDetailCodeList ( @ModelAttribute("searchVO") CmmnDetailCodeVO searchVO
			, ModelMap model
			) throws Exception {

        return cmmnDetailCodeManageService.selectCmmnDetailCodeList(searchVO);

	}
	
	/**
	 * 공통상세코드 상세항목을 조회한다.
	 * @param loginVO
	 * @param cmmnDetailCodeVO
	 * @param model
	 * @throws Exception
	 */
	@GetMapping(value = {"/detail"})
 	public CmmnDetailCode selectCmmnDetailCodeDetail (
 			CmmnDetailCodeVO cmmnDetailCodeVO,	ModelMap model
 			)	throws Exception {
    	return cmmnDetailCodeManageService.selectCmmnDetailCodeDetail(cmmnDetailCodeVO);

	}
	
	/**
     * 공통상세코드를 등록한다.
     * 
     * @param CmmnDetailCodeVO
     * @param CmmnDetailCodeVO
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
	@PostMapping(value = {"/detail"})
    public ResponseEntity<Object> insertCmmnDetailCode(@ModelAttribute("cmmnDetailCodeVO") @Valid CmmnDetailCodeVO cmmnDetailCodeVO,
                                                       BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {

		if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
		
		if(cmmnDetailCodeVO.getCodeId() != null){
			
			CmmnDetailCode vo = cmmnDetailCodeManageService.selectCmmnDetailCodeDetail(cmmnDetailCodeVO);
			if(vo != null){
				//TODO Messaing 처리
				return ResponseEntity.badRequest().build();
			}
		}
    	
		//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
				//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
    	cmmnDetailCodeVO.setFrstRegisterId("admin");
    	cmmnDetailCodeManageService.insertCmmnDetailCode(cmmnDetailCodeVO);
	
    	return ReturnUtil.returnOk();
    }
    
    /**
	 * 공통상세코드를 삭제한다.
	 * @param loginVO
	 * @param cmmnDetailCodeVO
	 * @param model
	 * @throws Exception
	 */
	@Secured("ROLE_ADMIN")
	@DeleteMapping(value = {"/detail"})
	public ResponseEntity<Object> deleteCmmnDetailCode (
			CmmnDetailCodeVO cmmnDetailCodeVO
			, ModelMap model
			) throws Exception {
    	
    	cmmnDetailCodeManageService.deleteCmmnDetailCode(cmmnDetailCodeVO);
    	
    	return ReturnUtil.returnOk();
	}
    
    
    /**
     * 공통상세코드를 수정한다.
     * 
     * @param cmmnDetailCodeVO
     * @param model
     * @throws Exception
     */
	@PutMapping(value = {"/detail"})
    public ResponseEntity<Object> updateCmmnDetailCode(@ModelAttribute("cmmnDetailCodeVO") @Valid CmmnDetailCodeVO cmmnDetailCodeVO, ModelMap model,
                                                       BindingResult bindingResult, Errors errors)
    				throws Exception {
    	
		if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
		
    	//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
		//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
    	cmmnDetailCodeVO.setLastUpdusrId("admin");
    	cmmnDetailCodeManageService.updateCmmnDetailCode(cmmnDetailCodeVO);
    	
    	return ReturnUtil.returnOk();
    }
		
}
