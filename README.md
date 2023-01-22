

				                    Tender Management System


Whenever a company  requires a service / merchandise , a tender is floated. Company maintains an empaneled list of Vendors. An empaneled vendor can only bid for a tender. Every vendor can bid only once against   each tender. Against each tender there may be   bids from several vendors. The company will then select the most suitable bid and places the order to that vendor.

There are 2 users in the system:
1. Administrator 
2. Vendor


The Role of Administrator is: 
1. Login with his account.
2. Register new Vendor. (assign a new username and password to him)
3. View all the vendors.
4. Create new tenders.
5. View All the Tenders.
6. View All the Bids of a tender.
7. Assign tender to a vendor.

The Role of a Vendor is: 
1. Login with his account (username and password given by admin)
1. View all the current Tenders.
2. Place a Bid against a Tender.
3. View status of a Bid(Whether Selected or Not)
4. View his own Bid History.


SQL TABLES


mysql> desc administrator;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| username | varchar(20) | YES  |     | NULL    |       |
| password | varchar(20) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+

mysql> desc vendor;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| vid      | int         | NO   | PRI | NULL    | auto_increment |
| vname    | varchar(20) | YES  |     | NULL    |                |
| email    | varchar(20) | YES  |     | NULL    |                |
| password | varchar(20) | YES  |     | NULL    |                |
| company  | varchar(20) | YES  |     | NULL    |                |
| address  | varchar(20) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

mysql> desc tender;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| tid       | int         | NO   | PRI | NULL    |       |
| flatType  | int         | YES  |     | NULL    |       |
| location  | varchar(20) | YES  |     | NULL    |       |
| startDate | varchar(20) | YES  |     | NULL    |       |
| enddate   | varchar(20) | YES  |     | NULL    |       |
| basePrice | double      | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+

mysql> desc bid;
+-------+------+------+-----+---------+-------+
| Field | Type | Null | Key | Default | Extra |
+-------+------+------+-----+---------+-------+
| tid   | int  | YES  |     | NULL    |       |
| vid   | int  | NO   | PRI | NULL    |       |
| offer | int  | YES  |     | NULL    |       |
+-------+------+------+-----+---------+-------+



![logo](![2023-01-20 (2)](https://user-images.githubusercontent.com/105917441/213762229-eb097981-27f5-41f7-bd0d-de260baf0775.png)
)
