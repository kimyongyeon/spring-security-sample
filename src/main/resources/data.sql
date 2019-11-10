
------------------------------------------------------------------------------------------
-- Authorization 관련
------------------------------------------------------------------------------------------

-- 그룹 ------------------------------
INSERT INTO COMTNAUTHORGROUPINFO ( GROUP_ID, GROUP_NM, GROUP_CREAT_DE,GROUP_DC ) VALUES ( 'GROUP_00000000000000', '0번  그룹입니다',  SYSDATE(), '0번  그룹입니다');

--권한정보 ------------------------------

INSERT INTO COMTNAUTHORINFO VALUES ('ROLE_ANONYMOUS'               ,'익명 사용자'      , '', SYSDATE());
INSERT INTO COMTNAUTHORINFO VALUES ('IS_AUTHENTICATED_ANONYMOUSLY' ,'스프링시큐리티 내부사용(롤부여 금지)'      , '', SYSDATE());
INSERT INTO COMTNAUTHORINFO VALUES ('IS_AUTHENTICATED_REMEMBERED'  ,'스프링시큐리티 내부사용(롤부여 금지)', '', SYSDATE());
INSERT INTO COMTNAUTHORINFO VALUES ('IS_AUTHENTICATED_FULLY'       ,'스프링시큐리티 내부사용(롤부여 금지)'    , '', SYSDATE());
INSERT INTO COMTNAUTHORINFO VALUES ('ROLE_USER'                    ,'일반 사용자'      , '', SYSDATE());
INSERT INTO COMTNAUTHORINFO VALUES ('ROLE_ADMIN'                   ,'관리자'           , '', SYSDATE());


-- 롤 계층구조 *주의: 권한 계층구조) ------------------------------
INSERT INTO COMTNROLES_HIERARCHY VALUES ('ROLE_ANONYMOUS'               ,'IS_AUTHENTICATED_ANONYMOUSLY');
INSERT INTO COMTNROLES_HIERARCHY VALUES ('IS_AUTHENTICATED_ANONYMOUSLY' ,'IS_AUTHENTICATED_REMEMBERED');
INSERT INTO COMTNROLES_HIERARCHY VALUES ('IS_AUTHENTICATED_REMEMBERED'  ,'IS_AUTHENTICATED_FULLY');
INSERT INTO COMTNROLES_HIERARCHY VALUES ('IS_AUTHENTICATED_FULLY'       ,'ROLE_USER');
INSERT INTO COMTNROLES_HIERARCHY VALUES ('ROLE_USER'                    ,'ROLE_ADMIN');


--롤정보 ------------------------------

INSERT INTO COMTNROLEINFO (ROLE_CODE, ROLE_NM, ROLE_PTTRN, ROLE_DC, ROLE_TY, ROLE_SORT, ROLE_CREAT_DE) VALUES('web-000001', '로그인롤', '\\A/uat/uia/.*\\.do.*\\Z', '로그인허용을 위한 롤', 'url', '1', SYSDATE());
INSERT INTO COMTNROLEINFO (ROLE_CODE, ROLE_NM, ROLE_PTTRN, ROLE_DC, ROLE_TY, ROLE_SORT, ROLE_CREAT_DE) VALUES('web-000002', '좌측메뉴', '/EgovLeft.do', '좌측 메뉴에 대한 접근 제한 롤', 'url', '2', SYSDATE());
INSERT INTO COMTNROLEINFO (ROLE_CODE, ROLE_NM, ROLE_PTTRN, ROLE_DC, ROLE_TY, ROLE_SORT, ROLE_CREAT_DE) VALUES('web-000003', '모든접근제한', '\\A/.*\\.do.*\\Z', '모든자원에 대한 접근 제한 롤', 'url', '3', SYSDATE());


--권한롤관계 ------------------------------

INSERT INTO COMTNAUTHORROLERELATE (AUTHOR_CODE, ROLE_CODE, CREAT_DT) VALUES ('ROLE_USER', 'web-000001', SYSDATE());
INSERT INTO COMTNAUTHORROLERELATE (AUTHOR_CODE, ROLE_CODE, CREAT_DT) VALUES ('ROLE_USER', 'web-000002', SYSDATE());


-- 사용자보안설정 ------------------------------

INSERT INTO COMTNEMPLYRSCRTYESTBS (SCRTY_DTRMN_TRGET_ID, MBER_TY_CODE, AUTHOR_CODE) VALUES ('admin', 'USR01', 'ROLE_ADMIN');
INSERT INTO COMTNEMPLYRSCRTYESTBS (SCRTY_DTRMN_TRGET_ID, MBER_TY_CODE, AUTHOR_CODE) VALUES ('user', 'USR02', 'ROLE_USER');
INSERT INTO COMTNEMPLYRSCRTYESTBS (SCRTY_DTRMN_TRGET_ID, MBER_TY_CODE, AUTHOR_CODE) VALUES ('xxx', 'USR03', 'ROLE_XXX');

------------------------------------------------------------------------------------------
-- 공통코드 관련
------------------------------------------------------------------------------------------

-- 공통분류코드 ------------------------------

INSERT INTO COMTCCMMNCLCODE(CL_CODE, CL_CODE_NM, CL_CODE_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES ('POC', 'SKT 사내 POC 공통서비스', '전자정부 프레임워크 공통서비스', 'Y', SYSDATE(), 'SYSTEM', SYSDATE(), 'SYSTEM');

--공통코드 ------------------------------

INSERT INTO COMTCCMMNCODE(CL_CODE, CODE_ID, CODE_ID_NM, CODE_ID_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID,LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES ('POC', 'COM033', '시스템로그구분', '', 'Y', SYSDATE(), 'SYSTEM', SYSDATE(), 'SYSTEM');

--공통상세코드 ------------------------------

INSERT INTO COMTCCMMNDETAILCODE(CODE_ID, CODE, CODE_NM, CODE_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES ('COM033', 'C', '생성', '생성', 'Y', SYSDATE(), 'SYSTEM', SYSDATE(), 'SYSTEM');
INSERT INTO COMTCCMMNDETAILCODE(CODE_ID, CODE, CODE_NM, CODE_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES ('COM033', 'R', '조회', '조회', 'Y', SYSDATE(), 'SYSTEM', SYSDATE(), 'SYSTEM');
INSERT INTO COMTCCMMNDETAILCODE(CODE_ID, CODE, CODE_NM, CODE_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES ('COM033', 'U', '수정', '수정', 'Y', SYSDATE(), 'SYSTEM', SYSDATE(), 'SYSTEM');
INSERT INTO COMTCCMMNDETAILCODE(CODE_ID, CODE, CODE_NM, CODE_DC, USE_AT, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID) VALUES ('COM033', 'D', '삭제', '삭제', 'Y', SYSDATE(), 'SYSTEM', SYSDATE(), 'SYSTEM');

------------------------------------------------------------------------------------------
-- 파일 관련
------------------------------------------------------------------------------------------

--파일속성 ------------------------------

--파일상세정보 ------------------------------