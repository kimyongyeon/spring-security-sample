package com.skt.poc.bizcommon.api.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 공통메시지 클래스를 정의한다.
 * 1. 최초 조회시 DB에서 읽어서 레디스에 저장한다.
 * 2. 변경사항이 생길때만 DB에서 읽어서 레디스에 저장하고 사용한다.
 */
@RestController
@Slf4j
@RequestMapping(value = {"/api/message"})
public class ComMessageManageController {

   /**
    * 등록된 메시지 조회
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    * @return
    */
   @GetMapping
   public List selectMessageList() {
      return null;
   }

   /**
    * 메시지를 데이터베이스로 저장한다.
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    */
   @PostMapping
   public ResponseEntity<Object> insertMessage() {
      return null;
   }

   /**
    * 기존 데이터베이스 메시지를 수정한다.
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    */
   @PutMapping
   public ResponseEntity<Object> updateMessage() {
      return null;
   }

   /**
    * 기존의 데이터베이스 메시지를 삭제한다.
    * TODO: 모델과 모델어튜리뷰트 정의하고, 쿼리를 작성해야 하고, 테이블생성 쿼리도 작성해야 한다.
    */
   @DeleteMapping
   public ResponseEntity<Object> deleteMessage() {
      return null;
   }

}
