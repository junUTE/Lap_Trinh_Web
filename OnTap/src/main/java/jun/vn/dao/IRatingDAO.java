package jun.vn.dao;

import jun.vn.entities.Rating;
import java.util.List;

public interface IRatingDAO {
    void save(Rating rating);
    void update(Rating rating);
    void delete(int userId, int bookId);
    Rating findById(int userId, int bookId);
    List<Rating> findByBookId(int bookId);
    List<Rating> findByUserId(int userId);
}
