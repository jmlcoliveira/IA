import java.util.ArrayList;

public class SimAnnealing {

    private final DistanceMatrix d;
    private final double alpha = 0.999;

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
        int[] rand = generateNonContiguous(1, cities.size()-1);
        int i1 = rand[0];
        int i2 = rand[1];
        String temp = cities.get(i1);
        cities.set(i1, cities.get(i2));
        cities.set(i2, temp);
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

    @SuppressWarnings("unchecked")
    public Solution solution(ArrayList<String> cities, double iniTemp){
        Solution current = computeSolution(cities);
        if(cities.size() <= 2) return current;
        Solution best = current;
        double temperature = iniTemp;
        while(true){
            ArrayList<String> curr = (ArrayList<String>) current.getSolutionPath().clone();
            Solution next = computeSolution(curr);
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

    private int[] generateNonContiguous(int minInc, int maxInc){
        int[] res = new int[2];
        res[0] = (int)(Math.random() * (maxInc)) + minInc;
        res[1] = (int)(Math.random() * (maxInc)) + minInc;
        while(Math.abs(res[0] - res[1]) <= 1){
            res[0] = (int)(Math.random() * (maxInc)) + minInc;
            res[1] = (int)(Math.random() * (maxInc)) + minInc;
        }
        return res;
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

    @Override
    public String toString() {
        return solutionPath + " with a distance of: " + solutionDistance;
    }
}
