create table if not exists `airplane`
(
    `id`            bigint not null AUTO_INCREMENT,
    `flight_hours`  decimal(19, 2) null,
    `license_plate` varchar(255) null,
    `manufacturer`  varchar(255) null,
    `model`         varchar(255) null,
    constraint UK_AIRPLANE_LICENSE_PLATE unique (`license_plate`),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

create table if not exists `airport`
(
    `id`        bigint not null AUTO_INCREMENT,
    `city`      varchar(255) null,
    `country`   varchar(255) null,
    `iata_code` varchar(255) null,
    `name`      varchar(255) null,
    constraint UK_AIRPORT_IATA_CODE unique (`iata_code`),
    PRIMARY KEY (`id`)

) ENGINE=InnoDB;

create table if not exists`crew_member`
(
    `id`           bigint not null AUTO_INCREMENT,
    `code`         varchar(255) null,
    `last_name`    varchar(255) null,
    `name`         varchar(255) null,
    `company_name` varchar(255) null,
    `role`         varchar(255) null,
    constraint UK_CREW_MEMBER_CODE unique (`code`),
    PRIMARY KEY (`id`)

) ENGINE=InnoDB;

create table if not exists `flight`
(
    `id`                     bigint not null AUTO_INCREMENT,
    `airline`                varchar(255) null,
    `arrival_date`           datetime(6) null,
    `departure_date`         datetime(6) null,
    `flight_code`            varchar(255) null,
    `flight_duration`        float null,
    `airplane_id`            bigint null,
    `destination_airport_id` bigint null,
    `origin_airport_id`      bigint null,
    constraint UK_FLIGHT_FLIGHT_CODE unique (`flight_code`),
    constraint FK_FLIGHT_DESTINATION_AIRPORT_ID foreign key (`destination_airport_id`) references airport (`id`),
    constraint FK_FLIGHT_AIRPLANE_ID foreign key (`airplane_id`) references airplane (`id`),
    constraint FK_FLIGHT_ORIGIN_AIRPORT_ID foreign key (`origin_airport_id`) references airport (`id`),
    PRIMARY KEY (`id`)

) ENGINE=InnoDB;

create table if not exists `crew_member_flight`
(
    `crew_member_id` bigint not null,
    `flight_id`      bigint not null,
    primary key (`crew_member_id`, `flight_id`),
    constraint FK_CREW_MEMBER_FLIGHT_FLIGHT_ID foreign key (`flight_id`) references flight (`id`),
    constraint FK_CREW_MEMBER_FLIGHT_CREW_MEMBER_ID foreign key (`crew_member_id`) references crew_member (`id`)
) ENGINE=InnoDB;

create table if not exists `mechanical_employee`
(
    `id`            bigint not null AUTO_INCREMENT,
    `code`          varchar(255) null,
    `last_name`     varchar(255) null,
    `name`          varchar(255) null,
    `company`       varchar(255) null,
    `education`     varchar(255) null,
    `starting_date` datetime(6) null,
    constraint UK_MECHANICAL_EMPLOYEE_CODE unique (`code`),
    PRIMARY KEY (`id`)

) ENGINE=InnoDB;

create table if not exists `technical_review`
(
    `id`                     bigint not null AUTO_INCREMENT,
    `end_date`               datetime(6) null,
    `review_type`            varchar(255) null,
    `spent_hours_on_review`  int null,
    `start_date`             datetime(6) null,
    `work_description`       varchar(255) null,
    `airport_id`             bigint null,
    `checked_airplane_id`    bigint null,
    `mechanical_employee_id` bigint null,
    constraint FK_TECHNICAL_REVIEW_MECHANICAL_EMPLOYEE_ID foreign key (`mechanical_employee_id`) references mechanical_employee (`id`),
    constraint FK_TECHNICAL_REVIEW_CHECKED_AIRPLANE_ID foreign key (`checked_airplane_id`) references airplane (`id`),
    constraint FK_TECHNICAL_REVIEW_AIRPORT_ID foreign key (`airport_id`) references airport (`id`),
    PRIMARY KEY (`id`)

) ENGINE=InnoDB;

INSERT INTO `airplane` (`flight_hours`, `license_plate`, `manufacturer`, `model`)
VALUES (1000.50, 'LP54125', 'Airbus', 'A380'),
       (200, 'G-ZBJB', 'Boeing', '787-8'),
       (288, 'H-524964', 'Airbus', 'A321-1'),
       (800, 'Q-608909', 'Airbus', '777-300ER');
COMMIT;
INSERT INTO `airport` (`city` , `country`, `iata_code`, `name`)
VALUES ('Madrid', 'Spain', 'MAD', 'Barajas'),
       ('Amsterdam', 'Netherlands', 'AMS', 'Schiphol'),
       ('Ada', 'United states of america', 'ADT', 'Ada Municipal Airport'),
       ('Altenrhein', 'Switzerland', 'ACH', 'St. Gallen–Altenrhein Airport');
COMMIT;
INSERT INTO `crew_member` (`code` , `name`, `last_name`, `role`, `company_name`)
VALUES ('code01', 'John', 'Doe', 'Flight attendant', 'Iberia'),
       ('codeRed', 'Manfred Albrecht', 'von Richthofen', 'Pilot', 'Iberia'),
       ('codeLaugh', 'Alfonso', 'Aragón Sac', 'Fun guy', 'Ryanair'),
       ('codeFam', 'Spike', 'Lee', 'Unimportant famous', 'United Airlines');
COMMIT;
INSERT INTO `flight` (`flight_code` ,`airline`, `airplane_id` , `origin_airport_id`, `destination_airport_id`, `departure_date`, `arrival_date`, `flight_duration`)
VALUES ('UX1094', 'Iberia', 1, 1, 2, '2021-02-06 12:33:53', '2021-02-07 04:08:03.761000', 2.5),
       ('UX1095', 'Iberia', 2, 4, 2, '2021-02-06 12:33:53', '2021-02-07 04:08:03.761000', 2.5),
       ('UX1098', 'Iberia', 3, 2, 4, '2021-02-01 12:33:53', '2021-02-09 04:08:03.761000', 2.5);
COMMIT;
INSERT INTO `crew_member_flight` (`crew_member_id`, `flight_id`)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 1),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 2),
       (4, 3);
