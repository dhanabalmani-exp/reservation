/**
use master;
drop database reserv;
create database reserv;

use reserv;
*/

CREATE TABLE City (
		[id] [int] IDENTITY(1,1) NOT NULL,
		[name] [varchar](250) NOT NULL,
		CONSTRAINT uc_city_name UNIQUE ([name]),
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

CREATE TABLE VehicleType (
		[id] [int] IDENTITY(1,1) NOT NULL,
		[type] [varchar](250) NOT NULL,
		CONSTRAINT uc_vehicle_type UNIQUE ([type]),
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

CREATE TABLE VehicleClassType (
		[id] [int] IDENTITY(1,1) NOT NULL,
		[type] [varchar](250) NOT NULL,
		CONSTRAINT uc_vehicle_class_type UNIQUE ([type]),
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

CREATE TABLE Vehicle (
		[id] [int] IDENTITY(1,1) NOT NULL,
		[name] [varchar](250) NOT NULL,
		[vehicleTypeId] [int] NOT NULL,
		[vehicleClassTypeId] [int] NOT NULL,
		[seatCapacity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

ALTER TABLE [Vehicle]  WITH CHECK ADD  CONSTRAINT [FK_vehicle_type_id_to_vehicletype_id] FOREIGN KEY([vehicleTypeId])
			REFERENCES [VehicleType] ([id]);

ALTER TABLE [Vehicle] WITH CHECK ADD CONSTRAINT [FK_vehicle_class_type_id_to_vehicleclasstype_id] FOREIGN KEY([vehicleClassTypeId])
			REFERENCES [VehicleClassType] ([id]);

GO

INSERT INTO City VALUES('Chennai'), ('Bangalore'), ('Karur'), ('Madurai'), ('Theni');

INSERT INTO VehicleType VALUES('BUS'), ('CAR'), ('BIKE');

INSERT INTO VehicleClassType VALUES('AC'), ('Non AC'), ('AC Sleeper');

INSERT INTO Vehicle VALUES('KPN', 1, 1, 32), ('SRS', 1, 2, 24), ('Pari', 1, 3, 32);

GO

CREATE TABLE CityRoute (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fromCityId] [int] NOT NULL,
	[toCityId] [int] NOT NULL,
	[km] [decimal](8,2) NOT NULL
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

ALTER TABLE [CityRoute]  WITH CHECK ADD  CONSTRAINT [FK_city_route_from_city_id_to_city_id] FOREIGN KEY([fromCityId])
			REFERENCES [City] ([id]);

ALTER TABLE [CityRoute] WITH CHECK ADD CONSTRAINT [FK_city_route_to_city_id_to_city_id] FOREIGN KEY([toCityId])
			REFERENCES [City] ([id]);

INSERT INTO [CityRoute] VALUES 
(1, 2, 346.7), -- Chennai to Bangalore
(1, 3, 396.9), -- Chennai to Karur
(1, 4, 462.3), -- Chennai to Madurai
(2, 1, 347.2), -- Bangalore to Chennai
(3, 1, 384.2), -- Karur to Chennai
(5, 1, 509.7); -- Theni to Chennai

GO

CREATE TABLE VehicleRoute (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[vehicleId] [int] NOT NULL,
	[cityRouteId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

ALTER TABLE [VehicleRoute]  WITH CHECK ADD  CONSTRAINT [FK_vehicle_route_vehicle_id_to_vehicle_id] FOREIGN KEY([vehicleId])
			REFERENCES [Vehicle] ([id]);

ALTER TABLE [VehicleRoute] WITH CHECK ADD CONSTRAINT [FK_vehicle_route_city_route_id_to_city_route_id] FOREIGN KEY([cityRouteId])
			REFERENCES [CityRoute] ([id]);

GO

INSERT INTO [VehicleRoute] VALUES 
(1, 1), -- KPN Chennai to Bangalore
(2, 4), -- SRS Bangalore to Chennai
(3, 5); -- Pari Karur to Chennai


GO

CREATE TABLE Customer (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](500) NOT NULL,
	[mobileNumber] [NUMERIC](10,0) NOT NULL,
	PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

CREATE TABLE Booking (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[customerId] [int] NOT NULL,
	[vehicleId] [int] NOT NULL,
	[bookingDate] [datetime] NOT NULL,
	[createdDate] [datetime] NOT NULL default CURRENT_TIMESTAMP,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);


GO

ALTER TABLE [Booking]  WITH CHECK ADD  CONSTRAINT [FK_booking_customer_id_to_customer_id] FOREIGN KEY([customerId])
			REFERENCES [Customer] ([id]);

ALTER TABLE [Booking] WITH CHECK ADD CONSTRAINT [FK_booking_vehicle_id_to_vehicle_id] FOREIGN KEY([vehicleId])
			REFERENCES [Vehicle] ([id]);


GO

CREATE TABLE BookingDetail (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bookingId] [int] NOT NULL,
	[seatNumber] [int] NOT NULL,
	[passengerName] [varchar] (500) NOT NULL
PRIMARY KEY CLUSTERED 
(
	[id] ASC
) ON [PRIMARY]
);

GO

ALTER TABLE [BookingDetail]  WITH CHECK ADD  CONSTRAINT [FK_bookingdetails_booking_id_to_booking_id] FOREIGN KEY([bookingId])
			REFERENCES [Booking] ([id]);