package com.app.applicationquizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    //PERMUTATION
    private static List<Questions> permutationQuiz()
    {
        final List<Questions> questionsList = new ArrayList<>();

        //Create Object of questions
        questionsList.add(new Questions("There are 8 students in a classroom but only 5 can take the examination at a time. How many possible ways that the teacher will arrange so that all of the students are able to have their examination?\n\nWhat is the formula to be used","P(n,n)=n!","P(n,r)=n!/((n-r)!)","P=n!/(p!  q!  r!)","P=(n-1)!", 2));
        questionsList.add(new Questions("There are 8 students in a classroom but only 5 can take the examination at a time. How many possible ways that the teacher will arrange so that all of the students are able to have their examination?\n\nWhat is the value of n and r?", "n=5 and r=8", "n=5 and r=4", "n=8 and r=5", "n=8 and r=8", 3));
        questionsList.add(new Questions("There are 8 students in a classroom but only 5 can take the examination at a time. How many possible ways that the teacher will arrange so that all of the students are able to have their examination?\n\nWhen we substitute the given value to the formula, what will happen to the equation?", "P(8,5)=8!/((8-5)!)", "P(8,5)=8!/((8+5)!)", "P(8,5)=8!/((5-8)!)", "P(8,5)=8!/((5+5)!)", 1));
        questionsList.add(new Questions("There are 8 students in a classroom but only 5 can take the examination at a time. How many possible ways that the teacher will arrange so that all of the students are able to have their examination?\n\nWhat would be the next step?", "P(8,5)=8!/6!", "P(8,5)=8!/5!", "P(8,5)=8!/4!", "P(8,5)=8!/3!", 4));
        questionsList.add(new Questions("There are 8 students in a classroom but only 5 can take the examination at a time. How many possible ways that the teacher will arrange so that all of the students are able to have their examination?\n\nWhat is the final answer?", "P(8,5)=6,720", "P(8,5)=7,620", "P(8,5)=6,270", "P(8,5)=6,702",1));

        return questionsList;
    }

    //COMBINATION FORMULA
    private static List<Questions> combinationFormulaQuiz()
    {
        final List<Questions> questionsList = new ArrayList<>();

        //Create Object of questions
        questionsList.add(new Questions("If there are 9 distinct points on a plane with no 4 of which are collinear, how many different polygons can be formed?\n\nIs the given problem a combination?", "Yes", "No, it’s a permutation", "Maybe, not sure", "Neither", 1));
        questionsList.add(new Questions("If there are 9 distinct points on a plane with no 4 of which are collinear, how many different polygons can be formed?\n\nWhat is the formula to be used?", "nCr=n!/r!(n+r)!", "rCn=n!/r!(n+r)!", "nCr=n!/r!(n-r)!", "nCn=n!/r!(n-r)!", 3));
        questionsList.add(new Questions("If there are 9 distinct points on a plane with no 4 of which are collinear, how many different polygons can be formed?\n\n9! Is equivalent to _________.", "382,880", "363,880", "362,880", "362,890", 3));
        questionsList.add(new Questions("If there are 9 distinct points on a plane with no 4 of which are collinear, how many different polygons can be formed?\n\nAfter substituting the given value to the formula, what will happen to our equation?", "9C4=9!/4!(9-4)!", "9C4=4!/9!(9-4)!", "9C4=9!/4!(9+4)!", "4C9=9!/4!(9-4)!", 1));
        questionsList.add(new Questions("If there are 9 distinct points on a plane with no 4 of which are collinear, how many different polygons can be formed?\n\nWhat is the final answer?","125 polygons", "126 polygons", "127 polygons", "128 polygons", 2));

        return questionsList;
    }

    //PERMUTATION OR COMBINATION
    private static List<Questions> permutationOrCombination()
    {
        final List<Questions> questionsList = new ArrayList<>();

        //Create Object of questions
        questionsList.add(new Questions("In a classroom, a teacher is selecting 38 out of 40 students to clean the field, the rest will clean the room. How many arrangements the teacher can do to choose who among the students will go and clean the field.\n\nWhat type of problem is given?", "Combination", "Circular permutation", "Factorial Notation ", "FCP", 1));
        questionsList.add(new Questions("In a classroom, a teacher is selecting 38 out of 40 students to clean the field, the rest will clean the room. How many arrangements the teacher can do to choose who among the students will go and clean the field.\n\nHow do say that it is a combination?", "Because order of the matter is not important.", "Because order of the matter is important.", "Because order of the matter is not calculated.", "Because order of the matter is calculated", 1));
        questionsList.add(new Questions("In a classroom, a teacher is selecting 38 out of 40 students to clean the field, the rest will clean the room. How many arrangements the teacher can do to choose who among the students will go and clean the field.\n\nWhat is the formula to be used?", "P= (n-1)!", "P=n!/(n-r)!", "nCr=n!/r!(n-r)!", "P=n!/(p!  q!  r!)", 3));
        questionsList.add(new Questions("In a classroom, a teacher is selecting 38 out of 40 students to clean the field, the rest will clean the room. How many arrangements the teacher can do to choose who among the students will go and clean the field.\n\nAfter substituting the given value to the formula, what will happen to our equation?", "40C38=40!/38!(40-38)!", "40C38=40!/38!(40+38)!", "38C40=40!/38!(40-38)!", "38C40=40!/38!(40+38)!", 1));
        questionsList.add(new Questions("In a classroom, a teacher is selecting 38 out of 40 students to clean the field, the rest will clean the room. How many arrangements the teacher can do to choose who among the students will go and clean the field.\n\nWhat is the final answer?", "780 possible ways", "1560 possible", "790 possible ways","1580 possible ways",1));

        return questionsList;
    }

    public static List<Questions> getQuestions(String getSelectedQuiz)
    {
        switch (getSelectedQuiz)
        {
            case "permutation":
                return permutationQuiz();

            case "comForm":
                return combinationFormulaQuiz();

            default:
                return permutationOrCombination();
        }
    }

}
