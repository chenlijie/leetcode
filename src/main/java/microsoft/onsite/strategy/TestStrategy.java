package microsoft.onsite.strategy;

import medium.TreeNode;

public class TestStrategy {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        context.setStrategy(new PreOrderStrategy());
        context.travesal(new TreeNode(1));
    }
}
