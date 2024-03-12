-- 코드를 입력하세요
SELECT j.flavor from july as j
left join first_half as fh on fh.shipment_id = j.shipment_id
group by j.flavor 
order by sum(j.total_order) + fh.total_order desc
limit 3
