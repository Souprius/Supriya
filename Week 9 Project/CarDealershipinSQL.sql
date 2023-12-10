#create vehicle
CREATE TABLE vehicles(
vin INT NOT NULL,
year INT NOT NULL,
make VARCHAR(20) NOT NULL,
model VARCHAR(20) NOT NULL,
vehicleType VARCHAR(50) NOT NULL,
color VARCHAR(20) NOT NULL,
odometer INT NOT NULL,
price DECIMAL(20,2) NOT NULL,
Sold BIT(1)
);

INSERT INTO vehicles(vin, year, make, model, vehicleType,color,odometer,price,sold)
VALUES(33564,1998,'BMW','328i','Coupe','White',75000,20000.75,1),
(06050, 2018,'Ford','Mustang','Coupe','White',82000,27500.00,1),
(07159,2010,'Ford','Fusion SE', 'Sedan','Red',140000,10200.50,1);

#create dealership
CREATE TABLE dealerships(
DealershipID INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
address VARCHAR(50),
phone VARCHAR (12)
);

INSERT INTO dealerships(name,address,phone)
VALUES('Souprius Auto','157 Da Baddest Blvd','214-662-4567'),
('Barrientos Palace','2024 High Ridge Ln','323-666-2368'),
('KIRO','940 W Acoustic Rd','919-658-8437');

#create inventory
CREATE TABLE inventories(
DealershipID INT,
vin INT,

FOREIGN KEY(DealershipID) REFERENCES dealerships(DealershipID),
FOREIGN KEY (vin) REFERENCES vehicles(vin)
);

INSERT INTO inventories(DealershipID,vin)
VALUES(1,07159),
(2,06050),
(3,33564);

#contract?
CREATE TABLE contracts(
date DATETIME NOT NULL,
customerName VARCHAR(150) NOT NULL,
customerEmail VARCHAR(150) NOT NULL,
vin INT,

FOREIGN KEY (vin) REFERENCES vehicles(vin)
);

INSERT INTO contracts(date,customerName, customerEmail,vin)
VALUES(NOW(),'Tempest Marie','tempsybempsy@gmail.com',33564),
(NOW(),'Josiah Anthony','jh0704@yahoo.com',06050),
(NOW(),'Rehana Aton','chloetinkaton@icloud.com',07159);


#create sales contract
CREATE TABLE salescontracts(
SalesID INT AUTO_INCREMENT PRIMARY KEY,
date DATETIME,
customerName VARCHAR(150),
customerEmail VARCHAR(150),
vin INT,
totalPrice DECIMAL(20,2) NOT NULL,
monthlyPayment DECIMAL(10,2) NOT NULL,
salesTax DECIMAL(10,2) NOT NULL,
recordingFee DECIMAL(10,2) NOT NULL,
financing BIT(1) NOT NULL,
processingFee DECIMAL(10,2) NOT NULL,

FOREIGN KEY(date) REFERENCES contracts(date),
FOREIGN KEY(vin) REFERENCES vehicles(vin),
FOREIGN KEY(customerName) REFERENCES contracts(customerName),
FOREIGN KEY(customerEmail) REFERENCES contracts(customerEmail)
);

INSERT INTO salescontracts(date,customerName,customerEmail,vin,totalPrice,monthlyPayment,salesTax,recordingFee,financing,processingFee)
VALUES(NOW(),'Tempest Marie','tempsybempsy@gmail.com',33564,25500.75,250.00,4705.00,50.00,0,295.00),
(NOW(),'Josiah Anthony','jh0704@yahoo.com',06050,27845.00,500.00,200.00,50.00,0,295.00),
(NOW(),'Rehana Aton','chloetinkaton@icloud.com',07159,10545.50,150.00,5.00,50.00,0,295.00);

#create lease contract
CREATE TABLE leasecontracts(
LeaseID INT AUTO_INCREMENT PRIMARY KEY,
date DATETIME,
customerName VARCHAR(150),
customerEmail VARCHAR(150),
vin INT,
expectedEndingValue DECIMAL(20,2) NOT NULL,
leaseFEe DECIMAL(10,2) NOT NULL,
totalPrice DECIMAL(20,2) NOT NULL,
monthlyPayment DECIMAL(10,2) NOT NULL,

FOREIGN KEY(date) REFERENCES contracts(date),
FOREIGN KEY(vin) REFERENCES vehicles(vin)
);

#Queries
#get all dealerships
SELECT *
FROM dealerships;

#find all vehicles for a specific dealership
SELECT dealerships.name, vehicles.*
FROM vehicles
JOIN inventories ON vehicles.vin = inventories.vin
JOIN dealerships ON inventories.DealershipID = dealerships.DealershipID
WHERE dealerships.DealershipID = 3;

#find a car by vin
SELECT *
FROM vehicles
WHERE VIN = 33564;

#find the dealership where a certain car is located, by VIN
SELECT dealerships.name, vehicles.*
FROM dealerships
JOIN inventories ON inventories.DealershipID = dealerships.DealershipID
JOIN vehicles ON vehicles.vin = inventories.vin
WHERE inventories.vin = 33564;

#Find all dealerships that have a certain car type (i.e Red Ford Mustang)
SELECT dealerships.name AS DealershipName
FROM dealerships
JOIN inventories ON inventories.DealershipID = dealerships.DealershipID
JOIN vehicles ON vehicles.vin = inventories.vin
WHERE vehicles.make = 'Ford'
GROUP BY dealerships.name;

#Get all sales information for a specific dealer for a specific date range
SELECT dealerships.name, salescontracts.*
FROM salescontracts
JOIN vehicles ON vehicles.vin = salescontracts.vin
JOIN inventories ON inventories.vin	= salescontracts.vin
JOIN dealerships ON inventories.DealershipID = dealerships.DealershipID
WHERE YEAR (salescontracts.date) = '2023' AND dealerships.DealershipID = 1;



