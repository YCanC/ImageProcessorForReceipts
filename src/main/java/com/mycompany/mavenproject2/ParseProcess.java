package com.mycompany.mavenproject2;

public class ParseProcess {
    
    int urunBulDegisken;
    
    void parseProcessing(String input){}
    
   //Market ismini bulma kısmı************************
    String IsimBul(String input)
    {
        int i=0;
        Boolean kontrol=false;
        String[] isim;
        
        
        //Gelen yazıyı büyük harfe dönüştürme işlemi
        String hepsiBuyukHarf = input.toUpperCase();
       
        //Satırlara göre bölme işlemi
        String[] lines = hepsiBuyukHarf.split("\\r?\\n");
        
        for(i=0; i<=3; i++)
        {
            if(lines[i].contains("A.Ş") || lines[i].contains("MARKET")|| lines[i].contains("MAGAZA") || lines[i].contains("A.S")|| lines[i].contains("A:S."))
            {
                kontrol = true;
                break;
            }
        }
        if(kontrol){
         isim = lines[i].split(" ");
        
        }
        else{
            isim=lines[0].split(" ");
        }
        
       String isim2="";
        for (int j = 0; j < isim.length; j++) {
            isim2+=isim[j];
            isim2+= " ";
        }
       
    
       

          return isim2;
    }
    
    //Tarihi bulma kısmı******************************
    String TarihBul(String input){
        int i=0;
        Boolean kontrol=false;
        
        //Gelen yazıyı büyük harfe dönüştürme işlemi
        String hepsiBuyukHarf = input.toUpperCase();
       
        //Satırlara göre bölme işlemi
        String[] lines = hepsiBuyukHarf.split("\\r?\\n");
        String tarih ="";
        
        
         for(i=0; i<lines.length; i++)
        {
             if(lines[i].contains("TARİH") || lines[i].contains("TARIH") || lines[i].contains("TARIK")|| lines[i].contains("TARİK"))
            {
                tarih=lines[i];
                kontrol = true;
                break;
            }
             
        }
         
         if(kontrol==false)
         {
              for (int j = 0; j < 10; j++) {
             
               for(int k=0; k<lines[j].length(); k++)
            {
                if(k>=7)
              {
                if(lines[j].charAt(k-7) == '/' && lines[j].charAt(k-4)== '/' && Character.isDigit(lines[j].charAt(k)) || lines[j].charAt(k-7) == '.' && lines[j].charAt(k-4)== '.' && Character.isDigit(lines[j].charAt(k))|| lines[j].charAt(k-7) == '-' && lines[j].charAt(k-4)== '-' && Character.isDigit(lines[j].charAt(k)))
                {
                    
                  tarih +=lines[j].charAt(k-9);
                  tarih+=lines[j].charAt(k-8);
                  tarih+='.';
                  tarih+=lines[j].charAt(k-6);
                  tarih+=lines[j].charAt(k-5);
                  tarih+='.';
                  tarih+=lines[j].charAt(k-3);
                  tarih+=lines[j].charAt(k-2);
                  tarih+=lines[j].charAt(k-1);
                  tarih+=lines[j].charAt(k-0); 
                  kontrol =true;
                  break;
                }
              }
            }              
          
            if(kontrol==true)
            {
                break;
            }
             
        }
         }
         
        
        
         if(kontrol)
         {
             return tarih;
         }
         return "tarih bulunamadi";
    }
    
    String FisNoBul(String input){
        int i=0;
        Boolean kontrol=false;
        
        //Gelen yazıyı büyük harfe dönüştürme işlemi
        String hepsiBuyukHarf = input.toUpperCase();
       
        //Satırlara göre bölme işlemi
        String[] lines = hepsiBuyukHarf.split("\\r?\\n");
        String fisno ="";
        
        for(i=0; i<lines.length; i++)
        {
            if(lines[i].contains("FİS NO") || lines[i].contains("FIS NO")|| lines[i].contains("FİŞ NO") || lines[i].contains("FİS NO") || lines[i].contains("FISNO"))
            {
                int index1 =0;
                index1=lines[i].indexOf("FİS NO");
                int index2 =0; 
                index2=lines[i].indexOf("FIS NO");
                int index3=0;
                index3 = lines[i].indexOf("FISNO");
                int index4=0;
                index4=lines[i].indexOf("FİŞ NO");
                int index5=0;
                index5 = lines[i].indexOf("FİS NO");
                /*
                System.out.println("index1: "+index1);
                System.out.println("index2: "+index2);
                System.out.println("index3: "+index3);
                System.out.println("index4: "+index4);
                System.out.println("index5: "+index5); */
                
                   if(index1!=-1)
                {
                    for(int k=index1; k<lines[i].length(); k++)
                    {
                        fisno+=lines[i].charAt(k);
                        urunBulDegisken=k;
                    }
                }
                      if(index2!=-1)
                {
                    for(int k=index2; k<lines[i].length(); k++)
                    {
                        fisno+=lines[i].charAt(k);
                         urunBulDegisken=k;
                    }
                }
                         if(index3!=-1)
                {
                    for(int k=index3; k<lines[i].length(); k++)
                    {
                        fisno+=lines[i].charAt(k);
                         urunBulDegisken=k;
                    }
                }
                            if(index4!=-1)
                {
                    for(int k=index4; k<lines[i].length(); k++)
                    {
                        fisno+=lines[i].charAt(k);
                         urunBulDegisken=k;
                    }
                }
                if(index5!=-1)
                {
                    for(int k=index5; k<lines[i].length(); k++)
                    {
                        fisno+=lines[i].charAt(k);
                         urunBulDegisken=k;
                    }
                }
            }
        }
        
        return fisno;
    }
    
    String UrunBul(String input){
        
          int i=0;
          int k=0;
        Boolean kontrol=false;
        
        //Gelen yazıyı büyük harfe dönüştürme işlemi
        String hepsiBuyukHarf = input.toUpperCase();
        
       
        //Satırlara göre bölme işlemi
        String[] lines = hepsiBuyukHarf.split("\\r?\\n");
        String urunler ="";
        for(i=0; i<lines.length; i++)
        {
         if(lines[i].contains("TOP") || lines[i].contains("TOPKDV")|| lines[i].contains("KDV")|| lines[i].contains("KDY"))
            {
                Boolean harfVar = false;
                System.out.println("urunBulDegisken: "+urunBulDegisken);
                System.out.println("i: "+i);
                for(k=3; k<i; k++){
                        if(lines[k].contains("%") || lines[k].contains("*")|| lines[k].contains("X") ||lines[k].contains(",")){
                        System.out.println("ife girdi");
                        urunler+=lines[k];
                        urunler+="\n";
                        kontrol=true;
                        } 
                } 
            }
        if(kontrol)
        {
            break;
        }
        }
        return urunler;
        
    }
    
    String ToplamBul(String input)
    {
        int i=0;
       // int k=0;
       // Boolean kontrol=false;
        
        //Gelen yazıyı büyük harfe dönüştürme işlemi
        String hepsiBuyukHarf = input.toUpperCase();
        
        //Satırlara göre bölme işlemi
        String[] lines = hepsiBuyukHarf.split("\\r?\\n");
        String toplam ="";
         for(i=0; i<lines.length; i++)
        {
         if(lines[i].contains("TOPLAM") || lines[i].contains("TOP"))
            {
                if(lines[i].contains("K")== false && lines[i].contains("D")== false && lines[i].contains("V")== false && lines[i].contains("Y")== false && lines[i].contains("U")== false)
                {
                    toplam+=lines[i];
                    break;
                }
            }
        }
        return toplam;
    }
    
    
}
