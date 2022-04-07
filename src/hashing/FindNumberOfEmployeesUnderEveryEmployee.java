package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
 2. An employee directly reports to only one manager.
 3. All managers are employees but the reverse is not true.
 4. An employee reporting to himself is the CEO of the company.
 5. You have to find the number of employees under each manager in the hierarchy not just their direct repartees.
 Ex: N = 6
 Employee   Manager
 misc.A          misc.C
 misc.B          misc.C
 misc.C          F
 D          E
 E          F
 F          F

 * */
public class FindNumberOfEmployeesUnderEveryEmployee {

    public static void main(String[] args) {

        //mapping of employee and his/her manager
        HashMap<String, String> empManagerMap = new HashMap<>();
        empManagerMap.put("misc.A", "misc.C");
        empManagerMap.put("misc.B", "misc.C");
        empManagerMap.put("misc.C", "F");
        empManagerMap.put("D", "E");
        empManagerMap.put("E", "F");
        empManagerMap.put("F", "F");

        HashMap<String, Integer> result = noOfEmployeesUnderEveryEmployee(empManagerMap, 6);
        for(Map.Entry<String, Integer> entry: result.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static HashMap<String, Integer> noOfEmployeesUnderEveryEmployee(HashMap<String, String> empManagerMap, int N) {

        //Now put the employees under the direct managers. Ex: misc.C -> misc.A, misc.B  E-> D  F-> misc.C, E
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        String ceo = "";
        for(String emp: empManagerMap.keySet()){
            String manager = empManagerMap.get(emp);

            if(manager.equals(emp)){
                //agar manager and emp equal hai that means woh sabse upar hai. Woh ceo hai
                ceo = emp;
            }else{
                //agar manager already report map mein hai toh uss report map ke set mein iss emp ko add kar do
                if(reportMap.containsKey(manager)){
                    HashSet<String> employeeSet = reportMap.get(manager);
                    employeeSet.add(emp);
                }else{
                    //agar manager reportMap mein nhi hai toh uss report map mein ek nayi set and nayi entry banao
                    //and emp ko set mein add kar do and reportMap.put kar do
                    HashSet<String> employeeSet = new HashSet<>();
                    employeeSet.add(emp);
                    reportMap.put(manager, employeeSet);
                }
            }
        }

        for(Map.Entry<String, HashSet<String>> entry: reportMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(" ");

        HashMap<String, Integer> result = new HashMap<>();
        countNumberOfRepartees(reportMap, ceo, result);
        return result;
    }

    private static int countNumberOfRepartees(HashMap<String, HashSet<String>> reportMap, String man, HashMap<String, Integer> result) {

        if(!reportMap.containsKey(man)){
            result.put(man, 0);
            return 1;
        }
        int sz = 0;
        for(String child: reportMap.get(man)){
            int cs = countNumberOfRepartees(reportMap, child, result);
            sz+= cs;
        }
        result.put(man, sz);
        return sz+1;
    }
}
