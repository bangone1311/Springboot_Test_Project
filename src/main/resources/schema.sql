CREATE PROCEDURE SP_INIT
AS
BEGIN
    IF NOT EXISTS(SELECT * FROM ROLES)
    BEGIN
        INSERT INTO roles(name) VALUES('ROLE_USER')
        INSERT INTO roles(name) VALUES('ROLE_MODERATOR')
        INSERT INTO roles(name) VALUES('ROLE_ADMIN')
    END

    INSERT INTO users (username, email, password) VALUES
      ('admin', 'admin@gmail.com', '$2a$10$crRTdpEOrKUSzdDv7PLhP.4k348ABRc5UrPThz6pVtKAfB9X9eW3m')

    INSERT INTO USER_ROLES VALUES (1,3)
END;
