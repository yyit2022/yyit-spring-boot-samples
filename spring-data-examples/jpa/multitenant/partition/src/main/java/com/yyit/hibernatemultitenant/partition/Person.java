package com.yyit.hibernatemultitenant.partition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.TenantId;


@Entity
public class Person {
    @Id
	@GeneratedValue
	private Long id;

	@TenantId
	private String tenant;

	private String name;

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

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
