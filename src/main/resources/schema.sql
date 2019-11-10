------------------------------------------------------------------------------------------
-- Authorization 관련
------------------------------------------------------------------------------------------

--권한그룹정보 ------------------------------

CREATE TABLE COMTNAUTHORGROUPINFO
(
    GROUP_ID       CHAR(20)     NULL,
    GROUP_NM       VARCHAR(60)  NOT NULL,
    GROUP_CREAT_DE CHAR(20)     NOT NULL,
    GROUP_DC       VARCHAR(100) NULL,
    PRIMARY KEY (GROUP_ID)
)
;

CREATE UNIQUE INDEX COMTNAUTHORGROUPINFO_PK ON COMTNAUTHORGROUPINFO
    (
     GROUP_ID
        )
;


--권한정보 ------------------------------

CREATE TABLE COMTNAUTHORINFO
(
    AUTHOR_CODE     VARCHAR(30)  NULL,
    AUTHOR_NM       VARCHAR(60)  NOT NULL,
    AUTHOR_DC       VARCHAR(200) NULL,
    AUTHOR_CREAT_DE CHAR(20)     NOT NULL,
    PRIMARY KEY (AUTHOR_CODE)
)
;

CREATE UNIQUE INDEX COMTNAUTHORINFO_PK ON COMTNAUTHORINFO
    (
     AUTHOR_CODE
        )
;


--롤 계층구조 (*주의: 권한 계층구조) ------------------------------

CREATE TABLE COMTNROLES_HIERARCHY
(
    PARNTS_ROLE VARCHAR(30) NOT NULL,
    CHLDRN_ROLE VARCHAR(30) NOT NULL,
    PRIMARY KEY (PARNTS_ROLE, CHLDRN_ROLE)
)
;

CREATE UNIQUE INDEX COMTNROLES_HIERARCHY_PK ON COMTNROLES_HIERARCHY
    (
     PARNTS_ROLE,
     CHLDRN_ROLE
        )
;

CREATE UNIQUE INDEX COMTNROLES_HIERARCHY_i01 ON COMTNROLES_HIERARCHY
    (
     PARNTS_ROLE
        )
;

CREATE INDEX COMTNROLES_HIERARCHY_i02 ON COMTNROLES_HIERARCHY
    (
     CHLDRN_ROLE
        )
;


--롤정보 ------------------------------

CREATE TABLE COMTNROLEINFO
(
    ROLE_CODE     VARCHAR(50)  NULL,
    ROLE_NM       VARCHAR(60)  NOT NULL,
    ROLE_PTTRN    VARCHAR(300) NULL,
    ROLE_DC       VARCHAR(200) NULL,
    ROLE_TY       VARCHAR(80)  NULL,
    ROLE_SORT     VARCHAR(10)  NULL,
    ROLE_CREAT_DE CHAR(20)     NOT NULL,
    PRIMARY KEY (ROLE_CODE)
)
;

CREATE UNIQUE INDEX COMTNROLEINFO_PK ON COMTNROLEINFO
    (
     ROLE_CODE
        )
;


--권한롤관계 ------------------------------

CREATE TABLE COMTNAUTHORROLERELATE
(
    AUTHOR_CODE VARCHAR(30) NOT NULL,
    ROLE_CODE   VARCHAR(50) NOT NULL,
    CREAT_DT    DATETIME    NULL,
    PRIMARY KEY (AUTHOR_CODE, ROLE_CODE)
)
;

CREATE UNIQUE INDEX COMTNAUTHORROLERELATE_PK ON COMTNAUTHORROLERELATE
    (
     AUTHOR_CODE,
     ROLE_CODE
        )
;

CREATE INDEX COMTNAUTHORROLERELATE_i01 ON COMTNAUTHORROLERELATE
    (
     AUTHOR_CODE
        )
;

CREATE INDEX COMTNAUTHORROLERELATE_i02 ON COMTNAUTHORROLERELATE
    (
     ROLE_CODE
        )
;


-- 사용자보안설정 ------------------------------

CREATE TABLE COMTNEMPLYRSCRTYESTBS
(
    SCRTY_DTRMN_TRGET_ID VARCHAR(20) NOT NULL,
    MBER_TY_CODE         CHAR(5)     NULL,
    AUTHOR_CODE          VARCHAR(30) NOT NULL,
    PRIMARY KEY (SCRTY_DTRMN_TRGET_ID)
)
;

CREATE UNIQUE INDEX COMTNEMPLYRSCRTYESTBS_PK ON COMTNEMPLYRSCRTYESTBS
    (
     SCRTY_DTRMN_TRGET_ID
        )
