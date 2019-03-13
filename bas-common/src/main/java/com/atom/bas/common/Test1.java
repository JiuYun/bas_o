package com.atom.bas.common;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****
 *
 * 让数据说话
 * 每月378块，10年
 *
 *
 */
public class Test1 {

    private static BigDecimal   unitPrice   = BigDecimal.valueOf(378);          //每期存入金额
    private static int          sumYear     = 30;                               //共计年
    private static int          saveYear    = 10;                               //需要存入年
    private static int          startYear   = 2017;                             //
    private static BigDecimal   live        = new BigDecimal(0.0035);
    private static BigDecimal   regular_1   = new BigDecimal(0.0175);
    private static BigDecimal   regular_2   = new BigDecimal(0.0225);
    private static BigDecimal   regular_3   = new BigDecimal(0.0275);
    private static BigDecimal   mouth       = new BigDecimal(12);


    public static void main(String[] args) {
        List<Map<String,Object>> issues      = new ArrayList<Map<String, Object>>();

        for(int i = 0; i < sumYear; i++){
            if(i >= saveYear){
                unitPrice = BigDecimal.ZERO;
            }

            for(int j = 1; j <= 12; j++){
                BigDecimal principal = i + j <= 1 ? BigDecimal.ZERO :  (issues.size() == 0 ? unitPrice : (((BigDecimal) issues.get(issues.size() - 1).get("interest_live"))));

                Map<String,Object> issue = new HashMap<String, Object>();
                issue.put("date",String.format("%s年%-2s月",startYear + (i + 1),j));
                issue.put("issue",i * 12 + j);
                issue.put("save",unitPrice.compareTo(BigDecimal.ZERO) == 0 ? "---" : unitPrice);
                issue.put("insurance",i < saveYear ? unitPrice.multiply(BigDecimal.valueOf(i * 12 + j)) : unitPrice.multiply(BigDecimal.valueOf(saveYear * 12)));
                issue.put("interest_live",(principal.multiply(live).multiply(BigDecimal.ONE).divide(mouth,2,BigDecimal.ROUND_DOWN)).add(principal).add(unitPrice).setScale(2,BigDecimal.ROUND_DOWN));

                //1.定期1年
                if(i > 0 && i % 1 == 0 && j == 12){
                    BigDecimal principal_1 = i == 1 ? (BigDecimal)issues.get(i * 12 - 1).get("interest_live") : ((BigDecimal)issues.get(i * 12 - 1).get("regular_1"));          //获取本金
                    BigDecimal live_1 = (BigDecimal)issues.get(12 - 1).get("interest_live");
                    issue.put("regular_1",principal_1.multiply(regular_1).multiply(BigDecimal.ONE).add(principal_1).add(live_1).setScale(2,BigDecimal.ROUND_DOWN));
                }else{
                    issue.put("regular_1","---");
                }

                //2.定期2年
                if(i % 2 == 0 && j == 12){

                }else{
                    issue.put("regular_2","---");
                }

                //3.定期3年
                if(i % 3 == 0 && j == 12){
                    issue.put("regular_3","---");
                }else{
                    issue.put("regular_3","---" );
                }

                issues.add(issue);
            }
        }


        for(int i = 0; i < issues.size(); i++){
            Map<String,Object> issue = issues.get(i);
            System.out.println(String.format("%s\t期号:%-3s\t存:%-3s\t保:%-8s\t活期:%-10s\t定期约转1年:%-10s",issue.get("date"),issue.get("issue"),issue.get("save"),issue.get("insurance"),issue.get("interest_live"),issue.get("regular_1")));



        }


















    }




}
