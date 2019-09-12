package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GradingStudents {
    private static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        for(int i = 0; i < grades.size(); i++){
            if(grades.get(i) >= 38 && 5 - grades.get(i) % 5 < 3){
                grades.set(i, grades.get(i) + (5 - grades.get(i) % 5));
            }
        }

        return grades;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);

        for(Integer grade : result){
            System.out.println(grade);
        }

        bufferedReader.close();
    }
}