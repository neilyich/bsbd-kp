create extension pgcrypto;

-- service_points
insert into service_points (address, city)
                    values ('ул. Необычная, д. 21', 'Москва');

select * from service_points where lower(city) = lower(?);

select * from service_points;

--employees
insert into employees (first_name, patronymic, second_name, employee_role, service_point_id, has_driver_license)
               values ('Петр', 'Петрович', 'Петров', 'ACCEPTOR_TRANSPORT_MANAGER', 1, true);

select * from employees;

-- accounts
insert into accounts (login, password, account_type, account_role, reference_id)
values ('arkadiy', crypt('qpwoeirut', gen_salt('md5')), 'CUSTOMER', 'CUSTOMER', 2);

insert into accounts (login, password, account_type, account_role, reference_id)
values (?, crypt(?, gen_salt('md5')), ?, ?, ?);

select * from accounts;

select * from accounts where login = 'ivan_ivanov' and password = crypt('123password', password); -- authorization

select * from accounts where login = ? and password = crypt(?, password); -- authorization

-- transports
insert into transports (registration_number)
                values ('c123ay99');

select * from transports;

--customers
insert into customers (phone_number, address, name)
               values ('89164567890', 'ул. Обычная, д. 3', 'Аркадий');

select * from customers;

-- orders
insert into orders (completion_date, cost, status, type, assigned_employee_id, customer_id)
            values (now() + interval '5 days', '7499.90', 'IN_PROGRESS', 'STANDARD', 3, 1);

select * from orders;

--order_transportations
insert into order_transportations (end_date, start_date, transportation_type, assigned_employee_id, order_id, transport_id)
                           values (now() + interval '1 hour', now() + interval '3 hours', 'CUSTOMER_TO_SERVICE_POINT', 2, 1, 1);

select * from order_transportations;