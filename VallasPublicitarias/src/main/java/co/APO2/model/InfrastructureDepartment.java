package co.APO2.model;
import co.APO2.ui.Main;

import java.io.*;
import java.util.ArrayList;



public class InfrastructureDepartment {


    private ArrayList<Billboard> billboards = new ArrayList<>();

    public static final String BILLBOARD_FILE_NAME = "Test.csv";



    public InfrastructureDepartment() throws Exception {

        billboards = new ArrayList<Billboard>();

        loadBillboard();
        System.out.println(getActivebillboards());



    }

    private void saveBillboards() throws IOException {
        String resource = Main.class.getClassLoader().getResource(InfrastructureDepartment.BILLBOARD_FILE_NAME).getFile();
        File archivo = new File(resource);
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        String temp = toString();
        System.out.println(temp);

        writer.write(temp);
        writer.flush();
        writer.close();
        System.out.println(resource);

    }

    public void addBillboard(double w, double h, boolean iu, String b) {

        Billboard temp = new Billboard(w, h, iu, b);
        billboards.add(temp);


        }





    public void loadBillboard() throws Exception {
        String resource = Main.class.getClassLoader().getResource(InfrastructureDepartment.BILLBOARD_FILE_NAME).getFile();


        File archivo = new File(resource);
        
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {

            String[] columns = line.split("\\|");
            //System.out.println(columns[0]);

            line = br.readLine();

            int[] valoresEnteros = new int[columns.length - 1]; // Excluimos la primera fila "width"

            //.matches("\\d+") verifica si hay un valor de 0 a 9 en la cadena String
            if (columns[0].matches("\\d+")) {
                double width = Double.parseDouble(columns[0]);


                if(columns[1].matches("\\d+")){
                    double height = Double.parseDouble(columns[1]);
                    boolean inUse = Boolean.parseBoolean(columns[2]);
                    String brand = columns[3];
                    




                    addBillboard(width,height,inUse,brand);






                }




            }


        }

        br.close();
        fr.close();


    }

    public void exportDangerousBillboardReport() throws IOException {
        String msg = "";
        msg+= "===========================\n";
        msg+= "DANGEROUS BILLBOARD REPORT\n";
        msg += "===========================\n";
        for (int i = 0; i < billboards.size(); i++) {
            if(billboards.get(i).calculateArea() > 160 ){
                msg += "Billboard " + billboards.get(i).getBrand() + " with area "
                        + billboards.get(i).calculateArea() + "\n";


            }


        }
        File file = new File("Archivo\\Reporte.txt");
        try {
            PrintWriter salida = new PrintWriter(file);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

        BufferedWriter writer = new BufferedWriter(
                new FileWriter(file));

        writer.write(msg);
        writer.flush();
        writer.close();
    }

    public void importData(String fn) {

        String[] result = fn.split("\\+\\+");
        double width = Double.parseDouble(result[0]);
        double height = Double.parseDouble(result[1]);
        boolean inUse = Boolean.parseBoolean(result[2]);
        String brand= result[3];

        addBillboard(width,height, inUse, brand);






    }


    public String toString() {
        String msg = "";
        msg += "| W  |  H  |  inUse  |  Brand \n" ;
        for (int i = 0; i < billboards.size(); i++) {


            msg += billboards.get(i).getWidth() + "  " + billboards.get(i).getHeight() + "  " +
                    billboards.get(i).isInUse() + "  " + billboards.get(i).getBrand() + "\n";



        }
        msg += "\nTOTAL: " + billboards.size();
        return msg;
    }

    public double calculateAverageHeight(){
        double sum = 0;
        for (int i = 0; i<billboards.size(); i++){
            sum+= billboards.get(i).getHeight();

            
        }

        return sum/billboards.size();

    }

    public double calculateAverageWidth(){
        double sum = 0;
        for (int i = 0; i<billboards.size(); i++){
            sum+= billboards.get(i).getWidth();
            
        }
        return sum/billboards.size();

    }

    public double calculateAverageArea(){
        double sum = 0;
        for (int i = 0; i < billboards.size(); i++) {
            sum += billboards.get(i).calculateArea();

        
            
        }

        return sum/billboards.size();
    }

    public String getActivebillboards(){
        String msg = "";
        msg+= "ACTIVE BILLBOARDS\n";
        msg += "| W  |  H  |  inUse  |  Brand \n";
        for (int i = 0; i < billboards.size(); i++) {
            if(billboards.get(i).isInUse()) {
                msg += billboards.get(i).getWidth() + "  " + billboards.get(i).getHeight() + "  " +
                        billboards.get(i).isInUse() + "  " + billboards.get(i).getBrand() + "\n";

            }
        }
        return msg;
    }

    public  String getBillboardsPerBrand(){
        String msg = "";
        msg += "BILLBOARDS PER BRAND\n";
        int x = 0;


        for(int i = 0; i < billboards.size() ; i++) {
            int counter = 1;
            for(int j = 1; j< billboards.size()- x; j++){

                if(billboards.get(i).getBrand().equals(billboards.get(j).getBrand()) && i != j){
                    counter += 1;
                }

                msg += billboards.get(i).getBrand() + " #Billboards: " + counter+"\n";
                i+=1;



            }
            x += 1;




        }

        return msg;
    }


}


