
-- 트리거에 필요한 테이블
CREATE TABLE SEQUENCE_TEST (
    dd DATE PRIMARY KEY,
    seq INT DEFAULT 1
);

CREATE TABLE TABLE_TEST (
    id VARCHAR(15) PRIMARY KEY,
   	name VARCHAR(15)
);


-- 트리거 생성
DELIMITER //
CREATE TRIGGER TABLE_TEST_PK
BEFORE INSERT ON TABLE_TEST
FOR EACH ROW
BEGIN
    DECLARE new_id VARCHAR(15);
    DECLARE current_seq INT;

    -- 시퀀스 테이블에서 오늘 날짜의 시퀀스를 가져옴
    SELECT seq INTO current_seq FROM SEQUENCE_TEST WHERE dd = CURRENT_DATE;

   	   
    IF current_seq IS NULL THEN	  	-- 시퀀스가 없으면 오늘 날짜에 해당하는 레코드를 추가
        INSERT INTO SEQUENCE_TEST (dd) VALUES (CURRENT_DATE);
        SET current_seq = 1;
       
    ELSE   							-- 시퀀스가 있으면 1 증가
        UPDATE SEQUENCE_TEST SET seq = seq + 1 WHERE dd = CURRENT_DATE;
        SET current_seq = current_seq + 1;
    END IF;

    -- PK 생성
    SET new_id = CONCAT('PPP', DATE_FORMAT(CURRENT_DATE, '%Y%m%d'), LPAD(current_seq, 3, '0'));
    SET NEW.id = new_id;

END //
DELIMITER ;


-- 테스트용 코드
INSERT INTO TABLE_TEST (name) values ('홍길동'), ('전지현'), ('김태희');


