package com.skt.poc.bizcommon.api.program;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 공통 프로그램 정보 클래스를 정의한다.
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/program"})
public class ComProgramInfoManageController {
   /**
    * 등록된 프로그램 조회
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    * @return
    */
   @GetMapping
   public List selectProgramList() {
      return null;
   }

   /**
    * 프로그램를 데이터베이스로 저장한다.
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    */
   @PostMapping
   public ResponseEntity<Object> insertProgram() {
      return null;
   }

   /**
    * 기존 데이터베이스 프로그램를 수정한다.
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    */
   @PutMapping
   public ResponseEntity<Object> updateProgram() {
      return null;
   }

   /**
    * 기존의 데이터베이스 프로그램를 삭제한다.
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    */
   @DeleteMapping
   public ResponseEntity<Object> deleteProgram() {
      return null;
   }
}
