-- 코드를 입력하세요
SELECT i.NAME, i.DATETIME 
FROM ANIMAL_INS as i LEFT JOIN ANIMAL_OUTS as o ON i.ANIMAL_ID = o.ANIMAL_ID 
WHERE o.ANIMAL_ID IS NULL 
ORDER BY 2 
LIMIT 3;