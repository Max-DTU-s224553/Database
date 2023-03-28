package org.example;

import jdk.javadoc.doclet.Reporter;

import java.sql.PreparedStatement;

public class createFootageAndReporter {

    public void createFootageAndReporter (Footage Reporter){
        try{
            PreparedStatement ps = connector.getConnection().prepareStatement(INSERT INTO footage VALUES (?, ?, ?));
            ps.setString(1, org.example.FootageAndReporter.getFootage().get.title());
            ps.setString(2, org.example.FootageAndReporter.getFootage().getDate();
            ps.setInt(3, org.example.FootageAndReporter.getFootage().getDuration());

            PreparedStatement ps = connector.getConnection().prepareStatement(INSERT INTO footage VALUES (?, ?, ?, ?, ?, ?, ?));
            ps.setInt(1, org.example.FootageAndReporter.getReporter().getCPR());
            ps.setString(2, org.example.FootageAndReporter.getReporter().get.firstName);
            ps.setString(3, org.example.FootageAndReporter.getReporter().get.lastName);
            ps.setString(4, org.example.FootageAndReporter.getReporter().get.streetName);
            ps.setString(5, org.example.FootageAndReporter.getReporter().get.civicNumber);
            ps.setInt(6, org.example.FootageAndReporter.getReporter().get.zipCode);
            ps.setString(7, org.example.FootageAndReporter.getReporter().get.country);


            }
        }
}
