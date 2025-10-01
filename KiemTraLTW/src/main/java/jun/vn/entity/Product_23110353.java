package jun.vn.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product_23110353 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(length = 200, columnDefinition = "NVARCHAR(200)")
    private String productName;

    private Long productCode;   // bigint trong DB

    @Column(length = 500, columnDefinition = "NVARCHAR(500)")
    private String description;

    private Float price;
    private Integer amount;
    private Integer stock;

    @Column(length = 500, columnDefinition = "NVARCHAR(500)")
    private String images;

    private Integer wishlist;
    private Integer status;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    // ================== RELATIONSHIPS ==================

    @ManyToOne
    @JoinColumn(name = "category_id")   // FK sang Category
    private Category_23110353 category;

    @ManyToOne
    @JoinColumn(name = "seller_id")     // FK sang Seller
    private Seller_23110353 seller;

    @OneToMany(mappedBy = "product")
    private List<CartItem_23110353> cartItems;

    // ================== CONSTRUCTORS ==================

    public Product_23110353() {
    }

    public Product_23110353(int productId, String productName, Long productCode, String description,
                            Float price, Integer amount, Integer stock, String images, Integer wishlist,
                            Integer status, Date createDate, Category_23110353 category,
                            Seller_23110353 seller) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.stock = stock;
        this.images = images;
        this.wishlist = wishlist;
        this.status = status;
        this.createDate = createDate;
        this.category = category;
        this.seller = seller;
    }

    // ================== GETTER / SETTER ==================

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getWishlist() {
        return wishlist;
    }

    public void setWishlist(Integer wishlist) {
        this.wishlist = wishlist;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category_23110353 getCategory() {
        return category;
    }

    public void setCategory(Category_23110353 category) {
        this.category = category;
    }

    public Seller_23110353 getSeller() {
        return seller;
    }

    public void setSeller(Seller_23110353 seller) {
        this.seller = seller;
    }

    public List<CartItem_23110353> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem_23110353> cartItems) {
        this.cartItems = cartItems;
    }
}
