INSERT INTO AdminDetails VALUES (562884,'Naresh', 'naresh05.TRN@infosys.com','1001', 0);
INSERT INTO AdminDetails VALUES (562885,'Ashwani', 'ashwani03.TRN@infosys.com','1002', 0);
INSERT INTO AdminDetails VALUES (562887,'Ritu', 'gupta03.TRN@infosys.com','1003', 0);
INSERT INTO AdminDetails VALUES (562871,'Pranay', 'pranay.TRN@infosys.com','1004', 0);
INSERT INTO AdminDetails VALUES (562889,'Nalin', 'nalin.TRN@infosys.com','1005', 0);
INSERT INTO AdminDetails VALUES (562886,'Pratap', 'pratap01.TRN@infosys.com','1006', 0);
INSERT INTO AdminDetails VALUES (562888,'Aseeem', 'aseem01.TRN@infosys.com','1007', 0);

INSERT INTO UserDetails VALUES('Billu Yadav', 'a@aaa.com', '9999966666', '111', null, null, 'INDIA', 'MALE', 0);
INSERT INTO UserDetails VALUES('Steve Chacha', 'aa@aaa.com', '9999966666', '111', null, null, 'INDIA', 'MALE', 0);
INSERT INTO UserDetails VALUES('Tony Pandey', 'aaa@aaa.com', '9999966666', '111', null, null, 'INDIA', 'TRANSGENDER', 0);
INSERT INTO UserDetails VALUES('Natasha Sreerag', 'aaaa@aaa.com', '9343632291', '111', null, null, 'INDIA', 'FEMALE', 0);

INSERT INTO userConnections VALUES (1, 'a@aaa.com', 'aa@aaa.com');
INSERT INTO userConnections VALUES (2, 'a@aaa.com', 'aaaa@aaa.com');
INSERT INTO userConnections VALUES (3, 'aa@aaa.com', 'a@aaa.com');
INSERT INTO userConnections VALUES (4, 'aa@aaa.com', 'aaa@aaa.com');
INSERT INTO userConnections VALUES (5, 'aa@aaa.com', 'aaaa@aaa.com');
INSERT INTO userConnections VALUES (6, 'aaa@aaa.com', 'aaaa@aaa.com');
INSERT INTO userConnections VALUES (7, 'aaaa@aaa.com', 'aa@aaa.com');

INSERT INTO cities VALUES(1, 'Mysore', 'A city of rich cultural heritage in India.');
INSERT INTO cities VALUES(2, 'Visakhapatnam', 'A city of destiny with clean beaches.');

INSERT INTO places VALUES(1, 'Mysore Palace', 'The palace built by ancient indian kings.', 2, 0, 1);
INSERT INTO places VALUES(2, 'Chamundi Hill', 'The temple built by ancient indian kings.', 4, 0, 1);
INSERT INTO places VALUES(3, 'R.K.Beach', 'The main tourist attraction of the city. Situated accross the Bay Of Bengal.', 4, 0, 2);
INSERT INTO places VALUES(4, 'Kailash Giri', 'The hill top spot with statues of Lord Shiva and Goddess Parvati.', 4, 0, 2);
INSERT INTO places VALUES(5, 'Araku Valley', 'The home to breathtaking views and nature at its best.', 4, 0, 2);

INSERT INTO cityplaces VALUES (1, 1);
INSERT INTO cityplaces VALUES (1, 2);
INSERT INTO cityplaces VALUES (2, 3);
INSERT INTO cityplaces VALUES (2, 4);
INSERT INTO cityplaces VALUES (2, 5);

INSERT INTO UserReviews VALUES(1, 'GEC is Better', 1, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'a@aaa.com', 'PUBLIC', 1, 0, 0);
INSERT INTO UserReviews VALUES(2, 'Nice drive to the temple. Temple itself is good', 3, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'aa@aaa.com', 'PUBLIC', 2, 0, 0);
INSERT INTO UserReviews VALUES(3, 'Temple is rushed during the dussehra times. Powerful temple according the locals', 4, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'aaa@aaa.com', 'PRIVATE', 2, 0, 0);
INSERT INTO UserReviews VALUES(4, 'The beach became polluted now.', 2, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'aa@aaa.com', 'PUBLIC', 3, 0, 0);
INSERT INTO UserReviews VALUES(5, 'Post the cleaning activities, one of the best beaches on the east coast of country.', 4, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'a@aaa.com', 'PUBLIC', 3, 0, 0);
INSERT INTO UserReviews VALUES(6, 'Good weather and wind. Nice for morning walks and jogging too.', 5, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'aaa@aaa.com', 'PRIVATE', 3, 0, 0);
INSERT INTO UserReviews VALUES(7, 'Ropeway is available to reach the top. Nice park to enjoy with kids.', 4, TO_DATE('12/5/2019', 'DD/MM/YYYY'), 'aa@aaa.com', 'PUBLIC', 4, 0, 0);

INSERT INTO placereviews VALUES (1, 1);
INSERT INTO placereviews VALUES (2, 2);
INSERT INTO placereviews VALUES (2, 3);
INSERT INTO placereviews VALUES (3, 4);
INSERT INTO placereviews VALUES (3, 5);
INSERT INTO placereviews VALUES (3, 6);
INSERT INTO placereviews VALUES (4, 7);

INSERT INTO queries VALUES (1, 'Test1', 'this is query 1', 'InProgress', 'a@aaa.com');
INSERT INTO queries VALUES (2, 'Test2', 'this is query 2', 'InProgress', 'a@aaa.com');
INSERT INTO queries VALUES (3, 'Test3', 'this is query 3', 'InProgress', 'aa@aaa.com');
INSERT INTO queries VALUES (4, 'Test4', 'this is query 4', 'InProgress', 'aaa@aaa.com');
INSERT INTO queries VALUES (5, 'Test5', 'this is query 5', 'Completed', 'aaa@aaa.com');

INSERT INTO site_feedback VALUES (1, '5', 'this is feedback 1', 'a@aaa.com');
INSERT INTO site_feedback VALUES (2, '4', 'this is feedback 2', 'aa@aaa.com');
INSERT INTO site_feedback VALUES (3, '4', 'this is feedback 3', 'aa@aaa.com');
INSERT INTO site_feedback VALUES (4, '5', 'this is feedback 4', 'aaa@aaa.com');
INSERT INTO site_feedback VALUES (5, '2', 'this is feedback 5', 'aaa@aaa.com');


SELECT * FROM site_feedback;
SELECT * FROM queries;
SELECT * FROM UserReviews;
SELECT * FROM places;
SELECT * FROM cities;
SELECT * FROM cityplaces;
SELECT * FROM placereviews;
SELECT * FROM UserLog;
SELECT * FROM AdminLog;
SELECT * FROM UserDetails;
SELECT * FROM AdminDetails;
SELECT * FROM userConnections;

SELECT count(review_id) as noOfReviews, placeId FROM UserReviews GROUP BY placeId ORDER BY count(review_id) desc;
SELECT count(review_id), placeId FROM UserReviews GROUP BY placeId ORDER BY count(review_id) desc;

SELECT to_user_id, count(user_connection_id) FROM userConnections GROUP BY to_user_id ORDER BY count(user_connection_id) desc

