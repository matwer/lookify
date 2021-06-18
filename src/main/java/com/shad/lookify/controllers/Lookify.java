/**
 * @author Matthew Werner
 * creating the table with getters and setters for all member variables
 **/

package com.shad.lookify.controllers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

/**
 * @Entity is @REQUIRED
 **/
@Entity

/**
 * create an @Table in the database
 **/
@Table(name="songs")
public class Lookify {
	/**
	 * build the table(s)
	 **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String artist;
    @NotNull
    @Min(1)
    @Max(10)
    private int rating;
    
	/**
	 * set the Date-Time format to the @param pattern
	 **/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	/**
	 * generate the @createdAt date before the record is saved
	 **/
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    
	/**
	 * tell the system the createdAt field should NOT be updated with each save
	 **/
    @Column(updatable=false)

	/**
	 * capture the date when a record is updated
	 **/
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
	/**
	 * constructor with no parameters @REQUIRED
	 **/
    public Lookify() {}
    
	/**
	 * a constructor which sets the title, artist and rating to @param list
	 **/
    public Lookify(String title, String artist, Integer rating) {
    	this.title = title;
    	this.artist = artist;
    	this.rating = rating;
    }

	/**
	 * @return the id
	 **/
	public Long getId() {
		return id;
	}

	/**
	 * set the id to @param id
	 **/
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 **/
	public String getTitle() {
		return title;
	}

	/**
	 * set the title to @param title
	 **/
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the artist
	 **/
	public String getArtist() {
		return artist;
	}

	/**
	 * set the artist to @param artist
	 **/
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the rating
	 **/
	public Integer getRating() {
		return rating;
	}

	/**
	 * set the rating to @param rating
	 **/
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return createdAt
	 **/
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * set createdAt to @param createdAt
	 **/
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return updatedAt
	 **/
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * set updatedAt to @param updatedAt
	 **/
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
