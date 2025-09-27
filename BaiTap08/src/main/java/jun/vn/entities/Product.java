package jun.vn.entities;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column(length = 500, columnDefinition = "nvarchar(500) not null")
	private String productName;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double unitPrice;
	@Column(length = 200)
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@ManyToMany(mappedBy = "products")
	private Set<User> users = new HashSet<>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, updatable = false)
	private java.util.Date createDate;
	
	@PrePersist
	protected void onCreate() {
	    this.createDate = new java.util.Date();
	}
}