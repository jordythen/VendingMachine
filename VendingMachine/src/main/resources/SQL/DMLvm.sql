/*- - - - - - - - Add sample data to tables - - - - - - - -*/

-- ----------------- insert sample users -----------------

INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Cookie', 'Monster', 'cmonster@email.com', 'cmonster', 'c123', 100.00);
    
INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Joe', 'Smith', 'jsmith@email.com', 'jsmith', 'j123', 50.00);

-- ----------------- insert sample vending machines -----------------
/*
INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (1, 'Monster Cookie Machine', 'The best cookies for a monster.', 'Cookies', '8E44AD', '85C1E9');

UPDATE usertable SET vendingmachineid = 1 WHERE id = 1;

INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (2, 'Joes Candybar Machine', 'A wide selection of candybars.', 'Candybars', 'F39C12', '85929E');

UPDATE usertable SET vendingmachineid = 2 WHERE id = 2;

-- ----------------- insert sample snacks -----------------

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, vendingmachineid, quantity )
    VALUES (1, 'Small Cookie', 'This cookie is bite sized.', 1.25, 1, 10);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, vendingmachineid, quantity )
    VALUES (2, 'Medium Cookie', 'The average cookie.', 2.50, 1, 20);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, vendingmachineid, quantity )
    VALUES (3, 'Large Cookie', 'The best cookie.', 5.99, 1, 5);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, vendingmachineid, quantity )
    VALUES (4, 'KitKat', 'KitKat Bar', 1.99, 2, 25);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, vendingmachineid, quantity )
    VALUES (5, 'Snickers', 'Large Snickers Bar', 1.99, 2, 15);

-- ----------------- insert sample snacktypes -----------------
*/
INSERT INTO snacktype (id,  snacktype)
    VALUES (1,  'DRIED_FRUIT');
INSERT INTO snacktype (id,  snacktype)
    VALUES (2,  'NUTS');
INSERT INTO snacktype (id,  snacktype)
    VALUES (3,  'CHIPS');
INSERT INTO snacktype (id,  snacktype)
    VALUES (4,  'CHOCOLATE');
INSERT INTO snacktype (id,  snacktype)
    VALUES (5,  'CHEESE');
INSERT INTO snacktype (id,  snacktype)
    VALUES (6,  'CRACKERS');
INSERT INTO snacktype (id,  snacktype)
    VALUES (7,  'TRAIL_MIX');
INSERT INTO snacktype (id,  snacktype)
    VALUES (8,  'YOGURT');
INSERT INTO snacktype (id,  snacktype)
    VALUES (9,  'JERKY');
INSERT INTO snacktype (id,  snacktype)
    VALUES (10,  'CANDY');
INSERT INTO snacktype (id,  snacktype)
    VALUES (11,  'COOKIES');
INSERT INTO snacktype (id, snacktype)
    VALUES (12,  'PRETZELS');
INSERT INTO snacktype (id,  snacktype)
    VALUES (13,  'FRUIT_CANDY');
INSERT INTO snacktype (id,  snacktype)
    VALUES (14,  'PROTEIN_BAR');
INSERT INTO snacktype (id,  snacktype)
    VALUES (15,  'CEREAL_BAR');
INSERT INTO snacktype (id,  snacktype)
    VALUES (16,  'OTHER');

-- ----------------- insert sample snack-snacktypes -----------------
/*
INSERT INTO snack_snacktype (id, snackid, typeid)
    VALUES (1, 1, 11);
INSERT INTO snack_snacktype (id, snackid, typeid)
    VALUES (2, 2, 11);
INSERT INTO snack_snacktype (id, snackid, typeid)
    VALUES (3, 3, 11);
INSERT INTO snack_snacktype (id, snackid, typeid)
    VALUES (4, 4, 10);
INSERT INTO snack_snacktype (id, snackid, typeid)
    VALUES (5, 5, 10);
*/
/*- - - - - - - - Make it so - - - - - - - -*/
COMMIT;
