package ru.geekbrains.qa.java2.lesson1;

public class Course {


    public Course(){

    }
    public void doIt(Team team){

        for(Team.TeamMember tm : team.getMembers()){
            tm.run();
        }
    }

    public enum Obstacle {

        FIRST( 3), SECOND( 3), THIRD( 2), FORTH( 1), FIFTH(2);

        private int height;
        public static final int MAX = 3;
        public static final int MIN = 1;

        public int getHeight() {
            return height;
        }

        Obstacle( int height) {
            this.height = height;
        }
    }
}
