/**
 * @author Matthew Werner
 *
 **/

package com.shad.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shad.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long> {

	/**
	 * use the built-in findAll() in JPA to run the query "SELECT * FROM <table>"
	 **/
	List<Lookify> findAll();
	
	/**
	 * use the built-in findByArtistContaining() to get songs by artist
	 **/
    List<Lookify> findByArtistContaining(String artist);
	
    @Query(value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
    List<Lookify> findTopTenWithNativeQuery();
}
