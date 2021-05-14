/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostromn.dvdlibrary.controller;

import com.mostromn.dvdlibrary.dao.DVDLibraryDao;
import com.mostromn.dvdlibrary.dao.DVDLibraryDaoException;
import com.mostromn.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.mostromn.dvdlibrary.dto.DVD;
import com.mostromn.dvdlibrary.ui.DVDLibraryView;
import com.mostromn.dvdlibrary.ui.UserIO;
import com.mostromn.dvdlibrary.ui.UserIOConsoleImpl;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author nicholasmostrom
 */
public class DVDLibraryController {
  
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    //added throws clause !!!!
    public void run() throws FileNotFoundException {
        boolean keepGoing = true;
        int MenuSelection = 0;
        
        try{
        while (keepGoing) {

            MenuSelection = getMenuSelection();

            switch (MenuSelection) {
                case 1:
                    listDVD();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                    editDVD();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                }
 
            }
            exitMessage();    
        }catch (DVDLibraryDaoException e) {
        view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createDVD() throws DVDLibraryDaoException{
    view.displayCreateDVDBanner();
    DVD newDVD = view.getNewDVDInfo();
    dao.addDVD (newDVD.getTitle(), newDVD);
    view.displayCreateSuccessBanner();
    }
    
    private void listDVD() throws DVDLibraryDaoException{
    view.displayDisplayAllBanner();
    List<DVD> dvdList = dao.getAllDVD();
    view.displayDVDList(dvdList);
    }
    
    private void viewDVD() throws DVDLibraryDaoException{
    view.displayDisplayDVDBanner();
    String Title = view.getTitleChoice();
    DVD dvd = dao.getDVD(Title);
    view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DVDLibraryDaoException{
    view.displayRemoveDVDBanner();
    String Title = view.getTitleChoice();
    DVD removeDVD = dao.removeDVD(Title);
    view.displayRemoveResult(removeDVD);
    }
    // New Edit DVD - edit menu with as well
    private void editDVD() throws DVDLibraryDaoException, FileNotFoundException{
    view.displayEditDVDBanner();
    String Title = view.getTitleChoice();
    //How to call on the file impl class??
    if (dao.doesEditDVDExist(Title)){
       DVD updatedDVD = view.editDVD(Title);
    DVD editDVD = dao.editDVD(Title, updatedDVD);
    view.displayEditResult(); 
    }
    else{
    io.print("DVD doesn't exist");
    }
    }
    
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
    view.displayExitBanner();
    }
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
    this.dao = dao;
    this.view = view;
}
}

