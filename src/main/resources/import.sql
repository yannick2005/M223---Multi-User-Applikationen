INSERT INTO Role (role) VALUES 
    ("admin"),
    ("member")
;

INSERT INTO ApplicationUser (description, age, password, email, lastname, firstname) VALUES 
    ("student",55, "smallMichi123", "M.Michersen@bluewin.com", "Michi", "Michersen"),
    ("-", 23, "Manuuu123", "manu44@gmail.com", "Borli", "Manuel"),
    ("-", 30, "svenny", "S.Svenson@.com", "Sven", "Svenson")
;

INSERT INTO Booking (title, startDate, halfDay, endDate, description, Status) VALUES 
    ("mr", "2023-11-10", TRUE, "2023-11-10", "none", ACCEPTED),
    ("mr", "2023-11-11", TRUE, "2023-11-11", "none", ACCEPTED),
    ("mrs", "2023-11-10", FALSE, "2023-11-10", "none", DECLINED)
;

INSERT INTO Room (title, free) VALUES
    ("Jupiter", TRUE),
    ("Uranus", FALSE),
    ("Mars", TRUE)
;

INSERT INTO Canteen (price, name) VALUES 
    (1.5, "Antigua und Barbuda"),
    (5.5, "Salomonen"),
    (4.5, "Nauru")
;

/* Initializing doesn't work */