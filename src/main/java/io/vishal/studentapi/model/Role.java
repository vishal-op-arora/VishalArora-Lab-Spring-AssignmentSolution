package io.vishal.studentapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role")
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	
	private String roleName;
	
	@ManyToMany
	@JoinTable(
			   name="user_roles",
			  joinColumns=@JoinColumn(name="fk_role_id"),
			  inverseJoinColumns=@JoinColumn(name="fk_user_id")
			)
	private Set<User> users;
	
	public Set<User> getUsers() {
		if(this.users == null) {
			this.users = new HashSet<User>();
		}
		
		return users;
	}
}
