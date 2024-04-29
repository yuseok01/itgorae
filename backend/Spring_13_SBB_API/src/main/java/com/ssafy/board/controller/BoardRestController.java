package com.ssafy.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-board")
@Tag(name = "BoardRestController", description = "게시판 CRUD")
//@CrossOrigin("*")
public class BoardRestController {
	private final BoardService boardService;

	@Autowired
	private ResourceLoader loader;
	
	
	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<?> list(){
//		List<Board> list = boardService.getBoardList(); //전체조회
//		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//	}

	// 게시글 (검색) 조회
	@GetMapping("/board")
	@Operation(summary = "게시글 조회", description = "게시글 조건에 따른 조회 가넝")
//	@CrossOrigin(value = "*", methods = RequestMethod.GET)
	public ResponseEntity<?> list(@Parameter(description = "검색 조건") @ModelAttribute SearchCondition condition) {
		List<Board> list = boardService.search(condition); // 검색 조회

		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");

		return new ResponseEntity<Board>(board, headers, HttpStatus.OK);
	}

	// 게시글 등록 (Form 형식으로 넘어왔을 때)
	@PostMapping("/board")
	public ResponseEntity<?> write(@ModelAttribute Board board) {
		// 등록한 게시글을 보냈는데
		boardService.writeBoard(board);
		// 등록이 되어있는지 눈으로 Talend API 보려고 이렇게 보낸거지
		// 실제로 프론트에게 보낼때는 크게 의미는 없다! ID만 보내서 디테일 쏘던지 바로 목록으로가면 필요없다!
		// insert, update, delete -> 반환값이 int 형의 값이 넘어온다. (바뀐 행의 개수가 반환됨)
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 게시글 수정 (JSON형태로 보낸다)
//	@PutMapping("/board")
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board) {
		board.setId(id);
		boardService.modifyBoard(board); // id를 따로 보내왔다면 바구니(DTO)에 넣어놓고 보내자
		return new ResponseEntity<Void>(HttpStatus.OK); // 조금 더 세밀하게 컨트롤 할 수도 있다.
	}

	// 게시글 삭제
	@Hidden
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		// 반환값에 따라서 실제로 지워졌는지 or 내가 없는 글을 지우려고 하지는 않는지... 등의 상황에따라
		// 응답코드가 바뀌면 프론트에서 처리하기가 더욱 수월해 지겠다.!
		boardService.removeBoard(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

//	@PostMapping("/file1")
//	public ResponseEntity<Void> fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException {
//
//		if (multipartFile != null && multipartFile.getSize() > 0) {
//			String fileName = multipartFile.getOriginalFilename();
//			
//			Resource resource = loader.getResource("classpath:/static/img");
//			multipartFile.transferTo(new File(resource.getFile(), fileName));
//		}
//
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@PostMapping("/file2")
	public ResponseEntity<Void> fileUpload2(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute Board board){
		
		boardService.fileBoard(multipartFile, board);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
