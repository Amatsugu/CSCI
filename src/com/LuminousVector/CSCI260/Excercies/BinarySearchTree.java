package com.LuminousVector.CSCI260.Excercies;

import com.LuminousVector.CSCI260.Projects.Project1.LinkedNode;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T>
{
	protected BTSNode<T> root;

	private boolean found;

	protected LinkedQueue<T> InOrderQueue;
	protected LinkedQueue<T> PreOrderQueue;
	protected LinkedQueue<T> PostOrderQueue;


	public BTSNode<T> getRoot()
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

	public BinarySearchTree<T> remove(T element, BTSNode<T> node)
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

	private void inOrder(BTSNode<T> node)
	{
		if(node != null)
		{
			inOrder(node.left);
			InOrderQueue.enqueue(node.info);
			inOrder(node.right);
		}
	}

	private void preOrder(BTSNode<T> node)
	{
		if(node == null)
			return;
	}

	private void postOrder(BTSNode<T> node)
	{
		if(node == null)
			return;
	}

	private BTSNode<T> recRemove(T element, BTSNode<T> node)
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

	private BTSNode<T> removeNode(BTSNode<T> node)
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

	private T getPredecessor(BTSNode<T> node)
	{
		while (node.right != null)
			node = node.right;
		return node.info;
	}

	private BTSNode<T> recAdd(T element, BTSNode<T> node)
	{
		if(node == null)
			node = new BTSNode<>(element);
		else if(element.compareTo(node.info) <= 0)
			node.left = recAdd(element, node.left);
		else
			node.right = recAdd(element, node.right);
		return node;
	}

	private T recGet(T element, BTSNode<T> node)
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

	private boolean recContains(T element, BTSNode<T> node)
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

	private int iterSize(BTSNode<T> node)
	{
		LinkedStack<BTSNode<T>> trail = new LinkedStack<>();
		trail.push(node);
		int count = 0;
		BTSNode<T> curNode = root;
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

	private int recSize(BTSNode<T> node)
	{
		return (node == null) ? 0 : 1 + recSize(node.left) + recSize(node.right);
	}
}
