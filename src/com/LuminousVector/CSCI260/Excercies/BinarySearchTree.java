package com.LuminousVector.CSCI260.Excercies;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T>
{
	protected BSTNode<T> root;

	private boolean found;

	protected LinkedQueue<T> InOrderQueue;
	protected LinkedQueue<T> PreOrderQueue;
	protected LinkedQueue<T> PostOrderQueue;


	public BSTNode<T> getRoot()
	{
		return root;
	}

	public int size()
	{
		return recSize(root);
	}

	public boolean contains(T element)
	{
		return recContains(element, root);
	}

	public T get(T element)
	{
		return recGet(element, root);
	}

	public BinarySearchTree<T> add(T element)
	{
		root = recAdd(element, root);
		return this;
	}

	public BinarySearchTree<T> remove(T element, BSTNode<T> node)
	{
		root = recRemove(element, node);
		return this;
	}

	public boolean isEmpty()
	{
		return root == null;
	}

	public int reset(int orderType)
	{
		int numNodes = size();
		switch (orderType)
		{
			case IN_ORDER:
				InOrderQueue = new LinkedQueue<>();
				inOrder(root);
				break;
			case PRE_ORDER:
				PreOrderQueue = new LinkedQueue<>();
				preOrder(root);
				break;
			case POST_ORDER:
				PostOrderQueue = new LinkedQueue<>();
				postOrder(root);
				break;
		}
		return numNodes;
	}

	public T getNext(int orderType)
	{
		switch (orderType)
		{
			case IN_ORDER:
				return InOrderQueue.dequeue();
			case PRE_ORDER:
				return PreOrderQueue.dequeue();
			case POST_ORDER:
				return PostOrderQueue.dequeue();
			default:
				return null;
		}
	}

	private void inOrder(BSTNode<T> node)
	{
		if(node != null)
		{
			inOrder(node.left);
			InOrderQueue.enqueue(node.info);
			inOrder(node.right);
		}
	}

	private void preOrder(BSTNode<T> node)
	{
		if(node == null)
			return;
	}

	private void postOrder(BSTNode<T> node)
	{
		if(node == null)
			return;
	}

	private BSTNode<T> recRemove(T element, BSTNode<T> node)
	{
		if(node == null)
			found = false;
		else if(element.compareTo(node.info) < 0)
			node.left = recRemove(element, node.left);
		else if(element.compareTo(node.info) > 0)
			node.right = recRemove(element, node.right);
		else
		{
			node = removeNode(node);
			found = true;
		}
		return node;
	}

	private BSTNode<T> removeNode(BSTNode<T> node)
	{
		T data;
		if(node.left == null)
			return node.right;
		else if(node.right == null)
			return node.left;
		else
		{
			data = getPredecessor(node.left);
			node.info = data;
			node.left = recRemove(data, node.left);
			return node;
		}
	}

	private T getPredecessor(BSTNode<T> node)
	{
		while (node.right != null)
			node = node.right;
		return node.info;
	}

	private BSTNode<T> recAdd(T element, BSTNode<T> node)
	{
		if(node == null)
			node = new BSTNode<>(element);
		else if(element.compareTo(node.info) <= 0)
			node.left = recAdd(element, node.left);
		else
			node.right = recAdd(element, node.right);
		return node;
	}

	private T recGet(T element, BSTNode<T> node)
	{
		if(node == null)
			return null;
		else if(element.compareTo(node.info) < 0)
			return recGet(element, node.left);
		else if(element.compareTo(node.info) > 0)
			return recGet(element, node.right);
		else
			return node.info;
	}

	private boolean recContains(T element, BSTNode<T> node)
	{
		if(node == null)
			return false;
		else if(element.compareTo(node.info) < 0)
			return recContains(element, node.left);
		else if(element.compareTo(node.info) > 0)
			return recContains(element, node.right);
		else
			return true;
	}

	private int iterSize(BSTNode<T> node)
	{
		LinkedStack<BSTNode<T>> trail = new LinkedStack<>();
		trail.push(node);
		int count = 0;
		BSTNode<T> curNode = root;
		while (!trail.isEmpty())
		{
			curNode = trail.top();
			trail.pop();
			count++;
			if(curNode.left != null)
				trail.push(curNode.left);
			if(curNode.right != null)
				trail.push(curNode.right);
		}
		return count;
	}

	private int recSize(BSTNode<T> node)
	{
		return (node == null) ? 0 : 1 + recSize(node.left) + recSize(node.right);
	}
}
