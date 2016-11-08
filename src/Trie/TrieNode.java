/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
public class TrieNode
{
    private Map<Character,TrieNode> child;
    private String word;
    private boolean isWord;
    public TrieNode()
    {
        child=new HashMap<>();
        word=new String();
        isWord=false;
        
    }
    public TrieNode(String word)
    {
        this();
        this.word=word;
    }
    
    public TrieNode getChild(Character letter)
    {
        return child.get(letter);
    }
    
    public Set<Character> getNextCharacters()
    {
        return child.keySet();
    }
    
    //insert a new character into the trie and update the label 
    //by appending the passed letter
    public TrieNode insert(Character letter)
    {
        if(child.containsKey(letter))
            return null;
        TrieNode newChild=new TrieNode(word+letter.toString());
         child.put(letter, newChild);
        
        return newChild;
    }
    
    //sets the isWord flag if the node ends a word
    public void setIsWord(boolean isWord)
    {
        this.isWord=isWord;
    }
    
    //gets whether or not the node ends a word
    public boolean isWord()
    {
        return isWord;
    }
    
    //gets the word 
    public String getWord()
    {
        return word;
    }

 
}
    