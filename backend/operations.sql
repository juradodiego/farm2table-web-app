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
--   consumer,
--   email,
--   fname
--   lname
--   salt ,
--   password)
-------------------------------------------
create or replace function newUser(userId integer,farmId integer,fname varchar(20), lname varchar(20),
  consumer boolean,email varchar(60),salt integer,password text)
    returns boolean as
    $$
    declare
        row_count_before int;
        row_count_after int;
    begin
        select count(*) into row_count_before from users;
        insert into farm2table.users(values(userId, farmId, fname, lname, consumer, email, salt, password));
        select count(*) into row_count_after from users;
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
-- getLatest(cid, t)
-------------------------------------------
create or replace function getLatestMessages(cid integer, t timestamp)
    returns table(messageId integer,
    chatId integer,
    senderId integer,
    content text,
    sentAt timestamp) as
    $$
    begin
        return (select * from farm2table.messages where messages.chatId = cid and messages.sentAt >= t
                                                  order by sentAt asc);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- sendMessage(mid, cid, sid, content, sat)
-------------------------------------------
create or replace function sendMessage(mid integer, cid integer,sid integer,content text,sat timestamp)
    returns boolean as
    $$
    declare
        row_count_before int;
        row_count_after int;
    begin
         select count(*) into row_count_before from messages;
         insert into farm2table.messages(values(mid, cid, sid, content, sat));
         select count(*) into row_count_after from messages;
         if row_count_after != row_count_before then
            return true;
        else
            return false;
        end if;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- getAllChats(uid)
-------------------------------------------
create or replace function getAllChats(uid integer)
    returns table(chatId integer,
    customerId integer,
    farmerId integer) as
    $$
    declare
        c boolean;
    begin
        select consumer into c from farm2table.users where userid = uid;
        if c = True then
            return (select * from farm2table.chat where chat.customerid = uid);
        else
            return (select * from farm2table.chat where chat.farmerid = uid);
        end if;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- CART FUNCTIONALITY
-------------------------------------------

-------------------------------------------
-- getCart(cid)
-------------------------------------------
create or replace function getChat(cid int)
    returns record as
    $$
    begin
        return (select * from farm2table.cart where cart.cartid = cid);
    end;
    $$
    language plpgsql;

-------------------------------------------
-- setCart(mid, cid, sid, content, sat)
-------------------------------------------
create or replace function setCart(cartId integer,customerId integer,farmerId integer,
chatId integer,approvedByFarmer boolean, approvedByUser boolean, isActive boolean)
    returns boolean as
    $$
    declare
        row_count_before int;
        row_count_after int;
    begin
         select count(*) into row_count_before from farm2table.cart;
         insert into farm2table.messages(values(cartId, customerId, farmerId, chatId, approvedByFarmer,
                                                approvedByUser, isActive));
         select count(*) into row_count_after from farm2table.cart;
         if row_count_after != row_count_before then
            return true;
        else
            return false;
        end if;
    end;
    $$
    language plpgsql;


-------------------------------------------
-- isFarmerApproved(cid)
-------------------------------------------
create or replace function isFarmerApproved(cid integer)
    returns boolean as
    $$
    declare
        toRet boolean;
    begin
        select approvedByFarmer into toRet from farm2table.cart where cartId = cid;
        return toRet;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- setFarmerApproved(cid)
-------------------------------------------
create or replace function setFarmerApproved(cid integer)
    returns void as
    $$
    begin
        update farm2table.cart set approvedByFarmer = True where cartId = cid;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- isCustomerApproved(cid)
-------------------------------------------
create or replace function isCustomerApproved(cid integer)
    returns boolean as
    $$
    declare
        toRet boolean;
    begin
        select approvedByCustomer into toRet from farm2table.cart where cartId = cid;
        return toRet;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- setCustomerApproved(cid)
-------------------------------------------
create or replace function setCustomerApproved(cid integer)
    returns void as
    $$
    begin
        update farm2table.cart set approvedByCustomer = True where cartId = cid;
    end;
    $$
    language plpgsql;

-------------------------------------------
-- PRODUCE FUNCTIONALITY
-------------------------------------------

-------------------------------------------
-- getProduce()
-------------------------------------------
create or replace function getProduce()
    returns table(produceId integer, name varchar(30)) as
    $$
    begin
        return (select * from farm2table.produce);
    end;
    $$
    language plpgsql;