;

CREATE INDEX COMTNEMPLYRSCRTYESTBS_i04 ON COMTNEMPLYRSCRTYESTBS
    (
     AUTHOR_CODE
        )
;

------------------------------------------------------------------------------------------
-- 공통코드 관련
------------------------------------------------------------------------------------------

--공통분류코드 ------------------------------

CREATE TABLE COMTCCMMNCLCODE
(
    CL_CODE           CHAR(3)      NOT NULL,
    CL_CODE_NM        VARCHAR(60)  NULL,
    CL_CODE_DC        VARCHAR(200) NULL,
    USE_AT            CHAR(1)      NULL,
    FRST_REGIST_PNTTM DATETIME     NULL,
    FRST_REGISTER_ID  VARCHAR(20)  NULL,
    LAST_UPDT_PNTTM   DATETIME     NULL,
    LAST_UPDUSR_ID    VARCHAR(20)  NULL,
    PRIMARY KEY (CL_CODE)
)
;

CREATE UNIQUE INDEX COMTCCMMNCLCODE_PK ON COMTCCMMNCLCODE
    (
     CL_CODE
        )
;

--공통코드 ------------------------------

CREATE TABLE COMTCCMMNCODE
(
    CODE_ID           VARCHAR(6)   NOT NULL,
    CODE_ID_NM        VARCHAR(60)  NULL,
    CODE_ID_DC        VARCHAR(200) NULL,
    USE_AT            CHAR(1)      NULL,
    CL_CODE           CHAR(3)      NULL,
    FRST_REGIST_PNTTM DATETIME     NULL,
    FRST_REGISTER_ID  VARCHAR(20)  NULL,
    LAST_UPDT_PNTTM   DATETIME     NULL,
    LAST_UPDUSR_ID    VARCHAR(20)  NULL,
    PRIMARY KEY (CODE_ID)
)
;

CREATE UNIQUE INDEX COMTCCMMNCODE_PK ON COMTCCMMNCODE
    (
     CODE_ID
        )
;

CREATE INDEX COMTCCMMNCODE_i01 ON COMTCCMMNCODE
    (
     CL_CODE
        )
;


--공통상세코드 ------------------------------

CREATE TABLE COMTCCMMNDETAILCODE
(
    CODE_ID           VARCHAR(6)   NOT NULL,
    CODE              VARCHAR(15)  NOT NULL,
    CODE_NM           VARCHAR(60)  NULL,
    CODE_DC           VARCHAR(200) NULL,
    USE_AT            CHAR(1)      NULL,
    FRST_REGIST_PNTTM DATETIME     NULL,
    FRST_REGISTER_ID  VARCHAR(20)  NULL,
    LAST_UPDT_PNTTM   DATETIME     NULL,
    LAST_UPDUSR_ID    VARCHAR(20)  NULL,
    PRIMARY KEY (CODE_ID, CODE)
)
;

CREATE UNIQUE INDEX COMTCCMMNDETAILCODE_PK ON COMTCCMMNDETAILCODE
    (
     CODE_ID,
     CODE
        )
;

CREATE INDEX COMTCCMMNDETAILCODE_i01 ON COMTCCMMNDETAILCODE
    (
     CODE_ID
        )
;

------------------------------------------------------------------------------------------
-- 파일 관련
------------------------------------------------------------------------------------------

--파일속성 ------------------------------

CREATE TABLE COMTNFILE
(
    ATCH_FILE_ID CHAR(20) NOT NULL,
    CREAT_DT     DATETIME NOT NULL,
    USE_AT       CHAR(1)  NULL,
    PRIMARY KEY (ATCH_FILE_ID)
)
;

CREATE UNIQUE INDEX COMTNFILE_PK ON COMTNFILE
    (
     ATCH_FILE_ID
        )
;


--파일상세정보 ------------------------------

CREATE TABLE COMTNFILEDETAIL
(
    ATCH_FILE_ID    CHAR(20)      NOT NULL,
    FILE_SN         NUMERIC(10)   NOT NULL,
    FILE_STRE_COURS VARCHAR(2000) NOT NULL,
    STRE_FILE_NM    VARCHAR(255)  NOT NULL,
    ORIGNL_FILE_NM  VARCHAR(255)  NULL,
    FILE_EXTSN      VARCHAR(20)   NOT NULL,
    FILE_CN         MEDIUMTEXT    NULL,
    FILE_SIZE       NUMERIC(8)    NULL,
    PRIMARY KEY (ATCH_FILE_ID, FILE_SN)
)
;

