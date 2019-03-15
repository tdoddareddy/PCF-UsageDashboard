package io.pivotal.tola.cfapi.Usage.model;

import lombok.Builder; 
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class SIUsage {

    private String orgGuid;
    private int year;
    private int quarter;

    private long totalSvcs;
    private long totalSis;
    private double siDurationInSecs;

    @Builder.Default
    private Map<String, SISpaceUsage> siSpaceUsage = new HashMap<>();

    public long getTotalSvcs(){

        long count = 0L;
        if(siSpaceUsage != null && siSpaceUsage.size() > 0){
            count = siSpaceUsage.values().stream().map(o-> o.getTotalSvcs()).mapToLong(Long::intValue).sum();
        }
        return count;
    }

    public long getTotalSis(){

        long count = 0L;
        if(siSpaceUsage != null && siSpaceUsage.size() > 0){
            count = siSpaceUsage.values().stream().map(o-> o.getTotalSis()).mapToLong(Long::intValue).sum();
        }
        return count;
    }

    public double getSiDurationInSecs(){

        double count = 0.0;
        if(siSpaceUsage != null && siSpaceUsage.size() > 0){
            count = siSpaceUsage.values().stream().map(o-> o.getSiDurationInSecs()).mapToDouble(Double::doubleValue).sum();
        }
        return count;
    }


}