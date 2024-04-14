-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, SUM(PRICE) TOTAL_SALES FROM USED_GOODS_BOARD UGB
JOIN USED_GOODS_USER UGU ON UGB.WRITER_ID = UGU.USER_ID
WHERE STATUS = 'DONE'
GROUP BY USER_ID HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES ASC
