package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-video")
@Tag(name="VideoRestController", description="영상")
public class VideoRestController {
	
	private final VideoService videoService;
	
	@Autowired
	public VideoRestController(VideoService videoService) {
		this.videoService = videoService;
	}
	
	// 전체 목록 조회
	@GetMapping("/list")
	@Operation(summary = "전체 목록 조회")
	public ResponseEntity<?> list() {
		List<Video> list = videoService.getVideoList();
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	// 부위별 목록 조회
	@GetMapping("/list/{part}")
	@Operation(summary = "부위별 목록 조회")
	public ResponseEntity<?> listByPart(@PathVariable("part") String part) {
		List<Video> list = videoService.getVideoListByPart(part);
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	// 정렬 조회
	@GetMapping("/sort")
	@Operation(summary = "정렬 조회")
	public ResponseEntity<?> sort() {
		List<Video> list = videoService.getOrderByViewCnt();
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	
	// 상세 조회
	@GetMapping("/detail/{videoId}")
	@Operation(summary = "상세 조회")
	public ResponseEntity<?> detail(@PathVariable("videoId") int videoId) {
		Video video = videoService.getVideoById(videoId);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	
	// 상세 리뷰 조회
	@GetMapping("/detail/review/{videoId}")
	@Operation(summary = "상세 리뷰 조회")
	public ResponseEntity<?> review(@PathVariable("videoId") int videoId) {
		List<Review> list = videoService.getReviewById(videoId);
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
}
