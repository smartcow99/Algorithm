SELECT 
    c.car_id, 
    c.car_type, 
    CAST((c.daily_fee * (100 - p.discount_rate) / 100 * 30) AS SIGNED INTEGER) AS FEE
FROM 
    CAR_RENTAL_COMPANY_CAR AS c
LEFT JOIN 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY AS h ON c.car_id = h.car_id
    AND h.start_date <= '2022-11-30'
    AND h.end_date >= '2022-11-01'
LEFT JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS p ON c.car_type = p.car_type 
WHERE 
    c.car_type IN ('세단', 'SUV')
    AND h.car_id IS NULL
    AND p.duration_type = '30일 이상'
    AND CAST((c.daily_fee * (100 - p.discount_rate) / 100 * 30) AS SIGNED INTEGER) >= 500000
    AND CAST((c.daily_fee * (100 - p.discount_rate) / 100 * 30) AS SIGNED INTEGER) < 2000000
ORDER BY 
    FEE DESC, 
    c.car_type ASC, 
    c.car_id DESC;