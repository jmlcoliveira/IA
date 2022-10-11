import java.util.ArrayList;

public class SimAnnealing {

    private final DistanceMatrix d;
    private final double alpha = 0.99;

    public SimAnnealing(DistanceMatrix d){
        this.d = d;
    }

    //decaimento
    private double newTemp(double currTemp){
        return alpha * currTemp;
    }

    private boolean toStop(double currTemp){
        return currTemp < 0.000000000001;
    }

    private Solution computeSolution(ArrayList<String> cities){
        int solutionDistance = 0;
        ArrayList<String> solutionPath = new ArrayList<>();
        for(int i=0; i<cities.size()-1; i++) {
            solutionPath.add(cities.get(i));
            solutionDistance += d.distance(cities.get(i), cities.get(i + 1));
        }
        solutionPath.add(cities.get(cities.size()-1));
        solutionDistance += d.distance(cities.get(cities.size()-1), cities.get(0));
        return new Solution(solutionPath, solutionDistance);
    }

    public Solution solution(ArrayList<String> cities, double iniTemp){
        Solution current = computeSolution(cities);
        Solution best = current;
        double temperature = iniTemp;
        while(true){
            int i = (int)Math.floor(Math.random() * (cities.size()-1));
            int j = (int)Math.ceil(Math.random() * (cities.size()-1));
            String temp = cities.get(i);
            cities.set(i, cities.get(j));
            cities.set(j, temp);
            Solution next = computeSolution(cities);
            if(next.getSolutionDistance() < current.getSolutionDistance()){
                current = next;
                if(current.getSolutionDistance() < best.getSolutionDistance())
                    best = current;
            }
            else{
                int distance = next.getSolutionDistance();
                if(Math.exp(-distance/temperature) > Math.random())
                    current = next;
            }
            if(toStop(temperature)) return best;
            temperature = newTemp(temperature);
        }
    }
}

class Solution{
    private ArrayList<String> solutionPath;
    private int solutionDistance;

    public Solution(ArrayList<String> solutionPath, int solutionDistance){
        this.solutionPath = solutionPath;
        this.solutionDistance = solutionDistance;
    }

    public int getSolutionDistance() {
        return solutionDistance;
    }

    public ArrayList<String> getSolutionPath() {
        return solutionPath;
    }

    public void setSolutionDistance(int solutionDistance) {
        this.solutionDistance = solutionDistance;
    }

    public void setSolutionPath(ArrayList<String> solutionPath) {
        this.solutionPath = solutionPath;
    }

    public void printSolution(){
        System.out.println(solutionPath + " with a distance of: " + solutionDistance);
    }
}