COMMIT;
INSERT INTO `mechanical_employee` (`code`, `last_name`, `name`, `company`, `education`, `starting_date`)
VALUES ('EmployeeCodePP', 'Picapiedra', 'Pedro', 'URJC', 'Universidad', '1998-05-08 22:00:00'),
       ('EmployeeCodePM', 'Marmol', 'Pablo', 'UPM', 'Doctorado', '2000-06-09 22:00:00'),
       ('EmployeeCodeVP', 'Picapiedra', 'Vilma', 'UAM', 'Master', '2002-08-11 22:00:00'),
       ('EmployeeCodeBM', 'Marmol', 'Betty', 'UAH', 'Grado superior', '2004-12-15 23:00:00');
COMMIT;
INSERT INTO `technical_review` (`end_date`, `review_type`, `spent_hours_on_review`, `start_date`, `work_description`, `airport_id`, `checked_airplane_id`, `mechanical_employee_id`)
VALUES ('2021-02-11 16:08:04.139000', 'Periodical', 10, '2021-02-11 02:14:44.139000', 'Work description OK', 1, 1, 1),
       ('2021-02-11 16:08:04.139000', 'Wheels', 10, '2021-02-11 02:14:44.139000', 'Work description OK', 2, 2, 1),
       ('2021-02-11 16:08:04.139000', 'Engine', 10, '2021-02-11 02:14:44.139000', 'Work description OK', 4, 1, 2),
       ('2021-02-11 16:08:04.139000', 'TooMany kilometers', 10, '2021-02-11 02:14:44.139000', 'Work description OK', 3, 3, 1),
       ('2021-02-11 16:08:04.139000', 'Paint and spray', 10, '2021-02-11 02:14:44.139000', 'Work description OK', 2, 4, 4),
       ('2021-02-11 16:08:04.139000', 'Lights', 10, '2021-02-11 02:14:44.139000', 'Work description OK', 1, 1, 3);
COMMIT;
