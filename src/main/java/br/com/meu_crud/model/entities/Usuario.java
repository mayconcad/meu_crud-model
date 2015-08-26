package br.com.meu_crud.model.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "username",
		"ativo" }) })
@NamedQueries({ @NamedQuery(name = "UserfindByUsername", query = "SELECT usu FROM Usuario usu WHERE usu.username = :username") })
public class Usuario extends BaseEntity implements Serializable, UserDetails {

	private static final long serialVersionUID = -8451679170281063697L;

	@NotNull
	@Size(min = 5, max = 20)
	@Column(unique = true)
	private String username;

	@NotNull
	@Size(min = 5, max = 100)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	// @Column(updatable = false)
	private Date createdAt;

	@NotBlank
	private String name;

	@Email
	private String email;

	public Usuario(Long id) {
		this.setId(id);
	}

	public Usuario() {
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
}
