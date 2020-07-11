package com.choelinska.horrorlibz.model.entities;

import com.choelinska.horrorlibz.util.Rating;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HorrorEntity {

	@Id
	private long id;
	private String title;
	private String genres;
	private String photo;
	private String descriptions;
	private double stars;
	private String media;
	private Rating rating;


}
