package com.ssafy.ssafit.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewDao;
    
    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> getReviewsByVideo(int videoId) {
        return reviewDao.selectReviewsByVideo(videoId);
    }

    @Override
    public Review getReview(int videoId, int reviewId) {
        reviewDao.updateReviewViewcnt(videoId, reviewId);
        return reviewDao.selectReview(videoId, reviewId);
    }

    @Transactional
    @Override
    public void writeReview(@Param("videoId") int videoId, @Param("review") Review review) {
        reviewDao.insertReview(videoId, review);
        
    }

    @Transactional
    @Override
    public void modifyReview(@Param("videoId") int videoId, @Param("reviewId") int reviewId, @Param("content") String content) {
        reviewDao.updateReview(videoId, reviewId, content);
    }

    @Transactional
    @Override
    public void removeReview(int videoId, int reviewId) {
        reviewDao.deleteReview(videoId, reviewId);
        
    }

}
