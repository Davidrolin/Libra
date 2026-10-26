CREATE TABLE app_user (
                          user_id INT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(50) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          enabled BOOLEAN NOT NULL DEFAULT TRUE
);

-- Kopplings-tabell för användarens roller
CREATE TABLE user_roles (
                            user_id INT NOT NULL,
                            role VARCHAR(50) NOT NULL,
                            PRIMARY KEY (user_id, role),
                            FOREIGN KEY (user_id) REFERENCES app_user(user_id) ON DELETE CASCADE
);