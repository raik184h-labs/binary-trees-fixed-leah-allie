package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Binary search node.
 */
class BinarySearchNode {
    protected BinarySearchNode parent;
    protected BinarySearchNode leftChild;
    protected BinarySearchNode rightChild;
    protected Person person;

    /**
     * setters and getters.
     * @param person the person
     */
    BinarySearchNode(Person person) {
        this.person = person;
    }

    /**
     * inserts stuff.
     * @param data the data
     * @return child
     */
    boolean insert(Person data) {
        // if statement
        if (data == this.person) {
            return false;
        } else if (Integer.compare(data.key, this.person.key) < 0) {
            // if statement
            if (this.leftChild == null) {
                this.setLeftChild(new BinarySearchNode(data));
                return true;
            } else {
                return this.leftChild.insert(data);
            }
        } else if (Integer.compare(data.key, this.person.key) > 0) {
            // if statment
            if (this.rightChild == null) {
                this.setRightChild(new BinarySearchNode(data));
                return true;
            } else {
                return this.rightChild.insert(data);
            }
        }
        return false;
    }

    /**
     * searches stuff.
     * @param key the key
     * @return this or child
     */
    BinarySearchNode search(int key) {
        // search key.
        if (this.leftChild != null && Integer.compare(key, this.person.key) < 0) {
            return this.leftChild.search(key);
        } else if (this.rightChild != null && Integer.compare(key, this.person.key) > 0) {
            return this.rightChild.search(key);
        } else if (this.person.key == key) {
            return this;
        } else {
            return null;
        }
    }

    /**
     * deletes stuff.
     * @param key the key
     * @return child
     */
    Person delete(int key) {
        // search node
        BinarySearchNode node = this.search(key);
        if (node == null) {
            return null;
        }
        Person deleted = node.person;

        // if statement
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent.leftChild == node) {
                node.parent.setLeftChild(null);
            }
            else if (node.parent.rightChild == node) {
                node.parent.setRightChild(null);
            }
        } else if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode min = node.rightChild.getNodeWithMinValue();
            node.person = min.person;
            int minKey = min.person.key;
            min.delete(minKey);
        } else if (node.parent.leftChild == node) {
            BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setLeftChild(newLeftChild);
        } else if (node.parent.rightChild == node) {
            BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setRightChild(newRightChild);
        }
        return deleted;
    }

    /**
     * gets min value.
     * @return left child or this
     */
    BinarySearchNode getNodeWithMinValue() {
        if (this.leftChild == null) {
            return this;
        } else {
            return this.leftChild.getNodeWithMinValue();
        }
    }

    /**
     * sets left child.
     * @param child child
     */
    void setLeftChild(BinarySearchNode child) {
        this.leftChild = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * sets right child.
     * @param child the child
     */
    void setRightChild(BinarySearchNode child) {
        this.rightChild = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /** 
     * in order search used for to string.
     */
    public String toString() {
        String toReturn = "";
        
        // returns string formated nicely
        toReturn += "  " + this.person.toString() + "\n";

        return toReturn;
    }

}