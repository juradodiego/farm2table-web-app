set schema 'farm2table';

-------------------------------------------
-- USER FUNCTIONALITY
-------------------------------------------

-------------------------------------------
-- getUser(username)
-------------------------------------------
create or replace function getUserByUsername(uname varchar(40))
    returns record as
    $$
    begin
        return (select * from farm2table.users where users.email = uname);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getUser(userid)
-------------------------------------------
create or replace function getUserByUserId(uid int)
    returns record as
    $$
    begin
        return (select * from farm2table.users where users.userId = uid);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getUser(user_id integer,
--   farm_id,
--   address_line,
--   city,
--   state,
--   zipcode,
--   consumer,
--   email,
--   salt ,
--   password)
-------------------------------------------
create or replace function newUser(userId integer,
  farmId integer,
  addressLine varchar(60),
  city varchar(30),
  state varchar(2),
  zipcode int,
  consumer boolean,
  email varchar(60),
  salt integer,
  password text)
    returns boolean as
    $$
    declare
        row_count_before int;
        row_count_after int;
    begin
        select count(*) into row_count_before from users;
        insert into farm2table.users(values(userId, farmId, addressLine, city, state,
                                            zipcode, consumer, email, salt, password));
        if row_count_after != row_count_before then
            return true;
        else
            return false;
        end if;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- CHAT FUNCTIONALITY
-------------------------------------------

-------------------------------------------
-- getChat(c_id, f_id)
-------------------------------------------
create or replace function getChat(cid int, fid int)
    returns record as
    $$
    begin
        return (select * from farm2table.chat where chat.customerId = cid and chat.farmerId = fid);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getLatest(c_id, time)
-------------------------------------------
-- create or replace function getChat(c_id int, time timestamp)
--     returns record as
--     $$
--     begin
--         return (select * from farm2table.chat where chat.customer_id = c_id and chat.farmer_id = f_id);
--     end;
--     $$
--     language plpgsql;