package jun.vn.entities;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
    private Integer bookId;

    public RatingId() {}

    public RatingId(Integer userId, Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId)) return false;
        RatingId that = (RatingId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId);
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
    
}

