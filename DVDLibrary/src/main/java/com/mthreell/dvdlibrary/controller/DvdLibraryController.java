/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.controller;

import com.mthreell.dvdlibrary.dao.DvdLibraryDao;
import com.mthreell.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthreell.dvdlibrary.dto.Dvd;
import com.mthreell.dvdlibrary.ui.DvdLibraryView;
import com.mthreell.dvdlibrary.ui.UserIO;
import com.mthreell.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *  controller "brains of the operation"; like a GC directing work
 * Controller can talk to both the View and the DAO
 * @author lindseylogan
 */
public class DvdLibraryController {
    
    private DvdLibraryView view = new DvdLibraryView();
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
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
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //1. add dvd to collection
    private void addDvd() {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayAddSuccessBanner();
    }
    
    //2. update existing dvd
    private void updateDvd() {
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.updateDvd(dvd);
        view.displayUpdateDvdBanner();
        view.displayDvd(dvd);       //not needed but i like to display updated dvd
        view.displayUpdateSuccessBanner();
    }
    
    //3. search DVDs by title
    private void getDvdsByTitle() {
        String title = view.getTitleChoice();
        List<Dvd> dvdsByTitle = dao.getDvdsByTitle(title);
        view.displayDvdCollection(dvdsByTitle);
    }
    
    
    //4. list all dvds in collection
    private void listDvds() {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdCollection(dvdList);
    }
    
    //5. display given dvd
    private void viewDvd() {
        view.displayDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    
    //6. remove dvd
    private void removeDvd() {
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
    
    
}
