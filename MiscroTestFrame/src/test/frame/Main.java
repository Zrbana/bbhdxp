package test.frame;

import test.frame.annotation.Case;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException {


        List<Case> caseList = caseRunner.InitCase();
        caseRunner caseRunner = new caseRunner();
        for (Case bCase : caseList) {
            caseRunner.runCase(bCase);

        }
    }
}
