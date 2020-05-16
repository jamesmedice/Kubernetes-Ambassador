CREATE DATABASE IF NOT EXISTS ambassadorsaas;

USE ambassadorsaas;



DROP TABLE if exists oauth_client_details;

CREATE TABLE oauth_client_details
(
   client_id                 VARCHAR (255) PRIMARY KEY,
   resource_ids              VARCHAR (255),
   client_secret             VARCHAR (255),
   scope                     VARCHAR (255),
   authorized_grant_types    VARCHAR (255),
   web_server_redirect_uri   VARCHAR (255),
   authorities               VARCHAR (255),
   access_token_validity     INTEGER,
   refresh_token_validity    INTEGER,
   additional_information    VARCHAR (4096),
   autoapprove               VARCHAR (255)
);

CREATE TABLE if
  not exists oauth_client_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

CREATE TABLE if
  not exists oauth_access_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(255)
);

CREATE TABLE if
  not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);

CREATE TABLE if
  not exists oauth_code (
  code VARCHAR(255), authentication LONG VARBINARY
);

CREATE TABLE if
  not exists oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

CREATE TABLE if
  not exists ClientDetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);

  
DROP TABLE IF EXISTS oauth_authority;
CREATE TABLE oauth_authority (
   id  INT NOT NULL,
   name VARCHAR(255),
   PRIMARY KEY (id)
);

ALTER TABLE  oauth_authority ADD CONSTRAINT authority_name UNIQUE (name);


DROP TABLE IF EXISTS oauth_users;
CREATE TABLE oauth_users (
   id INT NOT NULL,
   account_expired BOOLEAN,
   account_locked BOOLEAN,
   credentials_expired BOOLEAN,
   enabled BOOLEAN,
   password VARCHAR(255),
   user_name VARCHAR(255),
   PRIMARY KEY (id)
) ENGINE=InnoDB ;

ALTER TABLE oauth_users ADD CONSTRAINT oauth_users_user_name UNIQUE (user_name);



DROP TABLE IF EXISTS users_authorities;
CREATE TABLE users_authorities (
   user_id INT8 NOT NULL,
   authority_id INT8 NOT NULL,
   PRIMARY KEY (user_id, authority_id)
); 

/*ALTER TABLE  USERS_AUTHORITIES ADD CONSTRAINT USERS_AUTHORITIES_AUTHORITY  FOREIGN KEY (AUTHORITY_ID) REFERENCES OAUTH_AUTHORITY(ID);*/

/*ALTER TABLE  USERS_AUTHORITIES ADD CONSTRAINT USERS_AUTHORITIES_USER  FOREIGN KEY (USER_ID) REFERENCES OAUTH_USERS(ID);*/
