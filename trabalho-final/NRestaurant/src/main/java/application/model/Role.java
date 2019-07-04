package application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority{
	@Id
	@Column(length=200)
	private String papel;
	
	@ManyToMany(mappedBy = "roles")
	List<Cliente> clientes;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}


}
