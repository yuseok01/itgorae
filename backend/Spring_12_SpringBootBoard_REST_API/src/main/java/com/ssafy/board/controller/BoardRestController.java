package com.ssafy.board.controller;
/*
 * 이 모든게 보드 매퍼로 간다.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController //1. rest 컨트롤러로 쓰겠다. @Controller + @RequestBody
@RequestMapping("/api-board") 
/*이거 쓰면 getmapping 뒤에 board 경로 다 없어도됨
 * 현재 경로  /api-board/board
 */
@Tag(name="BoardRestController", description = "게시판 CRUD") //스웨거 -> 명세를 위함 
public class BoardRestController {
	private final BoardService boardService;
	
	@Autowired
	//4. 생성자 ,setter, 필드에 사용가능, 안써도 되지만 의존성 표기를 위해 써주자
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	
	//게시글 전체 조회 get방식
//	@GetMapping("/board")
	//2. responseEntity를 반환 하겠다. ?는 반환타입 board<list>로 해도됨
//	public ResponseEntity<?> list(){
//		List<Board> list = boardService.getBoardList(); //전체조회
//		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//4. list를 실어 보낼꺼고 잘 보냈는지 ok확인 
//5. 자바 객체 알아서 제이슨으로 바꿔줌 
//	}
	
	//1.게시글 검색포함 조회
	@GetMapping("/board")
	@Operation(summary = "게시글 조회", description = "게시글 조건에 따른 조회 가넝")//스웨거  서머리 : 요약정리 설명 
	public ResponseEntity<?> list(@Parameter(description = "검색 조건") @ModelAttribute SearchCondition condition){
		List<Board> list = boardService.search(condition); //3.검색 조회
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}//4. 리스트를 실어 보낼꺼고 잘 보냈는지 ok 확인
	//5. 자바 객체 알아서 제이슨으로 바꿔줌 
	
	//1.게시글 상세 보기 get방식 id 들고가자 
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id){
		//2.parhvariable id안적어도 되지만 적어주자 
		Board board = boardService.readBoard(id); //3.조회수도 하나 증가 하더라!
		//4.가져왔는데 board 가 null이면 예외처리를 해줘라! 404 처리! (직접 해볼것 ㅎ)
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	//1. 게시글 등록 (FORM 형식으로 넘어왔을때 ,JSON형태로 오는건 수정할때 할꺼임 둘다이해하자)
	@PostMapping("/board")
	public ResponseEntity<?> write(@ModelAttribute Board board){
		//2. board service에 writeboard 호출 
		boardService.writeBoard(board);
		//등록이 되어있는지 눈으로 Talend API 보려고 이렇게 보낸거지
		//실제로 프론트에게 보낼때는 크게 의미는 없다! ID만 보내서 디테일 쏘던지 바로 목록으로가면 필요없다!
		//insert, update, delete -> 반환값이 int 형의 값이 넘어온다. (바뀐 행의 개수가 반환됨)
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	//1.게시글 수정 json형태로 해보기   application/json -> api-board/board/4 4번글 수정 
//	@PutMapping("/board")
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board){
		board.setId(id); //2. 바구니에 id 실어 놓고
		boardService.modifyBoard(board); //3.id를 따로 보내왔다면 바구니(DTO)에 넣어놓고 보내자
		return new ResponseEntity<Void>(HttpStatus.OK);
		//조금 더 세밀하게 컨트롤 할 수도 있다.
	}
	
	//게시글 삭제 
	@Hidden // 스웨거 숨기기 
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		//반환값에 따라서 실제로 지워졌는지 or 내가 없는 글을 지우려고 하지는 않는지... 등의 상황에따라
		//응답코드가 바뀌면 프론트에서 처리하기가 더욱 수월해 지겠다.!
		boardService.removeBoard(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
