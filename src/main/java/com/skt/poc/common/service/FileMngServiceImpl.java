package com.skt.poc.common.service;

import com.skt.poc.common.mapper.FileMngMapper;
import com.skt.poc.common.model.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class Name : EgovFileMngServiceImpl.java
 *
 */
@Service("EgovFileMngService")
public class FileMngServiceImpl implements FileMngService {

	@Autowired
	private FileMngMapper fileManageMapper;

	/**
	 * 여러 개의 파일을 삭제한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#deleteFileInfs(List)
	 */
	public void deleteFileInfs(List<?> fvoList) throws Exception {
		fileManageMapper.deleteFileInfs(fvoList);
	}

	/**
	 * 하나의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#insertFileInf(egovframework.com.cmm.service.FileVO)
	 */
	public String insertFileInf(FileVO fvo) throws Exception {
		String atchFileId = fvo.getAtchFileId();

		fileManageMapper.insertFileInf(fvo);

		return atchFileId;
	}

	/**
	 * 여러 개의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#insertFileInfs(List)
	 */
	public String insertFileInfs(List<?> fvoList) throws Exception {
		String atchFileId = "";

		if (fvoList.size() != 0) {
			atchFileId = fileManageMapper.insertFileInfs(fvoList);
		}
		if (atchFileId == "") {
			atchFileId = null;
		}
		return atchFileId;
	}

	/**
	 * 파일에 대한 목록을 조회한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#selectFileInfs(egovframework.com.cmm.service.FileVO)
	 */
	public List<FileVO> selectFileInfs(FileVO fvo) throws Exception {
		return fileManageMapper.selectFileInfs(fvo);
	}

	/**
	 * 여러 개의 파일에 대한 정보(속성 및 상세)를 수정한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#updateFileInfs(List)
	 */
	public void updateFileInfs(List<?> fvoList) throws Exception {
		//Delete & Insert
		fileManageMapper.updateFileInfs(fvoList);
	}

	/**
	 * 하나의 파일을 삭제한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#deleteFileInf(egovframework.com.cmm.service.FileVO)
	 */
	public void deleteFileInf(FileVO fvo) throws Exception {
		fileManageMapper.deleteFileInf(fvo);
	}

	/**
	 * 파일에 대한 상세정보를 조회한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#selectFileInf(egovframework.com.cmm.service.FileVO)
	 */
	public FileVO selectFileInf(FileVO fvo) throws Exception {
		return fileManageMapper.selectFileInf(fvo);
	}

	/**
	 * 파일 구분자에 대한 최대값을 구한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#getMaxFileSN(egovframework.com.cmm.service.FileVO)
	 */
	public int getMaxFileSN(FileVO fvo) throws Exception {
		return fileManageMapper.getMaxFileSN(fvo);
	}

	/**
	 * 전체 파일을 삭제한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#deleteAllFileInf(egovframework.com.cmm.service.FileVO)
	 */
	public void deleteAllFileInf(FileVO fvo) throws Exception {
		fileManageMapper.deleteAllFileInf(fvo);
	}

	/**
	 * 파일명 검색에 대한 목록을 조회한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#selectFileListByFileNm(egovframework.com.cmm.service.FileVO)
	 */
	public Map<String, Object> selectFileListByFileNm(FileVO fvo) throws Exception {
		List<FileVO> result = fileManageMapper.selectFileListByFileNm(fvo);
		int cnt = fileManageMapper.selectFileListCntByFileNm(fvo);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("resultList", result);
		map.put("resultCnt", Integer.toString(cnt));

		return map;
	}

	/**
	 * 이미지 파일에 대한 목록을 조회한다.
	 *
	 * @see FileMngService.com.cmm.service.EgovFileMngService#selectImageFileList(egovframework.com.cmm.service.FileVO)
	 */
	public List<FileVO> selectImageFileList(FileVO vo) throws Exception {
		return fileManageMapper.selectImageFileList(vo);
	}
}
