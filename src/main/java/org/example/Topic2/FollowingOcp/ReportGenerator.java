package org.example.Topic2.FollowingOcp;

public class ReportGenerator {
    private ReportStrategy strategy;

    public void setStrategy(ReportStrategy strategy){
        this.strategy = strategy;
    }

    public void generateReport(String data,String path) {
        strategy.generate(data ,path);
    }
}
