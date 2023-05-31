INSERT IGNORE INTO categories (id, name, description) VALUES('6e8d7398-bb18-458d-9ded-86bd6d4ad587', 'WORK', 'Mochilas para el trabajo');
INSERT IGNORE INTO categories (id, name, description) VALUES('2e7ffcd8-f30b-4f6ea-a7b8-ad1396a99c08', 'TRAVEL', 'Mochilas para viaje');
INSERT IGNORE INTO categories (id, name, description) VALUES('8f390fda-2327-4c67-bda4-b173cb807768', 'SPORT', 'Mochilas deportivas');

-- Default roles --
INSERT IGNORE INTO roles (id, name, description) VALUES('a1b6d042-1be4-4907-9814-daf110a473f9', 'USER', 'Role user');
INSERT IGNORE INTO roles (id, name, description) VALUES('94dcfd3f-2367-4a67-bd81-4b6764513dc5', 'ADMIN', 'Role admin');

-- Products --
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('0fe9039f-109f-4547-9ffd-53d4006c65d1', true, 'descripcion mochila A', 'http://image.png', 'mochilas A', 15, 10, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('804ac3f2-6220-4f5d-ad9e-2b5de6873ad8', true, 'descripcion mochila B', 'http://image.png', 'mochilas B', 15.99, 20, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('34436f6f-e69d-4b37-9d43-5613ba09b4ac', true, 'descripcion mochila C', 'http://image.png', 'mochilas C', 16.99, 30, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('6a8c9b35-735f-4334-b85d-8df312c086ec', true, 'descripcion mochila D', 'http://image.png', 'mochilas D', 17, 40, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('d38430c1-e47f-4cdc-b1ab-71be5ea4b1e3', true, 'descripcion mochila E', 'http://image.png', 'mochilas E', 18.99, 50, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('6cef47db-6f20-4c47-9149-770b076d046f', true, 'descripcion mochila F', 'http://image.png', 'mochilas F', 19.99, 60, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('7881382d-3aef-49ce-964f-0b5b8117dd32', true, 'descripcion mochila G', 'http://image.png', 'mochilas G', 20, 70, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('49f6fb11-523c-44f4-92a8-578c2c86f5e5', true, 'descripcion mochila H', 'http://image.png', 'mochilas H', 21.99, 80, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('0cae6dd9-53c7-4ba5-850e-0fc8d27fca34', true, 'descripcion mochila I', 'http://image.png', 'mochilas I', 22.99, 90, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('88631823-cec6-4c9a-9666-979e54a57ed9', true, 'descripcion mochila J', 'http://image.png', 'mochilas J', 23, 100, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('0f90eb57-cc16-4f0a-9a1e-10f4d316794e', true, 'descripcion mochila K', 'http://image.png', 'mochilas K', 24.99, 10, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');
INSERT IGNORE INTO products(id, active, description, image_url, name, price, stock, category_id)
VALUES('e570d539-b097-418c-9b48-cfd880aa00d2', true, 'descripcion mochila L', 'http://image.png', 'mochilas L', 25.99, 20, '6e8d7398-bb18-458d-9ded-86bd6d4ad587');

-- User --
INSERT IGNORE INTO users (id, first_name, last_name, email, password, address, role_id)
VALUES('087cd593-113b-4650-8cea-b8640c6c16a0', 'Juan', 'Perez', 'admin@gmail.com', '123456', 'Cochabamba', '94dcfd3f-2367-4a67-bd81-4b6764513dc5');
INSERT IGNORE INTO users (id, first_name, last_name, email, password, address, role_id)
VALUES('fb7161b9-9c6f-4b70-99eb-3364653a4c84', 'Ana', 'Peredo', 'user@gmail.com', '123456', 'Cochabamba', 'a1b6d042-1be4-4907-9814-daf110a473f9');