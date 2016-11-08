/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.text.Collator;
import java.util.Locale;
import java.util.LinkedList;
import java.util.Queue;


public class Trie
{
    private TrieNode root;
    private int size;
    public Trie()
    {
        root = new TrieNode();
        size=0;
    }
    public int size()
    {
        return size;
    }
    public void addWord(String word)
    {
        TrieNode currentNode=new TrieNode();
        TrieNode nextNode= new TrieNode();
        currentNode=root;
        if (word.length() >0)
        {
            for (char c: word.toCharArray())
            {
                //insert character into child node and get reference to next node
                nextNode=currentNode.insert(c);
                if (nextNode != null)
                    currentNode=nextNode;
                else
                    currentNode=currentNode.getChild(c);
            }
            if (nextNode!=null && word.length() >0)
            {
                nextNode.setIsWord(true);
                size++;
            }
        }
    }
    
    //Searches the trie to see if a word is in it.  Returns true if a match is found
    public boolean searchTrie(String word)
    {
        TrieNode currentNode=new TrieNode();
        currentNode=root;
        
        while (!currentNode.isWord() && !currentNode.getWord().equals(word))
        for (Character c:word.toCharArray())
        {
            //check if currentNode contains the next letter in word
            if (currentNode.getNextCharacters().contains(c))
                currentNode=currentNode.getChild(c);
            else  //if letter isn't there no need to continue 
                return false;
            //check if currentNode is a word and is the word we are searching for
            if (currentNode.isWord() && currentNode.getWord().equals(word))
                return true;
        }
        //word not found
        return false;
    }
    //a recursive function to traverse all of the nodes in the trie
    //to build a dictionary that can be represented as a string
    //it is private because it can only be called by the toString function
    private void buildDictionary(TrieNode currentNode,List<String>dictionary)
    {
        //base case for recursive call
        if(currentNode==null)
            return;
        //add word to dictionary
        if (currentNode.isWord())
            dictionary.add(currentNode.getWord());
        //iterate through the nodes and recursively build the dictionary 
        for(Character c:currentNode.getNextCharacters())
        {
            TrieNode nextNode=currentNode.getChild(c);
            buildDictionary(nextNode,dictionary);
        }
                    
    }
    public String toString()
    {
        List<String> dictionary = new ArrayList<>();
        String buildString = new String();
        buildDictionary(root,dictionary);
        //sort dictionary alphabetically 
        Collections.sort(dictionary,Collator.getInstance(Locale.ENGLISH));
        //build string to return
        for (String entry:dictionary)
            buildString=buildString + "\n" + entry;
        return buildString;
    }
    
    //Use the Trie to retrieve a determined number of auto completed words 
    public List<String> autoPredictCompletions(String stem,int neededCompletions)
    {
        TrieNode currentNode=new TrieNode();
      //  TrieNode nextNode=new TrieNode();
        Queue<TrieNode> queue = new LinkedList<>();
        List<String>completions = new LinkedList<>();
      //  int foundCompletions=0;
        currentNode=root;        
        //get stem
        for (Character c:stem.toCharArray())
        {
            //stem found, get to node at last letter of stem
            if (currentNode.getNextCharacters().contains(c))
                currentNode=currentNode.getChild(c);
            //stem not found
            else 
                return completions; //return an empty completions list
        }
        //add stem node to the queue
        queue.add(currentNode);
        //search through trie until the completions are found
        while(!queue.isEmpty() && completions.size() <neededCompletions)
        {
            currentNode=queue.remove();
            if (currentNode.isWord())
                completions.add(currentNode.getWord());
            for (Character c:currentNode.getNextCharacters())
                queue.add(currentNode.getChild(c));
                
        }
        //sorts the completions list
        Collections.sort(completions,Collator.getInstance(Locale.ENGLISH));
        return completions;

    }
}
