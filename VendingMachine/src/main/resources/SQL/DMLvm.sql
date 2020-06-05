/*- - - - - - - - Add sample data to tables - - - - - - - -*/

-- ----------------- insert sample users -----------------

INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Cookie', 'Monster', 'cmonster@email.com', 'cmonster', 'c123', 100.00);
    
INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Joe', 'Smith', 'jsmith@email.com', 'jsmith', 'j123', 50.00);

-- ----------------- insert sample vending machines -----------------

INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Monster Cookie Machine', 'The best cookies for a monster.', 'Cookies', '#8E44AD', '#85C1E9');

INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Joes Candybar Machine', 'A wide selection of candybars.', 'Candybars', '#F39C12', '#85929E');
    


-- ----------------- insert sample snacks -----------------

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Small Cookie', 'This cookie is bite sized.', 1.25, 100, 110, 120, 130, 1, 10);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Medium Cookie', 'The average cookie.', 2.50,100, 110, 120, 130, 0 , 20);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Large Cookie', 'The best cookie.', 5.99, 100, 110, 120, 130, 0 , 5);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'KitKat', 'KitKat Bar', 1.99, 100, 110, 120, 130, 0 , 25);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snickers', 'Large Snickers Bar', 1.99,100, 110, 120, 130, 0 , 15);

-- ----------------- insert sample snacktypes -----------------

INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'DRIED_FRUIT');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'NUTS');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'CHIPS');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'CHOCOLATE');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'CHEESE');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'CRACKERS');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'TRAIL_MIX');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'YOGURT');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'JERKY');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'CANDY');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'COOKIES');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'PRETZELS');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'FRUIT_CANDY');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'PROTEIN_BAR');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'CEREAL_BAR');
INSERT INTO snacktype (id, snacktype) VALUES (type_seq.nextval,  'OTHER');

-- ----------------- insert sample snack-snacktypes -----------------

INSERT INTO snack_snacktype (snackid, typeid) VALUES ( 1, 11);
INSERT INTO snack_snacktype ( snackid, typeid) VALUES ( 2, 11);
INSERT INTO snack_snacktype ( snackid, typeid) VALUES ( 3, 11);
INSERT INTO snack_snacktype ( snackid, typeid) VALUES ( 4, 10);
INSERT INTO snack_snacktype ( snackid, typeid) VALUES ( 5, 10);

--------------------------connect user and vending machine-----------------------------
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (1,1);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (2,2);

--------------------------connect snacks with users------------------------------------
INSERT INTO snack_vendingmachine (snack_id,vendingmachine_id) values(1,1);
INSERT INTO snack_vendingmachine (snack_id,vendingmachine_id) values(2,1);
INSERT INTO snack_vendingmachine (snack_id,vendingmachine_id) values(3,2);
INSERT INTO snack_vendingmachine (snack_id,vendingmachine_id) values(4,2);
INSERT INTO snack_vendingmachine (snack_id,vendingmachine_id) values(5,2);

-- ----------------- insert sample reviews -----------------

INSERT INTO review (id, vendingmachineid, rating, comments, reviewtime)
    VALUES (review_seq.nextval, 1, 5, 'I like the selection.', '2020-06-03 09:43:14');
INSERT INTO review (id, vendingmachineid, rating, comments, reviewtime)
    VALUES (review_seq.nextval, 1, 3, 'Awesome snacks', '2020-06-03 09:43:14');
INSERT INTO review (id, vendingmachineid, rating, comments, reviewtime)
    VALUES (review_seq.nextval, 1, 4, 'Pretty good!', '2020-06-03 09:43:14');
    
INSERT INTO review (id, vendingmachineid, rating, comments, reviewtime)
    VALUES (review_seq.nextval, 2, 3, 'It is ok.', '2020-06-03 09:43:14');
INSERT INTO review (id, vendingmachineid, rating, comments, reviewtime)
    VALUES (review_seq.nextval, 2, 1, 'Do not like selection', '2020-06-03 09:43:14');
INSERT INTO review (id, vendingmachineid, rating, comments, reviewtime)
    VALUES (review_seq.nextval, 2, 2, 'Meh...', '2020-06-03 09:43:14');

/*- - - - - - - - Make it so - - - - - - - -*/
COMMIT;
