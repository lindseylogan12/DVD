/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.controller;

import com.mthreell.dvdlibrary.dao.DvdLibraryDao;
import com.mthreell.dvdlibrary.dao.DvdLibraryDaoException;
import com.mthreell.dvdlibrary.dto.Dvd;
import com.mthreell.dvdlibrary.ui.DvdLibraryView;
import com.mthreell.dvdlibrary.ui.UserIO;
import com.mthreell.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *  controller "brains of the operation"; like a GC directing work
 * Controller can talk to both the View and the DAO (only dao, not any impl details)
 * knows what, when, and what component
 * @author lindseylogan
 */
public class DvdLibraryController {
    
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    updateDvd();
                    break;
                case 3:
                    getDvdsByTitle();
                    break;
                case 4:
                    viewDvd();
                    break;
                case 5:
                    listDvds();
                    break;
                case 6:
                    removeDvd();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
                    
        }
        exitMessage();
    } catch (DvdLibraryDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
        
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //1. add dvd to collection
    private void addDvd() throws DvdLibraryDaoException {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayAddSuccessBanner();
    }
    
    //2. update existing dvd
    private void updateDvd() throws DvdLibraryDaoException {
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.updateDvd(dvd);
        view.displayUpdateDvdBanner();
        view.displayDvd(dvd);       //not needed but i like to display updated dvd
        view.displayUpdateSuccessBanner();
    }
    
    //3. search DVDs by title
    private void getDvdsByTitle() throws DvdLibraryDaoException {
        String title = view.getTitleChoice();
        List<Dvd> dvdsByTitle = dao.getDvdsByTitle(title);
        view.displayDvdCollection(dvdsByTitle);
    }
    
    
    //4. list all dvds in collection
    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdCollection(dvdList);
    }
    
    //5. display given dvd
    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    
    //6. remove dvd
    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveBanner();
        String title = view.getTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }
    
    //7. exit
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    // misc
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    //constructor to initialize dao and view
    //view's dependency is now injected into its constructor
    //not controller's job to inject correct userio impl, that's job of app class
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
}
