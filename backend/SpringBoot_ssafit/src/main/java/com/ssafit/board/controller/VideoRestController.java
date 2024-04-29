package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-video")
@Tag(name = "VideoRestController", description = "영상 관련 API")
//@CrossOrigin("*")
public class VideoRestController {
	
	private final VideoService videoService;
	
	@Autowired
	public VideoRestController(VideoService videoService) {
		this.videoService = videoService;
	}

	// 영상 전체 조회
	@GetMapping("/video")
	@Operation(summary = "영상 목록 조회", description = "영상 목록 조회 가넝")
	public ResponseEntity<?> list(){
		List<Video> list = videoService.getVideoList(); //전체조회
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}


	// 영상 상세 보기
	@GetMapping("/video/{id}")
	@Operation(summary = "영상 상세 조회", description = "영상 상세 조회 가넝")
	public ResponseEntity<Video> detail(@PathVariable("id") int id) {
		Video video = videoService.readVideo(id);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");

		return new ResponseEntity<Video>(video, headers, HttpStatus.OK);
	}

}
