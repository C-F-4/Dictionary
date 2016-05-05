/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTSDictionary;

import com.sun.speech.freetts.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// import java.io.IOException;
/**
 * Date Last Modified : Wednesday, May 04, 2016
 * @author XXL
 */
public class SpeechSynthesizer extends Thread {
    private Word w;
    private String _speech_text;
    private Word _empty;              // Used In case there's no word selected
                              // Instead an extra __emptyword__-meanin'(error) pair can be added at the top of the azdictor file 
    
    /**********************************************************************
     * Update _speech_text - Line:33 to change format in which TTS speaks**
     * ********************************************************************/
    
    SpeechSynthesizer(Word _w){
        System.setProperty("mbrola.base", "C:/Users/XXL/Documents/mbrola");
        if (_w.getMind() == null || _w.getWord() == "" ){ 
            w = _empty; 
            System.out.println("Word is empty");
        }
        else {
            w = _w;
        }
        _speech_text = /*w.getWord() + "means" + */_w.getMind();
    }
    
    public void speech_synthesizer(){
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("mbrola_us2");
        
        voice.allocate();
        
        try{
            voice.speak(_speech_text);
        }catch(Exception e){
            Logger.getLogger(TTSDictionary.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void run() {
        try {
            this.speech_synthesizer();
        } catch (Exception ex) {
            Logger.getLogger(ParseData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
