package util;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testConfiguration.ApplicationDetails;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import static org.apache.poi.ss.usermodel.CellType.*;


public class ReadExcel {

    private static final Logger logger = Logger.getLogger(ReadExcel.class);

    private final String Filepath = System.getProperty("user.dir")+"\\testData";
    private final String fName =ApplicationDetails.getFileName();
    private final String shName =ApplicationDetails.getSheetName();
    private final String FileName = Filepath + "\\"+fName;

    public static String FromCity,ToCity,Adults,Children,Infants,ClassOfTravel,Airline;


    public void readExcelFile() {
        String FileExtension;
        XSSFWorkbook workbook=null;
        Sheet worksheet;
        try {
//            File fs = new File(Filepath + "\\"+shName);
            File fs = new File(FileName);
            FileInputStream fis = new FileInputStream(fs);
            FileExtension = FileName.substring(FileName.indexOf("."));
            if (FileExtension.equals(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            }
//            else if (FileExtension.equals(".xls"))
//                workbook = new HSSFWorkbook(fis);

//            worksheet= workbook.getSheet("FlightDetails");
            worksheet= Objects.requireNonNull(workbook).getSheet(shName);
//               int rowCount = worksheet.getLastRowNum()-worksheet.getFirstRowNum();
            Iterator<Row> rowIterator =worksheet.rowIterator();
            ArrayList<String> arrayList = new ArrayList<>();
            while (rowIterator.hasNext()) {

                Row row =rowIterator.next();
                Iterator<Cell> cellIterator =row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell=cellIterator.next();
                    switch ( cell.getCellTypeEnum() ) {
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            arrayList.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            cell.setCellValue(cell.toString().replace(".0",""));
                            System.out.println(cell.getStringCellValue());
                            arrayList.add(cell.getStringCellValue());
                            break;
                        case BLANK:
                            System.out.println(cell.getRichStringCellValue());
                            break;
                    }
                }
                System.out.println("ArrayList :"+arrayList);
                int count = 0;
                while (arrayList.size()>count)
                {
                    FromCity = arrayList.get(0);
                    ToCity =arrayList.get(1);
                    Adults=arrayList.get(2);
                    Children=arrayList.get(3);
                    Infants =arrayList.get(4);
                    ClassOfTravel=arrayList.get(5);
                    Airline =arrayList.get(6);
                  count++;
                }
            }
            System.out.println("FromCity :"+FromCity);
            System.out.println("ToCity :"+ToCity);
            System.out.println("Adults :"+Adults);
            System.out.println("Children :"+Children);
            System.out.println("Infants :"+Infants);

        }
        catch (Exception e)
        {
            logger.error("Failed to read :"+e.getMessage(),e);
        }
    }


}
