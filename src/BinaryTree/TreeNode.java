/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;
    
public class TreeNode
{
        private TreeNode leftNode;
        private TreeNode rightNode;
        private String value;
        TreeNode()
        {
            this.leftNode=null;
            this.rightNode=null;
            
        }
        TreeNode(String value)
        {
            this();
            this.value = value;
        }
        TreeNode(TreeNode leftNode,TreeNode rightNode,String value)
        {
            this.leftNode=leftNode;
            this.rightNode=rightNode;
            this.value=value; 
        }
        String getValue()
        {
            return value;
        }
        void setValue(String value)
        {
            this.value=value;
        }
        TreeNode getLeftNode()
        {
            return leftNode;
        }
        void setLeftNode(TreeNode leftNode)
        {
            this.leftNode=leftNode;
        }
        TreeNode getRightNode()
        {
            return rightNode;
        }
        void setRightNode(TreeNode rightNode)
        {
            this.rightNode=rightNode;
        }
}
