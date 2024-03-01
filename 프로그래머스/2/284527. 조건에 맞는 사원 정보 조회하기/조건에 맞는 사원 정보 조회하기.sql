-- 코드를 작성해주세요
WITH VALUE AS (
    SELECT EMP_NO, SUM(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
    ORDER BY SCORE DESC
    LIMIT 1
    )

SELECT V.SCORE, V.EMP_NO, H.EMP_NAME, H.POSITION, H.EMAIL
FROM VALUE AS V
JOIN HR_EMPLOYEES AS H
ON V.EMP_NO = H.EMP_NO