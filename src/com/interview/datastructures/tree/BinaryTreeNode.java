package com.interview.datastructures.tree;

public class BinaryTreeNode {
	
	private int value;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	private BinaryTreeNode parent;
    private int size = 1;
	
	public BinaryTreeNode(int value){
		this.value = value;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
        if(leftChild != null)
		    leftChild.setParent(this);
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

    public int size() {
        return this.size;
    }

    public int resize() {
        int leftSubTreeSize = this.getLeftChild() == null ? 0 : this.getLeftChild().resize();
        int rightSubTreeSize = this.getRightChild() == null ? 0 : this.getRightChild().resize();
        this.size = leftSubTreeSize + rightSubTreeSize + 1;
        return this.size;
    }

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
        if(rightChild != null)
		    rightChild.setParent(this);
	}


	public int getValue() {
		return value;
	}

	public void setValue(int value){
		this.value = value;
	}
	public BinaryTreeNode getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}	
	
}
