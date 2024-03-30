set schema 'farm2table';

-------------------------------------------
-- USER FUNCTIONALITY
-------------------------------------------

-------------------------------------------
-- getUser(username)
-------------------------------------------
create or replace function getUserByUsername(uname varchar(20))
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
create or replace function getUserByUserId(uid varchar(20))
    returns record as
    $$
    begin
        return (select * from farm2table.users where users.user_id = uid);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getUser(user_id integer,
--   username varchar(20),
--   farm_id integer,
--   address_line varchar(60),
--   city varchar(30),
--   state varchar(2),
--   zipcode int,
--   consumer boolean,
--   email varchar(60),
--   salt integer,
--   password text,
--   farm_name)
-------------------------------------------
create or replace function getUser(user_id integer,
  username varchar(20),
  farm_id integer,
  address_line varchar(60),
  city varchar(30),
  state varchar(2),
  zipcode int,
  consumer boolean,
  email varchar(60),
  salt integer,
  password text,
  farm_name varchar(60))
    returns boolean as
    $$
    declare
        row_count_before int;
        row_count_after int;
    begin
        select count(*) into row_count_before from users;
        insert into farm2table.users(values(user_id, username, farm_id, address_line, city, state,
                                            zipcode, consumer, email, salt, password, farm_name));
        if row_count_after != row_count_before then
            return true;
        else
            return false;
        end if;
    end;
    $$
    language plpgsql;