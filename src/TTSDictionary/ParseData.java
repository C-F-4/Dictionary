

package TTSDictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Date Last Modified: Wednesday, May 04, 2016
 * @author XXL
 */
public class ParseData extends Thread{
    private final ArrayList<Word> wordList;
    private ArrayList<Word> _wordList;
    private final File file;
    
    ParseData(File _file){
        this.file = _file;
        wordList = new ArrayList<>();
    }

    private BufferedReader readFileData(File _file) throws IOException{
        BufferedReader in = null;
        try{
            in = new BufferedReader(new FileReader(_file));
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return in;
    }
    private void parseLine(String _line){
        String[] part = _line.split(" ", 2);
        Word aWord = new Word(part[0],part[1]);
        // System.out.println(aWord.getWord() + " : " + aWord.getMind());
        wordList.add(aWord);
    }
    public void parseList() throws IOException{
       try (BufferedReader in = readFileData(this.file)) {
            String str = "";
            while(true){
                str = in.readLine();
                if(str.equals("") || str == null){
                    break;
                }
                String temp = in.readLine();
                while(!temp.equals("")){
                    str += temp;
                    temp = in.readLine();
                }
                // System.out.println(str);
                if(str != null)
                    parseLine(str.trim());
            }
            System.out.println("Loop Exited");
        }
        catch (Exception e){
            System.out.println("File Error");
        }
        // close the file
       System.out.println("Reading complete");
    }
    /***********************************
     * Getters functions in ParseData **
     * @return ArrayList<Word>        **
     ***********************************/
    private ArrayList<Word> getTempWordList(){       // returns wordlist whenever you need it
        return this.wordList;
    }
    public ArrayList<Word> getWordList(){            // returns wordlist-copy whenever you need it
        return this._wordList;
    }
    @Override
    public void run() {
        try {
            this.parseList();
            _wordList = this.getTempWordList();
        } catch (IOException ex) {
            Logger.getLogger(ParseData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
