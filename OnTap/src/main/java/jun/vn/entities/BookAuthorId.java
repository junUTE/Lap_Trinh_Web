package jun.vn.entities;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthorId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer bookId;   
    private Integer authorId;

	public BookAuthorId() {
	}

	public BookAuthorId(Integer bookid, Integer authorId) {
		this.bookId = bookid;
		this.authorId = authorId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BookAuthorId))
			return false;
		BookAuthorId that = (BookAuthorId) o;
		return Objects.equals(bookId, that.bookId) && Objects.equals(authorId, that.authorId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, authorId);
	}

	public Integer getBookid() {
		return bookId;
	}

	public void setBookid(Integer bookid) {
		this.bookId = bookid;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}




	
	
}
