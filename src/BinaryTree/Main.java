package BinaryTree;


import BinaryTree.BinaryTree;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        testBinaryTree();
    }
    public static void testBinaryTree()
    {
        //in this implementation, the Binary Tree contains strings so it could be used as a dictionary 
        //for fast lookup of words 
        BinaryTree bt=new BinaryTree();
        bt.addWord("5");
        bt.addWord("1");
        bt.addWord("6");
        bt.addWord("3");
        bt.addWord("8");
        bt.addWord("7");
        bt.addWord("2");
        bt.addWord("0");
        bt.addWord("9");
        bt.addWord("4");
        bt.addWord("10");
        /*After loading the tree looks like:
                                    5
                                 /      \
                               1         6
                              / \           \
                            0    3          8
                                 /  \       /  \
                                2   4    7    9
                               /                    
                             10
        */
        //loadTree(bt,"words.small.txt");
        System.out.println();

        System.out.println("PreOrder Traversal of tree");
            bt.preOrderTraversal();
        System.out.println("PostOrder Traversal of tree");
            bt.postOrderTraversal();
        System.out.println("InOrder Traversal of tree");
            bt.inOrderTraversal();
    }
    public static void loadTree(BinaryTree bt,String filename)
    {
        int lines=0;
        try
        {
            Scanner input=new Scanner(Paths.get(filename));
            while(input.hasNext())
            {
                bt.addWord(input.nextLine());
                ++lines;
            }
            input.close();
        }
        catch(Exception e)
        {
            System.out.println("Problem loading file");
            e.printStackTrace();
        }


    }
    
}
