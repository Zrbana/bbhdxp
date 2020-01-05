package www.utils;

import www.annotation.Case;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        List<Case> caseList = CaseRunner.InitCase();
        CaseRunner caseRunner = new CaseRunner();
        for (Case bCase : caseList) {
            caseRunner.runCase(bCase);
        }
    }
}


