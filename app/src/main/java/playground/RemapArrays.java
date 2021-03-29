package playground;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeMap;

public class RemapArrays {
    TreeMap<String, target> map;

    @Getter
    @Setter
    @AllArgsConstructor
    public class target implements Comparable<target> {
        private String portfolioId;
        private Integer positionCount;

        @Override
        public int compare(target o1, target o2) {
            if(o1.getPositionCount() > o2.getPositionCount()){
                return 1;
            }else if(o1.getPositionCount() < o2.getPositionCount()){
                return -1;
            }else{
                return 0;
            }
        }

        @Override
        public int compareTo(target o) {
            return 0;
        }
    }

    public static void main(String[] args) {

    }

    public void init(){
        this.map = new TreeMap<String, target>();

        for(int i = 0; i <= 100; i++){
            target t = new target(i+ "", new Random().nextInt());
            this.map.put(t.getPortfolioId(),t);
        }

        map.sort();
    }

}
