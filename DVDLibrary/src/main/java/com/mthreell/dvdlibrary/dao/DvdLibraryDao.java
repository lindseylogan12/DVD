/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.dao;

import com.mthreell.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 * DAO is resp for the persistence and retrieval of DVD data
 * DAO cannot access the View.
 * @author lindseylogan
 */
public interface DvdLibraryDao {
    
    //adds a given dvd to collection and assocaites it with the given dvd title
    //if dvd alrdy associated with that title, it will return dvd object,
    // otherwise, null
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;
    
    // edit given dvd. if dvd is associaed with title, it will return dvd
    Dvd updateDvd(String title, Dvd dvd) throws DvdLibraryDaoException;
    
    //search dvds by title
    List<Dvd> getDvdsByTitle(String title) throws DvdLibraryDaoException;
    
    //display info for given dvd
    Dvd getDvd(String title) throws DvdLibraryDaoException;
    
    //displays list of all dvds
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;
    
    //remove dvd
    Dvd removeDvd(String title) throws DvdLibraryDaoException;
}
