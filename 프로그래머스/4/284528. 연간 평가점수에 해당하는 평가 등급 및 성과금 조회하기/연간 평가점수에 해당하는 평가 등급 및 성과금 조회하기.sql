-- 코드를 작성해주세요
WITH SCORE_BOARD AS (
    SELECT EMP_NO, AVG(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
    ),

RESULT AS (
    SELECT S.EMP_NO, H.EMP_NAME,
    CASE
        WHEN S.SCORE >= 96 THEN 'S'
        WHEN S.SCORE >= 90 THEN 'A'
        WHEN S.SCORE >= 80 THEN 'B'
        ELSE 'C'
        END AS GRADE,
    H.SAL
    FROM SCORE_BOARD AS S
    JOIN HR_EMPLOYEES AS H
    ON S.EMP_NO = H.EMP_NO
    )

SELECT EMP_NO, EMP_NAME, GRADE,
CASE GRADE
    WHEN 'S' THEN (SAL * 0.2)
    WHEN 'A' THEN (SAL * 0.15)
    WHEN 'B' THEN (SAL * 0.1)
    ELSE 0
    END AS BONUS
FROM RESULT
ORDER BY EMP_NO