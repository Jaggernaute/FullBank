create table account_type
(
    type varchar(23) null,
    id   int auto_increment
        primary key
);

create table card
(
    expiration_date date null,
    pin             int  null,
    CVV             int  null,
    card_number     int  null,
    id              int auto_increment
        primary key
);

create table staff_role
(
    role varchar(23) null,
    id   int auto_increment
        primary key
);

create table staff
(
    role  int          null,
    mail  varchar(100) null,
    phone varchar(10)  null,
    fname varchar(23)  null,
    name  varchar(23)  null,
    id    int auto_increment
        primary key,
    constraint staff_staff_role_id_fk
        foreign key (role) references staff_role (id)
);

create table terminal_type
(
    type varchar(23) null,
    id   int auto_increment
        primary key
);

create table terminal
(
    type    int         null,
    address varchar(80) null,
    city    varchar(23) null,
    id      int auto_increment
        primary key,
    constraint terminal_terminal_type_id_fk
        foreign key (type) references terminal_type (id)
);

create table user
(
    advisor  int          null,
    password varchar(80)  null,
    email    varchar(100) null,
    phone    varchar(10)  null,
    fname    varchar(23)  null,
    name     varchar(23)  null,
    id       int auto_increment
        primary key,
    constraint user_staff_id_fk
        foreign key (advisor) references staff (id)
);

create table account
(
    card    int         null,
    user_id int         null,
    balance int         null,
    IBAN    varchar(32) null,
    type    int         null,
    id      int auto_increment
        primary key,
    constraint account_account_type_id_fk
        foreign key (type) references account_type (id),
    constraint account_card_id_fk
        foreign key (card) references card (id),
    constraint account_user_id_fk
        foreign key (user_id) references user (id)
);

create table operations
(
    terminal int null,
    account  int null,
    type     int null,
    id       int auto_increment
        primary key,
    constraint operations_account_id_fk
        foreign key (account) references account (id),
    constraint operations_terminal_id_fk
        foreign key (terminal) references terminal (id)
);

create table transfer
(
    amount int null,
    `to`   int null,
    `from` int null,
    id     int auto_increment
        primary key,
    constraint transfer_account_id_fk
        foreign key (`from`) references account (id),
    constraint transfer_account_id_fk_2
        foreign key (`to`) references account (id)
);


