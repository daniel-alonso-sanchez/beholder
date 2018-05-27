package org.bringer.tools.beholder.applications.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
@Data
@Entity
@Table(name = "applications")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8505532442027182368L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String url;


}
