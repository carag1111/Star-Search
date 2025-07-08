#include <iostream>
using namespace std;

//Function to get and validate the judge's score
//Precondition: Score must be a float between 0 and 10
//Postcondition: Returns the score if valid
float getScore(int judge_number) {
    float score;
    cout << "Enter score for judge " << judge_number << "(0-10): ";
    cin >> score;

  while (cin.fail() || score < 0 || score > 10) {
        cin.clear(); //cleear the fail state
        cin.ignore(1000, '\n'); //ignore the rest of the invalid input
        cout << "Invalid score. Please enter a score between 0 and 10: ";
        cin >> score;
    }
    return score;
    }

//Function to calculate if val1 is less that or equal to val2
bool isLower(float val1, float val2) {
    return val1 <= val2;
    }

//Function to calculate if val1 is greater that or equal to val2
bool isHigher(float val1, float val2) {
    return val1 >= val2;
    }

//Function to calulate the average of three middle scores by removing min and max from total of all 5 scores
float calculateAverage(float total, float minScore, float maxScore) {
    return (total - minScore - maxScore) / 3;
    }

//Main function
int main() {
  float score, total = 0, minScore, maxScore;

  cout << "Welcome to the Star Search Scoring Calculator!\n";

  //Get first score
  score = getScore(1);
  total = score;
  minScore = score;
  maxScore = score;

  //Loop for judges 2-5
  for (int i = 2; i <= 5; i++) {
      score = getScore(i);
      total += score;

     if (isLower(score, minScore)) {
          minScore = score;
      }
      if (isHigher(score, maxScore)) {
          maxScore = score;
      }
    }
    //Calculate and display the average
    float average = calculateAverage(total, minScore, maxScore);
    cout << "The average score is: " << average << endl;
    return 0;
    }