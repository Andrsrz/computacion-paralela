/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author andrsrz
 */
public class MyThread extends Thread {
    
    private int thNumber;
    private int startPage;
    private int stopPage;
    private int wordAppearance;
    private int time;
    private String doc;
    private String docText;
    private String wordToFind;
    
    public void setThNumber (int thNumber) {
        this.thNumber = thNumber;
    }
    
    public int getThNumber () {
        return thNumber;
    }
    
    public void setStartPage (int startPage) {
        this.startPage = startPage;
    }
    
    public int getStartPage () {
        return startPage;
    }
    
    public void setStopPage (int stopPage) {
        this.stopPage = stopPage;
    }
    
    public int getStopPage () {
        return stopPage;
    }
    
    public void setDoc (String doc) {
        this.doc = doc;
    }
    
    public String getDoc () {
        return doc;
    }
    
    public void setText (String docText) {
        this.docText = docText;
    }
    
    public String getText () {
        return docText;
    }
    
    public void setWord (String wordToFind) {
        this.wordToFind = wordToFind;
    }
    
    public String getWord () {
        return wordToFind;
    }
    
    public void setWordAppearance (int wordAppearance) {
        this.wordAppearance = wordAppearance;
    }
    
    public int getWordAppearance () {
        return wordAppearance;
    }
    
    public void setTime (int time) {
        this.time = time;
    }
    
    public int getTime () {
        return time;
    }
    
    @Override
    public void run() {
        Long startTime = System.currentTimeMillis();
        // boolean isEmpty = true;
        /*
        System.out.println("Thread "
                + String.valueOf(getThNumber())
                + " initialized.");
        */
        PDFTextStripper pdfStripper;
        int count = 0;
        
        try {
            PDDocument docTh;
            docTh = PDDocument.load(new File(getDoc()));
            pdfStripper = new PDFTextStripper();
            
            for (int i = getStartPage(); i <= getStopPage(); i++) {
                pdfStripper.setStartPage(i);
                pdfStripper.setEndPage(i);
                
                String text = pdfStripper.getText(docTh);
                setText(text);
                
                if (!getWord().equals("")) {
                    // isEmpty = false;
                    String[] texts = getText().split(" ");

                    for (String word : texts) {
                        if (word.equals(getWord())) {
                            count++;
                        }
                    }
                } else {
                    String[] texts = getText().split(" ");

                    for (String word : texts) {
                        count++;
                    }
                }
            }
            /*
            if (isEmpty) {
                System.out.println("Thread "
                    + String.valueOf(getThNumber())
                    + " This book has "
                    + String.valueOf(count)
                    + " words.");
            } else {
                System.out.println("Thread "
                    + String.valueOf(getThNumber())
                    + " The word "
                    + getWord()
                    + " is "
                    + String.valueOf(count)
                    + " times.");
            }
            */
            docTh.close();
            setWordAppearance(count);
            Long estimatedTime = ((System.currentTimeMillis() - startTime) / 1000);
            setTime(estimatedTime.intValue());
            /*
            System.out.println("Thread" 
                        + getThNumber()
                        + " has ended in "
                        + getTime()
                        + " sec.");
            */
        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
