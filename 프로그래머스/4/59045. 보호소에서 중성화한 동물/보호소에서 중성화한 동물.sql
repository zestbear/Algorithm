-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME 
FROM ANIMAL_INS as i JOIN ANIMAL_OUTS as o ON i.ANIMAL_ID = o.ANIMAL_ID 
WHERE NOT i.SEX_UPON_INTAKE = o.SEX_UPON_OUTCOME;