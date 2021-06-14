DROP SEQUENCE HIBERNATE_SEQUENCE;

CREATE SEQUENCE hibernate_sequence START WITH 1001 INCREMENT BY 1;

DROP TABLE site_feedback;
DROP TABLE queries;
DROP TABLE userConnections;
DROP TABLE UserReviews CASCADE CONSTRAINTS;
DROP TABLE places CASCADE CONSTRAINTS;
DROP TABLE cities CASCADE CONSTRAINTS;
DROP TABLE cityplaces CASCADE CONSTRAINTS;
DROP TABLE placereviews CASCADE CONSTRAINTS;
DROP TABLE UserLog;
DROP TABLE AdminLog;
DROP TABLE UserDetails;
DROP TABLE AdminDetails;
DROP TABLE Messages;

CREATE TABLE AdminDetails(
    Admin_Id NUMBER NOT NULL UNIQUE,
    name  VARCHAR2(10) NOT NULL,
    email VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(10) NOT NULL,
    wrongAttempts NUMBER
);

CREATE TABLE UserDetails(
	name VARCHAR2(25) not null,
	email VARCHAR2(50) primary key,
	contact_number VARCHAR2(10) not null,
	password VARCHAR2(20) NOT NULL,
	dob date,
	dpStr CLOB,
	country VARCHAR2(20),
	gender VARCHAR2(12),
    wrongAttempts NUMBER
);

CREATE TABLE UserLog(
	userLogId NUMBER primary key,
  	logInTime date,
  	logOffTime date,
  	userEmailID VARCHAR2(20) REFERENCES UserDetails(email) NOT NULL
);

CREATE TABLE AdminLog(
	adminLogId NUMBER primary key,
  	logInTime date,
  	logOffTime date,
  	adminID VARCHAR2(20) REFERENCES AdminDetails(email) NOT NULL
);

CREATE TABLE cities(
	c_id NUMBER PRIMARY KEY,
	c_name VARCHAR2(20) NOT NULL,
	description CLOB NOT NULL
);

CREATE TABLE places(
	p_id NUMBER PRIMARY KEY,
	p_name VARCHAR2(20) NOT NULL,
	description CLOB NOT NULL,
	avg_rating NUMBER,
	page_request_count NUMBER,
	cityId NUMBER REFERENCES cities(c_id)
);

CREATE TABLE UserReviews(
	review_Id NUMBER PRIMARY KEY,
	review CLOB,
	rating NUMBER NOT NULL,
	timeStamp date,
	userEmail VARCHAR2(20) REFERENCES UserDetails(email) NOT NULL,
	privacyPreference VARCHAR2(20) NOT NULL, CHECK (privacyPreference IN ('PUBLIC', 'PRIVATE')),
	placeId NUMBER REFERENCES places(p_id),
	likes NUMBER,
	dislikes NUMBER
);

CREATE TABLE cityplaces(
	city NUMBER REFERENCES cities(c_id),
	place NUMBER REFERENCES places(p_id) UNIQUE
);

CREATE TABLE placereviews(
	place NUMBER REFERENCES places(p_id),
	review NUMBER REFERENCES UserReviews(review_Id) UNIQUE
);

CREATE TABLE site_feedback(
	feedback_id NUMBER PRIMARY KEY,
	satisfaction_level NUMBER NOT NULL,
	feedback_text VARCHAR2(150),
	user_id VARCHAR2(20) NOT NULL REFERENCES UserDetails(email)
);

CREATE TABLE queries(
	query_id NUMBER PRIMARY KEY,
	query_subject VARCHAR2(40),
	query_body VARCHAR2(150) NOT NULL,
	query_status VARCHAR2(10) NOT NULL,
	user_id VARCHAR2(20) NOT NULL REFERENCES UserDetails(email),
	check(query_status in ('Completed', 'InProgress'))
);

CREATE TABLE userConnections(
	user_connection_id NUMBER PRIMARY KEY,
	from_user_id VARCHAR2(20) NOT NULL REFERENCES UserDetails(email),
	to_user_id VARCHAR2(20) NOT NULL REFERENCES UserDetails(email)
);
  create table Messages(
  msgId varchar(20) primary key,
  senderEmailId varchar(20) NOT NULL,
  reciverEmailId varchar(20) NOT NULL,
  data clob,
  msgTime date,
  sendersName varchar(20) ,
  reciversName varchar(20)
  );
