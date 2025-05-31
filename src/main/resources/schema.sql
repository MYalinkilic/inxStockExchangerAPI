CREATE TABLE customer_assets (
                                 id BIGINT PRIMARY KEY,
                                 customer_id VARCHAR(255),
                                 asset_name VARCHAR(255),
                                 size FLOAT,
                                 usable_size FLOAT
);