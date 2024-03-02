-- 코드를 입력하세요
WITH VALUE AS (
    SELECT C.CAR_TYPE, C.DAILY_FEE, H.HISTORY_ID,
    CASE
        WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
        ELSE 'NONE'
        END AS DURATION_TYPE,
    DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS DURATION
    FROM CAR_RENTAL_COMPANY_CAR AS C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    ON C.CAR_ID = H.CAR_ID
    WHERE C.CAR_TYPE LIKE '트럭'
    )

SELECT V.HISTORY_ID,
ROUND((V.DAILY_FEE * V.DURATION) * ((100 - IFNULL(P.DISCOUNT_RATE, 0)) / 100)) AS FEE
FROM VALUE AS V
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
ON V.CAR_TYPE = P.CAR_TYPE
AND V.DURATION_TYPE = P.DURATION_TYPE
ORDER BY FEE DESC, V.HISTORY_ID DESC