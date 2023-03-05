package hard;

import java.util.*;

public class Solution818 {

    public static void main(String[] args){
        Solution818 solution818=new Solution818();
//        System.out.println(solution818.racecar(15));
        System.out.println(solution818.racecar(4));
    }

    public int racecar(int target) {
        LinkedList<State> states=new LinkedList<>();
        states.add(new State(0,0,1));
        Map<State,Integer> stateIntegerMap=new HashMap<>();
        stateIntegerMap.put(new State(0,0,1),0);
        int result = 3 * target;
        while (states.size()>0){
            State topState =states.poll();
            if (topState.position==target) {
                result=Math.min(result,topState.count);
                continue;
            }
            if (topState.count>result) continue;
            State state1 = topState.copy();
            state1.count=topState.count+1;
            state1.speed=state1.speed>0?-1:1;
            if (state1.count<result) {
                if (stateIntegerMap.get(state1) == null || state1.count < stateIntegerMap.get(state1)) {
                    states.addFirst(state1);
                    stateIntegerMap.put(state1, state1.count);
                }
            }
            State state2 = topState.copy();
            state2.count=topState.count+1;
            state2.position=state2.position+state2.speed;
            state2.speed=2*state2.speed;
            if (state2.position<=2*target+1 && state2.position>=-(2*target+1)){
                if (stateIntegerMap.get(state2) == null || state2.count < stateIntegerMap.get(state2)) {
                    states.addFirst(state2);
                    stateIntegerMap.put(state2, state2.count);
                }
            }
        }
        return result;
    }

    class State{
        int position;
        int speed;
        int count;
        public State(int position,int count,int speed){
            this.position=position;
            this.count=count;
            this.speed=speed;
        }

        public State copy(){
            return new State(this.position,this.count,this.speed);
        }

        public int hashCode(){
            return Integer.hashCode(position)+Integer.hashCode(speed);
        }

        public boolean equals(Object obj){
            return (obj instanceof State) && (this.position==((State) obj).position)
                    && (this.speed==((State) obj).speed);
        }
    }

}
