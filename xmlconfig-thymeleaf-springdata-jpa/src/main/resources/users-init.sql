INSERT INTO USER (USER_ID, username, email, password, enabled, accountExpired, accountLocked, credentialsExpired) VALUES (0, 'root', 'root@example.org', '$2a$10$//HU8yTgOoLrZX6z9cgXhuR/IJki.BtS/ZM4Pr8s/zBDCFIT.I3P6', true, false, false, false);
INSERT INTO USER (USER_ID, username, email, password, enabled, accountExpired, accountLocked, credentialsExpired) VALUES (1, 'user', 'user@example.org', '$2a$10$qspi.NK1570DsUrvDmxETekRTqpk/ZY2hmI3XCMER.RWPVlPAfpYK', true, false, false, false);

INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_ADMIN');
INSERT INTO USER_ROLES (user, role) VALUES(1, 'ROLE_USER');