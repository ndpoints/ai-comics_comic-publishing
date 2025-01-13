CREATE TABLE comic_publishing (
    publication_id INTEGER NOT NULL UNIQUE,
    comic_id INTEGER NOT NULL,
    published_at DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    platform VARCHAR(100) NOT NULL,
    PRIMARY KEY (publication_id)
);

CREATE INDEX idx_comic_id ON comic_publishing(comic_id);

INSERT INTO comic_publishing (publication_id, comic_id, published_at, status, platform) VALUES
(1, 101, NOW(), 'published', 'Web'),
(2, 102, NOW(), 'draft', 'Mobile'),
(3, 103, NOW(), 'published', 'Print');