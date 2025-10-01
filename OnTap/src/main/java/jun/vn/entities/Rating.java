package jun.vn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
@IdClass(RatingId.class)   // Dùng composite key (userid + bookid)
public class Rating {

    @Id
    @Column(name = "userid", nullable = false)
    private Integer userId;

    @Id
    @Column(name = "bookid", nullable = false)
    private Integer bookId;

    @Column
    private Byte rating;   // tinyint -> Byte (0–255)

    @Column(columnDefinition = "TEXT")
    private String reviewText;

	public Rating(Integer userId, Integer bookId, Byte rating, String reviewText) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.rating = rating;
		this.reviewText = reviewText;
	}

	public Rating() {
		super();
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

	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
    
    
}
