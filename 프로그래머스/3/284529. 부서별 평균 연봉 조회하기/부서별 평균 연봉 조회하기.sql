-- 코드를 작성해주세요
WITH RESULT AS (
    SELECT D.DEPT_NAME_EN, ROUND(AVG(E.SAL)) AS AVG_SAL
    FROM HR_DEPARTMENT AS D
    JOIN HR_EMPLOYEES AS E
    ON D.DEPT_ID = E.DEPT_ID
    GROUP BY D.DEPT_NAME_EN
    )

SELECT D.DEPT_ID, R.DEPT_NAME_EN, R.AVG_SAL
FROM RESULT AS R
JOIN HR_DEPARTMENT AS D
ON R.DEPT_NAME_EN = D.DEPT_NAME_EN
ORDER BY AVG_SAL DESC