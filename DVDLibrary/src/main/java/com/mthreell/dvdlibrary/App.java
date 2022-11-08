/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mthreell.dvdlibrary;

import com.mthreell.dvdlibrary.controller.DvdLibraryController;
import com.mthreell.dvdlibrary.dao.DvdLibraryDao;
import com.mthreell.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthreell.dvdlibrary.ui.DvdLibraryView;
import com.mthreell.dvdlibrary.ui.UserIO;
import com.mthreell.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author lindseylogan
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = 
                new DvdLibraryController(myDao, myView);
        controller.run();
    }
}
