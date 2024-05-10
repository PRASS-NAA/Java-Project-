 desc cashier;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| username | varchar(20)  | YES  | UNI | NULL    |                |
| cname    | varchar(30)  | YES  |     | NULL    |                |
| phoneno  | varchar(12)  | YES  |     | NULL    |                |
| id       | int          | NO   | PRI | NULL    | auto_increment |
| password | varchar(100) | YES  |     | NULL    |                |
| mail     | varchar(30)  | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+

 desc admin;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| id       | int         | NO   | PRI | NULL    |       |
| username | varchar(30) | NO   |     | NULL    |       |
| password | varchar(30) | NO   |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+

 desc products;
+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| batch_id      | varchar(30) | YES  | MUL | NULL    |       |
| product_id    | int         | YES  | MUL | NULL    |       |
| prodname      | varchar(30) | YES  |     | NULL    |       |
| price         | int         | YES  |     | NULL    |       |
| quantity      | int         | YES  |     | NULL    |       |
| sold_quantity | int         | YES  |     | 0       |       |
| expiry        | date        | YES  |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+

 desc salesmaster;
+------------+---------------+------+-----+---------+----------------+
| Field      | Type          | Null | Key | Default | Extra          |
+------------+---------------+------+-----+---------+----------------+
| stransid   | int           | NO   | PRI | NULL    | auto_increment |
| phoneno    | varchar(15)   | YES  | MUL | NULL    |                |
| salesamt   | decimal(10,2) | YES  |     | NULL    |                |
| stransdate | date          | YES  |     | NULL    |                |
| cashier_id | int           | YES  | MUL | NULL    |                |
+------------+---------------+------+-----+---------+----------------+

 desc salesdetails;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| stransid   | int         | YES  | MUL | NULL    |       |
| batch_id   | varchar(30) | YES  | MUL | NULL    |       |
| product_id | int         | YES  | MUL | NULL    |       |
| quantity   | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
