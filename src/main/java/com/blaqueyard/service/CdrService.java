package com.blaqueyard.service;

import com.blaqueyard.model.Cdr;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CdrService implements ICdrService {

    private final ArrayList<Cdr> cdrs;

    public CdrService() {

        cdrs = new ArrayList();
    }

    @Override
    public ArrayList<Cdr> findAll() {

        FileInputStream fis = null;

        try {

            String fileName = "cdr.csv";

            fis = new FileInputStream(new File(fileName));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                System.out.println("Name"  + nextLine[0]);
                System.out.println("Age"  + Integer.valueOf(nextLine[1]));

                Cdr cdr = new Cdr(nextLine[0], Integer.valueOf(nextLine[1]), Integer.valueOf(nextLine[2]), Integer.valueOf(nextLine[3]), nextLine[4]);
                cdrs.add(cdr);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CdrService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CdrService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CdrService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cdrs;
    }
}