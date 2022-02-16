package com.justynsoft.da.tester;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justynsoft.da.tester.JobConfig;


public class TestYamlReader {

    public static void main(String[] args){
        try {
            String configFileName = "test.yml";
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(configFileName)));
//            OtherConfig otherConfig =new ObjectMapper(new YAMLFactory()).readValue(reader, OtherConfig.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
