SELECT sum(STD_YY)
FROM TB_PRPSL_MST;


SELECT DISTINCT BIZ_TP
FROM TB_PRPSL_MST;


-- 프로젝트명으로 검색
SELECT PRJ_CD AS 프로젝트코드, PRJ_NM AS 프로젝트명, STD_YY AS 기준년도, BUSI_RPSR_NM AS 영업대표, PFRM_PM_NM AS 수행PM, LST_CUST AS 고객명, BIZ_TP AS 사업유형
FROM TB_PRPSL_MST
WHERE PRJ_NM LIKE CONCAT('%', UPPER('ao'), '%');

SELECT PRJ_CD AS 프로젝트코드, PRJ_NM AS 프로젝트명, STD_YY AS 기준년도, BUSI_RPSR_NM AS 영업대표, PFRM_PM_NM AS 수행PM, LST_CUST AS 고객명, BIZ_TP AS 사업유형
FROM TB_PRPSL_MST
WHERE PRJ_NM LIKE '%ao%';

SELECT PRJ_CD AS 프로젝트코드, PRJ_NM AS 프로젝트명, STD_YY AS 기준년도, BUSI_RPSR_NM AS 영업대표, PFRM_PM_NM AS 수행PM, LST_CUST AS 고객명, BIZ_TP AS 사업유형
FROM TB_PRPSL_MST
WHERE PRJ_NM LIKE CONCAT('%', 'ao', '%');

SELECT upper('a')
from dual;

SELECT trim(' a  o')
from dual;

select REPLACE(' 개인 정보 ', ' ', '')
from dual;


select 
    M.PRJ_CD, 
    M.PRJ_NM,
    M.STD_YY, 
    M.BUSI_RPSR_NM, 
    M.PFRM_PM_NM, 
    M.LST_CUST, 
    M.BIZ_TP
FROM TB_PRPSL_MST M
WHERE M.PRJ_NM LIKE CONCAT('%', REPLACE('a o', ' ', ''), '%')
AND M.PRJ_NM LIKE CONCAT('%', REPLACE('2021', ' ', ''), '%');


select CONCAT('%', UPPER(REPLACE('ao i', ' ', '')), '%')
from dual;


select CONCAT('%', REPLACE('ao i', ' ', ''), '%')
from dual;


SELECT TRIM('  안녕하세요  ');




