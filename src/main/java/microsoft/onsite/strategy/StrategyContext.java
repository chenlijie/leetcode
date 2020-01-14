package microsoft.onsite.strategy;

import medium.TreeNode;

public class StrategyContext {

    private IteratorStrategy strategy;

    public void setStrategy(IteratorStrategy strategy) {
        this.strategy = strategy;
    }

    public void travesal(TreeNode node) {
        strategy.iterate(node);
    }
}
