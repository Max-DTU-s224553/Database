DROP DATABASE IF EXISTS TV3;
CREATE DATABASE TV3;
USE TV3;

CREATE TABLE Program
(Title	    	VARCHAR(50),
 FootageID      INT(10),
 ProgramDate	Date,
 Duration		INT(181),
 CPRNummer      INT(10),
 PRIMARY KEY(Title, FootageID));
 
 -- SELECT * FROM Program;
 
 -- ALTER TABLE Program ADD ProgramID INT(10);


 
 -- select * from Program;
 
 CREATE TABLE Journalist
 (CPRNummer     INT(10), 
  FirstName     VARCHAR(20), 
  LastName      VARCHAR(20), 
  PRIMARY KEY (CPRNummer, FirstName));
  
  -- SELECT * FROM Journalist;
  
CREATE TABLE Journalist_Address
(CPRNummer       INT(10),
 Streetname      VARCHAR(30), 
 CivicNumber     SMALLINT, 
 ZIPCode         INT(4),
 City            VARCHAR(15), 
 Country         VARCHAR(20), 
 Continent       ENUM('Europa','Afrika','USA','Syd Amerika', 'Asien', 'Australien'),
 PRIMARY KEY (CPRNummer));
 
 -- SELECT * FROM Journalist_Address;
 
 /*
 Drop table Program;
 Drop table Address;
 Drop table Journalist;
 */
 
INSERT Program VALUES
('Royal wedding', '01','2004-05-14','174', '10103040'),
('Covid-19 Restrictions', '02', '2020-03-11','162', '30302125'),
('Fatal car accident', '03', '2021-10-09','108', '30302125'),
('Pottery Exhibit', '04', '2021-10-11','98', '10203344'),
('Superliga Final Match', '05', '2022-05-29','118', '20208981'),
('SAS Strike', '06', '2022-07-18','112', '30302125'),
('Election Day', '07', '2022-01-11','155', '10204410'),
('Snowstorm', '08', '2023-03-06','111', '10103040');

-- SELECT * FROM Program order by FootageID;

-- select distinct * from Program Left join Journalist on Journalist.CPRNummer;

-- select distinct Program.Title, Program.ProgramDate, Program.Duration, Journalist.CPRNummer, Journalist.FirstName, Journalist.LastName 
-- from Program Left join Journalist 
-- on Journalist.CPRNummer = Program.CPRNummer;

INSERT Journalist VALUES
('10103040','Mark','Miller'),
('30302125','Olga','Owens'),
('10203344','Lukas','Laas'),
('20208981','Pia','Pabst'),
('10204410','Nick','Nassar');

-- SELECT * FROM Journalist;

INSERT Journalist_Address VALUES
('10103040','Nullvej', '132', '2800', 'Kgs. Lyngby', 'Danmark', 'Europa'), 
('30302125','Nybrovej', '28', '2840', 'Holte', 'Danmark', 'Europa'), 
('10203344', 'Østergaardsvej', '12', '2820', 'Gentofte', 'Danmark', 'Europa'), 
('20208981', 'Hovedgade', '9', '2850', 'Nærum', 'Danmark', 'Europa'), 
('10204410', 'Vestergaardsvej', '13', '2830', 'Virum', 'Danmark', 'Europa');

-- SELECT * FROM Journalist_Address;

  

