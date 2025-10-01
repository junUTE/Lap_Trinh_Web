package jun.vn.services;

import jun.vn.entities.Rating;
import java.util.List;

public interface IRatingService {
    void save(Rating rating);
    void update(Rating rating);
    void delete(int userId, int bookId);
    Rating findById(int userId, int bookId);
    List<Rating> findByBookId(int bookId);
    List<Rating> findByUserId(int userId);
}
