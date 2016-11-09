/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Main
{

    public static void main(String[] args)
    {
        testTrie();
    }
    public static void testTrie()
    {
        Trie t = new Trie();
        //load trie
        loadTrie(t,"words.small.txt");
        System.out.println(t.toString());
        System.out.printf("There are %d entries in the dictionary%n",t.size());
        
        //test completions
        List<String> completions = new ArrayList<>();
        String stem=new String();
        stem="an"; //set stem
            completions=t.autoPredictCompletions(stem, 5);
            System.out.printf("There are %d words with stem %s%n",completions.size(),stem);
            for (String word:completions)
                System.out.printf("\t -> %s%n",word);

    }
    public static void loadTrie(Trie t,String filename)
    {
        int lines=0;
        try
        {
            Scanner input=new Scanner(Paths.get(filename));
            while(input.hasNext())
            {
                t.addWord(input.nextLine());
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
