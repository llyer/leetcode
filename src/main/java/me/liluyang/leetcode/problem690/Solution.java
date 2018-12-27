package me.liluyang.leetcode.problem690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class Solution {

    Map<Integer, Employee> employeeMap = new HashMap<>();

    /**
     * 1.这道题分析之后发现数据结构明显是树。需求就是给定一棵树，以及一棵树中的一个节点，求这个节点和对应的子树的权重（员工的重要性）之和
     * <p>
     * 2.list 的数据结构无法方便的根据 id 取得对应的 employee 节点，所以我们将 list 转化为 map
     * <p>
     * 3.数据结构中每个节点都存储子节点的 id，因此树形结构的节点关联关系就有了。
     * <p>
     * 4.递归（深度优先搜索）计算当前节点的重要性
     *
     * @param employees 公司的员工信息
     * @param id        其中一个员工id
     * @return 对应员工的重要性
     */
    public int getImportance(List<Employee> employees, int id) {

        // 将数据放到 map 中
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int eid) {
        Employee employee = employeeMap.get(eid);
        int answer = employee.importance;
        for (int id : employee.subordinates) {
            answer += dfs(id);
        }
        return answer;
    }
}

/**
 * 员工类。原型是树形数据结构中的 TreeNode
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;

    // the importance value of this employee
    public int importance;

    // the id of direct subordinates
    public List<Integer> subordinates;

}