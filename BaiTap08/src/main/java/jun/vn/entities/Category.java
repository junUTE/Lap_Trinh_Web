package jun.vn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Category")
public class Category implements Serializable{

	@Id
	private static final long serialVersionUID = 1L;
	private Long categoryId;
    private String categoryName;
    private String images;
    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL )
    private Set<Product> products;
    
}
