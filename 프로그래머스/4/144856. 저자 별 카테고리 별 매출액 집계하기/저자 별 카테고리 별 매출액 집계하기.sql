-- 코드를 입력하세요
WITH VALUE AS (
    SELECT S.BOOK_ID, B.CATEGORY, B.AUTHOR_ID, (S.SALES * B.PRICE) AS SALES
    FROM BOOK_SALES AS S
    JOIN BOOK AS B
    ON S.BOOK_ID = B.BOOK_ID
    WHERE S.SALES_DATE LIKE '2022-01%'
    )

SELECT A.AUTHOR_ID, A.AUTHOR_NAME, V.CATEGORY, SUM(V.SALES) AS TOTAL_SALES
FROM VALUE AS V
JOIN AUTHOR AS A
ON V.AUTHOR_ID = A.AUTHOR_ID
GROUP BY A.AUTHOR_NAME, V.CATEGORY
ORDER BY A.AUTHOR_ID, V.CATEGORY DESC