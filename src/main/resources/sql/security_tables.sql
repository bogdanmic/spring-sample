CREATE  TABLE security_users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(250) NOT NULL ,
  enabled INTEGER NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE security_user_roles (
  user_role_id bigserial NOT NULL,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES security_users (username));

ALTER TABLE security_user_roles
   ADD CONSTRAINT uni_username_role UNIQUE (role,username);
CREATE INDEX fk_username_idx
   ON security_user_roles (username ASC NULLS LAST);


INSERT INTO security_users(username,password,enabled)
VALUES ('user','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 1);
INSERT INTO security_users(username,password,enabled)
VALUES ('mkyong','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 1);
INSERT INTO security_users(username,password,enabled)
VALUES ('alex','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 1);

INSERT INTO security_user_roles (username, role)
VALUES ('mkyong', 'ROLE_USER');
INSERT INTO security_user_roles (username, role)
VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO security_user_roles (username, role)
VALUES ('alex', 'ROLE_USER');

INSERT INTO security_user_roles (username, role)
VALUES ('user', 'ROLE_USER');
INSERT INTO security_user_roles (username, role)
VALUES ('user', 'ROLE_ADMIN');