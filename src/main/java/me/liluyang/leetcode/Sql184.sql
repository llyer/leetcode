# 题目：184. 部门工资最高的员工
# 链接：https://leetcode-cn.com/problems/department-highest-salary/
# 标签：Mysql

-- 右表为 null 时不能返回数据，所以要用 join 不能用 left join

SELECT
  d.name AS department,
  e.name AS employee,
  e.salary
FROM employee AS e

  JOIN department AS d

    ON e.departmentId = d.id
WHERE (e.departmentId, e.salary) IN (SELECT
                                       departmentId,
                                       max(salary)
                                     FROM employee
                                     GROUP BY departmentId)