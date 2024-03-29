-- 코드를 작성해주세요
WITH DATA AS (
    SELECT D.ID,
    GROUP_CONCAT(S.NAME) AS CODENAME,
    GROUP_CONCAT(S.CATEGORY) AS CATENAME
    FROM SKILLCODES AS S
    JOIN DEVELOPERS AS D
    ON S.CODE & D.SKILL_CODE
    GROUP BY D.ID
    )
    
SELECT
CASE
    WHEN CATENAME LIKE '%Front End%' AND CODENAME LIKE '%Python%' THEN 'A'
    WHEN CODENAME LIKE '%C#%' THEN 'B'
    WHEN CATENAME LIKE '%Front End%' THEN 'C'
    END AS GRADE,
    D.ID, DEV.EMAIL
FROM DATA AS D
JOIN DEVELOPERS AS DEV
ON D.ID = DEV.ID
HAVING GRADE IS NOT NULL
ORDER BY GRADE, D.ID