package thesociopath;

import java.util.ArrayList;
import java.util.Random;


public class TheSociopath{

    static char[] studentsID = {'A','B','C','D','E','F','G','H','I','J'};
    static int[] rep = new int[10];

    public static void main(String[] args) {
        Graph<Character,Integer> students = new Graph<>();
        for(char a : studentsID)
            students.addVertex(a);
        Random r = new Random();
        for(int i=0;i<studentsID.length;i++){
            int a = r.nextInt(2)+1;
            ArrayList<Integer> check = new ArrayList<>();
            for(int j=0;j<a;j++){
                int b = r.nextInt(10);
                int c = r.nextInt(10)+1;
                int d = r.nextInt(10)+1;
                if(check.contains(b)||b==i)
                    continue;
                check.add(b);
                students.addEdge(studentsID[i], studentsID[b], c);
                students.addEdge(studentsID[b], studentsID[i], d);
                rep[b]+=c;
                rep[i]+=d;
            }
        }
        System.out.println("Student and list of friends : \n");
        students.printEdges();
        System.out.println("\nCurrent reputation point of students : ");
        for(int i=0;i<studentsID.length;i++){
            System.out.println("#Student " + studentsID[i] + " : " + rep[i]);
        }
    }

}