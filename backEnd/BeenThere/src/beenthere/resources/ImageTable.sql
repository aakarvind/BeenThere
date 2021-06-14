DROP TABLE cityImages;
DROP TABLE placeImages;
DROP TABLE reviewsImages;
DROP TABLE ImageTable;

CREATE TABLE ImageTable(
	imageId NUMBER primary key,
	imageStr CLOB NOT NULL
);

CREATE TABLE cityImages(
	city NUMBER REFERENCES cities(c_id),
	image NUMBER REFERENCES ImageTable(imageId) UNIQUE
);

CREATE TABLE placeImages(
	place NUMBER REFERENCES places(p_id),
	image NUMBER REFERENCES ImageTable(imageId) UNIQUE
);

CREATE TABLE reviewsImages(
	review NUMBER REFERENCES UserReviews(review_id),
	image NUMBER REFERENCES ImageTable(imageId) UNIQUE
);

SELECT * FROM ImageTable;
SELECT * FROM cityImages;
SELECT * FROM placeImages;
SELECT * FROM reviewsImages;