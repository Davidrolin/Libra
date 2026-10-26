ALTER TABLE book ADD COLUMN user_id INT;

ALTER TABLE book
    ADD CONSTRAINT fk_book_user
        FOREIGN KEY (user_id) REFERENCES app_user(user_id) ON DELETE CASCADE;