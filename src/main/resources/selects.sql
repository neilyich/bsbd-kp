select * from accounts where login = ? and password = crypt(?, password);

select o.id as order_id, o.status as order_status, o.type as order_type, o.cost as order_cost, o.completion_date,
       e.first_name as employee_first_name, e.second_name as employee_second_name, e.patronymic as employee_patronymic, e.employee_role,
       sp.city as service_point_city, sp.address as service_point_address,
       c.phone_number as customer_phone_number, c.name as customer_name, c.address as customer_address
    from orders o
        left outer join employees e on o.assigned_employee_id = e.id
        left outer join service_points sp on e.service_point_id = sp.id
        left outer join customers c on o.customer_id = c.id
    where o.id = ?;

select o.id as order_id, o.status as order_status, o.type as order_type, o.cost as order_cost, o.completion_date,
       e.first_name as employee_first_name, e.second_name as employee_second_name, e.patronymic as employee_patronymic, e.employee_role
    from orders o
        left outer join customers c on o.customer_id = c.id
        left outer join employees e on o.assigned_employee_id = e.id
    where c.id = ?
        order by o.id desc;

select coalesce(max(ot.end_date), now())
    from order_transportations ot
        left outer join transports t on ot.transport_id = t.id
    where t.id = ?;

select c.*
    from orders o
        left outer join customers c on o.customer_id = c.id
    where o.id = ?;

select o, c
    from orders o
        left outer join customers c on o.customer_id = c.id
    where o.assigned_employee_id = ?;

select (select c from customers c where c.id = o.customer_id),
       sum(o.cost) as total_price,
       count(o.id) as orders_count
    from orders o
        where o.customer_id = 1
            group by o.customer_id;
