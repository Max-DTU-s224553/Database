package org.example;

import jdk.javadoc.doclet.Reporter;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class createFootageAndReporter {

    public void createFootageAndReporter (Footage Reporter){
        try{
            PreparedStatement ps = DriverManager.getConnection().prepareStatement("INSERT INTO" Footage "VALUES" (?, ?, ?, ?));
            ps.setString(1, org.example.FootageAndReporter.getFootage().get.title());
            ps.setString(2, org.example.FootageAndReporter.getFootage().get.programDate());
            ps.setInt(3, org.example.FootageAndReporter.getFootage().get.duration());
            ps.setInt(4, org.example.FootageAndReporter.getFootage().get.footageID());

            PreparedStatement ps = DriverManager.getConnection().prepareStatement("INSERT INTO" Reporter "VALUES" (?, ?, ?, ?, ?, ?, ?, ?));
            ps.setInt(1, org.example.FootageAndReporter.getReporter().getCPRNummer());
            ps.setString(2, org.example.FootageAndReporter.getReporter().get.firstName());
            ps.setString(3, org.example.FootageAndReporter.getReporter().get.lastName());
            ps.setString(4, org.example.FootageAndReporter.getReporter().get.streetName());
            ps.setString(5, org.example.FootageAndReporter.getReporter().get.civicNumber());
            ps.setInt(6, org.example.FootageAndReporter.getReporter().get.zipCode());
            ps.setString(7, org.example.FootageAndReporter.getReporter().get.country());
            ps.setString(8, org.example.FootageAndReporter.getReporter().get.continent());


            }
        }
}
