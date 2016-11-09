/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

public class BinaryTree
{
    private TreeNode root;
    
    public BinaryTree()
    {
        root=new TreeNode();
    }
    public void addWord(String value)
    {
        TreeNode currentNode=new TreeNode();

        if (root.getValue()==null)
            root=new TreeNode(value);
        else
        {
            currentNode=root;
     
            while(currentNode!=null)
            {
                //value is less than the node value
                if ((value.compareTo(currentNode.getValue())) <0)
                {
                    //null node found, insert value on left side
                    if (currentNode.getLeftNode()==null)
                        currentNode.setLeftNode(new TreeNode(value));

                    currentNode=currentNode.getLeftNode();
                }
                //value is greater than the node value
                else if ((value.compareTo(currentNode.getValue())) >0)
                {
                    //null node found, insert value on the right side
                    if (currentNode.getRightNode()==null)
                        currentNode.setRightNode(new TreeNode(value));

                    currentNode=currentNode.getRightNode();
                }
                //value is already in the tree so duplicate isn't added
                else
                    break;
            }
        }
    }
    //helper function to call in order traversal so that the root node class variable
    //doesn't have to be exposed to the client.
    public void inOrderTraversal()
    {
        inOrder(root);
    }
    //works it way down the tree by visiting the left node first then 
    //visits the parent node and then the right node
    private void inOrder(TreeNode currentNode)
    {
        if(currentNode!=null)
        {
            inOrder(currentNode.getLeftNode());
            System.out.println(currentNode.getValue());
            inOrder(currentNode.getRightNode());
        }
    }
    //helper function to call post order traversal so that the root node class variable
    //doesn't have to be exposed to the client. 
    public void postOrderTraversal()
    {
        postOrder(root);
    }
    //works its way down the tree by visiting the leftmost nodes first, then visits the 
    //right nodes, then finally the parent node
    private void postOrder(TreeNode currentNode)
    {
        if (currentNode !=null)
        {
            postOrder(currentNode.getLeftNode());
            postOrder(currentNode.getRightNode());
            System.out.println(currentNode.getValue());
        }
    }
    //helper function to call pre order traversal so that the root node class variable
    //doesn't have to be exposed to the client.
    public void preOrderTraversal()
    {
        preOrder(root);
    }
    //visits the parent node first then it traverses the graph downward by visiting
    //the left nodes first then working its way back up to the right nodes 
    private void preOrder(TreeNode currentNode)
    {
        if (currentNode !=null)
        {
            System.out.println(currentNode.getValue());
            preOrder(currentNode.getLeftNode());
            preOrder(currentNode.getRightNode());
        }
    }
    
    //returns the node containing the value
    //currently not being used
    private TreeNode getEntry(String value)
    {
        TreeNode currentNode=root;
        TreeNode emptyNode=new TreeNode();
        boolean found=false;
        while(currentNode!=null)
        {
            //value is less than the node value
            if ((value.compareTo(currentNode.getValue())) <0)
                currentNode=currentNode.getLeftNode();
            //value is greater than the node value
            else if ((value.compareTo(currentNode.getValue())) >0)
                currentNode=currentNode.getRightNode();
            //value found, return node
            else if ((value.compareTo(currentNode.getValue())) == 0)
                return currentNode;
        }
        return emptyNode;
    }
    
    //helper function for Search Tree. Keeps the root node class variable from having to be exposed
    //to the client
    public boolean search(String value)
    {
        return searchTree(root,value);
    }
    private boolean searchTree(TreeNode currentNode,String value)
    {
        if (currentNode==null)
            return false;

        if ((value.compareTo(currentNode.getValue()))==0)
                return true;
        return(searchTree(currentNode.getLeftNode(),value) || searchTree(currentNode.getRightNode(),value));
    }

}
