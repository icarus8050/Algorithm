import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 나이순 정렬(https://www.acmicpc.net/problem/10814)
 */
public class BOJ_10814 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");

            people.add(new Person(i, Integer.parseInt(inputs[0]), inputs[1]));
        }

        Collections.sort(people);

        for (int i = 0; i < n; i++) {
            bw.write(people.get(i).age+ " " + people.get(i).name);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    public static class Person implements Comparable<Person> {
        int seq;
        int age;
        String name;

        public Person(int seq, int age, String name) {
            this.name = name;
            this.age = age;
            this.seq = seq;
        }

        @Override
        public int compareTo(Person o) {
            if (age == o.age) {
                return seq - o.seq;
            }
            return age - o.age;
        }
    }
}
