/**
 * @author Matthew Werner
 *
 **/

package com.shad.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shad.lookify.controllers.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long> {

	/**
	 * use the built-in findAll() in JPA to run the query "SELECT * FROM <table>"
	 **/
	List<Lookify> findAll();
	
}
