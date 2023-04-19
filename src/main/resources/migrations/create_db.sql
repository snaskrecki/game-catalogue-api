DROP DATABASE IF EXISTS cdpr_test_db;
DROP USER IF EXISTS 'cdpr_test_user'@'%';
CREATE DATABASE cdpr_test_db;
CREATE USER 'cdpr_test_user'@'%' IDENTIFIED BY 'cdpr_test_pass';
GRANT ALL PRIVILEGES ON cdpr_test_db.* TO 'cdpr_test_user'@'%';
