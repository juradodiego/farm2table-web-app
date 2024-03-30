DROP SCHEMA IF EXISTS farm2table CASCADE;
CREATE SCHEMA farm2table;
SET SCHEMA 'farm2table';

-------------------------------------------
-- Farm
-------------------------------------------
drop table if exists farm CASCADE;
create table farm (
  farmId integer,
  farmName varchar(30) not null,
  latitude real not null,
  longitude real not null,
  constraint farm_pk primary key (farmId)
);

-------------------------------------------
-- User
-------------------------------------------
drop table if exists users CASCADE;
create table users (
  user_id integer,
  fName text,
  lName text,
  farmId integer,
  consumer boolean not null,
  email text not null unique,
  salt integer,
  password text not null,
  constraint user_pk primary key (user_id)
  -- constraint user_farm_fk foreign key (farmId) references farm(farmId)
);

-------------------------------------------
-- produce
-------------------------------------------
-- drop table if exists produce CASCADE;
-- create table produce (
--   produceId integer,
--   name varchar(30) not null,
--   constraint produce_pk primary key (produceId)
-- );

-------------------------------------------
-- has_produce
-------------------------------------------
-- drop table if exists selling CASCADE;
-- create table selling (
--   produceId integer,
--   farmerId integer not null,
--   constraint selling_pk primary key (produceId, farmerId),
--   constraint selling_produce_fk foreign key (produceId) references produce(produceId),
--   constraint selling_farmer_fk foreign key (farmerId) references users(userId)
-- );

-------------------------------------------
-- chat
-------------------------------------------
-- drop table if exists chat CASCADE;
-- create table chat (
--   chatId integer,
--   customerId integer not null,
--   farmerId integer not null,
--   constraint chat_pk primary key (chatId),
--   constraint chat_customer_fk foreign key (customerId) references users(userId),
--   constraint chat_farmer_fk foreign key (farmerId) references users(userId)
-- );

-------------------------------------------
-- messages
-------------------------------------------
-- drop table if exists messages CASCADE;
-- create table messages (
--   messageId integer,
--   chatId integer,
--   senderId integer not null,
--   content text,
--   sentAt timestamp not null,
--   constraint messages_pk primary key (messageId, chatId),
--   constraint messages_sender_fk foreign key (senderId) references users(userId),
--   constraint messages_chat_fk foreign key (chatId) references chat(chatId)
-- );

-------------------------------------------
-- cart
-------------------------------------------
-- drop table if exists cart CASCADE;
-- create table cart (
--   cartId integer,
--   farmId integer,
--   customerId integer,
--   farmerId integer,
--   chatId integer,
--   content text not null,
--   approvedByFarmer boolean,
--   approvedByUser boolean,
--   constraint cart_pk primary key (cartId),
--   constraint cart_customer_fk foreign key (customerId) references users(userId),
--   constraint cart_chat_fk foreign key (chatId) references chat(chatId),
--   constraint cart_farm_fk foreign key (farmerId) references farm(farmId)
-- );

-------------------------------------------
-- contains
-------------------------------------------
-- drop table if exists contains CASCADE;
-- create table contains (
--   cartId integer,
--   produceId integer,
--   quantity integer not null,
--   price real not null,
--   constraint contains_pk primary key (cartId, produceId),
--   constraint contains_cart_fk foreign key (cartId) references cart(cartId),
--   constraint contains_produce_fk foreign key (produceId) references produce(produceId)
-- );


-------------------------------------------
-- USER FUNCTIONALITY
-------------------------------------------
-- CREATE FUNCTION test()
-- RETURNS void AS $$
-- BEGIN
--     -- Function body goes here
--     -- You can include SQL statements, control structures, etc.
-- END;
-- $$ LANGUAGE plpgsql;



-------------------------------------------
-- getUser(username)
-------------------------------------------
-- CREATE OR REPLACE FUNCTION getUserByUsername(uname TEXT)
-- RETURNS void
-- AS $$
-- -- DECLARE
-- --     result_row users%ROWTYPE;
-- BEGIN
--     -- SELECT * INTO result_row FROM farm2table.users WHERE email = uname;
--     -- RETURN result_row;
-- END;
-- $$ LANGUAGE plpgsql;


