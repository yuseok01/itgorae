package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dao.CarDao;
import com.ssafy.ws.model.dto.Car;

@Service
public class CarServiceImpl implements CarService {

	private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

	/**
	 * has a 관계로 사용할 CarDao 타입의 carDao를 선언한다.
	 */
	private CarDao carDao;
	/**
	 * 파일 업로드 경로를 설정하기 위해 ResourceLoader를 주입받는다.
	 */
	@Autowired
	ResourceLoader resLoader;

	/**
	 * setter를 통해 CarRepo를 주입받는다.
	 * 
	 * @Autowired를 통해 CarRepo 타입의 빈을 주입 받는다.
	 * @param carDao
	 */
	@Autowired
	public void setRepo(CarDao repo) {
		this.carDao = repo;
	}

	@Override
	// 트랜잭션 처리를 위해 어노테이션 설정
	@Transactional
	public int insert(Car car) throws IllegalStateException, IOException {
//		// 에러 발생 코드
//		car.setVin("error");
//		carDao.insert(car);
		Resource res = resLoader.getResource("resources/upload");
		MultipartFile file = car.getFile();
		if (file != null && file.getSize()>0) {
			// prefix를 포함한 전체 이름
			car.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			car.setOrgImg(file.getOriginalFilename());


			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + car.getImg()));
		}
		return carDao.insert(car);
	}

	@Override
	public Car searchByVin(String vin) {
		return carDao.searchByVin(vin);
	}

	@Override
	public List<Car> selectAll() {
		return carDao.selectAll();
	}

	@Override
	public List<Car> searchByModelName(String modelName) {
		return carDao.searchByModelName(modelName);
	}

}
