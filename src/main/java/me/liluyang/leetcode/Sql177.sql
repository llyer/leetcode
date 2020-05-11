# 题目：178. 分数排名
# 链接：https://leetcode-cn.com/problems/rank-scores/
# 标签：Mysql


# 考察知识：
#      1. 要定义变量接受函数里面的参数
#      2. set, group by, order by, limit, offset 关键字
# 注意的点：
#      1. 薪水需要去重
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
       BEGIN
              SET N = N - 1;
              RETURN (
                     # Write your MySQL query statement below.
                     select salary
                     from employee
                     group by salary
                     order by salary desc
                     limit 1 offset N
              );
       END