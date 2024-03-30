DROP SCHEMA IF EXISTS farm2table CASCADE;
CREATE SCHEMA farm2table;
SET SCHEMA 'farm2table';

-------------------------------------------
-- Farm
-------------------------------------------
drop table if exists farm CASCADE;
create table farm (
  farmId integer,
  latitude real not null,
  longitude real not null,
  constraint farm_pk primary key (farmId)
);

-------------------------------------------
-- User
-------------------------------------------
drop table if exists users CASCADE;
create table users (
  userId integer,
  farmID integer,
  addressLine varchar(60) not null,
  city varchar(30) not null,
  state varchar(2) not null,
  zipcode int not null,
  consumer boolean not null,
  email varchar(40) not null unique,
  salt integer not null,
  password text not null,
  constraint user_pk primary key (userId),
  constraint user_farm_fk foreign key (farmID) references farm(farmId)
);

-------------------------------------------
-- produce
-------------------------------------------
drop table if exists produce CASCADE;
create table produce (
  produceId integer,
  name varchar(30) not null,
  constraint produce_pk primary key (produceId)
);

-------------------------------------------
-- has_produce
-------------------------------------------
drop table if exists selling CASCADE;
create table selling (
  produceId integer,
  farmerId integer not null,
  constraint selling_pk primary key (produceId, farmerId),
  constraint selling_produce_fk foreign key (produceId) references produce(produceId),
  constraint selling_farmer_fk foreign key (farmerId) references users(userId)
);

-------------------------------------------
-- chat
-------------------------------------------
drop table if exists chat CASCADE;
create table chat (
  chatId integer,
  customerId integer not null,
  farmerId integer not null,
  constraint chat_pk primary key (chatId),
  constraint chat_customer_fk foreign key (customerId) references users(userId),
  constraint chat_farmer_fk foreign key (farmerId) references users(userId)
);

-------------------------------------------
-- messages
-------------------------------------------
drop table if exists messages CASCADE;
create table messages (
  messageId integer,
  chatId integer,
  senderId integer not null,
  content text,
  sentAt timestamp not null,
  constraint messages_pk primary key (messageId),
  constraint messages_sender_fk foreign key (senderId) references users(userId),
  constraint messages_chat_fk foreign key (chatId) references chat(chatId)
);

-------------------------------------------
-- cart
-------------------------------------------
drop table if exists cart CASCADE;
create table cart (
  cartId integer,
  farmId integer,
  customerId integer,
  farmerId integer,
  chatId integer,
  content text not null,
  constraint cart_pk primary key (cartId),
  constraint cart_customer_fk foreign key (customerId) references users(userId),
  constraint cart_chat_fk foreign key (chatId) references chat(chatId),
  constraint cart_farm_fk foreign key (farmerId) references farm(farmId)
);

-------------------------------------------
-- contains
-------------------------------------------
drop table if exists contains CASCADE;
create table contains (
  cartId integer,
  produceId integer,
  quantity integer not null,
  price real not null,
  constraint contains_pk primary key (cartId, produceId),
  constraint contains_cart_fk foreign key (cartId) references cart(cartId),
  constraint contains_produce_fk foreign key (produceId) references produce(produceId)
);