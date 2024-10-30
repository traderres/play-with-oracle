-------------------------------------------------------------------------------------------
-- Filename:  V1.0__baseline.sql
-------------------------------------------------------------------------------------------


-- Create sequences used for  ids and for transactions
Create sequence seq_table_ids increment by 1 START WITH 5000;
Create sequence seq_transaction_ids increment by 1 START WITH 1000;


-----------------------------------------------------------------------------
-- Create this table:  system_parameters
-----------------------------------------------------------------------------
create table system_parameters
(
    name              varchar(100)    not null,
    value             clob            not null,
    primary key(name)
);


create table users
(
    id                     integer         not null,
    full_name              varchar(100)    not null,
    primary key(id)
);