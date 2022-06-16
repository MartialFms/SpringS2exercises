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
@Getter
@Setter

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@NotNull
	public String login;
	@NotNull
	public String password;
	@NotNull
	public boolean adminRight;



	@ConstructorProperties({ "id", "login", "password","adminRight" }) // detache et deserialize les getters/setters en appel
																// externe
	public User(long id, String login, String password, boolean adminRight) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.adminRight = adminRight;
	}

	@ConstructorProperties({})
	public User() {
	}

}
