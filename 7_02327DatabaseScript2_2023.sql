USE TV3;

select distinct Program.Title, Program.ProgramDate, Program.Duration, Journalist.CPRNummer, Journalist.FirstName, Journalist.LastName 
from Program Left join Journalist 
on Journalist.CPRNummer = Program.CPRNummer;

CREATE TABLE Edition AS SELECT Title, ProgramDate, Duration FROM Program;

select * From PROGRAM;

CREATE View AllProgramInformation as select distinct Program.Title, Program.ProgramDate, Program.Duration, 
Journalist.CPRNummer, Journalist.FirstName, Journalist.LastName 
from Program Left join Journalist 
on Journalist.CPRNummer = Program.CPRNummer;

SELECT * FROM AllProgramInformation;

create table Roles 
(TopicID      Varchar(50), 
JournalistID   Int(10),
Rolename      Varchar(50), 
primary key (TopicID, JournalistID),
foreign key (TopicID) references Program (Title),
foreign key (JournalistID) references Journalist (CPRNummer));

SELECT * FROM Roles;

INSERT Roles VALUES
('Royal wedding','10103040', ''),
('Covid-19 Restrictions', '30302125', ''),
('Fatal car accident', '30302125', ''),
('Pottery Exhibit', '10203344', ''),
('Superliga Final Match', '20208981', ''),
('SAS Strike', '30302125', ''),
('Election Day', '10204410', ''),
('Snowstorm', '10103040', '');

Select * from Roles;

INSERT INTO Roles (TopicID, JournalistID, Rolename) VALUES ('X-factor','10103040', '');

DELIMITER //

CREATE FUNCTION CountProgrammer (vTitle VARCHAR(50))
RETURNS INT
BEGIN 
    DECLARE vProgrammerCount INT;
    SELECT COUNT(*) INTO vProgrammerCount FROM Program WHERE Title = vTitle;
    RETURN vProgrammerCount;
END //

DELIMITER ;

Select * From Program;

Drop function CountProgrammer;


/*tælle antallet af programmer i databasen*/
DELIMITER //
CREATE FUNCTION CountProgrammer ()
RETURNS INT
BEGIN 
    DECLARE vProgrammerCount INT;
    SELECT COUNT(*) INTO vProgrammerCount FROM Program;
    RETURN vProgrammerCount;
END //
DELIMITER ;

SELECT CountProgrammer();



INSERT INTO Program (Title, FootageID, ProgramDate, Duration, CPRNummer) VALUES ('X-factor', '01','2004-05-14','174', '10103040');


/*trigger, der automatisk indstiller et program-id, når et nyt program bliver tilføjet til databasen.*/ 
DELIMITER //
CREATE TRIGGER set_program_id
BEFORE INSERT ON Program
FOR EACH ROW
BEGIN
  SET NEW.ProgramID = (SELECT IFNULL(MAX(ProgramID),0)+1 FROM Program);
END//
DELIMITER ;


INSERT INTO Program (Title, FootageID, ProgramDate, Duration, CPRNummer) VALUES ('X-factor', '01','2004-05-14','174', '10103040');
select * from Program;


INSERT INTO Program (Title, FootageID, ProgramDate, Duration, CPRNummer) VALUES ('ChatGPT overtager verden', '','2023-03-30','178', '10103040');
select * from Program;


DELETE FROM PROGRAM WHERE Title = 'ChatGPT overtager verden';

SELECT * FROM Program;

SELECT * FROM Title NATURAL RIGHT OUTER JOIN CPRNummer;

SELECT Edition.Duration FROM Edition Where Duration>(SELECT MAX(Edition.Duration));

SELECT MAX(Duration) AS highest_Duration FROM EDITION;

select distinct Program.Title, Program.ProgramDate, Program.Duration, Journalist.CPRNummer, Journalist.FirstName, Journalist.LastName 
from Program Left join Journalist 
on Journalist.CPRNummer = Program.CPRNummer;

SELECT * FROM Program NATURAL RIGHT OUTER JOIN Journalist ORDER BY CPRNummer;


SELECT * FROM Program NATURAL JOIN Journalist ORDER BY CPRNummer;

UPDATE Program SET Duration=Duration*1.03 WHERE Duration<120;


CREATE TABLE ProgramOld LIKE Program;
SET SQL_SAFE_UPDATES = 0;
UPDATE Program Set Duration= 2 WHERE ProgramID=1;
SELECT * FROM Program;
CALL ProgramOld;
SET SQL_SAFE_UPDATES = 1;