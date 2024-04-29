package com.ssafit.board.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-review")
@Tag(name = "ReviewRestController", description = "리뷰 관련 API")
//@CrossOrigin("*")
public class ReviewRestController {
	
	private final ReviewService reviewService;
	
	@Autowired //의존성 삽입
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/review")
	@Operation(summary = "리뷰 목록 조회", description = "리뷰 목록 조회 가넝")
	public ResponseEntity<?> list(){
		List<Review> list = reviewService.getReviewList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/review/{id}")
	@Operation(summary = "리뷰 조회", description = "리뷰 한개 조회 가넝")
	public ResponseEntity<?> detail(@PathVariable("id") int id){
		Review review = reviewService.getReviewOne(id);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	@PostMapping("/review")
	@Operation(summary = "리뷰 작성", description = "리뷰 작성 가넝")
	public ResponseEntity<?> write(@ModelAttribute Review review){
		if(reviewService.insertReview(review) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/review/{id}")
	@Operation(summary = "리뷰 수정", description = "리뷰 수정 가넝")
	public ResponseEntity<?> update(@PathVariable("id") int id, @ModelAttribute Review review){
		review.setId(id);
		if(reviewService.modifyReview(review) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/review/{id}")
	@Operation(summary = "리뷰 삭제", description = "리뷰 삭제 가넝")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(reviewService.removeReview(id) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
