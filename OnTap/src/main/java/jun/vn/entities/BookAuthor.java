package jun.vn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_author")
@IdClass(BookAuthorId.class)
public class BookAuthor {

    @Id
    @Column(name = "bookid")
    private Integer bookId;

    @Id
    @Column(name = "author_id")
    private Integer authorId;

    // Mapping quan hệ nhiều-1 tới Book
    @ManyToOne
    @JoinColumn(name = "bookid", insertable = false, updatable = false)
    private Book book;

    // Mapping quan hệ nhiều-1 tới Author
    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

	public BookAuthor(Integer bookId, Integer authorId, Book book, Author author) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
		this.book = book;
		this.author = author;
	}

	public BookAuthor() {
		super();
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
    
    
}
