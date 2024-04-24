package com.ssafy.debug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.debug.model.dao.MusicalDao;
import com.ssafy.debug.model.dto.Musical;
import com.ssafy.debug.model.service.MusicalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api") 
public class MusicalController {
		
	private final MusicalService musicalService;
	/*
	 * 뮤지컬 등록기능
	 * 뮤지컬 전체 정보 조회 기능
	 * 뮤지컬 상세 정보 조회 기능{id}
	 * 뮤지컬 수정 기능{id}
	 * 뮤지컬 삭제 기능{id}
	 * 뮤지컬 검색기능
	 */
	@Autowired
	public MusicalController(MusicalService musicalService) {
		this.musicalService = musicalService;
	}
	
	
	@PostMapping("/musicals") // 1. 뮤지컬 등록 기능 , 등록 = post = modelAttribute
	public ResponseEntity<Integer> addMusical(@ModelAttribute Musical musical) {
		int result = musicalService.addMusical(musical);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	@GetMapping("/musicals")// 2. 뮤지컬 전체조회  
	public ResponseEntity<List<Musical>> getAllMusicals() {
		List<Musical> musicals = musicalService.findAllMusicals();
		return new ResponseEntity<List<Musical>>(musicals, HttpStatus.OK);
	}

	@GetMapping("/musicasl/{id}") // 3. 상세정보 조회 기능 경로의 id 변수 처리 필요
	public ResponseEntity<Musical> getMusicalDetail(@PathVariable("id") Long id) {
		Musical musical = musicalService.findMusicalById(id);
		if (musical == null) { //널이면 못찾아
			return new ResponseEntity<Musical>(HttpStatus.NOT_FOUND);
		}//널이 아니면 뮤지컬출력 
		return new ResponseEntity<Musical>(musical, HttpStatus.OK);
	}

	@PutMapping("/musicals/{id}") // 4 뮤지컬 수정 기능 => put 방식  pathvariable id와  requestbody 필요
	public ResponseEntity<Integer> updateMusical(@PathVariable("id") Long id, @RequestBody Musical musical) { 
		musical.setComposer(String.valueOf(id));
		int result = musicalService.updateMusical(musical);
		if (result == 0) {
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@DeleteMapping("/musicals/{id}") //5. 뮤지컬삭제  경로에 제목 변수처리 변수 담아서 삭제! 삭제했는지 해당 자료없는지 결과 출력  
	public ResponseEntity<Void> deleteMusical(@PathVariable("id") Long id) {
		if (musicalService.deleteMusical(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/musicals/search") // 6. 검색 기능 list에 keyword와 value 담아서 보내자 
	public ResponseEntity<List<Musical>> searchMusicals(@RequestParam("keyword") String keyword, @RequestParam("value") String value) {
		List<Musical> result = musicalService.searchMusicals(keyword, value);
		return new ResponseEntity<>(result, HttpStatus.OK);
	
	}
}

