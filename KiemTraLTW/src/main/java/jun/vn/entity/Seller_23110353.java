package jun.vn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Seller")
public class Seller_23110353 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sellerId;

	@Column(nullable = false, length = 200)
	private String sellername;

	private String images;

	private Boolean status;

	// Mỗi seller chỉ thuộc về 1 user
	@OneToOne
	@JoinColumn(name = "user_id", unique = true)
	private User_23110353 user;

	public Seller_23110353(Integer sellerId, String sellername, String images, Boolean status, User_23110353 user) {
		super();
		this.sellerId = sellerId;
		this.sellername = sellername;
		this.images = images;
		this.status = status;
		this.user = user;
	}

	public Seller_23110353() {
		super();
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public User_23110353 getUser() {
		return user;
	}

	public void setUser(User_23110353 user) {
		this.user = user;
	}

}
