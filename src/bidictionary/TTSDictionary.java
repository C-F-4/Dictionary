/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bidictionary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Date Last Modified: Wednesday, May 04, 2016
 * @author XXL
 */
public class TTSDictionary {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        /*****************************************************************************************
         * About the Input File                                                                 **
         * Input file must be named "azdictor.txt"                                              **
         * Word-Meaning pairs must be separated by a blank-space                                **
         * Each Word-Meaning pair must be separated by blank new line;                          **
         * Once the program crosses pd.join(), the file is closed and not used anywhere else;   **
         *****************************************************************************************/
        
        mainFrame.main(args);                    // GUI Creation starts here
        
        /******************************************************************************************
         * If you don't need to work with GUI, comment out mainFrame.main(args) - Line 36        **
         * It should work perfectly on the console without it                                    **
         * ****************************************************************************************/
        
        File f = new File("azdictor.txt");        // This is the file used for word-definition pairs
        ParseData pd = new ParseData(f);
        pd.start();                               // starts parsing thread - pd - here
        try {
            pd.join();                            // current thread main() waits til pd finishes it's execution. 
                                                  // Once parsing succefully done, main() resumes
        } catch (InterruptedException ex) {
            Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*******************************************************************************************
         ** @return ArrayList<Word> _wordList;                                                    **
         * Separate variables created in the pd of word-meaning ArrayList are returned here to lw **
         * and class ParseData is not used furthur                                                **
         *******************************************************************************************/
        ArrayList<Word> lw = pd.getWordList();
        
        Scanner input = new Scanner(System.in);
        int index;
        do{
            System.out.print("Enter a word: ");
            String word = input.nextLine();

            Search s = new Search(word,lw);
            index = s.getIndex();
            if(index == 0){
                System.out.println("Error in lookup;");
            }else{
                Word aw = lw.get(index);
                System.out.println(aw.getWord() + " : "+ aw.getMind());
                
                /**************************
                 * @param Word Object aw **
                 **************************/
                SpeechSynthesizer speech = new SpeechSynthesizer(aw);
                /***********************************
                 ** Implements usage for FreeTTS  **
                 ***********************************/ 
                speech.start();
                
            }
        }while(index != 0);
    }
    
}
