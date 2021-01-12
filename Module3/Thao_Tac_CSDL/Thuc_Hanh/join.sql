use classicmodels;

select customers.customerNumber, customerName, phone, paymentDate, amount from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas';

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers
left join orders
on customers.customerNumber = orders.customerNumber ;

SELECT 
    customers.customerNumber,
    customers.customerName,
    orders.orderNumber,
    orders.status
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
WHERE
    orderNumber IS NULL;