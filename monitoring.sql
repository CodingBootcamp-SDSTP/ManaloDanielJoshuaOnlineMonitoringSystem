DROP TABLE IF EXISTS tbl_employees;
CREATE TABLE tbl_employees ( 
	empid INTEGER PRIMARY KEY,
	fname VARCHAR(50) NOT NULL,
	lname VARCHAR(50) NOT NULL,
	address VARCHAR(255),
	assignedto INTEGER,
	sss INTEGER,
	philhealth INTEGER,
	position VARCHAR(25) NOT NULL,
	details VARCHAR(255) );

DROP TABLE IF EXISTS tbl_goods;
CREATE TABLE tbl_goods (
	gid INTEGER NOT NULL,
	quantity INTEGER NOT NULL,
	name VARCHAR(100) PRIMARY KEY NOT NULL,
	brand VARCHAR(50),
	batchcode VARCHAR(20) NOT NULL,
	unitprice DECIMAL(10,3) NOT NULL,
	type VARCHAR(50) NOT NULL,
	details VARCHAR(255) );

DROP TABLE IF EXISTS tbl_sales;
CREATE TABLE tbl_sales (
	branchid VARCHAR(255) NOT NULL,
	dailysales INTEGER PRIMARY KEY,
	details VARCHAR(255) );

DROP TABLE IF EXISTS tbl_branches;
CREATE TABLE tbl_branches (
	branchid INTEGER PRIMARY KEY,
	address VARCHAR(100) NOT NULL,
	owner VARCHAR(100) NOT NULL,
	details VARCHAR(255) );


INSERT INTO tbl_employees ( empid, fname, lname, address, assignedto, sss, philhealth, position ) VALUES ( 2018061701, 'Emil', 'Sebastian', 'Santa Rosa, Laguna', 2018001, 00012523457, 05678223, 'Salesman' );
INSERT INTO tbl_employees ( empid, fname, lname, address, assignedto, sss, philhealth, position ) VALUES ( 2018051001, 'Renan', 'Nuevo', 'Santa Rosa, Laguna', 2018001, 000056238481, 20934762, 'Salesman' );
INSERT INTO tbl_employees ( empid, fname, lname, address, assignedto, sss, philhealth, position ) VALUES ( 2018040801, 'Ronald', 'Raz', 'Santa Rosa, Laguna', 2018001, 001239587475, 51231239, 'Store Manager' );
INSERT INTO tbl_employees ( empid, fname, lname, address, assignedto, sss, philhealth, position ) VALUES ( 2018030201, 'Ivan', 'Ivan', 'Santa Rosa, Laguna', 2018001, 00233495792, 49564565, 'Security Guard' );
INSERT INTO tbl_employees ( empid, fname, lname, address, assignedto, sss, philhealth, position ) VALUES ( 2018040201, 'Nida', 'Nida', 'Santa Rosa, Laguna', 2018001, 00010485717, 40123775, 'Janitress' );

INSERT INTO tbl_goods ( gid, quantity, name, brand, batchcode, unitprice, type ) VALUES ( '3210', '500', 'Men shirt', 'Dickies', '2017001', 350.00, 'clothing' );
INSERT INTO tbl_goods ( gid, quantity, name, brand, batchcode, unitprice, type ) VALUES ( '4510', '450', 'Women shirt', 'Dickies', '2018001', 300.00, 'clothing' );
INSERT INTO tbl_goods ( gid, quantity, name, brand, batchcode, unitprice, type ) VALUES ( '0990', '250', 'Polo shirt', 'Dickies', '2018011', 450.00, 'clothing' );
INSERT INTO tbl_goods ( gid, quantity, name, brand, batchcode, unitprice, type ) VALUES ( '1280', '500', 'Men Pants', 'Dickies', '2016012', 750.00, 'clothing' );
INSERT INTO tbl_goods ( gid, quantity, name, brand, batchcode, unitprice, type ) VALUES ( '0087', '300', 'Women Pants', 'Dickies', '2018070', 700.00, 'clothing' );

INSERT INTO tbl_branches ( branchid, address, owner ) VALUES ( 4019, 'Complex Balibago, Sta. Rosa, Philippines', 'Alfie Osayan' );

