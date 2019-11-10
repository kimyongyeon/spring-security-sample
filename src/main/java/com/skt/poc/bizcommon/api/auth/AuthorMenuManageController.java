package com.skt.poc.bizcommon.api.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 권한별 메뉴 관리 클래스를 정의한다.
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/auth"})
public class AuthorMenuManageController {
}
