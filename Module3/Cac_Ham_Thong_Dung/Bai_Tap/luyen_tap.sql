select *
from table
where TEN = "Huong";

select table.TEN , sum(SOTIEN) as "TongTien"
from table
where TEN = "HUONG";
group by TEN;

select table.TEN
from table
group by TEN;


