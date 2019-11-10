package com.skt.poc.common.mapper;

import com.skt.poc.common.model.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * @Class Name : EgovFileMngDAO.java
 * @Description : 파일정보 관리를 위한 데이터 처리 클래스
 *
 */

//@Repository
@Component
@Mapper
public class FileMngMapper {

	@Autowired
//	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	/**
	 * 여러 개의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 *
	 * @param fileList
	 * @return
	 * @throws Exception
	 */
	public String insertFileInfs(List<?> fileList) throws Exception {
		FileVO vo = (FileVO) fileList.get(0);
		String atchFileId = vo.getAtchFileId();

		sqlSession.insert("insertFileMaster", vo);

		Iterator<?> iter = fileList.iterator();
		while (iter.hasNext()) {
			vo = (FileVO) iter.next();

			sqlSession.insert("insertFileDetail", vo);
		}

		return atchFileId;
	}

	/**
	 * 하나의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 *
	 * @param vo
	 * @throws Exception
	 */
	public void insertFileInf(FileVO vo) throws Exception {
		sqlSession.insert("insertFileMaster", vo);
		sqlSession.insert("insertFileDetail", vo);
	}

	/**
	 * 여러 개의 파일에 대한 정보(속성 및 상세)를 수정한다.
	 *
	 * @param fileList
	 * @throws Exception
	 */
	public void updateFileInfs(List<?> fileList) throws Exception {
		FileVO vo;
		Iterator<?> iter = fileList.iterator();
		while (iter.hasNext()) {
			vo = (FileVO) iter.next();
			sqlSession.insert("insertFileDetail", vo);
		}
	}

	/**
	 * 여러 개의 파일을 삭제한다.
	 *
	 * @param fileList
	 * @throws Exception
	 */
	public void deleteFileInfs(List<?> fileList) throws Exception {
		Iterator<?> iter = fileList.iterator();
		FileVO vo;
		while (iter.hasNext()) {
			vo = (FileVO) iter.next();

			sqlSession.delete("deleteFileDetail", vo);
		}
	}

	/**
	 * 하나의 파일을 삭제한다.
	 *
	 * @param fvo
	 * @throws Exception
	 */
	public void deleteFileInf(FileVO fvo) throws Exception {
		sqlSession.delete("deleteFileDetail", fvo);
	}

	/**
	 * 파일에 대한 목록을 조회한다.
	 *
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FileVO> selectFileInfs(FileVO vo) throws Exception {
		return sqlSession.selectList("selectFileList", vo);
	}

	/**
	 * 파일 구분자에 대한 최대값을 구한다.
	 *
	 * @param fvo
	 * @return
	 * @throws Exception
	 */
	public int getMaxFileSN(FileVO fvo) throws Exception {
		return (Integer) sqlSession.selectOne("getMaxFileSN", fvo);
	}

	/**
	 * 파일에 대한 상세정보를 조회한다.
	 *
	 * @param fvo
	 * @return
	 * @throws Exception
	 */
	public FileVO selectFileInf(FileVO fvo) throws Exception {
		return (FileVO) sqlSession.selectOne("selectFileInf", fvo);
	}

	/**
	 * 전체 파일을 삭제한다.
	 *
	 * @param fvo
	 * @throws Exception
	 */
	public void deleteAllFileInf(FileVO fvo) throws Exception {
		sqlSession.update("deleteCOMTNFILE", fvo);
	}

	/**
	 * 파일명 검색에 대한 목록을 조회한다.
	 *
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FileVO> selectFileListByFileNm(FileVO fvo) throws Exception {
		return sqlSession.selectList("selectFileListByFileNm", fvo);
	}

	/**
	 * 파일명 검색에 대한 목록 전체 건수를 조회한다.
	 *
	 * @param fvo
	 * @return
	 * @throws Exception
	 */
	public int selectFileListCntByFileNm(FileVO fvo) throws Exception {
		return (Integer) sqlSession.selectOne("selectFileListCntByFileNm", fvo);
	}

	/**
	 * 이미지 파일에 대한 목록을 조회한다.
	 *
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FileVO> selectImageFileList(FileVO vo) throws Exception {
		return sqlSession.selectList("selectImageFileList", vo);
	}
}
