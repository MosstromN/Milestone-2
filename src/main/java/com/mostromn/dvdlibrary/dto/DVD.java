/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostromn.dvdlibrary.dto;

/**
 *
 * @author nicholasmostrom
 */
public class DVD {


    
    private String Title;
    private String ReleaseDate;
    private String MPAARating;
    private String Studio;
    private String UserRating;
    private String DirectorsName;


   
    public DVD(String Title) {
        this.Title = Title;
    }
    
     public void setTitle(String Title) {
        this.Title = Title;
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }
    

    public String getDirectorsName() {
        return DirectorsName;
    }

    public void setDirectorsName(String DirectorsName) {
        this.DirectorsName = DirectorsName;
    }    
    
    public String getStudio(){
        return Studio;
    }
   
    public void setStudio(String Studio){
        this.Studio = Studio;
    }
   
    public String getUserRating(){
        return UserRating;
    }
   
    public void setUserRating(String UserRating){
        this.UserRating = UserRating;
    }

   

}
