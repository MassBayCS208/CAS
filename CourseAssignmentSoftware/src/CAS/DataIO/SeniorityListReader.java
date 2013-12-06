/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.DataIO;
import java.util.*;
import java.io.*;
import CAS.Data.*;
/**
 *
 * @author Eric Sullivan
 */

public class SeniorityListReader extends FileReader
{
    Scanner scan;
    String workArea;
    int senior;
    String name;
    String input;
    
    public SeniorityListReader() throws FileNotFoundException {
        super("FakeSeniority.txt");
        String workArea = "";
        int senior =0;
        String name ="";
        input = "";
    }
    public HashMap<String,Instructor> loadSeniorityList(HashMap<String,Instructor> theMap){
        StringBuilder snip;
        StringTokenizer st;
        String last;
        while(scan.hasNextLine()){
            input = scan.nextLine();
            if(!input.equals("")){
            if(input.charAt(0)=='-'&&input.charAt(1)=='-'){
                snip = new StringBuilder(input);
                workArea = snip.substring(2);
                
            }
            else{
                st = new StringTokenizer(input,",\r\n\t\f ");
                last = st.nextToken();
                name = st.nextToken()+" "+last;
                senior =Integer.parseInt(st.nextToken());
                System.out.println("name "+ name+" Senority: "+ senior+" Workarea "+workArea);
                theMap.get(name).getSeniority().put(workArea,senior);
            }
            }
        }
        return theMap;
    }
}
