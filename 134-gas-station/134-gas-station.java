class Solution {
    /*public int canCompleteCircuit(int[] gas, int[] cost){
      int total_gas = 0;
        int total_cost = 0;

        for (int i : gas) {
            total_gas += i;
        }
        //System.out.println(total_gas);
        for (int j : cost) {
            total_cost += j;
        }
        //System.out.println(total_cost);
        if (total_gas < total_cost) {
            return -1;
        }

        System.out.println(total_gas);
        for (int ind = 0; ind < gas.length; ind++) {
            if (gas[ind] - cost[ind] < 0)
                continue;
            int tot_tank = 0;
            for (int j = ind; j < gas.length + ind; j++) {
                tot_tank += gas[j % gas.length] - cost[j % gas.length];
                if (tot_tank < 0)
                    break;
            }
            if (tot_tank >= 0)
                return ind;
        }

        return -1;
    }*/
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;

    int total_tank = 0;
    int curr_tank = 0;
    int starting_station = 0;
    for (int i = 0; i < n; ++i) {
      total_tank += gas[i] - cost[i];
      curr_tank += gas[i] - cost[i];
      // If one couldn't get here,
      if (curr_tank < 0) {
        // Pick up the next station as the starting one.
        starting_station = i + 1;
        // Start with an empty tank.
        curr_tank = 0;
      }
    }
    return total_tank >= 0 ? starting_station : -1;
  }
}