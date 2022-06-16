package fr.fms.entities;

import java.beans.ConstructorProperties;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@NotNull
	public String description;

	@Getter
	@Setter
	@DecimalMin("50")
	public double price;

	@ConstructorProperties({ "id", "description", "price" }) // detache et deserialize les getters/setters en appel
																// externe
	public Article(long id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	@ConstructorProperties({ "description", "price" })
	public Article(String description, double price) {
		this.description = description;
		this.price = price;
	}

	@ConstructorProperties({})
	public Article() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;

	}

	public void setDescription(double price) {
		this.price = price;
	}

}
