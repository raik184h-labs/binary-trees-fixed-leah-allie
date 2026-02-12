package edu.unl.raikes.BinarySearchTreeLab;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class InOrderTraversal<BinarySearchTree> {
    List<BinarySearchNode> traversalList;
	
	
	// TODO: write JavaDoc comments
	public List<BinarySearchNode> inOrderTraversal(BinarySearchTree tree){
		// TODO: set up variables (especially the list to return)
		this.traversalList = new ArrayList();
        if (tree.getRoot() != null) {
            
        }
		this.inOrderTraversal(tree.getRoot());
		
		return this.traversalList;
	}
	
	// TODO: write JavaDoc comments
	private void inOrderTraversal(BinarySearchNode node) {
		// TODO: perform recursive traversal
        if (node.getLeftChild() == null) {
            this.traversalList.add(node.getParent());
        } else {
            if (node.getLeftChild() != null) {
                this.inOrderTraversal(node.getLeftChild());    
            } 
            this.traversalList.add(node.getParent());
            if (node.getRightChild() != null) {
                this.inOrderTraversal(node.getRightChild());
            }
        }

	}

}
