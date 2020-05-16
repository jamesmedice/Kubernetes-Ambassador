package com.medici.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author a73s
 *
 */
@Entity
@Table(name = "oauth_authority", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class OauthAuthority implements GrantedAuthority {
 
	private static final long serialVersionUID = 7679757793863742613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Override
	public String getAuthority() {
		return getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}