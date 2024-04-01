select BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE from book as b
join author as a on b.author_id = a.author_id
where category like '경제'
order by published_date
