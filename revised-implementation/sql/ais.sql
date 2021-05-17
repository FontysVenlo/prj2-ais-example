begin work;
drop table if exists customers cascade;
create table customers(
       customerid serial primary key,
       name text,
       dateofbirth date,
       since timestamp not null default now()::timestamp
);

commit;
