 
INSERT INTO oauth_client_details (client_id,
                                  client_secret,
                                  resource_ids,
                                  scope,
                                  authorized_grant_types,
                                  web_server_redirect_uri,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity,
                                  additional_information,
                                  autoapprove)
     VALUES ('clientId',
             '$2a$10$f47G/Xv1i70BYerfdeWxguYCJDDgYQBuazFwK5TAadcj5BKlGCNJ2',
             'resource_server_rest_api',
             'foo,read,write',
             'password,authorization_code,refresh_token',
             NULL,
             'ADMIN',
             36000,
             36000,
             NULL,
             TRUE);
            
 /* james passowrd : jmsPWD */             
INSERT INTO oauth_users (id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
        VALUES (  1,
                  'james',
                  '$2a$10$6Ma.GWHneStxnAz/ktuGgex/oU2fvEit3L3Cih3i93RUMI8Mt2.O2', FALSE, FALSE, FALSE, TRUE);
              
              
 /* matthew passowrd : mtthwPWD */     
INSERT INTO oauth_users (id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
        VALUES (  2,
                  'matthew',
                  '$2a$10$lQR.gETjhgplcbLOtDrEv.irf8zSjzoW0T1vykBHdsNwTrqnQ6im6', FALSE, FALSE, FALSE, TRUE);

 /* tiago passowrd : tgPWD */     
INSERT INTO oauth_users (id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
        VALUES ( 3 ,
                  'tiago',
                  '$2a$10$H5wwEW8xZVXssRs5svhhp.yhHZl1ApzfxWGP2cZko1PfD.xxNxA.i', FALSE, FALSE, FALSE, TRUE);
              
 /* lucas passowrd : lcsPWD */         
INSERT INTO oauth_users (id, user_name, password, account_expired, account_locked, credentials_expired, enabled)
        VALUES ( 4,
                  'lucas',
                  '$2a$10$PPrf2YTMV50WEyE.w.qUJuNKb3pZ7lf04IbrnrGBB5Ey1D.SDo5bW', FALSE, FALSE, FALSE, TRUE);
                  
                  

INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 1);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 2);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 3);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 4);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 5);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 6);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 7);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 8);
INSERT INTO users_authorities(user_id, authority_id) VALUES (1, 9);

INSERT INTO users_authorities(user_id, authority_id) VALUES (2, 2);
INSERT INTO users_authorities(user_id, authority_id) VALUES (2, 6);

INSERT INTO users_authorities(user_id, authority_id) VALUES (3, 3);
INSERT INTO users_authorities(user_id, authority_id) VALUES (3, 7);

INSERT INTO users_authorities(user_id, authority_id) VALUES (4, 10);
 

INSERT INTO oauth_authority(id, name) VALUES (1, 'CREATE');
INSERT INTO oauth_authority(id, name) VALUES (2, 'READ');
INSERT INTO oauth_authority(id, name) VALUES (3, 'UPDATE');
INSERT INTO oauth_authority(id, name) VALUES (4, 'DELETE');

INSERT INTO oauth_authority(id, name) VALUES (5, 'USER');
INSERT INTO oauth_authority(id, name) VALUES (6, 'DEVELOPER');
INSERT INTO oauth_authority(id, name) VALUES (7, 'ARCHITECT');
INSERT INTO oauth_authority(id, name) VALUES (8, 'MANAGER');

INSERT INTO oauth_authority(id, name) VALUES (9, 'DIRECTOR');
INSERT INTO oauth_authority(id, name) VALUES (10, 'ADMIN');