-- -------------------------------------------
-- -- getUser(userid)
-- -------------------------------------------
-- create or replace function getUserByUserId(uid int)
--     returns record as
--     $$
--     begin
--         return (select * from farm2table.users where users.userId = uid);
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- getUser(user_id integer,
-- --   farm_id,
-- --   address_line,
-- --   city,
-- --   state,
-- --   zipcode,
-- --   consumer,
-- --   email,
-- --   salt ,
-- --   password)
-- -------------------------------------------
-- create or replace function newUser(userId integer,farmId integer,addressLine varchar(60),city varchar(30),state varchar(2),zipcode int,
--   consumer boolean,email varchar(60),salt integer,password text)
--     returns boolean as
--     $$
--     declare
--         row_count_before int;
--         row_count_after int;
--     begin
--         select count(*) into row_count_before from users;
--         insert into farm2table.users(values(userId, farmId, addressLine, city, state,
--                                             zipcode, consumer, email, salt, password));
--         select count(*) into row_count_after from users;
--         if row_count_after != row_count_before then
--             return true;
--         else
--             return false;
--         end if;
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- CHAT FUNCTIONALITY
-- -------------------------------------------

-- -------------------------------------------
-- -- getChat(c_id, f_id)
-- -------------------------------------------
-- create or replace function getChat(cid int, fid int)
--     returns record as
--     $$
--     begin
--         return (select * from farm2table.chat where chat.customerId = cid and chat.farmerId = fid);
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- getLatest(cid, t)
-- -------------------------------------------
-- create or replace function getLatestMessages(cid integer, t timestamp)
--     returns table(messageId integer,
--     chatId integer,
--     senderId integer,
--     content text,
--     sentAt timestamp) as
--     $$
--     begin
--         return (select * from farm2table.messages where messages.chatId = cid and messages.sentAt >= t);
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- sendMessage(mid, cid, sid, content, sat)
-- -------------------------------------------
-- create or replace function sendMessage(mid integer, cid integer,sid integer,content text,sat timestamp)
--     returns boolean as
--     $$
--     declare
--         row_count_before int;
--         row_count_after int;
--     begin
--          select count(*) into row_count_before from messages;
--          insert into farm2table.messages(values(mid, cid, sid, content, sat));
--          select count(*) into row_count_after from messages;
--          if row_count_after != row_count_before then
--             return true;
--         else
--             return false;
--         end if;
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- getAllChats(uid)
-- -------------------------------------------
-- create or replace function getAllChats(uid integer)
--     returns table(chatId integer,
--     customerId integer,
--     farmerId integer) as
--     $$
--     declare
--         c boolean;
--     begin
--         select consumer into c from farm2table.users where userid = uid;
--         if c = True then
--             return (select * from farm2table.chat where chat.customerid = uid);
--         else
--             return (select * from farm2table.chat where chat.farmerid = uid);
--         end if;
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- CART FUNCTIONALITY
-- -------------------------------------------

-- -------------------------------------------
-- -- getCart(c_id, f_id)
-- -------------------------------------------
-- create or replace function getChat(cid int)
--     returns record as
--     $$
--     begin
--         return (select * from farm2table.cart where cart.cartid = cid);
--     end;
--     $$
--     language plpgsql;

-- -------------------------------------------
-- -- setCart(mid, cid, sid, content, sat)
-- -------------------------------------------
-- -- create or replace function setCart(cartId integer,farmId integer,customerId integer,farmerId integer,
-- -- chatId integer,content text,approvedByFarmer boolean,approvedByUser boolean)
-- --     returns boolean as
-- --     $$
-- --     declare
-- --         row_count_before int;
-- --         row_count_after int;
-- --     begin
-- --          select count(*) into row_count_before from messages;
-- --          insert into farm2table.messages(values(mid, cid, sid, content, sat));
-- --          select count(*) into row_count_after from messages;
-- --          if row_count_after != row_count_before then
-- --             return true;
-- --         else
-- --             return false;
-- --         end if;
-- --     end;
-- --     $$
-- --     language plpgsql;