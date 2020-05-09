#Below are the answers for all 5 questions like #a indicates answer for first querstion

#a
select c.customerName from customers as c 
inner join employees as e on c.salesRepEmployeeNumber=e.employeeNumber
inner join offices as o on e.officeCode=o.officeCode
where c.city not like o.city;

#b
select o.orderNumber,o.productCode,o.priceEach,p.productName,p.MSRP from orderdetails as o
inner join products as p on o.productCode=p.productCode
where o.priceEach < p.MSRP
group by o.productCode;

#c
select p.productCode,p.productName,avg(((od.priceEach-p.buyPrice)/p.buyPrice)*100) as Mark_up_Percentage
    from 
    orders as o
    inner join orderdetails as od on o.orderNumber=od.orderNumber
    inner join products as p on od.productCode=p.productCode
    where extract(year from o.orderDate) = 2004
    group by p.productCode
    order by Mark_up_percentage Desc
    limit 5;
    
#d
select  a.emp , a.fName,a.sName, avg(a.avgdiv) as AverageDiversity from 
(SELECT employees.employeeNumber as emp, employees.firstName as fName, employees.lastName as sName,  count(distinct(orderdetails.productCode)) as avgdiv FROM employees
Inner Join customers on customers.salesRepEmployeeNumber = employees.employeeNumber
Inner join orders on orders.customerNumber = customers.customerNumber
Inner join orderdetails on orderdetails.orderNumber = orders.orderNumber
group by orderdetails.orderNumber
order by avgdiv desc
) a  group by a.emp order by AverageDiversity desc limit 3;

#e
select off.officeCode,off.city,avg(DATEDIFF(o.shippedDate, o.orderDate)) as average_time
from orders as o
inner join customers as c on o.customerNumber=c.customerNumber
inner join employees as e on c.salesRepEmployeeNumber=e.employeeNumber
inner join offices as off on e.officeCode=off.officeCode
where extract(year from o.orderDate) = 2005
group by off.city
order by off.officeCode asc;



