-- create user 'cliente_usr'@'localhost' identified with mysql_native_password by 'p455w0rD!';
use mysql;
create user 'cliente_usr'@'localhost' identified by 'p455w0rD!';
grant all on clientes.* to 'cliente_usr'@'localhost';
