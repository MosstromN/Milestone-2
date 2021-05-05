/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostromn.dvdlibrary.dao;

import com.mostromn.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author nicholasmostrom
 */
public interface DVDLibraryDao {
    /**

     * @param Title
     * @param dvd
     * @return 
     * @throws com.mostromn.dvdlibrary.dao.DVDLibraryDaoException 

     */
    DVD addDVD(String Title, DVD dvd)
    throws DVDLibraryDaoException;
    /**
     * @return
     * @throws com.mostromn.dvdlibrary.dao.DVDLibraryDaoException
     */
    List<DVD> getAllDVD()
    throws DVDLibraryDaoException;
    /**
     * @param Title
     * @return 
     * @throws com.mostromn.dvdlibrary.dao.DVDLibraryDaoException 
     */
    DVD getDVD(String Title)
    throws DVDLibraryDaoException;
    /**
     * @param Title
     * @return 
     * @throws com.mostromn.dvdlibrary.dao.DVDLibraryDaoException 
     */
    DVD removeDVD(String Title) 
    throws DVDLibraryDaoException;
    
    
    
    DVD editDVD(String Title, DVD dvd)
    throws DVDLibraryDaoException;

}
