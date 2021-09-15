package ru.geekbrains.qa.java2.lesson1;

import java.util.Random;

public class Team {
    String name;
    TeamMember members[];

    public Team(String name, String memberNames[]){
        this.name = name;
        this.members = new Team.TeamMember[memberNames.length];
        int i = 0;
        for(String s:memberNames){
            this.members[i++] = new TeamMember(s);
        }
    }

    public TeamMember[] getMembers(){
        return members;
    }

    public void showResults(){
        for(TeamMember m: members){
            String s = "";
            for (boolean b: m.getResults())
            {
                s += b + "; ";
            }
            System.out.println("Результат члена команды " + m.getName() + " " + s);
        }
    }

    public void showRun(){
        for(TeamMember m: members){
            if(m.isSucceeded()){
                System.out.println("Член команды пробежал дистанцию с препятсвиями " + m.name);
            };
        }
    }


    public class TeamMember{
        private String name;
        private boolean []results;

        public TeamMember(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        boolean [] getResults(){
            return results;
        }



        boolean isSucceeded(){
            if (results == null) return false;
            boolean b = results[0];
            for(boolean result: results){
                b &= result;
            }
            return b;
        }

        public void run(){
            this.results = new boolean[Course.Obstacle.values().length];
            int i = 0;
            for(Course.Obstacle o : Course.Obstacle.values()) {
               results[i++]=singleRun(o.getHeight());
            }
        }

        private boolean singleRun(int height){

            int step = Course.Obstacle.MIN + new Random().nextInt(Course.Obstacle.MAX - Course.Obstacle.MIN + 1);
            if(height - step <= 0)
                return true;
            else return false;
        }
    }
}
