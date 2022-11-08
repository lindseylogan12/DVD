/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.ui;

/**
 * Defines methods to be impl by any class that wants to directly interact with user interface tech
 * @author lindseylogan
 */
public interface UserIO {
    
    void print(String message);
    
    String readString(String prompt);
    
    int readInt(String prompt);
    
    int readInt(String prompt, int min, int max);
    
    double readDouble(String prompt);
    
    double readDouble(String prompt, double min, double max);
    
    float readFloat(String prompt);
    
    float readFloat(String prompt, float min, float max);
    
    long readLong(String prompt);
    
    long readLong(String prompt, long min, long max);
    
}
