/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostromn.dvdlibrary.ui;

import com.mostromn.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author nicholasmostrom
 */
public class DVDLibraryView {
    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD's");
        io.print("2. Create New DVD");
        io.print("3. View DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }    
public DVD getNewDVDInfo() {
    String title = io.readString("Please enter Title");
    String mPAARating = io.readString("Please enter MPAA Rating");
    String releaseDate = io.readString("Please enter Release Date");
    String directorsName = io.readString("Please enter Directors Name");
    String studio = io.readString("Please enter Studio");
    String userRating = io.readString("Please enter User Rating");
    DVD currentDVD = new DVD(title);
    currentDVD.setMPAARating(mPAARating);
    currentDVD.setReleaseDate(releaseDate);
    currentDVD.setDirectorsName(directorsName);
    currentDVD.setStudio(studio);
    currentDVD.setUserRating(userRating);
    return currentDVD;
    }
public void displayCreateDVDBanner() {
    io.print("=== Create DVD ===");
}
public void displayCreateSuccessBanner() {
    io.readString("DVD successfully created.  Please hit enter to continue");
}
public void displayDVDList(List<DVD> dvdList) {
    for (DVD currentDVD : dvdList) {
        String dvdInfo = String.format("#%s : %s %s",
              currentDVD.getTitle(),
              currentDVD.getDirectorsName(),
              currentDVD.getReleaseDate());
        io.print(dvdInfo);
        }
    io.readString("Please hit enter to continue.");
    }


public void displayDisplayAllBanner() {
    io.print("=== Display All DVDs ===");
    }

public void displayDisplayDVDBanner () {
    io.print("=== Display DVD ===");
}

public String getTitleChoice() {
    return io.readString("Please enter the Title.");
}

public void displayDVD (DVD dvd) {
    if (dvd != null) {
        io.print(dvd.getTitle());
        io.print(dvd.getDirectorsName() + " " + dvd.getStudio());
        io.print(dvd.getMPAARating());
        io.print(dvd.getReleaseDate());
        io.print(dvd.getUserRating());
        io.print("");
    } else {
        io.print("No such DVD.");
    }
    io.readString("Please hit enter to continue.");
}

public DVD editDVD (String Title) {
    
    
    io.print(Title);
    String mPAARating = io.readString("Please enter new MPAA Rating");
    String releaseDate = io.readString("Please enter new Release Date");
    String directorsName = io.readString("Please enter new Director Name");
    String studio = io.readString("Please enter new Studio");
    String userRating = io.readString("Please enter new User Rating");
    String title = Title;
    
    DVD currentDVD = new DVD(title);  
    currentDVD.setMPAARating(mPAARating);
    currentDVD.setReleaseDate(releaseDate);
    currentDVD.setDirectorsName(directorsName);
    currentDVD.setStudio(studio);
    currentDVD.setUserRating(userRating);
    
    io.readString("Please hit enter to continue.");
 
    return currentDVD;   
}

public void displayRemoveDVDBanner () {
    io.print("=== Remove DVD ===");
}

public void displayRemoveResult(DVD dvdRecord) {
    if(dvdRecord != null){
      io.print("DVD successfully removed.");
    }else{
      io.print("No such DVD.");
    }
    io.readString("Please hit enter to continue.");
}

public void displayEditDVDBanner () {
    io.print("=== Edit DVD ===");
}
        
public void doesEditDVDExist () {

    
}


public void displayEditResult (){
        io.print("DVD succesfully Edited");
        io.readString("Please hit enter to continue.");
    }
public void displayExitBanner() {
    io.print("Good Bye!!!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!!!");
}

public DVDLibraryView(UserIO io) {
    this.io = io;
}

public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}


}

