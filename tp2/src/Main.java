import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "Distancias.txt";
    private static final String READ_FROM_COMMAND_LINE = "C";
    private static final  String READ_FROM_FILE = "F";

    public static void main(String[] args) throws FileNotFoundException {
        DistanceMatrix d = new DistanceMatrix(FILE_NAME);
        Scanner in = new Scanner(System.in);
        switch(in.nextLine().trim()) {
            case READ_FROM_COMMAND_LINE:
                break;
            case READ_FROM_FILE:
            in = new Scanner(new BufferedReader(new FileReader(in.nextLine().trim())));
                break;
            default:
                System.out.println("Bruh");
                break;
        }

        ArrayList<String> cities = readCities(in);
        System.out.println(cities);
    }

    private static ArrayList<String> readCities(Scanner in){
        ArrayList<String> temp = new ArrayList<>();
        String city = "";
        //in.useDelimiter(System.getProperty("line.separator"));
        while(in.hasNext())
            temp.add(in.next().trim());
        in.nextLine();
        return temp;
    }
}
