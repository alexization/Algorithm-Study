-- 코드를 입력하세요
WITH JULY AS (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    FROM JULY
    GROUP BY FLAVOR
    ),

RESULT AS (
    SELECT F.FLAVOR, SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) AS TOTAL_ORDER
    FROM FIRST_HALF AS F
    JOIN JULY AS J
    ON F.FLAVOR = J.FLAVOR
    GROUP BY F.FLAVOR
    )

SELECT FLAVOR
FROM RESULT
ORDER BY TOTAL_ORDER DESC
LIMIT 3