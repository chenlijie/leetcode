package easy

import spock.lang.Specification

/**
 * Created by chenlijie on 4/2/17.
 */
class Invert_Binary_Tree_226Test extends Specification {

    void 'test'() {
        given:
        Invert_Binary_Tree_226.TreeNode node1 = new Invert_Binary_Tree_226.TreeNode(1)
        Invert_Binary_Tree_226.TreeNode node2 = new Invert_Binary_Tree_226.TreeNode(2)
        Invert_Binary_Tree_226.TreeNode node3 = new Invert_Binary_Tree_226.TreeNode(3)

        node1.left = node2

        when:
        Invert_Binary_Tree_226.invertTree(node1)

        then:
        node1.right.val == 2
        node1.left == null
    }
}
