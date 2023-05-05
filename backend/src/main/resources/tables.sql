-- Run this script to initialize the database you specified in application.properties.

CREATE SCHEMA hiking;
CREATE TABLE hiking.feature_collection(
	id UUID PRIMARY KEY,
	name TEXT UNIQUE NOT NULL
);

CREATE TABLE hiking.feature(
	id UUID PRIMARY KEY,
	collection_id UUID NOT NULL,
	properties JSONB NOT NULL
);

CREATE TABLE hiking.feature_geo(
	feature_id UUID PRIMARY KEY,
	geo_type SMALLINT NOT NULL,
	coordinates JSONB NOT NULL
);

CREATE TABLE hiking.feature_review(
	id UUID PRIMARY KEY,
	user_id UUID NOT NULL,
	trail_id UUID NOT NULL,
	n_stars SMALLINT NOT NULL,
	title VARCHAR(100) NOT NULL,
	body TEXT,
	last_updated TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE INDEX COLL_INDX ON hiking.feature(collection_id);
CREATE INDEX NAME_INDX ON hiking.feature_collection(name);
CREATE INDEX RVW_UID_INDX ON hiking.feature_review(user_id);
CREATE INDEX RVW_TRAIL_UID_INDX ON hiking.feature_review(trail_id);

ALTER TABLE hiking.feature
ADD CONSTRAINT FK_COLLECTION_ID
FOREIGN KEY (collection_id) 
REFERENCES hiking.feature_collection(id) ON DELETE CASCADE;

ALTER TABLE hiking.feature_geo
ADD CONSTRAINT FK_FEATURE_ID
FOREIGN KEY (feature_id) 
REFERENCES hiking.feature(id) ON DELETE CASCADE;
