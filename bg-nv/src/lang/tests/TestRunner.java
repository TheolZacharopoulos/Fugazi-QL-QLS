package lang.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Nik on 10-2-15.
 */
public class TestRunner
{
    public static void main(String[] args)
    {
        print("Initiating test");
        Result result = JUnitCore.runClasses(ParserTest.class, LexerTest.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
            System.out.println(failure.getTrace());
        }
        print("Test run " + (result.wasSuccessful() ? "passed" : "FAILED"));
    }

    private static void print(String msg)
    {
        System.out.println("------------------------------> " + msg + " <------------------------------");
    }
}
