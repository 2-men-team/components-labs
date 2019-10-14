/*==============================================================*/
/* Database name:  SALE                                         */
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     13.02.2014 19:12:34                          */
/*==============================================================*/


/*==============================================================*/
/* Database: SALE                                               */
/*==============================================================*/
create database SALE;

/*==============================================================*/
/* Table: INVOICE                                               */
/*==============================================================*/
create table INVOICE  (
                          ID_STUFF             VARCHAR(128)                   not null,
                          STAFF_NAME           VARCHAR(128),
                          E_MAIL               VARCHAR(128),
                          INVOICE              VARCHAR(128),
                          SUPPLIER             VARCHAR(128),
                          PRODUCT              VARCHAR(128),
                          QUANTITY             VARCHAR(128),
                          PRICE                VARCHAR(128),
                          INVOICE_DATE         VARCHAR(128)
);

/*==============================================================*/
/* Table: SALES                                                 */
/*==============================================================*/
create table SALES  (
                        ID_STUFF              VARCHAR(128)                   not null,
                        STAFF_NAME            VARCHAR(128),
                        PRODUCT               VARCHAR(128),
                        SOLD_IN_JANUARY_2013  VARCHAR(128),
                        SOLD_IN_FEBRUARY_2013 VARCHAR(128),
                        SOLD_IN_MARCH_2013    VARCHAR(128),
                        SOLD_IN_APRIL_2013    VARCHAR(128),
                        SOLD_IN_MAY_2013      VARCHAR(128),
                        SOLD_IN_JUNE_2013     VARCHAR(128),
                        SOLD_IN_JULY_2013     VARCHAR(128),
                        SOLD_IN_AUGUST_2013   VARCHAR(128),
                        SOLD_IN_SEPTEMBER_2013 VARCHAR(128),
                        SOLD_IN_OCTOBER_2013  VARCHAR(128),
                        SOLD_IN_NOVEMBER_2013 VARCHAR(128),
                        SOLD_IN_DECEMBER_2013 VARCHAR(128)
);

/*==============================================================*/
/* Table: STORE                                                 */
/*==============================================================*/
create table STORE  (
                        STUFF_NAME           VARCHAR(124)                   not null,
                        SUPPLIER             VARCHAR(124),
                        SHELF                VARCHAR(124),
                        PRODUCT              VARCHAR(124),
                        QUANTITY             VARCHAR(124),
                        OPER_TYPE            VARCHAR(124),
                        STORE_DATE           VARCHAR(124)
);