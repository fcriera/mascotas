package com.frc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Mascota {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_nacimiento")
	private Date fechaNac;
	private String raza;
	private Double peso;
	private boolean tieneChip;
	private String urlFoto;
	
	
	
}
