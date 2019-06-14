package com.blaqueyard.service;

import com.blaqueyard.model.Cdr;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class CdrService implements ICdrService {

    private final ArrayList<Cdr> cdrs;

    public CdrService() {

        cdrs = new ArrayList();
    }

    @Override
    public ArrayList<Cdr> findAll() throws IOException {

        FileInputStream fis = null;

        try {

            String fileName = "csv.csv";

            fis = new FileInputStream(new File(fileName));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {

                Cdr cdr = new Cdr(nextLine[0], nextLine[1], nextLine[2],nextLine[3], nextLine[4]);
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

        JSONObject object = new JSONObject();
        /* add the list to initial object */
        object.put("list", cdrs);

        int x = 0;
        for (Cdr temp : cdrs) {
//            x+=1;
            final String uuid = UUID.randomUUID().toString().replace("-", "");
            final String uuidTwo = UUID.randomUUID().toString().replace("-", "");
            String a = uuid;
            String b = uuidTwo;

            System.out.println(x);

            while (x++ <= cdrs.size()){
                if (x == cdrs.size()) break;
                String lOne = "<"+a+"> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://visallo.org/dev#person>";
                String lTwo = "<"+a+"> <http://visallo.org#title> "  + temp.getName();
                String lThree = "<"+a+"> <http://visallo.org/dev#name> "+ temp.getName().toString()+"";
                String lFour = "<"+a+"> <http://visallo.org/personNumbers#idNumber> "+ temp.getId_Number();
                String lFive = "<"+a+"> <http://visallo.org/personNumbers#kraPin> "+ temp.getKra_Pin();
                String lSix = "<"+a+"> <http://visallo.org#source>  " + "\"theFuture\"";

                String l2One = "<"+b+"> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://visallo.org/dev#phoneNumber>";
                String l2Two = "<"+b+"> <http://visallo.org/dev#phoneNumber>"+ temp.getPhone_Number();
                String l2Three = "<"+b+">  <http://visallo.org#title>"+  temp.getPhone_Number();
                String l2Four = "<"+b+"><http://visallo.org#source> " + "\"theFuture\"";
                String l2Five = "<"+a+"> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://visallo.org/dev#person>";
                String l2Six = "<"+b+"> <http://visallo.org#source> " + "\"theFuture\"";

                System.out.println(lOne);
                System.out.println(lTwo);
                System.out.println(lThree);
                System.out.println(lFour);
                System.out.println(lFive);
                System.out.println(lSix);
                System.out.println(l2One);
                System.out.println(l2Two);
                System.out.println(l2Three);
                System.out.println(l2Four);
                System.out.println(l2Five);
                System.out.println(l2Six);

                FileWriter fw=new FileWriter("test.nt");
                fw.write(lOne);
                fw.write(lTwo);
                fw.write(lThree);
                fw.write(lFour);
                fw.write(lFive);
                fw.write(lSix);
                fw.write(l2One);
                fw.write(l2Two);
                fw.write(l2Three);
                fw.write(l2Four);
                fw.write(l2Five);
                fw.write(l2Six);
                fw.close();
            }

    }
        return cdrs;
    }
}