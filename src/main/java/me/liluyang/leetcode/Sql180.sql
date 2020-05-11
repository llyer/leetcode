# 题目：180. 连续出现的数字
# 链接：https://leetcode-cn.com/problems/consecutive-numbers/
# 标签：Mysql

# 注意的点：题目中说的连续的三个，那就证明 id 是连续的
# 考察的知识点，链表的连表查询和 distinct 关键字

select distinct(l1.num) as ConsecutiveNums from
  logs l1,
  logs l2,
  logs l3

where l1.id = l2.id -1
      and l2.id = l3.id - 1
      and l1.num = l2.num
      and l2.num = l3.num

