package jun.vn.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Category")
public class Category_23110353 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(length = 200, columnDefinition = "NVARCHAR(200)")
    private String categoryName;

    @Column(length = 500, columnDefinition = "NVARCHAR(500)")
    private String images;

    private Integer status;
    
    @OneToMany(mappedBy = "category")
    private java.util.List<Product_23110353> products;

	public Category_23110353(int categoryId, String categoryName, String images, Integer status,
			List<Product_23110353> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.images = images;
		this.status = status;
		this.products = products;
	}

	public Category_23110353() {
		
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.List<Product_23110353> getProducts() {
		return products;
	}

	public void setProducts(java.util.List<Product_23110353> products) {
		this.products = products;
	}
}