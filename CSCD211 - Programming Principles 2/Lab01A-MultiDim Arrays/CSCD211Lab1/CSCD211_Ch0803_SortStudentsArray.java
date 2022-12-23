
/*
Johanne McClenahan - CSCD211 Lab01 from Ch08 Section03 - SortStudentsArray

Objective of Program: 
1. rewrite the given java file (GradeExam.java) to sort students based on number of correct answers in ascending order.
2. display the sorted array of students along with their corresponding index number.
3. display the results in the format: "Student [studentIndex#]'s correct count is [#ofCorrectAnswers]"
*/

public class CSCD211_Ch0803_SortStudentsArray{
  /** Main method */
  public static void main(String args[]) {
    // Students' answers to the questions
    char[][] answers = {
      {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
      {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
      {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
      {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
// Key to the questions
    char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
// Each student's number of correct answers
    int [][] studentResults = new int[2][8];
// Each student's corresponding index number
    int studentIndex = 0;

    // Grade all answers
    for (int i = 0; i < answers.length; i++) {
      // Grade one student
      int correctCount = 0;
      for (int j = 0; j < answers[i].length; j++) {
        if (answers[i][j] == keys[j])
          correctCount++;
      }
      // Adds student's results into one of the eight columns in the results array
      studentResults[0][i] = correctCount;
      // Adds students index number into the results array into the corresponding column that contains the same student's results
      studentResults[1][i] = studentIndex; 
      // increments studentIndex to the next student's index number
      studentIndex++;
    }
      // Sorting students in ascending order based on the number of correct answers while keeping track of their index number followed by displaying them to the user
    for(int i = 0; i < studentResults[0].length; i++) {
      int temp = studentResults[0][i];
      for(int j = i+1; j < studentResults[0].length; j++) {
         if(studentResults[0][i] > studentResults[0][j]) {
      // Sort student's score based on correct answers
            temp = studentResults[0][i];
            studentResults[0][i] = studentResults[0][j]; 
            studentResults[0][j] = temp;  
      // Sort student's index number based on the student's correct answers
            temp = studentResults[1][i];
            studentResults[1][i] = studentResults[1][j]; 
            studentResults[1][j] = temp;  
               }
            }
      // Print results in order of correct answers with student index number
    System.out.println("Student " + (studentResults[1][i]) + "'s correct count is " + studentResults[0][i]);

    }
    
  }
}
