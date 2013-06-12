package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
public class Image {
	

	@Id
	private String id;

	private String gallery;

	@Stereotype("PHOTOGRAPH")
	private byte[] image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGallery() {
		return gallery;
	}

	public void setGallery(String gallery) {
		this.gallery = gallery;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	

}