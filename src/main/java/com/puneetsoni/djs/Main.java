package com.puneetsoni.djs;

import com.puneetsoni.djs.agent.AgentApplication;
import com.puneetsoni.djs.master.MasterApplication;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        if (ArrayUtils.isEmpty(args)) {
            System.err.println("No component provided. Please choose between: {master, agent}");
            return;
        }
        String component = args[0];
        System.out.println("Component: " + component);
        args = Arrays.copyOfRange(args, 1, args.length);
        System.out.println(Arrays.asList(args));
        switch (component) {
            case "master":
                new MasterApplication().run(args);
                break;
            case "agent":
                new AgentApplication().run(args);
                break;
            default:
                throw new Exception("Unknown component: " + component);
        }
    }
}
