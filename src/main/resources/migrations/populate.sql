USE cdpr_test_db;

INSERT INTO game (id, name, description, price, currency)
VALUES
    (1, 'Witcher 1', 'Witcher 1 desc', 19.99, 'PLN'),
    (2, 'Witcher 2', 'Witcher 2 desc', 29.99, 'PLN'),
    (3, 'Witcher 3', 'Witcher 3 desc', 39.99, 'PLN'),
    (4, 'Cyberpunk 2077', 'Cyberpunk 2077 desc', 99.99, 'PLN'),
    (5, 'Gwent', 'Gwent desc', 29.99, 'PLN');

INSERT INTO admin (id, username, password)
VALUES
    (1, 'admin', 'admin');
