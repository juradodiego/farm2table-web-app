set schema 'farm2table';

-------------------------------------------
-- USER FUNCTIONALITY
-------------------------------------------

-------------------------------------------
-- getUser(username)
-------------------------------------------
create or replace function getUser(uname varchar(20))
    returns record as
    $$
    begin
        return (select * from farm2table.users where users.username = uname);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getUser(userid)
-------------------------------------------
create or replace function getUser(uid varchar(20))
    returns record as
    $$
    begin
        return (select * from farm2table.users where users.user_id = uid);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getUser(user_id integer,
--   username varchar(20) not null,
--   farm_id integer,
--   address_line varchar(60) not null,
--   city varchar(30) not null,
--   state varchar(2) not null,
--   zipcode int not null,
--   consumer boolean not null,
--   email varchar(60) not null unique,
--   salt integer not null,
--   password text not null,
--   farm_name varchar(60),)
-------------------------------------------
-- create or replace function getUser(uid varchar(20))
--     returns record as
--     $$
--     begin
--         return (select * from farm2table.users where users.user_id = uid);
--     end;
--     $$
--     language plpgsql;