package jun.vn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartItem")
public class CartItem_23110353 {

    @Id
    @Column(length = 50, columnDefinition = "NVARCHAR(50)")
    private String cartItemId;

    private Integer quantity;  
    private Float unitPrice;    
    private Integer productId;  

    @Column(length = 50, columnDefinition = "NVARCHAR(50)")
    private String cartId;
    
    @ManyToOne
    @JoinColumn(name = "cartId", insertable = false, updatable = false)
    private Cart_23110353 cart;
    
    @ManyToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product_23110353 product;

	public CartItem_23110353(String cartItemId, Integer quantity, Float unitPrice, Integer productId, String cartId) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.productId = productId;
		this.cartId = cartId;
	}

	public CartItem_23110353() {

	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}   
    
    
}
