drop sequence if exists orders_seq;
create SEQUENCE orders_seq START with 1 INCREMENT by 1;
drop sequence if exists order_id_seq;
create SEQUENCE order_id_seq START with 1 INCREMENT by 1;
drop sequence if exists transaction_code_seq;
create SEQUENCE transaction_code_seq START with 1 INCREMENT by 1;