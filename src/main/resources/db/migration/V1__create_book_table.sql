CREATE TABLE book (
                      book_id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      publication_year INT NOT NULL,
                      genre VARCHAR(255) NOT NULL,
                      finished BOOLEAN NOT NULL DEFAULT FALSE,
                      rating INT NOT NULL DEFAULT 0
);