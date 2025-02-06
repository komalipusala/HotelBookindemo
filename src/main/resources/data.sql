INSERT INTO customers (name, email, mobile, gender) VALUES
('Vedansh', 'vedansh@example.com', '1234567890', 'Male'),
('Komali', 'komali@example.com', '0987654321', 'Female');

INSERT INTO rooms (room_number, floor, room_type, bed_type, tariff, status) VALUES
(101, 1, 'Deluxe', 'Queen', 150.00, 'Available'),
(102, 1, 'Executive', 'King', 200.00, 'Occupied');

INSERT INTO booking_history (id, customer_id, room_number, start_date, end_date) VALUES
(1, 1, 101, '2025-02-05', '2025-02-05');

INSERT INTO upcoming_bookings (id, customer_id, start_date, room_type, bed_type, number_of_rooms) VALUES
(1, 2, '2025-02-20', 'Deluxe', 'Queen', 2);