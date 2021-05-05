/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostromn.dvdlibrary;

import com.mostromn.dvdlibrary.controller.DVDLibraryController;
import com.mostromn.dvdlibrary.dao.DVDLibraryDao;
import com.mostromn.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.mostromn.dvdlibrary.ui.DVDLibraryView;
import com.mostromn.dvdlibrary.ui.UserIO;
import com.mostromn.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author nicholasmostrom
 */
public class App {
  
    public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    DVDLibraryView myView = new DVDLibraryView(myIo);
    DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
    DVDLibraryController controller =
            new DVDLibraryController(myDao, myView);
    controller.run();
    }
}
