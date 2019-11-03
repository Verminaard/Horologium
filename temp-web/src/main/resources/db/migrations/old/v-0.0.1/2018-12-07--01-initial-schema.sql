-- liquibase formatted sql

-- changeset baryshnikov-oi-180801:1
create table REVINFO
(
  REV      int auto_increment
    primary key,
  REVTSTMP bigint null
);
-- rollback drop table REVINFO;

-- changeset baryshnikov-oi-180801:2
create table UserPermission
(
  id   varchar(36)  not null
    primary key,
  name varchar(255) null,
  text varchar(255) null
);
-- rollback drop table UserPermission;

-- changeset baryshnikov-oi-180801:3
create table UserPermission_AUD
(
  id      varchar(36)  not null,
  REV     int          not null,
  REVTYPE tinyint      null,
  name    varchar(255) null,
  text    varchar(255) null,
  primary key (id, REV),
  constraint `fk_germes_UserPermission_AUD_REV`
  foreign key (REV) references REVINFO (REV)
);
-- rollback drop table UserPermission_AUD;

-- changeset baryshnikov-oi-180801:4
create table UserPermission_UserPermission
(
  permission_id    varchar(36) not null,
  subpermission_id varchar(36) not null,
  primary key (permission_id, subpermission_id),
  constraint `unique_germes_UserPermission_UserPermission_permission_id`
  unique (subpermission_id),
  constraint `fk_germes_UserPermission_UserPermission_permission_id`
  foreign key (permission_id) references UserPermission (id),
  constraint `fk_germes_UserPermission_UserPermission_subpermission_id`
  foreign key (subpermission_id) references UserPermission (id)
);
-- rollback drop table UserPermission_UserPermission;

-- changeset baryshnikov-oi-180801:5
create table UserPermission_UserPermission_AUD
(
  REV              int         not null,
  permission_id    varchar(36) not null,
  subpermission_id varchar(36) not null,
  REVTYPE          tinyint     null,
  primary key (REV, permission_id, subpermission_id),
  constraint `fk_germes_UserPermission_UserPermission_REV`
  foreign key (REV) references REVINFO (REV)
);
-- rollback drop table UserPermission_UserPermission_AUD;

-- changeset baryshnikov-oi-180801:6
create table UserRole
(
  id     varchar(36)  not null
    primary key,
  custom bit          null,
  name   varchar(255) null
);
-- rollback drop table UserRole;

-- changeset baryshnikov-oi-180801:7
create table User
(
  id                         varchar(36)  not null
    primary key,
  firstName                  varchar(255) null,
  middleName                 varchar(255) null,
  lastName                   varchar(255) null,
  isEnabled                  bit          null,
  login                      varchar(255) null,
  institution_guid           varchar(36)  null,
  is_account_non_expired     bit          null,
  is_account_non_locked      bit          null,
  is_credentials_non_expired bit          null,
  userRole_id                varchar(36)  null,
  constraint `unique_germes_User_login`
  unique (login),
  constraint `fk_germes_User_userRole_id`
  foreign key (userRole_id) references UserRole (id)
);
-- rollback drop table User;

-- changeset baryshnikov-oi-180801:8
create table UserRole_AUD
(
  id      varchar(36)  not null,
  REV     int          not null,
  REVTYPE tinyint      null,
  custom  bit          null,
  name    varchar(255) null,
  primary key (id, REV),
  constraint `fk_germes_UserRole_AUD_REV`
  foreign key (REV) references REVINFO (REV)
);
-- rollback drop table UserRole_AUD;

-- changeset baryshnikov-oi-180801:9
create table UserRole_UserPermission
(
  role_id       varchar(36) not null,
  permission_id varchar(36) not null,
  primary key (role_id, permission_id),
  constraint `fk_germes_UserRole_UserPermission_permission_id`
  foreign key (permission_id) references UserPermission (id),
  constraint `fk_germes_UserRole_UserPermission_role_id`
  foreign key (role_id) references UserRole (id)
);
-- rollback drop table UserRole_UserPermission;

-- changeset baryshnikov-oi-180801:10
create table UserRole_UserPermission_AUD
(
  REV           int         not null,
  role_id       varchar(36) not null,
  permission_id varchar(36) not null,
  REVTYPE       tinyint     null,
  primary key (REV, role_id, permission_id),
  constraint `fk_germes_UserRole_UserPermission_AUD_REV`
  foreign key (REV) references REVINFO (REV)
);
-- rollback drop table UserRole_UserPermission_AUD;

-- changeset baryshnikov-oi-180801:11
create table User_AUD
(
  id                         varchar(36)  not null,
  REV                        int          not null,
  REVTYPE                    tinyint      null,
  firstName                  varchar(255) null,
  middleName                 varchar(255) null,
  lastName                   varchar(255) null,
  isEnabled                  bit          null,
  login                      varchar(255) null,
  institution_guid           varchar(36)  null,
  is_account_non_expired     bit          null,
  is_account_non_locked      bit          null,
  is_credentials_non_expired bit          null,
  userRole_id                varchar(36)  null,
  primary key (id, REV),
  constraint `fk_germes_User_AUD_REV`
  foreign key (REV) references REVINFO (REV)
);
-- rollback drop table User_AUD;

-- changeset baryshnikov-oi-180801:12
create table User_UserRole
(
  user_id varchar(36) not null,
  role_id varchar(36) not null,
  primary key (user_id, role_id),
  constraint `fk_germes_User_UserRole_role_id`
  foreign key (role_id) references UserRole (id),
  constraint `fk_germes_User_UserRole_user_id`
  foreign key (user_id) references User (id)
);
-- rollback drop table User_UserRole;

-- changeset baryshnikov-oi-180801:13
create table User_UserRole_AUD
(
  REV     int         not null,
  user_id varchar(36) not null,
  role_id varchar(36) not null,
  REVTYPE tinyint     null,
  primary key (REV, user_id, role_id),
  constraint `fk_germes_User_UserRole_AUD_REV`
  foreign key (REV) references REVINFO (REV)
);
-- rollback drop table User_UserRole_AUD;

