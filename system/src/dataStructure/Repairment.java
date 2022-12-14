package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import dataStructure.Fault;

public class Repairment {
    int id;//报修的编号
    int state;//报修状态
    public float report_time;//报修时间
    public int fault_type;//故障类别
    public String report_person;//报修人
    public String report_method;//报修来源
    //构造函数
    public Repairment(){
        HashMap< String, Integer> faultmap = new HashMap< String, Integer>();
        faultmap.put("断电", 1); // 将故障存储到Map中
        faultmap.put("下水道堵塞", 2);
        faultmap.put("电梯故障", 3);
        fault_type = faultmap.get();



    }
}
