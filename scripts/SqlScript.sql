create database roteyping;
show databases;


CREATE TABLE roteyping.Address (
  AddressID INT(11) NOT NULL AUTO_INCREMENT,
  Address1 varchar(255) NULL,
  Address2 varchar(255) NULL,
  District varchar(50) NULL,
  Country varchar(50) NULL,
  PRIMARY KEY (AddressID)
);

CREATE TABLE roteyping.GLOBALINSTITUTE(
    GlobalInstituteID int(11)  NOT NULL auto_increment,
    InstituteName varchar(50) NULL,
	PRIMARY KEY(GlobalInstituteID)
);

CREATE TABLE roteyping.INSTITUTETYPE(
    InstituteTypeID INT(11) NOT NULL AUTO_INCREMENT,
    InstituteType varchar(50) NOT NULL,
 PRIMARY KEY(InstituteTypeID)
);



CREATE TABLE roteyping.INSTITUTE(
    InstituteID INT(11) NOT NULL AUTO_INCREMENT,
    InstituteName varchar(255) NULL,
    InstituteTypeID int NULL,
    InstituteAdressID int NULL,
	PRIMARY KEY(InstituteID),

	FOREIGN KEY(InstituteTypeID)
		REFERENCES INSTITUTETYPE(InstituteTypeID)
		ON UPDATE CASCADE ON DELETE RESTRICT,

	FOREIGN KEY(InstituteAdressID)
		REFERENCES ADDRESS(AddressID)
		
);

CREATE TABLE roteyping.PARENT(
    ParentID INT(11) NOT NULL AUTO_INCREMENT,
    FirstName varchar(255) NULL,
    LastName varchar(255) NULL,
	PRIMARY KEY(ParentID)
);

CREATE TABLE roteyping.STUDENT(
    StudentID INT(11) NOT NULL AUTO_INCREMENT,
    FirstName varchar(255) NULL,
    LastName varchar(255) NULL,
	PRIMARY KEY(StudentID)
);

CREATE TABLE roteyping.TEACHER(
    TeacherID INT(11) NOT NULL AUTO_INCREMENT,
    FirstName varchar(255) NULL,
    LastName varchar(255) NULL,
	PRIMARY KEY(TeacherID)
);

CREATE TABLE roteyping.TEACHERTYPE(
    TeacherTypeID INT(11) NOT NULL AUTO_INCREMENT,
    TeacherType varchar(20) NULL,
	PRIMARY KEY(TeacherTypeID)
);

CREATE TABLE roteyping.USERS(
    UserID INT(11) NOT NULL AUTO_INCREMENT,
    UserName varchar(50) NULL,
    Password varchar(50) NULL,
	PRIMARY KEY(UserID)
);

CREATE TABLE roteyping.USERS_INSTITUTE(
    UserID INT NOT NULL,
    InstituteID int NOT NULL,
    IsGlobalUser bit NULL,
	PRIMARY KEY(UserID,InstituteID),

	FOREIGN KEY(UserID)
		REFERENCES USERS(UserID),

	FOREIGN KEY(InstituteID)
		REFERENCES INSTITUTE(InstituteID)
);

CREATE TABLE roteyping.TEACHERS_INSTITUTE(
    InstituteID int NOT NULL,
    TeacherID int NOT NULL,
    UserID int NULL,
    TeacherTypeID int NULL,
	PRIMARY KEY(InstituteID,TeacherID),
	
	FOREIGN KEY(InstituteID)
		REFERENCES INSTITUTE(InstituteID),

	FOREIGN KEY(TeacherID)
		REFERENCES Teacher(TeacherID),

	FOREIGN KEY(UserID)
		REFERENCES USERS(UserID),

	FOREIGN KEY(TeacherTypeID)
		REFERENCES TEACHERTYPE(TeacherTypeID)
);


CREATE TABLE roteyping.STUDENTS_PARENT(
    StudentID int NOT NULL,
    ParentID int NOT NULL,

	PRIMARY KEY(StudentID,ParentID),

	FOREIGN KEY(StudentID)
		REFERENCES STUDENT(StudentID),

	FOREIGN KEY(ParentID)
		REFERENCES PARENT(ParentID)	
);

CREATE TABLE roteyping.STUDENTS_INSTITUTE(
    StudentID int NOT NULL,
    InstituteID int NOT NULL,
    UserID int NULL,

	PRIMARY KEY(StudentID,InstituteID),

	FOREIGN KEY(StudentID)
		REFERENCES STUDENT(StudentID),

	FOREIGN KEY(InstituteID)
		REFERENCES INSTITUTE(InstituteID),

	FOREIGN KEY(UserID)
		REFERENCES USERS(UserID)

);

CREATE TABLE roteyping.PARENTS_INSTITUTE(
    InstituteID int NOT NULL,
    ParentID int NOT NULL,
    UserID int NULL,
	PRIMARY KEY(ParentID,InstituteID),

	FOREIGN KEY(ParentID)
		REFERENCES PARENT(ParentID),

	FOREIGN KEY(InstituteID)
		REFERENCES INSTITUTE(InstituteID),

	FOREIGN KEY(UserID)
		REFERENCES USERS(UserID)
);



INSERT INTO roteyping.TEACHERTYPE(teachertype) VALUES('FACULTY');
INSERT INTO roteyping.TEACHERTYPE(teachertype) VALUES('SPORTS');
INSERT INTO roteyping.TEACHERTYPE(teachertype) VALUES('ADMINISTRATOR');

INSERT INTO roteyping.institutetype(InstituteType) VALUES('SCHOOL');
INSERT INTO roteyping.institutetype(InstituteType) VALUES('COLLEGE');
INSERT INTO roteyping.institutetype(InstituteType) VALUES('UNIVERSITY');

DELIMITER $$
CREATE PROCEDURE roteyping.`GET_USER`(UserID INT)
BEGIN
	SELECT * FROM users where UserID=UserID;
END$$
DELIMITER ;






