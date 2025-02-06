CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    mobile VARCHAR(15) NOT NULL,
    gender VARCHAR(10)
);

CREATE TABLE rooms (
    room_number INT PRIMARY KEY,
    floor INT NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    bed_type VARCHAR(50) NOT NULL,
    tariff DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('Available', 'Occupied'))
);

CREATE TABLE booking_history (
    id SERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    room_number INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (room_number) REFERENCES rooms(room_number)
);

CREATE TABLE upcoming_bookings (
    id SERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    bed_type VARCHAR(50) NOT NULL,
    number_of_rooms INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);






