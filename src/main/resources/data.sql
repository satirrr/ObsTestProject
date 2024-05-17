INSERT INTO item(id, name, price) VALUES
(1, 'Pen', 5),
(2, 'Book', 10),
(3, 'Bag', 30),
(4, 'Pencil', 3),
(5, 'Shoe', 45),
(6, 'Box', 5),
(7, 'Cap', 25);

INSERT INTO inventory(item_id, qty, type) VALUES
(1, 5, 'T'),
(2, 10, 'T'),
(3, 30, 'T'),
(4, 3, 'T'),
(5, 45, 'T'),
(6, 5, 'T'),
(7, 25, 'T'),
(5, 10, 'W');

INSERT INTO "ORDER"(order_no, item_id, qty) VALUES
('01', 1, 2),
('02', 2, 3),
('03', 5, 4),
('04', 4, 1),
('05', 5, 2),
('06', 6, 3),
('07', 1, 5),
('08', 2, 4),
('09', 3, 2),
('010', 4, 3);