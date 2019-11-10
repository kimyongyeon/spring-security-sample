package com.skt.poc.bizcommon.utils;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ReturnUtil {
	
	public static ResponseEntity<Object> returnOk(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "OK");
		return  ResponseEntity.ok(map);
	}
		
	
}
