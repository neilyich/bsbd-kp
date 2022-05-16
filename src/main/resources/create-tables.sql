create table service_points
(
    id      serial primary key,
    address varchar(255) not null,
    city    varchar(50) not null
);

create table employees
(
    id                 serial primary key,
    first_name         varchar(50) not null,
    second_name        varchar(50) not null,
    patronymic         varchar(50) not null,
    employee_role      varchar(50) not null,
    has_driver_license bool not null,
    service_point_id   integer
        constraint service_point_fk
            references service_points
);

create table customers
(
    id           serial primary key,
    phone_number varchar(20) not null,
    address      varchar(255),
    name         varchar(50)
);

create table orders
(
    id                   bigserial primary key,
    completion_date      timestamp not null,
    cost                 numeric(19, 2) not null,
    status               varchar(20) not null,
    type                 varchar(20) not null,
    assigned_employee_id integer
        constraint assigned_employee_fk
            references employees,
    customer_id          integer
        constraint customer_id_fk
            references customers
);

create table transports
(
    id                  serial primary key,
    registration_number varchar(255) not null unique
);

create table order_transportations
(
    id                   serial primary key,
    end_date             timestamp not null,
    start_date           timestamp not null,
    transportation_type  varchar(50) not null,
    assigned_employee_id integer
        constraint driving_employee_id_fk
            references employees,
    order_id       bigint
        constraint order_fk
            references orders,
    transport_id   integer
        constraint transport_fk
            references transports
);

create table accounts
(
    login        varchar(50)
        constraint accounts_pk
            primary key,
    password     varchar(255) not null,
    account_type varchar(20)  not null,
    account_role varchar(20)  not null,
    reference_id int          not null
);