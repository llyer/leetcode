# 题目：178. 分数排名
# 链接：https://leetcode-cn.com/problems/rank-scores/
# 标签：Mysql


-- 主要考察的就是 distinct, count 关键字
-- 另外要注意的就是 rank，可以用单引号括起来就可以避免被当做关键字判断
select a.Score as Score,
       (select count(distinct b.Score) from Scores as b where b.Score >= a.Score) as 'Rank'
from Scores as a
order by a.Score DESC