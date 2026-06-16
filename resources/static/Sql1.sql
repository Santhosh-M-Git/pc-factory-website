CREATE TABLE pc_orders (
    id NUMBER PRIMARY KEY,
    cpu VARCHAR2(100),
    gpu VARCHAR2(100),
    ram VARCHAR2(50),
    ssd VARCHAR2(50),
    psu VARCHAR2(50),
    cabinet VARCHAR2(50),
    total_price NUMBER,
    customer_name VARCHAR2(100),
    email VARCHAR2(100),
    phone VARCHAR2(20)
);



CREATE SEQUENCE pc_orders_seq
START WITH 1
INCREMENT BY 1
NOCACHE;



CREATE OR REPLACE TRIGGER pc_orders_trigger
BEFORE INSERT ON pc_orders
FOR EACH ROW
BEGIN
  SELECT pc_orders_seq.NEXTVAL
  INTO :NEW.id
  FROM dual;
END;
/

SELECT * FROM pc_orders;


DROP TABLE pc_orders;

DROP SEQUENCE pc_orders_seq;

DELETE FROM pc_orders;
COMMIT;

DROP TRIGGER pc_orders_trigger;




CREATE TABLE contact_messages (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    email VARCHAR2(100),
    phone VARCHAR2(20),
    message VARCHAR2(500)
);



CREATE SEQUENCE contact_seq
START WITH 1
INCREMENT BY 1;



CREATE OR REPLACE TRIGGER contact_trigger
BEFORE INSERT ON contact_messages
FOR EACH ROW
BEGIN
SELECT contact_seq.NEXTVAL
INTO :NEW.id
FROM dual;
END;
/


SELECT * FROM contact_messages;


DELETE FROM contact_messages;
COMMIT;

DROP SEQUENCE contact_seq;

DROP TRIGGER contact_trigger;




CREATE TABLE review (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    message VARCHAR2(500)
);

CREATE SEQUENCE review_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE OR REPLACE TRIGGER review_trigger
BEFORE INSERT ON review
FOR EACH ROW
BEGIN
  SELECT review_seq.NEXTVAL INTO :NEW.id FROM dual;
END;
/
COMMIT;


DROP SEQUENCE review_seq;

DROP TRIGGER review_trigger;

DELETE FROM review;

SELECT * FROM review;



ALTER TABLE review ADD status VARCHAR2(20);

UPDATE review SET status='ACTIVE';
COMMIT;



CREATE TABLE content (
    id NUMBER PRIMARY KEY,
    page VARCHAR2(50),
    section VARCHAR2(50),
    content VARCHAR2(1000)
);

CREATE SEQUENCE content_seq 
START WITH 1 
INCREMENT BY 1
NOCACHE;

CREATE OR REPLACE TRIGGER content_trigger
BEFORE INSERT ON content
FOR EACH ROW
BEGIN
  SELECT content_seq.NEXTVAL INTO :NEW.id FROM dual;
END;
/

COMMIT;

DROP TABLE website_content;

DELETE FROM content WHERE page='contact';
COMMIT;

ALTER TABLE content 
ADD CONSTRAINT unique_page_section UNIQUE (page, section);

DROP TRIGGER content_trigger;