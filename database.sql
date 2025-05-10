CREATE TABLE `users` (
    id serial INTEGER,
    login TEXT NOT NULL UNIQUE,
    hashed_password TEXT NOT NULL
)

CREATE TYPE FURNISH AS ENUM ('DESIGNER', 'NONE', 'FINE', 'LITTLE');
CREATE TYPE VIEW_ENUM AS ENUM ('STREET', 'PARK', 'BAD', 'NORMAL', 'TERRIBLE');
CREATE TYPE TRANSPORT AS ENUM ('FEW', 'NONE', 'NORMAL');


CREATE TABLE `flat_collection` (
    id serial PRIMARY KEY,
    user_id INTEGER REFERENCES users(id) NOT NULL,
    name TEXT NOT NULL,
    coordinate_x DOUBLE NOT NULL CHECK(coordinate_x < 497),
    coordinate_y DOUBLE NOT NULL CHECK(coordinate_x > -738),
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    area FLOAT NOT NULL CHECK(area > 0),
    number_of_rooms INTEGER NOT NULL CHECK(number_of_rooms BETWEEN 0 AND 20),
    furnish FURNISH DEFAULT NULL,
    flat_view VIEW_ENUM DEFAULT NULL,
    transport TRANSPORT DEFAULT NULL,
    house_name TEXT DEFAULT NULL,
    house_year BIGINT CHECK(house_year > 0) DEFAULT NULL,
    house_number_of_lifts BIGINT CHECK(house_number_of_lifts > 0) DEFAULT NULL
)