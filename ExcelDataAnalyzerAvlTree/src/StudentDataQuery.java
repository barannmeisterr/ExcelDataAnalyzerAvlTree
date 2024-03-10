import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentDataQuery {
	//-----------------------------------------------------
	// Title: Student Data Query class
	// Author: Arda Baran
	// Description: This class opens and reads excel xlsx file and places these datas to avl tree and searches student query
	// based on student's full name. shows distrubiton of fullnames in avl tree by printing tree,shows overall average. 
	//-----------------------------------------------------
    public static void main(String[] args) throws IOException {
        String filePath = "src/resources/data.xlsx";
        DataOperations dataOperations = new DataOperations();
        Student root =null; // Root node of avl tree
        int ch;                                 
		Scanner sc = new Scanner(System.in);
		System.out.println(" =====================================================================================");
		System.out.println("|    Press 1 to see all data in excel file                                           |");
		System.out.println("|    Press 2 to see AVL tree and number of inserted datas                            |");
		System.out.println("|    Press 3 to search a student in excel file based on fullname of(his/her)         |");
		System.out.println("|    Press 4 to see average of all total grades(average of total row in excel file)  |");
		System.out.println(" =====================================================================================");
		System.out.println("");
		System.out.print("Choice: ");
		ch = sc.nextInt();
        try (FileInputStream file = new FileInputStream(new File(filePath))) {
            // open xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // get first page
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    // get all cells
                    String name = getStringValue(row.getCell(0));
                    String surname = getStringValue(row.getCell(1));
                    String email = getStringValue(row.getCell(2));
                    double lab1 = getNumericValue(row.getCell(3));
                    double lab2 = getNumericValue(row.getCell(4));
                    double lab3 = getNumericValue(row.getCell(5));
                    double lab4 = getNumericValue(row.getCell(6));
                    double lab5 = getNumericValue(row.getCell(7));
                    double pl6 = getNumericValue(row.getCell(8));
                    double lab6 = getNumericValue(row.getCell(9));
                    double pl7 = getNumericValue(row.getCell(10));
                    double lab7 = getNumericValue(row.getCell(11));
                    double pl8 = getNumericValue(row.getCell(12));
                    double lab8 = getNumericValue(row.getCell(13));
                    double labsOverall = getNumericValue(row.getCell(14));
                    double project = getNumericValue(row.getCell(15));
                    double midterm = getNumericValue(row.getCell(16));
                    double finalex = getNumericValue(row.getCell(17));
                    double total = getNumericValue(row.getCell(18));
String fullName=name +" "+surname;        
                    root = dataOperations.insertRecord(root, new Student(fullName,  email, lab1, lab2, lab3, lab4, lab5, pl6, lab6, pl7, lab7, pl8, lab8, labsOverall, project, midterm, finalex, total));

                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch(ch) {
        case 1:
        	System.out.println("Name/Surname,Email,L1,L2,L3,L4,L5,PL6,L6,PL7,L7,PL8,L8,labs,project,midterm,final,total");
        	dataOperations.printAllDatas(root);
        break;
        case 2:
        
        dataOperations.printTree(root);
        System.out.println("Number Of Records in AVL Tree: "+dataOperations.getSize(root));
   break;
        case 3:
        	 sc.nextLine();
        	String searchedKey;
        	System.out.println("Please Enter Full Name Of The Student You Want To Search: ");	
        	searchedKey =sc.nextLine();
        dataOperations.search(root,searchedKey);
        break;
       case 4 :
        System.out.printf("Average Of Course: %.2f\n" ,dataOperations.average(root));
        break;
        default:
        	System.out.println("Invalid Choice...Please Enter a Valid Choice...");
        }
    sc.close();   
    }
    public static String getStringValue(Cell cell) {
        if (cell != null) {
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
        }
        return "";
    }
    public static double getNumericValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == CellType.STRING) {
               //convert excel cell to numeric value
                try {
                    return Double.parseDouble(cell.getStringCellValue().replace(",", "."));
                } catch (NumberFormatException e) {
                  
                    return 0.0;
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                // if cell is numeric ,then return the numeric value
                return cell.getNumericCellValue();
            }
        }
        return 0.0;
    }
}
