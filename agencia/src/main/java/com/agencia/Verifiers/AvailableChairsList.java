package com.agencia.Verifiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvailableChairsList {

    public static List<String> generate(int number, List<String> lstReservedChairs) {

        List<String> lstAvailableChairs = new ArrayList<>();
        boolean exitFillingList = false;
        int maxColumns = 6;
        int maxRows =(int) Math.ceil((double)number / maxColumns);
        int counterChairs = 1;
        int counterRows = 0;
        int counterColumns = 1;
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";

        String [] alphabet = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".toUpperCase().split(",", 26);
        List <String> alphabetList = new ArrayList<>(Arrays.asList(alphabet));

        
        while (exitFillingList == false) {

            for (int c = 1; c <= maxColumns; c++) {

                for (int r = 1; r <= maxRows; r++) {

                    
                    if ( counterChairs <= number ) {

                        String chair = String.format("%s%d", alphabetList.get(counterRows), counterColumns);

                        if (r == maxRows) {

                            if(r == maxRows && c == 3) {

                                if (lstReservedChairs.contains(chair)) {

                                    System.out.print(RED + "XX" + RESET + "\n\n\n");    
                                    
        
                                } else {
        
                                    lstAvailableChairs.add(chair);
        
                                    System.out.print(GREEN + chair + RESET + "\n\n\n");
        
                                }


                            } else {

                                if (lstReservedChairs.contains(chair)) {

                                    System.out.print(RED + "XX" + RESET + "\n");    
                                    
        
                                } else {
        
                                    lstAvailableChairs.add(chair);
        
                                    System.out.print(GREEN + chair + RESET + "\n");
        
                                }

                            }


                        } else {

                            if (lstReservedChairs.contains(chair)) {

                                System.out.print(RED + "XX" + RESET + "  ");    
                                
    
                            } else {
    
                                lstAvailableChairs.add(chair);
    
                                System.out.print(GREEN + chair + RESET + "  ");
    
                            }

                        }


                        
                        
                        counterChairs++;
                        counterRows++;
                        

                    } else {

                        exitFillingList = true;
                    }

                    
                }
                 counterRows = 0;
                 counterColumns++;


            }
            
        }

        System.out.println("\n");

    


        return lstAvailableChairs;
        
    }

}
