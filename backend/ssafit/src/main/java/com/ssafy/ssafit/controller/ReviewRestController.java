package com.ssafy.ssafit.controller;

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

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.service.ReviewService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-review")
@Tag(name="ReviewRestController", description = "리뷰")
public class ReviewRestController{
	
	private final ReviewService reviewService;
	
	@Autowired
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/review/{videoId}")
	@Operation(summary = "비디오별 리뷰 전체조회")
	public ResponseEntity<?> list(@PathVariable("videoId") int videoId){
		List<Review> list = reviewService.getReviewsByVideo(videoId); //비디오별 리뷰 조회
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/review/{videoId}/{reviewId}")
	@Operation(summary = "비디오별 리뷰 상세조회")
	public ResponseEntity<Review> detail(@PathVariable("videoId") int videoId, @PathVariable("reviewId") int reviewId){
		Review review = reviewService.getReview(videoId, reviewId); 
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	@PostMapping("/review/{videoId}")
	@Operation(summary = "비디오별 리뷰 등록")
	public ResponseEntity<?> write(@PathVariable("videoId") int videoId, @ModelAttribute Review review){
		reviewService.writeReview(videoId, review);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	
	@PutMapping("/review/{videoId}/{reviewId}")
	@Operation(summary = "비디오별 리뷰 수정")
	public ResponseEntity<Void> update(@PathVariable("videoId") int videoId, @PathVariable("reviewId") int reviewId, @RequestBody String content){
		reviewService.modifyReview(videoId, reviewId, content);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/review/{videoId}/{reviewId}")
	@Operation(summary = "비디오별 리뷰 삭제")
	public ResponseEntity<Void> delete(@PathVariable("videoId") int videoId, @PathVariable("reviewId") int reviewId){
		reviewService.removeReview(videoId, reviewId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
