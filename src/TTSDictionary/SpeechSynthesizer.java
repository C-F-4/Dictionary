/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTSDictionary;

import com.sun.speech.freetts.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Date Last Modified : Wednesday, May 04, 2016
 * @author XXL
 */
public class SpeechSynthesizer extends Thread {
    Word _w;
    String _speech_text;
    Word _empty;              // Used In case there's no word selected
                              // Instead an extra __emptyword__-meanin'(error) pair can be added at the top of the azdictor file 
    
    /**********************************************************************
     * Update _speech_text - Line:33 to change format in which TTS speaks**
     * ********************************************************************/
    
    SpeechSynthesizer(Word w){
        System.setProperty("mbrola.base", "C:/Users/XXL/Documents/mbrola");
        if (w.getMind() == null ){ 
            _w = _empty; 
        }
        else {
            _w = w;
        }
        _speech_text = /*w.getWord() + "means" + */w.getMind();
    }
    
    public void speech_synthesizer(){
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("mbrola_us1");
        
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
