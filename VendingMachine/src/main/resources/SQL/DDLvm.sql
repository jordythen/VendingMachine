drop table USERTABLE cascade constraints;
drop table VENDINGMACHINE cascade constraints;
drop table REVIEW cascade constraints;
drop table SNACK cascade constraints;
drop table SNACKTYPE cascade constraints;
drop table SNACKOFFER cascade constraints;
drop table SNACK_SNACKTYPE cascade constraints;
drop table OFFER cascade constraints;
drop table ORDERTABLE cascade constraints;

create table USERTABLE (
    id number(10) not null,
    first_name varchar2(30),
    last_name varchar2(30),
    email varchar2(30),
    username varchar2(30) unique,
    passwd varchar2(30),
    balance number(5,2),
    vendingmachineID number(10),
    
    
    constraint PK_USERTABLE primary key(id),
    constraint FK_USERTABLE_VENDINGMACHINE foreign key (vendingmachineID) references VENDINGMACHINE(id)

);

create table VENDINGMACHINE (
    id number(10) not null,
    vending_name varchar2(30),
    descript varchar2(50),
    theme varchar2(30),
    main_color varchar2(30),
    secondary_color varchar2(30),
    
    constraint PK_VENDINGMACHINE primary key(id)
);

create table REVIEW (
    id number(10) not null,
    authorID number(10),
    vendingmachineID number(10),
    rating number(1),
    comments varchar(50),
    reviewTime timestamp,
    
    constraint PK_REVIEW primary key(id),
    foreign key (authorID) references usertable(id),
    foreign key (vendingmachineID) references vendingmachine(id)
);
alter table review modify reviewTime varchar2(30);

create table SNACK(
    id number(10) not null,
    snack_name varchar(30),
    snack_desc varchar(50),
    snack_cost number(5,2),
    
    vendingmachineID number(10),
    
    total_fat number(30),
    total_carbs number(30),
    sodium number(30),
    cholesterol number(30),
    
    constraint PK_SNACK primary key(id),
    foreign key (vendingmachineID) references vendingmachine(id)
);

alter table snack add isHidden char(1);
alter table snack add quantity number(5);

--many snacks can have many types
create table SNACKTYPE(
    id number(10) not null,
    snackid number(10),
    snacktype varchar2(30),
    
    constraint PK_SNACKTYPE primary key(id),
    foreign key (snackid) references SNACK(id)
);

--many to many table
create table SNACK_SNACKTYPE(
    id number(10) not null,
    snackid number(10),
    typeid number(10),

    constraint PK_SNACK_SNACKTYPE primary key(id),
    foreign key (snackid) references SNACK(id),
    foreign key (typeid) references SNACKTYPE(id)

);

--ONE TO MANY TABLE FOR OFFERS
create table OFFER(
    id number(10) not null,
    authorID number(10),
    vendingmachineID number(10),
    statusType varchar2(30),
    
    constraint PK_OFFER primary key(id),
    foreign key (authorID) references usertable(id),
    foreign key (vendingmachineID) references vendingmachine(id)
    
);

alter table offer add timeOfferWasMade varchar2(30);
alter table offer modify statusType number(5);

-- Everytime user makes an offer
-- it's going to insert ONE row into the offer table
-- also insert multiple/one row into the OFFER_SNACK table
create table SNACKOFFER(
    id number(10) not null,
    offerID number(10),
    snacksOfInterestID number(10),
    snacksToOfferID number(10),
    
    constraint PK_OFFER_SNACK primary key(id),
    foreign key (offerID) references OFFER(id),
    foreign key (snacksOfInterestID) references SNACK(id),
    foreign key (snacksToOfferID) references SNACK(id)
);

create table ORDERTABLE(
    id number(10) not null,
    authorID number(10),
    vendingmachineID number(10),
    tax number(5,2),
    orderTotal number(5,2),
    orderTime timestamp,
    
    
    constraint PK_ORDERTABLE primary key(id),
    foreign key (authorID) references usertable(id),
    foreign key (vendingmachineID) references vendingmachine(id)
);

alter table ordertable modify orderTime varchar2(30);


















