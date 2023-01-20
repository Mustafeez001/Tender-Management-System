

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




SQL Tables


create table administrator
(
username varchar(20),
password varchar(20)
);

create table Tender
(

tid int primary key,
flatType int,
location varchar(20),
startDate varchar(20),
enddate varchar(20),
basePrice double
);

create table Vendor
(

vid int primary key auto_increment,
vname varchar(20),
email varchar(20),
password varchar (20),
company varchar(20),
address varchar(20)

);


create table bid
(
tid int,
vid int primary key,
offer int,
foreign key(vid) references vendor(vid)
);


![logo](https://camo.githubusercontent.com/48ec00ed4c84e771db4a1db90b56352923a8d644452a32b434d68e97006c9337/68747470733a2f2f63686b736b696c6c732e636f6d2f77702d636f6e74656e742f75706c6f6164732f323032302f30342f504e432d416e696d617465642d42616e6e6572732e676966)
