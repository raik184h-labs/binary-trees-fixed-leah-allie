package edu.unl.raikes.BinarySearchTreeLab;

import java.util.ArrayList;
import java.util.List;
import edu.unl.raikes.BinarySearchTreeLab.InOrderTraversal;
import org.w3c.dom.Node;

/**
 * The binary search tree.
 */
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    /**
     * insterts stuff.
     * @param data the data
     */
    public void insert(Person data) {
        boolean inserted = false;
        // if statement
        if (this.root == null) {
            this.root = new BinarySearchNode(data);
            inserted = true;
        } else {
            inserted = this.root.insert(data);
        }
        if (inserted) {
            this.size++;
        }
    }

    /**
     * Searches stuff.
     * @param key the key
     * @return null or found person
     */
    public Person search(int key) {
        // if statement
        if (this.root == null) {
            return null;
        }
        // creates variable
        BinarySearchNode found = this.root.search(key);
        // Tchecks if found
        if (found != null) {
            return found.person;
        } else {
            return null;
        }

    }

    /**
     * Deletes stuff.
     * @param key the key
     * @return delted
     */
    public Person delete(int key) {
        Person deleted = null;

        // if statement
        if (this.root == null) {
            return null;
        } else { //else
            // checks if key
            if (this.root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(this.root);
                // deletes root
                deleted = this.root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                this.root = auxRoot.leftChild;
                // checks if root not null
                if (this.root != null) {
                    this.root.parent = null;
                }  
            }
            else {
                deleted = this.root.delete(key);
            }

<<<<<<< HEAD
            if (deleted != null) {
                this.size--;
            }
            return deleted;
        }
    }

    /**
     * Makes a to string.
     */
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + this.size + "\n";
        BinarySearchNode currNode = this.root;
        List<BinarySearchNode> list = new ArrayList<BinarySearchNode>();
        this.inOrderTraversal(currNode, list);
        for (BinarySearchNode node : list) {
            if (node != null) {
                toReturn += node.toString();
            }
        }
        return toReturn;
    }

    /**
     * Traversal.
     * @param root the root.
     * @param result the result.
     */
    private void inOrderTraversal(BinarySearchNode root, List<BinarySearchNode> result) {
        if (root == null) {
            return;
        } 
        this.inOrderTraversal(root.leftChild, result);
        result.add(root);
        this.inOrderTraversal(root.rightChild, result);
=======
	// TODO: ADD JAVADOC COMMENT
	public String toString() {
		String toReturn = "Binary Search Tree of Size: " + size + "\n";
		BinarySearchNode currNode = this.root;
		List<BinarySearchNode> list = InOrderTraversal.inOrderTraversal(this);
		for (BinarySearchNode node : list) {
			if (node != null) {
				toReturn += node.toString();
			}
		}
		return toReturn;
	}

    public BinarySearchNode getRoot() {
        return this.root;
>>>>>>> 75d60fef13f7efebddb2bce91ce4241be366813f
    }
}
