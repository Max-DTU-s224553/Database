package org.example;

import jdk.javadoc.doclet.Reporter;

import java.sql.PreparedStatement;
import java.util.Date;public class FootageAndReporter {

	}

	private final Reporter reporter;
	private final Footage footage;

	public FootageAndReporter(String title, Date programDate, Integer duration, Integer CPRNummer, String firstName, String lastName, String streetName, Integer civicNumber, Integer zipCode, String country, String footageID, String continent) {
		reporter = new Reporter(CPRNummer, firstName, lastName, streetName, civicNumber, zipCode, country, continent);
		footage = new Footage(title, programDate, duration, footageID);
	}

	public Reporter getReporter() {
		return reporter;
	}

	public Footage getFootage() {
		return footage;
	}
}
