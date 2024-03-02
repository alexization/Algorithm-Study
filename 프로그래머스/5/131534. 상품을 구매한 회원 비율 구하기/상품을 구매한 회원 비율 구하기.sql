-- 코드를 입력하세요
WITH TOTAL AS (
    SELECT COUNT(USER_ID) AS TOTAL_USER
    FROM USER_INFO
    WHERE JOINED LIKE '2021%'
    ),

VALUE AS (
    SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, COUNT(DISTINCT O.USER_ID) AS PUCHASED_USERS
    FROM USER_INFO AS U
    JOIN ONLINE_SALE AS O
    ON U.USER_ID = O.USER_ID
    WHERE U.JOINED LIKE '2021%'
    GROUP BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE)
    )

SELECT V.YEAR, V.MONTH, V.PUCHASED_USERS,
ROUND((V.PUCHASED_USERS / T.TOTAL_USER), 1) AS PUCHASED_RATIO
FROM TOTAL AS T, VALUE AS V
ORDER BY V.YEAR, V.MONTH