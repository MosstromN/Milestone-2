/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostromn.dvdlibrary.dao;

import com.mostromn.dvdlibrary.dto.DVD;
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

/**
 *
 * @author nicholasmostrom
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private Map<String, DVD> dvd = new HashMap<>();
    public static final String ROSTER_FILE = "library.txt";
    public static final String DELIMITER = "::";
    private DVD DVD;
    
    @Override
    public DVD addDVD(String Title, DVD DVD) 
    throws DVDLibraryDaoException{
        loadLibrary(); 
        DVD prevDVD = dvd.put(Title, DVD);
        writeLibrary();
        return prevDVD;
}

    @Override
    public List<DVD> getAllDVD() 
    throws DVDLibraryDaoException{
        loadLibrary();
        return new ArrayList<DVD>(dvd.values());
    }

    @Override
    public DVD getDVD(String Title) 
    throws DVDLibraryDaoException {
        loadLibrary();
        return dvd.get(Title);
}

    @Override
    public DVD removeDVD(String Title) 
    throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = dvd.remove(Title);
        writeLibrary();
        return removedDVD;
}
    @Override
    public DVD editDVD(String Title, DVD DVD)
    throws DVDLibraryDaoException {
        loadLibrary();
        DVD editedDVD = dvd.replace(Title, DVD);
        writeLibrary();
        return editedDVD;
    }
    


    private DVD unmarshallDVD(String dvdAsText){


    String[] dvdTokens = dvdAsText.split(DELIMITER);

   
    String Title = dvdTokens[0];


    DVD dvdFromFile = new DVD(Title);


    dvdFromFile.setDirectorsName(dvdTokens[1]);

    
    dvdFromFile.setMPAARating(dvdTokens[2]);

    
    dvdFromFile.setStudio(dvdTokens[3]);

    
    dvdFromFile.setReleaseDate(dvdTokens[4]);


    dvdFromFile.setUserRating(dvdTokens[5]);

    
    return dvdFromFile;
    }
    
    
    
    private void loadLibrary() throws DVDLibraryDaoException {
    Scanner scanner;

    try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(ROSTER_FILE)));
    } catch (FileNotFoundException e) {
        throw new DVDLibraryDaoException(
                "-_- Could not load roster data into memory.", e);
    }
    // currentLine holds the most recent line read from the file
    String currentLine;
    // currentDVD holds the most recent DVD unmarshalled
    DVD currentDVD;
    // Go through ROSTER_FILE line by line, decoding each line into a 
    // DVD object by calling the unmarshallDVD method.
    // Process while we have more lines in the file
    while (scanner.hasNextLine()) {
        // get the next line in the file
        currentLine = scanner.nextLine();
        // unmarshall the line into a DVD
        currentDVD = unmarshallDVD(currentLine);

        dvd.put(currentDVD.getTitle(), currentDVD);
        }
    // close scanner
    scanner.close();
    }

    
    
    private String marshallDVD(DVD aDVD){

    // Start with the Title, since that's supposed to be first.
    String dvdAsText = aDVD.getTitle() + DELIMITER;

    // add the rest of the properties in the correct order:

 
    dvdAsText += aDVD.getDirectorsName() + DELIMITER;

    dvdAsText += aDVD.getMPAARating() + DELIMITER;
    
    dvdAsText += aDVD.getStudio() + DELIMITER;
    
    dvdAsText += aDVD.getReleaseDate() + DELIMITER;

    dvdAsText += aDVD.getUserRating();

    // We have now turned a dvd to text! Return it!
    return dvdAsText;
    }
    
    
    
    private void writeLibrary() throws DVDLibraryDaoException {
    // NOTE FOR APPRENTICES: We are not handling the IOException - but
    // we are translating it to an application specific exception and 
    // then simple throwing it (i.e. 'reporting' it) to the code that
    // called us.  It is the responsibility of the calling code to 
    // handle any errors that occur.
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(ROSTER_FILE));
    } catch (IOException e) {
        throw new DVDLibraryDaoException(
                "Could not save student data.", e);
    }

    String dvdAsText;
    List<DVD> dvdList = this.getAllDVD();
    for (DVD currentDVD : dvdList) {
        // turn a DVD into a String
        dvdAsText = marshallDVD(currentDVD);
       
        out.println(dvdAsText);
        // force PrintWriter to write line to the file
        out.flush();
    }
    // Clean up
    out.close();
    }


    }