CREATE UNIQUE INDEX COMTNFILEDETAIL_PK ON COMTNFILEDETAIL
    (
     ATCH_FILE_ID,
     FILE_SN
        )
;


CREATE INDEX COMTNFILEDETAIL_i01 ON COMTNFILEDETAIL
    (
     ATCH_FILE_ID
        )
;

--메뉴생성내역 ------------------------------

CREATE TABLE `COMTNMENUCREATDTLS`
(
    `AUTHOR_CODE` varchar(30)    NOT NULL,
    `MENU_NO`     decimal(20, 0) NOT NULL,
    `MAPCREAT_ID` char(30) DEFAULT NULL,
    PRIMARY KEY (`AUTHOR_CODE`, `MENU_NO`),
    CONSTRAINT `R_303` FOREIGN KEY (`AUTHOR_CODE`) REFERENCES `COMTNAUTHORINFO` (`AUTHOR_CODE`)
);

--메뉴정보 ------------------------------

CREATE TABLE `COMTNMENUINFO`
(
    `MENU_NM`           varchar(50)  NOT NULL,
    `UPPER_MENU_NO`     NUMERIC(20)  NOT NULL,
    `MENU_NO`           NUMERIC(20)  NOT NULL,
    `MENU_ORDR`         NUMERIC(20)  NOT NULL,
    `MENU_DC`           varchar(100) NOT NULL,
    `RELATE_IMAGE_PATH` varchar(100) NOT NULL,
    `RELATE_IMAGE_NM`   varchar(50)  NOT NULL,
    `PROGRM_FILE_NM`    varchar(50)  NOT NULL,
    PRIMARY KEY (`MENU_NO`)
);
CREATE UNIQUE INDEX MENUINFO_PK ON COMTNMENUINFO
    (
     MENU_NO
        )
;
CREATE UNIQUE INDEX MENUINFO_FK2 ON COMTNMENUINFO
    (
     UPPER_MENU_NO
        )
;
CREATE UNIQUE INDEX COMTNMENUINFO_ibfk_1 ON COMTNMENUINFO
    (
     PROGRM_FILE_NM
        )
;

--사이트맵 ------------------------------

CREATE TABLE `COMTNSITEMAP`
(
    `MAPCREAT_ID`      char(35)     NOT NULL DEFAULT '',
    `CREAT_OPERTOR_ID` varchar(20)  NOT NULL,
    `MAP_FILE_NM`      varchar(50)  NOT NULL,
    `MAP_FILE_PATH`    varchar(100) NOT NULL,
    PRIMARY KEY (`MAPCREAT_ID`),
    UNIQUE KEY `SITEMAP_PK` (`MAPCREAT_ID`)
);

--프로그램목록 ------------------------------

CREATE TABLE `COMTNPROGRMLIST`
(
    `PROGRM_FILE_NM`   varchar(50)  NOT NULL DEFAULT '',
    `PROGRM_STRE_PATH` varchar(100) NOT NULL,
    `PROGRM_KOREANNM`  varchar(50)           DEFAULT NULL,
    `PROGRM_DC`        mediumtext,
    `URL`              varchar(100) NOT NULL,
    PRIMARY KEY (`PROGRM_FILE_NM`),
    UNIQUE KEY `PROGRMLIST_PK` (`PROGRM_FILE_NM`)
);

--프로그램변경내역 ------------------------------

CREATE TABLE `COMTHPROGRMCHANGEDTLS`
(
    `PROGRM_FILE_NM`     varchar(50)    NOT NULL,
    `RQESTER_NO`         decimal(10, 0) NOT NULL DEFAULT '0',
    `RQESTER_ID`         varchar(20)    NOT NULL,
    `CHANGERQESTER_CN`   mediumtext,
    `RQESTER_PROCESS_CN` mediumtext,
    `OPETR_ID`           varchar(20)             DEFAULT NULL,
    `PROCESS_STTUS_CODE` varchar(15)    NOT NULL,
    `PROCESS_DE`         date                    DEFAULT NULL,
    `RQESTER_DE`         date                    DEFAULT NULL,
    `RQESTER_SJ`         varchar(50)    NOT NULL,
    PRIMARY KEY (`PROGRM_FILE_NM`, `RQESTER_NO`)
);

CREATE UNIQUE INDEX COMTHPROGRMCHANGEDTLS_FK1 ON COMTHPROGRMCHANGEDTLS
    (
     PROGRM_FILE_NM
        )
;
CREATE UNIQUE INDEX COMTHPROGRMCHANGEDTLS_PK ON COMTHPROGRMCHANGEDTLS
    (
     PROGRM_FILE_NM, RQESTER_NO
        )
;