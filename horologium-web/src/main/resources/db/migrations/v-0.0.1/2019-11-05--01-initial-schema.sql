-- liquibase formatted sql

-- changeset baryshnikov-oi-180801:1
create table Category
(
  id      varchar(36)  not null
    primary key,
  deleted bit          null,
  name    varchar(255) not null
);
-- rollback drop table Category;

-- changeset baryshnikov-oi-180801:2
create table Speciality
(
  id      varchar(36)  not null
    primary key,
  deleted bit          null,
  name    varchar(255) not null,
  code    varchar(255) not null
);
-- rollback drop table Speciality;

-- changeset baryshnikov-oi-180801:3
create table Doctor
(
  id            varchar(36)  not null
    primary key,
  deleted       bit          null,
  firstName     varchar(255) null,
  lastName      varchar(255) null,
  middleName    varchar(255) null,
  category_id   varchar(36)  null,
  speciality_id varchar(36)  null,
  constraint FK617nhwoub1ckomdxj5eq901h9
    foreign key (category_id) references Category (id),
  constraint FKf7ugc3ja08wavpjyv3vysgfrg
    foreign key (speciality_id) references Speciality (id)
);
-- rollback drop table Doctor;


