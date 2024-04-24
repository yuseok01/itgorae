package com.ssafy.debug.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.debug.model.dto.Musical;

public interface MusicalDao {
	int insertMusical(Musical musical);
	List<Musical> selectAllMusicals();
	Musical selectMusicalById(long id);
	int updateMusical(Musical musical);
	int deleteMusical(long id);
	List<Musical> searchMusicals(Map<String, String> map);
	
}
