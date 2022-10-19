import java.util.ArrayList;

public class SimAnnealing {

    private final DistanceMatrix d;
    private final double ALPHA = 0.85;

    private final double BETA = 1.005;

    public SimAnnealing(DistanceMatrix d){
        this.d = d;
    }

    //decaimento
    private double newTemp(double currTemp){
        return ALPHA * currTemp;
    }

    private double var_n_iter(double num_iter){
        return BETA * num_iter;
    }

    private boolean toStop(double currTemp){
        return currTemp < 0.0000000001;
    }

    private Solution computeSolution(int curr_iter, double curr_temp, ArrayList<String> cities){
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
        return new Solution(solutionPath, solutionDistance, curr_iter, curr_temp);
    }

    public Solution solution(ArrayList<String> cities, double iniTemp, double num_iter){
        int count = 0;
        Solution current = computeSolution(count, iniTemp, cities);
        if(cities.size() <= 3) return current;
        Solution best = current;
        double temperature = current.getCurr_temp()*2;
        while(true){
            for(int i = 0; i < (int)num_iter; i++){
                count++;
                ArrayList<String> curr = new ArrayList<>(current.getSolutionPath());
                curr.remove(curr.size()-1);
                Solution next = computeSolution(count, temperature, curr);
                int distance = next.getSolutionDistance() - current.getSolutionDistance();
                if(distance < 0){
                    current = next;
                    if(current.getSolutionDistance() < best.getSolutionDistance())
                        best = current;
                }
                else{
                    if(Math.exp(-distance/temperature) > Math.random())
                        current = next;
                }
            }
            if(toStop(temperature)) return best;
            temperature = newTemp(temperature);
            num_iter = var_n_iter(num_iter);
        }
    }

    private int[] generateNonContiguous(int minInc, int maxInc){
        int[] res = new int[2];
        res[0] = (int)(Math.random() * (maxInc)) + minInc;
        res[1] = (int)(Math.random() * (maxInc)) + minInc;
        if(Math.abs(res[0] - res[1]) == 0)
            return generateNonContiguous(minInc, maxInc);
        return res;
    }
}

class Solution{
    private final ArrayList<String> solutionPath;
    private final int solutionDistance;
    private final int curr_iter;
    private final double curr_temp;

    public Solution(ArrayList<String> solutionPath, int solutionDistance, int curr_iter, double curr_temp){
        this.solutionPath = new ArrayList<>(solutionPath);
        this.solutionPath.add(this.solutionPath.get(0));
        this.solutionDistance = solutionDistance;
        this.curr_iter = curr_iter;
        this.curr_temp = curr_temp;
    }

    public int getSolutionDistance() {
        return solutionDistance;
    }

    public ArrayList<String> getSolutionPath() {
        return solutionPath;
    }

    public double getCurr_temp() {
        return curr_temp;
    }

    @Override
    public String toString() {
        return "Nr. iter: " + curr_iter + "\nTemp: " + curr_temp + "\n" + solutionPath + " with a distance of: " + solutionDistance;
    }
}
