/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.dao;

/**
 * Error class of application. Extends Exception (inheritance)
 * @author lindseylogan
 */
public class DvdLibraryDaoException extends Exception {
    
    public DvdLibraryDaoException(String message) {
        super(message);
    }
    
    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
