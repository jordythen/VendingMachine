/*- - - - - - - - Add sample data to tables - - - - - - - -*/

------------------- insert snacktypes -----------------
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



------------------- insert sample users -----------------
INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Cookie', 'Monster', 'cmonster@email.com', 'cmonster', 'c123', 100.00);
    
INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Joe', 'Smith', 'jsmith@email.com', 'jsmith', 'j123', 50.00);

INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Alex', 'Patton', 'AlexPatton@email.com', 'apatton', 'pass', 500.00);

INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Dustin', 'Dwyer', 'DustinDwyer@email.com', 'ddwyer', 'pass', 500.00);

INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Jordy', 'Then', 'JordyThen@email.com', 'jthen', 'pass', 500.00);

INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Michael', 'Mead', 'MichaelMead@email.com', 'mmead', 'pass', 500.00);
    
INSERT INTO usertable (id, first_name, last_name, email, username, passwd, balance)
    VALUES (user_seq.nextval, 'Ryan', 'Gerold', 'RyanGerold@email.com', 'rgerold', 'pass', 500.00);

------------------- insert sample vending machines -----------------
INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Monster Cookie Machine', 'The best cookies for a monster.', 'Cookies', '8E44AD', '85C1E9');

INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Joes Candybar Machine', 'A wide selection of candybars.', 'Candybars', 'F39C12', '85929E');

INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Alex Vending Machine', 'Owned by Alex', 'Misc', '8E44AD', '85C1E9');
    
INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Dustin Vending Machine', 'Owned by Dustin', 'Misc', '8E44AD', '85C1E9');

INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Jordy Vending Machine', 'Owned by Jordy', 'Misc', '8E44AD', '85C1E9');
    
INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Michael Vending Machine', 'Owned by Michael', 'Misc', '8E44AD', '85C1E9');
    
INSERT INTO vendingmachine (id, vending_name, descript, theme, main_color, secondary_color)
    VALUES (vendingmachine_seq.nextval, 'Ryan Vending Machine', 'Owned by Ryan', 'Misc', '8E44AD', '85C1E9');
    
--------------------------connect user and vending machine-----------------------------
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (1,1);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (2,2);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (3,3);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (4,4);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (5,5);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (6,6);
INSERT INTO user_vendingmachine (user_id, vendingmachine_id) values (7,7);




------------------- insert sample snacks -----------------
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Small Cookie', 'This cookie is bite sized.', 1.25, 100, 110, 120, 130, 1, 10);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Medium Cookie', 'The average cookie.', 2.50, 100, 110, 120, 130, 0 , 20);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Large Cookie', 'The best cookie.', 5.99, 100, 110, 120, 130, 0 , 5);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'KitKat', 'KitKat Bar', 1.99, 100, 110, 120, 130, 0 , 25);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snickers', 'Large Snickers Bar', 1.99, 100, 110, 120, 130, 0 , 15);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 1', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 2', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 3', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 4', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 5', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 6', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 7', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 8', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);
    
INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 9', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);

INSERT INTO snack (id, snack_name, snack_desc, snack_cost, total_fat, total_carbs, sodium, cholesterol, ishidden, quantity )
    VALUES (snack_seq.nextval, 'Snack 10', 'Desc of Snack 1', 1.99, 100, 110, 120, 130, 0 , 15);

------------------- connect snacks with snacktypes -----------------
INSERT INTO snack_snacktype (snackid, typeid) VALUES (1, 11);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (2, 11);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (3, 11);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (4, 10);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (5, 10);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (6, 1);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (7, 2);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (8, 3);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (9, 4);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (10, 5);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (11, 6);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (12, 7);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (13, 8);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (14, 9);
INSERT INTO snack_snacktype (snackid, typeid) VALUES (15, 10);

-------------------------- connect snacks with vendingmachines ------------------------------------
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(1,1);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(2,1);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(3,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(4,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(5,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(6,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(7,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(8,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(9,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(10,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(11,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(12,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(13,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(14,2);
INSERT INTO snack_vendingmachine (snack_id, vendingmachine_id) values(15,2);

------------------- insert sample reviews -----------------
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

/*- - - - - - - - Commit - - - - - - - -*/
COMMIT;
