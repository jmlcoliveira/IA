import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
        //ArrayList<String> cities = d.getCities();

        SimAnnealing sim = new SimAnnealing(d);
        int best = Integer.MAX_VALUE;
        while(true) {
            Solution s = sim.solution(cities, 1000, 10);
            if(s.getSolutionDistance() < best){
                System.out.println(s);
                best = s.getSolutionDistance();
            }
        }
    }

    private static ArrayList<String> readCities(Scanner in){
        ArrayList<String> temp = new ArrayList<>();
        String cities = in.nextLine();
        cities = cities.replaceAll("[,.;-]", "");
        StringBuilder city= new StringBuilder();
        for(int i = 0; i<cities.length(); i++){
            if(cities.charAt(i) != ' ')
                city.append(cities.charAt(i));
            else{
                temp.add(city.toString());
                city = new StringBuilder();
            }
        }
        temp.add(city.toString());
        return temp;
    }
}
