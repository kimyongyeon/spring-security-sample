package com.skt.poc.common.api;

import com.skt.poc.bizcommon.utils.ReturnUtil;
import com.skt.poc.common.model.FileVO;
import com.skt.poc.common.service.FileMngService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 파일 조회, 삭제, 다운로드 처리를 위한 컨트롤러 클래스
 * 
 * [참고] 전자정부에서 파일의 등록/수정은 실제 화면과 연동되는 컨트롤러에서 작업됨.
 *  - 예시: 게시판. EgovArticleController 참고.
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/common"})
public class FileMngController {

	@Autowired
    private FileMngService fileService;
	
    /**
     * 첨부파일에 대한 목록을 조회한다.
     *
     * @param fileVO
     * @param atchFileId
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
	@GetMapping(value = {"/file"})
    public Map<String, Object> selectFileInfs(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {
    	
    	String atchFileId = (String)commandMap.get("param_atchFileId");

		fileVO.setAtchFileId(atchFileId);
		List<FileVO> result = fileService.selectFileInfs(fileVO);
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		retMap.put("fileList", result);
		retMap.put("updateFlag", "N");
		retMap.put("fileListCnt", result.size());
		retMap.put("atchFileId", atchFileId);
	
		return retMap;
    }

    /**
     * 첨부파일에 대한 삭제를 처리한다.
     *
     * @param fileVO
     * @param returnUrl
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
	@DeleteMapping(value = {"/file"})
    public ResponseEntity<Object> deleteFileInf(@ModelAttribute("searchVO") FileVO fileVO,
                                                //SessionVO sessionVO,
                                                HttpServletRequest request,
                                                ModelMap model) throws Exception {

    	//TODO 인증확인 처리
//		Boolean isAuthenticated = isAuthenticated();
//		if (isAuthenticated) {
    		fileService.deleteFileInf(fileVO);
//		}

    	return ReturnUtil.returnOk();

    }

    /**
     * 이미지 첨부파일에 대한 목록을 조회한다.
     *
     * @param fileVO
     * @param atchFileId
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
	@DeleteMapping(value = {"/image-file"})
    public List<FileVO> selectImageFileInfs(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap,
                                            //SessionVO sessionVO,
                                            ModelMap model) throws Exception {

		String atchFileId = (String)commandMap.get("atchFileId");
	
		fileVO.setAtchFileId(atchFileId);
		return fileService.selectImageFileList(fileVO);
	
    }
}
