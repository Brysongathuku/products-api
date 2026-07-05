-- admin / admin123
-- user  / user123
INSERT INTO users (full_name, username, email, password, role, status) VALUES
    ('Bryson Admin', 'admin', 'admin@pesira.com', '$2b$10$46AzBnrGoDLz7/vcGxY4vuDZt/KUrLw0EYJNPsR2ZJskUqyLKC/O.', 'ADMIN', 'ACTIVE'),
    ('Jane User', 'user', 'user@pesira.com', '$2b$10$Vqa4mC4muhcZ76SnjqhqCumOXb7jE2Iw09TNLf9pWa.E7181POuJG', 'USER', 'ACTIVE');

INSERT INTO products (name, description, category, price, quantity, image_url) VALUES
    ('Wireless Mouse', 'Ergonomic wireless mouse with USB receiver', 'Electronics', 1500.00, 120, 'https://placehold.co/300x300?text=Mouse'),
    ('Mechanical Keyboard', 'RGB backlit mechanical keyboard, blue switches', 'Electronics', 6500.00, 45, 'https://placehold.co/300x300?text=Keyboard'),
    ('Office Chair', 'Adjustable ergonomic office chair with lumbar support', 'Furniture', 15000.00, 20, 'https://placehold.co/300x300?text=Chair'),
    ('Standing Desk', 'Electric height-adjustable standing desk', 'Furniture', 32000.00, 8, 'https://placehold.co/300x300?text=Desk'),
    ('USB-C Hub', '7-in-1 USB-C hub with HDMI and card reader', 'Electronics', 3200.00, 60, 'https://placehold.co/300x300?text=Hub'),
    ('Notebook Pack', 'Pack of 5 A5 ruled notebooks', 'Stationery', 800.00, 200, 'https://placehold.co/300x300?text=Notebooks'),
    ('Desk Lamp', 'LED desk lamp with adjustable brightness', 'Furniture', 2200.00, 0, 'https://placehold.co/300x300?text=Lamp'),
    ('External SSD 1TB', 'Portable USB 3.2 external SSD, 1TB capacity', 'Electronics', 9500.00, 30, 'https://placehold.co/300x300?text=SSD'),
    ('Whiteboard Markers', 'Set of 8 assorted color whiteboard markers', 'Stationery', 600.00, 150, 'https://placehold.co/300x300?text=Markers'),
    ('Webcam HD', '1080p HD webcam with built-in microphone', 'Electronics', 4200.00, 25, 'https://placehold.co/300x300?text=Webcam');
