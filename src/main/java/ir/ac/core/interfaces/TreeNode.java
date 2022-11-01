package ir.ac.core.interfaces;

import java.util.Collection;

public interface TreeNode<T extends TreeNode>  extends Treeable<T> {
   Collection<T> getChildren();
   T  getParent();

   boolean isLeaf();

}
