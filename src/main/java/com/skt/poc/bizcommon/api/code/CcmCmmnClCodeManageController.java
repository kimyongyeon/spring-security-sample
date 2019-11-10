package com.skt.poc.bizcommon.api.code;

import com.skt.poc.bizcommon.model.code.CmmnClCode;
import com.skt.poc.bizcommon.model.code.CmmnClCodeVO;
import com.skt.poc.bizcommon.service.code.CcmCmmnClCodeManageService;
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
 * 공통분류코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
 * 
 */

@RestController
@Slf4j
@RequestMapping(value = {"/api/code"})
public class CcmCmmnClCodeManageController {
	
	@Autowired
    private CcmCmmnClCodeManageService cmmnClCodeManageService;
	

	/**
	 * 공통분류코드 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @throws Exception
	 */
	@GetMapping(value = {"/classes"})
	public List<CmmnClCodeVO> selectCmmnClCodeList(@ModelAttribute("searchVO") CmmnClCodeVO searchVO, ModelMap model) throws Exception {
		
		try {
			return cmmnClCodeManageService.selectCmmnClCodeList(searchVO);
		} catch (Exception e) {
			log.error("### ERROR ###", e);
			return null;
		}
		

	}

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 * 
	 * @param loginVO
	 * @param cmmnClCode
	 * @param model
	 * @throws Exception
	 */
	@GetMapping(value = {"/class"})
	public CmmnClCode selectCmmnClCodeDetail(CmmnClCodeVO cmmnClCodeVO,
			ModelMap model) throws Exception {

		return cmmnClCodeManageService.selectCmmnClCodeDetail(cmmnClCodeVO);

	}
	
	
	 /**
     * 공통분류코드를 등록한다.
     * 
     * @param CmmnClCodeVO
     * @param CmmnClCodeVO
     * @param status
     * @param model
     * @throws Exception
     */
	@PostMapping(value = {"/class"})
    public ResponseEntity<Object> insertCmmnClCode(@ModelAttribute("cmmnClCodeVO") @Valid CmmnClCodeVO cmmnClCodeVO,
                                                   BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {
    	
		if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
		if(cmmnClCodeVO.getClCode() != null){
			CmmnClCode vo = cmmnClCodeManageService.selectCmmnClCodeDetail(cmmnClCodeVO);
			if(vo != null){
				//TODO Messaing 처리
				return ResponseEntity.badRequest().build();
			}
		}
		
		//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
    	//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
		
		cmmnClCodeVO.setFrstRegisterId("admin");
		cmmnClCodeManageService.insertCmmnClCode(cmmnClCodeVO);
	
		return ReturnUtil.returnOk();
    }

    /**
     * 공통분류코드를 삭제한다.
     * 
     * @param cmmnClCodeVO
     * @param status
     * @param model
     * @throws Exception
     */
	@Secured("ROLE_ADMIN")
	@DeleteMapping(value = {"/class"})
    public ResponseEntity<Object> deleteCmmnClCode(@ModelAttribute("searchVO") CmmnClCodeVO cmmnClCode, @ModelAttribute("cmmnClCodeVO") CmmnClCodeVO cmmnClCodeVO,
                                                   BindingResult bindingResult, ModelMap model) throws Exception {

    	//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
    	//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
    	
		cmmnClCodeVO.setLastUpdusrId("admin");
		cmmnClCodeManageService.deleteCmmnClCode(cmmnClCodeVO);

		return ReturnUtil.returnOk();
    } 
    
    /**
     * 공통분류코드를 수정한다.
     * 
     * @param cmmnClCodeVO
     * @param status
     * @param model
     * @throws Exception
     */
    @PutMapping(value = {"/class"})
    public ResponseEntity<Object> updateCmmnClCode(@ModelAttribute("searchVO") @Valid CmmnClCodeVO cmmnClCode, @ModelAttribute("cmmnClCodeVO") CmmnClCodeVO cmmnClCodeVO,
                                                   BindingResult bindingResult, Errors errors, ModelMap model) throws Exception {
    	
    	if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    	
    	//TODO [전자정부] 로그인 여부 판단 및 ID 가져오는 루틴 있음.
    	//	=> ID를 일방적으로 admin으로 하드코딩 해놓음. 향후 상황에 맞게 변경.
    	
		cmmnClCodeVO.setLastUpdusrId("admin");
		cmmnClCodeManageService.updateCmmnClCode(cmmnClCodeVO);
	
		return ReturnUtil.returnOk();
    }

}