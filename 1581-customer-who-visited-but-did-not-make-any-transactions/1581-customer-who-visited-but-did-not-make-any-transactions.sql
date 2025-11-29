# Write your MySQL query statement below
SELECT customer_id, COUNT(*) AS count_no_trans FROM Visits v LEFT JOIN Transactions t ON v.visit_id=t.visit_id WHERE t.visit_id is NULL GROUP BY customer_id
