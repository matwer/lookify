/**
 * @author Matthew Werner
 *
 **/

package com.shad.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.lookify.controllers.Lookify;
import com.shad.lookify.repositories.LookifyRepository;

/**
 * MAKE SURE YOU ADD THE SERVICE ANNOTTION!!!
 **/
@Service
public class LookifyService {

	/**
	 * instantiate a new repository
	 **/
	private final LookifyRepository songRepo;
	
	/**
	 * create a constructor for the service which takes a repository
	 **/
	public LookifyService(LookifyRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	/**
	 * returns all entries from the repository
	 **/
    public List<Lookify> allEntries() {
        return songRepo.findAll();
    }
    
	/**
	 * adds a new entry to the repository
	 **/
    public Lookify addEntry(Lookify song) {
        return songRepo.save(song);
    }
    
	/**
	 * finds an existing entry if it exists
	 **/
    public Lookify findEntry(Long id) {
        Optional<Lookify> opt = songRepo.findById(id);
        
        if(opt.isPresent()) {
            return opt.get();
        } 

        return null;
    }
    
	/**
	 * updates an entry if it exists
	 **/
    public Lookify updateEntry(Lookify song) {
    	Optional<Lookify> opt = Optional.of(song); 
    	
    	// if the entry is present, update it 
    	if(opt.isPresent()) {
    		return songRepo.save(song);
    	}
    	
    	return null;
    }
    
    
	/**
	 * updates an entry if it exists
	 **/
    public void deleteEntry(Long id) {
    	Optional<Lookify> opt = songRepo.findById(id);
    	
    	// check to see if the entry exists
        if(opt.isPresent()) {
        	songRepo.deleteById(id);
        }
    }
	
    /**
     * returns all songs by artist
     **/
    public List<Lookify> findByArtist(String artist) {
    	return songRepo.findByArtistContaining(artist);
    }
    
    /**
     * returns the top 10 songs by rating from the repository
     **/
    public List<Lookify> findTopTen() {
    	return songRepo.findTopTenWithNativeQuery();
    }
    

}
