/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.dao;

import com.mthreell.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * file persistence feature added at end
 * @author lindseylogan
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd) {
        Dvd newDvd = dvds.put(title, dvd);
        return newDvd;
    }

    @Override
    public Dvd updateDvd(String title, Dvd dvd) {
        Dvd updateDvd = dvds.put(title, dvd);
        return updateDvd;
    }

    @Override
    public List<Dvd> getDvdsByTitle(String title) {
        ArrayList<Dvd> matchingDvds = new ArrayList<>();
        Set<String> dvdTitles = dvds.keySet();
        
        for (String currentTitle : dvdTitles) {
            Dvd currentDvd = dvds.get(currentTitle);
            if (currentTitle.contains(title)) {
            matchingDvds.add(currentDvd);
            }
        }
        return matchingDvds;
        
    }

    @Override
    public Dvd getDvd(String title) {
        return dvds.get(title);
    }

    @Override
    public List<Dvd> getAllDvds() {
        //gets all dvd objects out of dvds map as a collection by calling values()
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd removeDvd(String title) {
        Dvd removedDvd = dvds.remove(title);
        return removedDvd;
    }
    
}
