# Write your MySQL query statement below
SELECT DISTINCT p.email AS Email FROM Person p JOIN Person d ON p.id != d.id WHERE p.email = d.email