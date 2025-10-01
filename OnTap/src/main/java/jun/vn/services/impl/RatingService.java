package jun.vn.services.impl;

import jun.vn.dao.IRatingDAO;
import jun.vn.dao.impl.RatingDAO;
import jun.vn.entities.Rating;
import jun.vn.services.IRatingService;

import java.util.List;

public class RatingService implements IRatingService {
    private IRatingDAO ratingDAO = new RatingDAO();

    @Override
    public void save(Rating rating) {
        ratingDAO.save(rating);
    }

    @Override
    public void update(Rating rating) {
        ratingDAO.update(rating);
    }

    @Override
    public void delete(int userId, int bookId) {
        ratingDAO.delete(userId, bookId);
    }

    @Override
    public Rating findById(int userId, int bookId) {
        return ratingDAO.findById(userId, bookId);
    }

    @Override
    public List<Rating> findByBookId(int bookId) {
        return ratingDAO.findByBookId(bookId);
    }

    @Override
    public List<Rating> findByUserId(int userId) {
        return ratingDAO.findByUserId(userId);
    }
}
