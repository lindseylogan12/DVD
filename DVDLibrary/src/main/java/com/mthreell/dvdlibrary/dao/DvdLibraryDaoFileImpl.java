/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.dao;

import com.mthreell.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * text file-specific implementation of DAO interface
 * file persistence feature added at end
 * @author lindseylogan
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        loadDvds();
        Dvd newDvd = dvds.put(title, dvd);
        writeDvd();
        return newDvd;
    }

    @Override
    public Dvd updateDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        loadDvds();
        Dvd updateDvd = dvds.put(title, dvd);
        writeDvd();
        return updateDvd;
    }

    @Override
    public List<Dvd> getDvdsByTitle(String title) throws DvdLibraryDaoException {
        loadDvds();
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
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadDvds();
        return dvds.get(title);
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadDvds();
        //gets all dvd objects out of dvds map as a collection by calling values()
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadDvds();
        Dvd removedDvd = dvds.remove(title);
        writeDvd();
        return removedDvd;
    }
    
    private Dvd unmarshallDvd(String dvdAsText) {
        
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        
        String title = dvdTokens[0];
        Dvd dvdFromFile = new Dvd(title);
        
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setRating(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRatingOrNote(dvdTokens[5]);
        
        //created new dvd object, return it
        return dvdFromFile;
    }
    
    
    //reads dvd file into memory
    // read the line into string var, pass line to unmarshall method to parse into object, and put newly created object into map
    private void loadDvds() throws DvdLibraryDaoException {
        Scanner scanner;
        
        try {
            //scanner to read file
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
            "-_- Could not load DVD data into memory.", e);
        }
        //curentLine holds most recent line read from file
        String currentLine;
        //curentDvd holds more recent DVD unmarshalled
        Dvd currentDvd;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            
            //use title as map key in our map
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }
    
    //turn dvd into line of text for our file
    private String marshallDvd(Dvd aDvd) {
        
        String dvdAsText = aDvd.getTitle() + DELIMITER;
        
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getUserRatingOrNote();
        
        return dvdAsText;
    }
    
    //turn dvd to text using marshall method
    //write string to output file
    private void writeDvd() throws DvdLibraryDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(
            new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
            "Could not save DVD's data.", e);
        }
        
        String dvdAsText;
        //reuse list method since we've alrdy created it
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            //turn dvd into string
            dvdAsText = marshallDvd(currentDvd);
            //write dvd object into our file
            out.println(dvdAsText);
            //force printwriter to write line to the file
            out.flush();
        }
        //clean up by closing printwriter
        out.close();
    }
    
     
}
