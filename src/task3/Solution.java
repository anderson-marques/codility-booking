package task3;

import java.util.*;

/**
 * Created by anderson on 09/05/17.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A = new int[3];
        A[0] = 60;
        A[1] = 80;
        A[2] = 40;
        int[] B = new int[3];
        B[0] = 2;
        B[1] = 3;
        B[2] = 5;

        int stops = solution.solution(A, B, 5, 2, 200);

        System.out.println(stops);
    }

    public int solution(int[] A, int[] B, int M, int elevatorMaximumCapacity, int elevatorMaximumWeight) {
        // Elevator stops
        int elevatorStops = 0;
        // Floors M
        final int floorsCount = M;
        // Elevator maximum capacity X, maximum weight Y
        Elevator elevator = new Elevator(elevatorMaximumCapacity, elevatorMaximumWeight);
        // Organize the queue
        LinkedList<Person> peopleWaiting = new LinkedList<>();
        for (int i = 0; i < A.length && i < B.length; i++){
            int weight = A[i];
            int target = B[i];
            peopleWaiting.add(new Person(weight,target));
        }

        while (peopleWaiting.size() > 0){
            // Populate the elevator cabin
            Iterator<Person> itWaiting = peopleWaiting.iterator();
            while (!elevator.isFull() && itWaiting.hasNext()){
                Person personWaiting = itWaiting.next();
                if (elevator.support(personWaiting)){
                    elevator.enterPerson(personWaiting);
                    itWaiting.remove();
                }
            }

            // Deliver people
            for (int i = 1 ; i <= floorsCount; i++){
                elevatorStops += elevator.leavePeople(i) ? 1 : 0;
            }
        }

        return elevatorStops;
    }

    private class Person {
        public final int weight;
        public final int target;

        public Person(int weight, int target){
            this.weight = weight;
            this.target = target;
        }
    }

    private class Elevator {
        private final int elevatorMaximumCapacity;
        private final int elevatorMaximumWeight;

        private int elevatorCapacity;
        private int elevatorWeight;

        private List<Person> peopleInside = new ArrayList<>();

        private boolean full = false;

        public Elevator(int elevatorMaximumCapacity, int elevatorMaximumWeight){
            this.elevatorMaximumCapacity = elevatorMaximumCapacity;
            this.elevatorMaximumWeight = elevatorMaximumWeight;
        }

        public boolean isFull(){
            return this.full;
        }

        public Elevator enterPerson(final Person person){
            this.elevatorCapacity++;
            this.elevatorWeight += person.weight;
            peopleInside.add(person);
            return this;
        }

        public boolean leavePeople(int floor){
            boolean leavePeople = false;
            Iterator<Person> peopleInsideIt = this.peopleInside.iterator();
            while (peopleInsideIt.hasNext()){
                Person person = peopleInsideIt.next();
                if (person.target == floor){
                    this.elevatorCapacity--;
                    this.elevatorWeight -= person.weight;
                    peopleInsideIt.remove();
                    leavePeople = true;
                    this.full = false;
                }
            }

            return leavePeople;
        }

        public boolean support(Person person) {
            if ((this.elevatorCapacity + 1 <= this.elevatorMaximumCapacity ) && (this.elevatorWeight + person.weight <= this.elevatorMaximumWeight)){
                return true;
            } else {
                this.full = true;
                return false;
            }
        }
    }

}
