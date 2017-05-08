package easy

import spock.lang.Specification

class Sum_Of_Left_Leaves_404Test extends Specification {

    void 'test'() {
        given:
        Sum_Of_Left_Leaves_404.TreeNode leaves1 = new Sum_Of_Left_Leaves_404.TreeNode(1)

        Sum_Of_Left_Leaves_404.TreeNode leaves2 = new Sum_Of_Left_Leaves_404.TreeNode(1)
        Sum_Of_Left_Leaves_404.TreeNode leaves3 = new Sum_Of_Left_Leaves_404.TreeNode(1)

        Sum_Of_Left_Leaves_404.TreeNode leaves4 = new Sum_Of_Left_Leaves_404.TreeNode(1)
        Sum_Of_Left_Leaves_404.TreeNode leaves5 = new Sum_Of_Left_Leaves_404.TreeNode(1)

        Sum_Of_Left_Leaves_404.TreeNode leaves6 = new Sum_Of_Left_Leaves_404.TreeNode(3)
        Sum_Of_Left_Leaves_404.TreeNode leaves7 = new Sum_Of_Left_Leaves_404.TreeNode(1)

        Sum_Of_Left_Leaves_404.TreeNode leaves8 = new Sum_Of_Left_Leaves_404.TreeNode(7)
        Sum_Of_Left_Leaves_404.TreeNode leaves9 = new Sum_Of_Left_Leaves_404.TreeNode(1)

        leaves1.left = leaves2
        leaves1.right = leaves3

        leaves2.left = leaves4
        leaves2.right = leaves5

        leaves3.left = leaves6
        leaves3.right = leaves7

        leaves4.left = leaves8
        leaves4.right = leaves9

        Sum_Of_Left_Leaves_404.TreeNode leaves = new Sum_Of_Left_Leaves_404.TreeNode(1)

        expect:
//        Sum_Of_Left_Leaves_404.sumOfLeftLeaves(leaves1) == 10
        Sum_Of_Left_Leaves_404.sumOfLeftLeaves(leaves) == 0

    }

}
