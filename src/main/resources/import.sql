INSERT INTO user_role (id, role) VALUES (1,'admin');
INSERT INTO user_role (id, role) VALUES (2,'member');

INSERT INTO coworking_user (description, age, password, email, lastname, firstname, id)
VALUES ('student',55, 'smallMichi123','M.Michersen@bluewin.com','Michi', 'Michersen', 1);

INSERT INTO coworking_user (description, age, password, email, lastname, firstname, id)
VALUES ('-', 23, 'Manuuu123','manu44@gmail.com','Borli', 'Manuel', 2);

INSERT INTO coworking_user (description, age, password, email, lastname, firstname, id)
VALUES ('-', 30, 'svenny','S.Svenson@.com','Sven', 'Svenson', 3);

-- INSERT INTO booking (title, startDate, halfDay, endDate, description, Status, id)
-- VALUES ('mr', '2023-11-10', TRUE, '2023-11-10','keine', ACCEPTED, 1);

-- INSERT INTO booking (title, startDate, halfDay, endDate, description, Status, id)
-- VALUES ('mr', '2023-11-10', TRUE, '2023-11-10','keine', ACCEPTED, 2);

INSERT INTO room (title, free,id)
VALUES ('Jupiter', TRUE, 1);

INSERT INTO room (title, free,id)
VALUES ('Uranus', FALSE, 2);

INSERT INTO room (title, free,id)
VALUES ('Mars', TRUE, 3);

INSERT INTO canteen (Price, name, id)
VALUES (1.5, 'Antigua und Barbuda', 1);

INSERT INTO canteen (Price, name, id)
VALUES (5.5, 'Salomonen', 2);

INSERT INTO canteen (Price, name, id)
VALUES (4.5, 'Nauru', 3);

-- INSERT INTO canteen_user (snack_idfs, user_idfs)
-- VALUES (1, 2);

-- INSERT INTO canteen_user (snack_idfs, user_idfs)
-- VALUES (2, 3);