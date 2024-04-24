package com.ssafy.debug.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.debug.model.dto.Musical;

@Service
public class MusicalServiceImpl implements MusicalService {

	private final MusicalService musicalDao;
	
	@Autowired
	public MusicalServiceImpl(MusicalService musicalDao) {
		this.musicalDao = musicalDao;
	}
	@Transactional
	@Override
	public int addMusical(Musical musical) {
		return musicalDao.insertMusical();
	}
	@Transactional
	@Override
	public List<Musical> findAllMusicals() {
		return musicalDao.selectAllMusicals();
	}
	@Transactional
	@Override
	public Musical findMusicalById(Long id) {
		return musicalDao.selectMusicalById(id);
	}
	
	@Transactional
	@Override
	public int updateMusical(Musical musical) {
		return musicalDao.updateMusical(musical);	
	}
	
	@Transactional
	@Override
	public List<Musical> searchMusicals(String keyword, String value) {
		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("value", value);
		return musicalDao.searchMusicals(map);
	}
	
	@Transactional
	@Override
	public boolean deleteMusical(Long id) {
		return musicalDao.removeMusical(id) == 1;
	}
}