-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS
GROUP BY CART_ID
HAVING GROUP_CONCAT(NAME) LIKE '%Milk%'
AND GROUP_CONCAT(NAME) LIKE '%Yogurt%'
ORDER BY CART_ID