/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/10/14 19:25:46                          */
/*==============================================================*/


drop table if exists myorder;

drop table if exists pcollect;

drop table if exists pmessage;

drop table if exists product;

drop table if exists product2;

drop table if exists user;

drop table if exists user2;

drop table if exists wanttobuy;

/*==============================================================*/
/* Table: myorder                                               */
/*==============================================================*/
create table myorder
(
   id                   varchar(20) not null,
   time                 datetime not null,
   state                int not null,
   sno                  varchar(20) not null,
   pid2                 varchar(20),
   pid                  varchar(20),
   total                float default NULL,
   primary key (id),
   key FK_Reference_7 (sno),
   key FK_Reference_8 (pid2)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*==============================================================*/
/* Table: pcollect                                              */
/*==============================================================*/
create table pcollect
(
   id                   varchar(20) not null,
   sno                  varchar(20) not null,
   pid                  varchar(20),
   pro_pId              varchar(20),
   time                 datetime not null,
   primary key (id),
   key FK_Reference_4 (sno),
   key FK_Reference_5 (pid)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*==============================================================*/
/* Table: pmessage                                              */
/*==============================================================*/
create table pmessage
(
   id                   varchar(20) not null,
   time                 datetime not null,
   sno                  varchar(20) not null,
   pid                  varchar(20),
   pro_pId              varchar(20),
   Content              varchar(100) not null,
   primary key (id),
   key FK_Reference_2 (sno),
   key FK_Reference_3 (pid)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   pId                  varchar(20) not null,
   pname                varchar(50) not null,
   level                int not null,
   price                Decimal(0.00) not null,
   category             int not null,
   pinfo                varchar(255),
   display              int not null,
   Image                varchar(255) not null,
   time                 datetime not null,
   sno                  varchar(20) not null,
   primary key (pId)
);

/*==============================================================*/
/* Table: product2                                              */
/*==============================================================*/
create table product2
(
   pId                  varchar(20) not null,
   pname                varchar(50) not null,
   level                int(11) not null,
   price                decimal(10,0) not null,
   category             int(11) not null,
   pinfo                varchar(255) default NULL,
   display              int(11) not null,
   Image                varchar(255) not null,
   time                 datetime not null,
   sno                  varchar(20) not null,
   primary key (pId),
   key FK_Reference_1 (sno)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   sno                  varchar(20) not null,
   password             varchar(20) not null,
   username             varchar(20) not null,
   phonenumber          Char(11) not null,
   realname             varchar(10) not null,
   adress               varchar(20),
   marjoy               varchar(10),
   balance              float,
   primary key (sno)
);

/*==============================================================*/
/* Table: user2                                                 */
/*==============================================================*/
create table user2
(
   sno                  varchar(20) not null,
   password             varchar(20) not null,
   username             varchar(20),
   phonenumber          char(11) not null,
   realname             varchar(10) not null,
   adress               varchar(20) default NULL,
   marjoy               varchar(10) default NULL,
   balance              float default NULL,
   primary key (sno)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*==============================================================*/
/* Table: wanttobuy                                             */
/*==============================================================*/
create table wanttobuy
(
   id                   varchar(20) character set utf8 not null,
   time                 datetime not null,
   pname                varchar(20) not null,
   info                 varchar(100) default NULL,
   price                decimal(10,0) not null,
   isbought             int not null,
   sno                  varchar(20) default NULL,
   primary key (id),
   key FK_Reference_6 (sno)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

alter table myorder add constraint FK_Reference_7 foreign key (sno)
      references user (sno) on delete restrict on update restrict;

alter table myorder add constraint FK_Reference_8 foreign key (pid2)
      references product (pId) on delete restrict on update restrict;

alter table pcollect add constraint FK_Reference_4 foreign key (sno)
      references user (sno) on delete restrict on update restrict;

alter table pcollect add constraint FK_Reference_5 foreign key (pid)
      references product (pId) on delete restrict on update restrict;

alter table pmessage add constraint FK_Reference_2 foreign key (sno)
      references user (sno) on delete restrict on update restrict;

alter table pmessage add constraint FK_Reference_3 foreign key (pid)
      references product (pId) on delete restrict on update restrict;

alter table product add constraint FK_Reference_1 foreign key (sno)
      references user (sno) on delete restrict on update restrict;

alter table product2 add constraint FK_Reference_1 foreign key (sno)
      references user (sno) on delete restrict on update restrict;

alter table wanttobuy add constraint FK_Reference_6 foreign key (sno)
      references user (sno) on delete restrict on update restrict;

