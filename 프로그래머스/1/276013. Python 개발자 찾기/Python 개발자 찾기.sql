-- 코드를 작성해주세요
WITH VALUE AS (
    SELECT ID, CONCAT_WS('', SKILL_1, SKILL_2, SKILL_3) AS SKILLS
    FROM DEVELOPER_INFOS
    HAVING SKILLS LIKE '%Python%'
)

SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPER_INFOS AS D
JOIN VALUE
ON D.ID = VALUE.ID
ORDER BY D.ID