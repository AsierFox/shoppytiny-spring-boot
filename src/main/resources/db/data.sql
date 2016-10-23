----
---- Categories
----
INSERT INTO Categories (name) VALUES
	('Sports'),
	('Gaming'),
	('Cooking'),
	('Computer');

----
---- Products
----
INSERT INTO Products (name, image, description, price) VALUES
	('Call of duty', 'call-of-duty-4.png', 'This game is the best one in the market of FPS', 20.50),
	('Racquet', 'racquet-yellow.png', 'This racquet was made in France, where the best players in the world go to.', 50.00),
	('ISLE 10,5 Versa', 'versa-surfboard.jpg', 'This model offers a generous width and thickness in a classic longboard shape, it is a one-board solution for paddlers wanting stability and versatility in both flat water and small-to-medium surf.', 50.00),
	('Apple iMac retina 5K Desktop', 'mac-computer.jpg', 'The stunning all-in-one iMac features a beautiful 27-inch Retina 5K widescreen display, quad-core Intel Core i5 processors and AMD Radeon R9 M380 graphics processor with 2GB of GDDR5 memory', 1699.00),
	('Cruacial RAM', 'crucial-ram.jpg', 'BLS8G3D1609DS1S00 is a single 8GB DDR3 module that operates at speeds up to 1600 MT/s and has a CL9 latency with extended timings of 9-9-9-24. It is Performance and is non-ECC..', 19.99),
	('Pan', 'pan-egg.png', 'This pan is biodegradable and is safe to cook with.', 15.20);

----
---- Category Product
----
INSERT INTO category_product (category_id, product_id) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(4, 4),
	(4, 5),
	(3, 6);
