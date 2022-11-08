/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.ui;

import com.mthreell.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 * the view (and helper classes) resp for all user interaction; no other component
 * may interact with the user
 * The View cannot access the DAO.
 * @author lindseylogan
 */
public class DvdLibraryView {
    
    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. Add DVD to Collection");
            io.print("2. Update an Existing DVD");
            io.print("3. Search DVDs by Title");
            io.print("4. Display Info for a DVD");
            io.print("5. List all DVDs in the Collection");
            io.print("6. Remove a DVD");
            io.print("7. Exit");
            
            return io.readInt("Please select from the"
                    + " above choices.", 1, 7);
    }
    
    //1. add dvd to collection
    public void displayAddDvdBanner() {
        io.print("=== Add DVD ===");
    }
    
    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release Date");
        String rating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter the Recording Studio");
        String userRatingOrNote = io.readString("Please enter your personal"
        + " rating or any comments you'd like");
        
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRatingOrNote(userRatingOrNote);
        return currentDvd;
    }
    
    public void displayAddSuccessBanner() {
        io.readString("DVD successfully added. Please hit enter to continue.");
    }
    
    //2. update existing dvd
    public void displayUpdateDvdBanner(){
        io.print("=== Update DVD ===");
    }
    
    public Dvd updateDvd(Dvd dvd) {
        io.print("Please enter which change you'd like to make based off"
                + " of the following choices:");
        io.print("1. Update Release Date");
        io.print("2. Update MPAA Rating");
        io.print("3. Update Director's Name");
        io.print("4. Update the Studio");
        io.print("5. Update User Rating or Comments");
        
        int choice = io.readInt("Please select from the above choices.", 1, 5);
       
        if (choice == 1) {
            String releaseDate = io.readString("Please enter Release Date");
            dvd.setReleaseDate(releaseDate);
        } else if (choice == 2) {
           String rating = io.readString("Please enter MPAA Rating");
           dvd.setRating(rating);
        } else if (choice == 3) {
           String directorName = io.readString("Please enter Director's Name");
           dvd.setDirectorName(directorName);
        } else if (choice == 4) {
           String studio = io.readString("Please enter the Recording Studio");
           dvd.setStudio(studio);
        } else if (choice == 5) {
           String userRatingOrNote = io.readString("Please enter your personal"
            + " rating or any comments you'd like");
           dvd.setUserRatingOrNote(userRatingOrNote);
        } else {
           displayUnknownCommandBanner();
        }
        return dvd;
    }
    
    public void displayUpdateSuccessBanner() {
        io.readString("DVD successfully updated. Please hit enter to continue.");
    }
    
    
    //3. search DVDs by title
    public void displayDvdsByTitleBanner() {
        io.print("=== Display DVDs by Title ===");
    }
    
    public void displayDvdsByTitle(List<Dvd> dvdList, Dvd dvd) {
        if (dvd != null) {
          for (Dvd currentDvd : dvdList) {
              String dvdInfo = String.format("Title: %s",
                      currentDvd.getTitle());
              io.print(dvdInfo);
          }  
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    
    
    
    //4. display info for dvd
    public void displayDvdBanner() {
        io.print("=== Display DVD ===");
    }
    
    public String getTitleChoice() {
        return io.readString("Please enter the Title of the DVD.");
    }
    
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            String dvdInfo;
        dvdInfo = String.format("Title: %s | Release Date: %s | "
                + "MPAA Rating: %s | Director's Name: %s | Studio: %s | "
                + "Notes: %s",
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getRating(),
                dvd.getDirectorName(),
                dvd.getStudio(),
                dvd.getUserRatingOrNote());
        io.print(dvdInfo);
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    //5. list all dvds in the collection
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDvdCollection(List<Dvd> dvdList) {
    for (Dvd currentDvd : dvdList) {
        String dvdInfo;
        dvdInfo = String.format("Title: %s | Release Date: %s | "
                + "MPAA Rating: %s | Director's Name: %s | Studio: %s | "
                + "Notes: %s",
                currentDvd.getTitle(),
                currentDvd.getReleaseDate(),
                currentDvd.getRating(),
                currentDvd.getDirectorName(),
                currentDvd.getStudio(),
                currentDvd.getUserRatingOrNote());
        io.print(dvdInfo);
    }
    io.readString("Please hit enter to continue.");
    }
    
    
    
    //6. remove a dvd
    public void displayRemoveBanner() {
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveResult(Dvd dvdRecord) {
        if(dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    //7. exit
    public void displayExitBanner() {
        io.print("Good Bye!");
    }
    
    // misc
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command.");
    }
    
}