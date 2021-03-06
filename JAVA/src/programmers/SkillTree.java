package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SkillTree {

    public static void main(String[] args) {
        String[] s = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution("CBD", s));
    }

    // 정말 많이 풀려 노력했지만...
    // 코드 자체도 너무 더러워지고
    // 효율도 너무 떨어졌다
    // 그래서 검색해서 찾아보았다
    // 아직 공부할 게 많아 보인다

    public static int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int beforeIdx = 0, currentIdx = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            beforeIdx = skill_trees[i].indexOf(skill.charAt(0)); //맨 처음 스킬의 위치를 찾아낸다. ex) 스킬이 CBD면 C의 위치를 찾아냄

            for (int j = 1; j < skill.length(); j++) {
                currentIdx = skill_trees[i].indexOf(skill.charAt(j)); //반복문을 돌려서 0번 이후의 스킬들의 위치를 찾아낸다

                if ((beforeIdx > currentIdx && currentIdx != -1) || (beforeIdx == -1 && currentIdx != -1)) { //이건 잘못된 케이스들을 모아놓은 것
                    answer--; //그래서 answer은 스킬트리의 길이였는데 아닌 것마다 빼주니 맞는 것만 남는 것
                    break;
                }

                beforeIdx = currentIdx;
            }
        }

        return answer;
    }

//    프로그래머스 다른 사람의 풀이에 있는거
//    정규식 표현과 Iterator를 활용한 간단한 풀이
//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
//        //ArrayList<String> skillTrees = new ArrayList<String>();
//        Iterator<String> it = skillTrees.iterator();
//
//        while (it.hasNext()) {
//            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
//                it.remove();
//            }
//        }
//        answer = skillTrees.size();
//        return answer;
//    }

}
