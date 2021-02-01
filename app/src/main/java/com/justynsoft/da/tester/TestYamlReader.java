package justynsoft.da.tester;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestYamlReader {

    public static void main(String[] args){
        try {
            String configFileName = "test.yml";
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(configFileName)));
            JobConfig jobConfig = new ObjectMapper(new YAMLFactory()).readValue(reader, JobConfig.class);
//            OtherConfig otherConfig =new ObjectMapper(new YAMLFactory()).readValue(reader, OtherConfig.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
