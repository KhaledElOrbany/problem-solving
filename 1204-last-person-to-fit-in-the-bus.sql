select q.person_name 
from Queue q
where ((select sum(weight) from Queue q2 where q2.turn <= q.turn order by q2.turn) <= 1000)
order by q.turn desc
limit 1;