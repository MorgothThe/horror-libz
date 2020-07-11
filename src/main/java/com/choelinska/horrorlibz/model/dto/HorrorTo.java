package com.choelinska.horrorlibz.model.dto;

import com.choelinska.horrorlibz.util.Rating;
import lombok.Data;

@Data
public class HorrorTo {

		private long id;
		private String title;
		private String genres;
		private String photo;
		private String descriptions;
		private double stars;
		private String media;
		private Rating rating;
}
