package jun.vn.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Cart")
public class Cart_23110353 {

    @Id
    @Column(length = 50, columnDefinition = "NVARCHAR(50)")
    private String cartId;

    private Integer userId;   // int

    @Temporal(TemporalType.TIMESTAMP) // datetime
    private Date buyDate;

    private Integer status;   // int
    
    @OneToMany(mappedBy = "cart")
    private java.util.List<CartItem_23110353> items;

	public Cart_23110353(String cartId, Integer userId, Date buyDate, Integer status) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.buyDate = buyDate;
		this.status = status;
	}

	public Cart_23110353() {
		
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
