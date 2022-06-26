class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();
    
    private Map<String, Pair<Double, Double>> journeyData = new HashMap<>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
       Pair<String, Integer> newP = checkInData.get(id);
        String startStn = newP.getKey();
        Integer startTime = newP.getValue();
        
        
        String journeyKey = getStnKey(startStn, stationName);       
        Pair<Double, Double> routeStat = journeyData.getOrDefault(journeyKey, new Pair<>(0.0,0.0));
        
        double total  = routeStat.getKey();
        double totalTimes = routeStat.getValue();
        
        int travelTime = t - startTime;
        journeyData.put(journeyKey,new Pair<>(total + travelTime, totalTimes +1));
      checkInData.remove(id);  
    }
    
    public String getStnKey(String stn1, String stn2)
    {
        return stn1 + "->" + stn2;
    }
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double,Double> data = journeyData.get(getStnKey(startStation,endStation));
            double totalTime = data.getKey();
        double times = data.getValue();
        
        return totalTime/times;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */