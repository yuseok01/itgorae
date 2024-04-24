package com.ssafy.debug.model.service;

import java.util.List;

import com.ssafy.debug.model.dto.Musical;

public interface MusicalService {
	int addMusical(Musical musical);

	List<Musical> findAllMusicals();

	Musical findMusicalById(Long id);

	int updateMusical(Musical musical);

	boolean deleteMusical(Long id);

	List<Musical> searchMusicals(String keyword, String value);
}