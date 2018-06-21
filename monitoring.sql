DROP TABLE IF EXISTS tbl_sales;
DROP TABLE IF EXISTS tbl_goods;
DROP TABLE IF EXISTS tbl_employees;
DROP TABLE IF EXISTS tbl_branches;
DROP TABLE IF EXISTS tbl_users;

CREATE TABLE IF NOT EXISTS `tbl_users` (
	`userid` INTEGER(10) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) DEFAULT NULL,
	`password` VARCHAR(50) NOT NULL,
	`firstname` VARCHAR(50) NOT NULL,
	`lastname` VARCHAR(50) NOT NULL,
	`extension` VARCHAR(10) DEFAULT '',
	`dob` DATE NOT NULL,
	`gender` CHAR(8) DEFAULT '',
	PRIMARY KEY (`userid`)
);

CREATE TABLE IF NOT EXISTS `tbl_branches` (
	`branchcode` VARCHAR(10) NOT NULL,
	`city` VARCHAR(20) DEFAULT '',
	`address` VARCHAR(100) DEFAULT '',
	`postalcode` VARCHAR(10) NOT NULL,
	`phonenum` VARCHAR(15) DEFAULT '',
	`username` VARCHAR(100) NOT NULL,
	`details` VARCHAR(255) DEFAULT '',
	PRIMARY KEY (`branchcode`)
);

CREATE TABLE IF NOT EXISTS `tbl_employees` ( 
	`employeeid` BIGINT(12) NOT NULL AUTO_INCREMENT,
	`firstname` VARCHAR(50) NOT NULL,
	`lastname` VARCHAR(50) NOT NULL,
	`branchcode` VARCHAR(10),
	`address1` VARCHAR(255) DEFAULT '',
	`address2` VARCHAR(255) DEFAULT '',
	`gender` VARCHAR(8) DEFAULT '',
	`sss` VARCHAR(20),
	`philhealth` VARCHAR(20),
	`jobtitle` VARCHAR(50) NOT NULL,
	`details` VARCHAR(255) DEFAULT '',
	PRIMARY KEY (`employeeid`)
);

CREATE TABLE IF NOT EXISTS `tbl_goods` (
	`goodsid` INTEGER(10) NOT NULL,
	`quantity` SMALLINT(6) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`codename` VARCHAR(30) DEFAULT '',
	`branchcode` VARCHAR(10),
	`brand` VARCHAR(50) DEFAULT '',
	`batchcode` VARCHAR(20),
	`unitprice` DECIMAL(10,3) DEFAULT "0.00",
	`type` VARCHAR(50) DEFAULT '',
	`details` VARCHAR(255) DEFAULT '',
	PRIMARY KEY (`goodsid`)
);

CREATE TABLE IF NOT EXISTS `tbl_sales` (
	`branchcode` VARCHAR(10),
	`sales` DECIMAL(10,3) NOT NULL,
	`date` DATE NOT NULL,
	`details` VARCHAR(255),
	PRIMARY KEY (`date`)
);

INSERT INTO tbl_users ( userid, username, email, password, firstname, lastname, extension, dob, gender) VALUES
( 1001, 'alpha', 'alpha123@gmail.com', 'beta', 'Daniel', 'Manalo', 'xxx', '2000-02-10', 'male' );

INSERT INTO tbl_branches ( branchcode, city, address, postalcode, phonenum, username ) VALUES
( '1001', 'Complex Balibago', 'Sta. Rosa, Philippines', 2085, '+123345678', 'alpha' ),
( '1002', 'San Fernando', 'Pampanga, Philippines', 3502, '+123345678', 'alpha1' ),
( '1003', 'Cavite City', 'Cavite, Philippines', 1003, '+123345678', 'alpha2' );

INSERT INTO tbl_employees ( employeeid, firstname, lastname, branchcode, address1, address2, gender, sss, philhealth, jobtitle ) VALUES
( 20170123, 'Emil', 'Sebastian', '1001', 'Santa Rosa, Laguna', '', 'male', '00012523457', '0567456788223', 'Salesman' ),
( 20108134, 'Renan', 'Nuevo', '1001', 'Santa Rosa, Laguna', '', 'male', '000056238481', '2091234534762', 'Salesman' ),
( 20080145, 'Ronald', 'Raz', '1001', 'Santa Rosa, Laguna', '', 'male', '001239587475', '5123567891239', 'Store Manager' ),
( 20022501, 'Ivan', 'Ivan', '1001', 'Santa Rosa, Laguna', '', 'male', '00233495792', '4956434567565', 'Security Guard' ),
( 20180701, 'Nida', 'Nida', '1001', 'Santa Rosa, Laguna', '', 'female', '00010485717', '4012234123775', 'Janitress' );

INSERT INTO tbl_goods ( goodsid, quantity, name, codename, branchcode, brand, batchcode, unitprice, type ) VALUES
( 3212640, 500, 'Men shirt', '', '1001', 'Dickies', '2017001-A', 350.00, 'clothing' ),
( 4526410, 450, 'Women shirt', '', '1001', 'Dickies', '2018001-C', 300.00, 'clothing' ),
( 0990211, 250, 'Polo shirt', '', '1001', 'Dickies', '2018011-A', 450.00, 'clothing' ),
( 1226480, 500, 'Men Pants', '', '1001', 'Dickies', '2016012-D', 750.00, 'clothing' ),
( 0264087, 300, 'Women Pants', '', '1001', 'Dickies', '2018070-A', 700.00, 'clothing' ),
( 0264027, 300, 'Panyo', 'hndkrchf', '1001', 'Caruso', '2018470-A', 150.00, 'rug' );

INSERT INTO tbl_sales ( branchcode, sales, date ) VALUES
( '1001', 73209.25, '2018-06-16' ),
( '1001', 27005.90, '2018-06-18' ),
( '1001', 48239.50, '2018-06-15' ),
( '1001', 39550.75, '2018-06-19' );
