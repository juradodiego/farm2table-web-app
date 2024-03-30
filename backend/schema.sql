DROP SCHEMA IF EXISTS farm2table CASCADE;
CREATE SCHEMA farm2table;
SET SCHEMA 'farm2table';

-------------------------------------------
-- Farm
-------------------------------------------
drop table if exists farm CASCADE;
create table farm (
  farm_id integer,
  latitude real not null,
  longitude real not null,
  constraint farm_pk primary key (farm_id)
);

-------------------------------------------
-- User
-------------------------------------------
drop table if exists users CASCADE;
create table users (
  user_id integer,
  username varchar(20) not null,
  farm_id integer,
  address_line varchar(60) not null,
  city varchar(30) not null,
  state varchar(2) not null,
  zipcode int not null,
  consumer boolean not null,
  email varchar(60) not null unique,
  salt integer not null,
  password text not null,
  farm_name varchar(60),
  constraint user_pk primary key (user_id),
  constraint user_farm_fk foreign key (farm_id) references farm(farm_id)
);

-------------------------------------------
-- produce
-------------------------------------------
drop table if exists produce CASCADE;
create table produce (
  produce_id integer,
  name varchar(30) not null,
  constraint produce_pk primary key (produce_id)
);

-------------------------------------------
-- has_produce
-------------------------------------------
drop table if exists selling CASCADE;
create table selling (
  produce_id integer,
  farmer_id integer not null,
  constraint selling_pk primary key (produce_id, farmer_id),
  constraint selling_produce_fk foreign key (produce_id) references produce(produce_id),
  constraint selling_farmer_fk foreign key (farmer_id) references users(user_id)
);

-------------------------------------------
-- chat
-------------------------------------------
drop table if exists chat CASCADE;
create table chat (
  chat_id integer,
  customer_id integer not null,
  farmer_id integer not null,
  constraint chat_pk primary key (chat_id),
  constraint chat_customer_fk foreign key (customer_id) references users(user_id),
  constraint chat_farmer_fk foreign key (farmer_id) references users(user_id)
);

-------------------------------------------
-- messages
-------------------------------------------
drop table if exists messages CASCADE;
create table messages (
  message_id integer,
  chat_id integer,
  sender_id integer not null,
  content text,
  sent_at timestamp not null,
  constraint messages_pk primary key (message_id),
  constraint messages_sender_fk foreign key (sender_id) references users(user_id),
  constraint messages_chat_fk foreign key (chat_id) references chat(chat_id)
);

-------------------------------------------
-- cart
-------------------------------------------
drop table if exists cart CASCADE;
create table cart (
  cart_id integer,
  farm_id integer,
  customer_id integer,
  farmer_id integer,
  chat_id integer,
  content text not null,
  sent_at timestamp not null,
  constraint cart_pk primary key (cart_id),
  constraint cart_customer_fk foreign key (customer_id) references users(user_id),
  constraint cart_chat_fk foreign key (chat_id) references chat(chat_id),
  constraint cart_farm_fk foreign key (farmer_id) references farm(farm_id)
);

-------------------------------------------
-- contains
-------------------------------------------
drop table if exists contains CASCADE;
create table contains (
  cart_id integer,
  produce_id integer,
  quantity integer not null,
  price real not null,
  constraint contains_pk primary key (cart_id, produce_id),
  constraint contains_cart_fk foreign key (cart_id) references cart(cart_id),
  constraint contains_produce_fk foreign key (produce_id) references produce(produce_id)
);