package tweeter;

public class SQL {

//    SELECT DEPARTMENT.NAME AS 'DNAME', IFNULL(COUNT(EMPLOYEE.DEPT_ID),0) AS 'NUM'
//    FROM DEPARTMENT
//    LEFT JOIN EMPLOYEE
//    ON EMPLOYEE.DEPT_ID=DEPARTMENT.DEPT_ID
//    GROUP BY DEPARTMENT.DEPT_ID,DEPARTMENT.NAME
//    ORDER BY NUM DESC, DNAME;

//    select o.customerNumber as customer
//    from ORDERS as o
//    group by customerNumber
//    order by count(orderNumber) desc
//    limit 1;


    //Parent, Children Node
//    https://www.hackerrank.com/challenges/binary-search-tree-1/problem
//    SELECT N, IF(P IS NULL,'Root',IF((SELECT COUNT(*) FROM BST WHERE P=B.N)>0,'Inner','Leaf'))
//    FROM BST AS B
//    ORDER BY N

//    SELECT N, IF(P IS NULL,'Root',IF(exists(SELECT N FROM BST WHERE P=B.N),'Inner','Leaf'))
//    FROM BST AS B
//    ORDER BY N
}
