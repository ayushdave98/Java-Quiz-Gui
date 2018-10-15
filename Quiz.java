//Import the necessary classes for the code
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Name of Program: The viral quiz
 * Description:
 * This program allows the user to read a passage about viruses, and then take it a quiz about it. The program will have possible answers for each question, but also
 * hint buttons and "Remove 2 answers" buttons which will either give the user a hint or remove 2 of the wrong answers. If the user gets the question wrong, the program
 * will tell them the correct answer. At the end of the quiz, the program will determine and display a percent score.
 * Name: Ayush Dave 
 * 
 */
public class Quiz
{
    public static void main (String Args[])
    {
        //Prevents Joptionpane from displaying a blank window 
        SwingUtilities.invokeLater(new Runnable()   
            {
                public void run()
                {
                    //Creates an exception if the array is out of bounds so that, the program will not crash
                    try
                    {
                        virus();    //Contains the main menu with options for the user
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("You quit the program, Please start the program again");    //Contains the main menu with options for the user
                    }
                }
            });
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void virus()  //Contains the main menu with the options for the user
    {
        String[] choice = new String[] {"Read Passage", "Proceed to Quiz","Exit The Program"}; //String array which will be used as buttons
        //Creates a option menu that allows user to read the passage, proceed straight to the quiz or exit the program
        int c=JOptionPane.showOptionDialog(null, "Would you like to read the passage or start the quiz.", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, choice, choice[0]);
        if(choice[c]=="Read Passage")   //If the user clicks the "Read Passage" button
        {
            passage();  //The program will call the passage() method, and display the passage
        }
        else if(choice[c]=="Exit The Program")  //If the user clicks "Exit the Progam" button
        {
            System.exit(0); //The program will end
        }
        else 
        {
            gui();  //If the user clicks any other button (Proceed to Quiz), then the program will display the quiz questions one by one
        }
    }

    public static void passage()    //Method that contains the passage about viruses and a button to proceed to quiz
    {
        String[] passage = new String[] {"Proceed to Quiz"};    //Creates a string array which will be used as a button to proceed to the quiz
        //Creates a menu that contains a formated passage about viruses
        int p=JOptionPane.showOptionDialog(null, "<html><br>Viruses are unique replicating computer programs. Examples of viruses include Macros, Trojan Horses and Worms They can be spread through many mediums such as the internet and email attachments.<br> There is a great history behind viruses, John Von Neumann was the first person to create instructions to building a virus, He credited with the Theory of Automata.<br> In later years there were many tests done to create a virus to see it's effects, In 1959 a game called Core Wars was created to for testing what happens to a computer with a virus.<br> Viruses can be created to attack a variety of things, for example a virus called 'Brain' was the first virus to attack MS-DOS.<br> Another example of a virus attacking a different thing, is the Morris Worm which exploited weak passwords.<br> Viruses currently have many applications, They currently have the ability to steal private information, take control of a computer and even destroy it. <br>In the future, Viruses are expected to attack more than just computers, they are expected to attack cell phones and voice over ip phones (VOIP).<br> Currently in Canada, you cannot be charged for creating a virus, but if you spread it, you can be charged for mischief.</html> ", "Passage", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, passage, passage[0]);
        if(passage[p]=="Proceed to Quiz")   //If the user clicks the "Proceed to Quiz" button
        {
            try
            {
                gui();  
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.print("You quit the Program, Please start the program again");
            }
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void gui()    //Method that contains the quiz questions and answers, and will display the percent score after the quiz
    {
        int questions=0;    //Set an integer variable that will count the number of questions to 0
        double score=0;     //Set an decimal variable that will count the number of correct questions to 0
        //Asks the user the 1st question
        String[] question1 = new String[] {"Trojan Virus", "Worm", "Macro", "Macafee", "Remove 2 Wrong Answers"};   //Create a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers, and a Remove 2 Wrong Answers button
        int q1=JOptionPane.showOptionDialog(null, "Which of these is not a virus", "Question 1", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question1, question1[0]);
        if(question1[q1]=="Macafee")    //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question1[q1]=="Remove 2 Wrong Answers")    //If the user clicks the "Remove 2 answers" button
        {
            //2 of the wrong answers in the original array will be removed
            String[] questionHint1 = new String[] {"Macro", "Macafee"}; //The string array will now contain 2 buttons with the 2 possible answers 
            //Creates a window with the question again, but will only contain 2 buttons giving the user a better chance of getting the correct answer
            int qh1=JOptionPane.showOptionDialog(null, "Which of these is not a virus", "Question 1", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint1, questionHint1[0]);
            if(questionHint1[qh1]=="Macafee")   //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks the anything other than the correct answer
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was Macafee");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Remove 2 Wrong Answers"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was Macafee");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 2nd question
        String[] question2 = new String[] {"True", "False", "Hint"};    //Create a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers, and a hint button
        int q2=JOptionPane.showOptionDialog(null, "Viruses can be spread through email attachments", "Question 2", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question2, question2[0]);
        if(question2[q2]=="True")   //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question2[q2]=="Hint")  //If the user clicks the "Hint" button
        {
            JOptionPane.showMessageDialog(null,"My friend emailed me a virus once. it crashed my computer");   //Creates a window displaying the hint
            String[] questionHint2 = new String[] {"True", "False"}; //Create a string array with buttons as possible answers   
            //Creates a window that contains the question again and buttons used for possible answers
            int qh2=JOptionPane.showOptionDialog(null, "Viruses can be spread through email attachments", "Question 2", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint2, questionHint2[0]);
            if(questionHint2[qh2]=="True")  //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks the anything other than the correct answer
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was True");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "hint"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was True");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 3rd question
        String[] question3 = new String[] {"Bill Gates", "Steve Jobs", "John Von Neumann", "Mark zuckerberg","Hint"}; //Create a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers, and a hint button
        int q3=JOptionPane.showOptionDialog(null, "Who created the theory or automata?", "Question 3", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question3, question3[0]);
        if(question3[q3]=="John Von Neumann")   //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question3[q3]=="Hint")  //If the user clicks the "Hint" button
        {
            JOptionPane.showMessageDialog(null,"The answer is not any of the CEOs");    //Creates a window displaying the hint
            String[] questionHint3 = new String[] {"Bill Gates", "Steve Jobs", "John Von Neumann", "Mark zuckerberg"};  //Create a string array with buttons as possible answers
            //Creates a window that contains the question and buttons used for possible answers
            int qh3=JOptionPane.showOptionDialog(null, "Who created the theory or automata?", "Question 3", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint3, questionHint3[0]);
            if(questionHint3[qh3]=="John Von Neumann")  //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks the anything other than the correct answer
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was John Von Neumann");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "hint"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was John Von Neumann");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 4th question
        String[] question4 = new String[] {"Minesweeper", "Core Wars", "Ram Game", "Battleship", "Remove 2 Answers"};   //Create a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers, and a Remove 2 Wrong Answers button
        int q4=JOptionPane.showOptionDialog(null, "What game did programmers create in 1959 for testing purposes?", "Question 4", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question4, question4[0]);
        if(question4[q4]=="Core Wars")  //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question4[q4]=="Remove 2 Answers")  //If the user clicks the "Remove 2 Answers" button
        {
            String[] questionHint4 = new String[] {"Core Wars", "Ram Game"};    //Create a string array with buttons as possible answers
            //Creates a window with the question again, but will only contain 2 buttons giving the user a better chance of getting the correct answer
            int qh4=JOptionPane.showOptionDialog(null, "What game did programmers create in 1959 for testing purposes?", "Question 4", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint4, questionHint4[0]);
            if(questionHint4[qh4]=="Core Wars") //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks any button other than the correct answer
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was Core Wars");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Remove 2 Answers"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer was Core Wars");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 5th question
        String[] question5 = new String[] {"Viren", "Spam", "Coresweeper", "Brain", "Hint"};     //Create a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers, and a Hint button
        int q5=JOptionPane.showOptionDialog(null, "Which virus was the first virus created to attack MS-DOS", "Question 5", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question5, question5[0]);
        if(question5[q5]=="Brain")  //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");   //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question5[q5]=="Hint")  //If the user clicks the "Hint" button
        {
            JOptionPane.showMessageDialog(null,"Its an organ in your body");    //Creates a window displaying the hint
            String[] questionHint5 = new String[] {"Viren", "Spam", "Coresweeper", "Brain"};    //Create a string array with buttons as possible answers
            //Creates a window that contains the question and buttons used for possible answers
            int qh5=JOptionPane.showOptionDialog(null, "Which virus was the first virus created to attack MS-DOS", "Question 5", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint5, questionHint5[0]);
            if(questionHint5[qh5]=="Brain") //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks any button other than the correct answer 
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is Brain");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "hint"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is Brain");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 6th question
        String[] question6 = new String[] {"Morris Worm", "Morris horse", "Morris Macro", "Morris Spam", "Remove 2 Answers"};   //Create a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers and a "Remove 2 Answers" button
        int q6=JOptionPane.showOptionDialog(null, "Which of these viruses exploited weak passwords", "Question 6", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question6, question6[0]);
        if(question6[q6]=="Morris Worm")    //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;       //The questions varaible will increment by itself +1
        }
        else if(question6[q6]=="Remove 2 Answers")  //If the user clicks the "Remove 2 Answers" button
        {
            String[] questionHint6 = new String[] {"Morris Worm", "Morris horse"}; //Creates a string array with buttons as possible answers
            //Creates a window with the question again, but will only contain 2 buttons giving the user a better chance of getting the correct answer
            int qh6=JOptionPane.showOptionDialog(null, "Which of these viruses exploited weak passwords", "Question 6", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint6, questionHint6[0]);
            if(questionHint6[qh6]=="Morris Worm")   //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks any button other than the correct answer 
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is Morris Worm");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Remove 2 Answers"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is Morris Worm");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 7th question
        String[] question7 = new String[] {"Destroy a computer", "Steal private information", "Take control of a computer", "All of the Above", "Hint"};    //Creates a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers and a "Hint" button
        int q7=JOptionPane.showOptionDialog(null, "What can a virus do?", "Question 7", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question7, question7[0]);
        if(question7[q7]=="All of the Above")   //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question7[q7]=="Hint")  //If the user clicks the "Hint" Button
        {
            JOptionPane.showMessageDialog(null,"They are all correct"); //Creates a window displaying the hint
            String[] questionHint7 = new String[] {"Destroy a computer", "Steal private information", "Take control of a computer", "All of the Above"};    //Creates a string array with buttons as possible answers
            int qh7=JOptionPane.showOptionDialog(null, "What can a virus do?", "Question 7", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint7, questionHint7[0]);;
            if(questionHint7[qh7]=="All of the Above")  //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks any button other than the correct answer 
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is 'All of the Above'");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Hint"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is 'All of the Above'");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 8th question
        String[] question8 = new String[] {"Cell Phones", "Gaming Systems", "Cordless Phones", "Laptops","Remove 2 Answers"};    //Creates a string array with buttons as possible answers
        //Creates a window that contains the question and buttons used for possible answers and a "Remove 2 Answers" button
        int q8=JOptionPane.showOptionDialog(null, "Which of the following is a viruses expected to attack in the future", "Question 8", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question8, question8[0]);
        if(question8[q8]=="Cell Phones")    //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question8[q8]=="Remove 2 Answers")  //If the user clicks the "Remove 2 Answers" button
        {
            String[] questionHint8 = new String[] {"Cell Phones", "Gaming Systems"};    //Creates a string array with buttons as possible answers
            //Creates a window with the question again, but will only contain 2 buttons giving the user a better chance of getting the correct answer
            int qh8=JOptionPane.showOptionDialog(null, "Which of the following is a viruses expected to attack in the future", "Question 8", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint8, questionHint8[0]);
            if(questionHint8[qh8]=="Cell Phones")   //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else     //If the user clicks any button other than the correct answer 
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is Cell Phones");
                questions++;     //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Remove 2 Answers"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is Cell Phones");
            questions++;     //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 9th question
        String[] question9 = new String[] {"True", "False","Hint"};     //Create a string array with possible answers
        //Creates a window that contains the question and buttons used for possible answers and a "Hint" button
        int q9=JOptionPane.showOptionDialog(null, "In Canada, you can be charged for creating a virus", "Question 9", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question9, question9[0]);
        if(question9[q9]=="False")  //If the user clicks the correct answer
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question9[q9]=="Hint")  //If the user clicks the "Hint"
        {
            JOptionPane.showMessageDialog(null,"I can create a virus and the cops can't do anything about it");     //Creates a window displaying the hint
            String[] questionHint9 = new String[] {"True", "False"};    //Create a string array with possible answers
            //Creates a window that contains the question and buttons used for possible answers 
            int qh9=JOptionPane.showOptionDialog(null, "In Canada, you can be charged for creating a virus", "Question 9", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint9, questionHint9[0]);
            if(questionHint9[qh9]=="False") //If the user clicks the correct answer
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;    //The questions varaible will increment by itself +1
            }
            else    //If the user clicks any button other than the correct answer 
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The Correct Answer is False");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Hint"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The Correct Answer is False");
            questions++;    //The questions varaible will increment by itself +1
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Asks the user the 10th question
        String[] question10 = new String[] {"Yes", "No","Hint"};    //Create a string array with possible answers
        //Creates a window that contains the question and buttons used for possible answers and a "Hint" button
        int q10=JOptionPane.showOptionDialog(null, "In Canada, Can you be charged for spreading a virus?", "Question 10", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                null, question10, question10[0]);
        if(question10[q10]=="Yes")  //If the user clicks the correct answers
        {
            JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
            score++;    //The score varaible will increment by itself +1
            questions++;    //The questions varaible will increment by itself +1
        }
        else if(question10[q10]=="Hint")    //If the user clicks the "Hint"
        {
            JOptionPane.showMessageDialog(null,"I wouldn't send a virus to anyone because I dont want to get in big trouble");  //Creates a window displaying the hint
            String[] questionHint10 = new String[] {"Yes", "No"}; //Creates a string array with possible answers
            //Creates a window that contains the question and buttons used for possible answers 
            int qh10=JOptionPane.showOptionDialog(null, "In Canada, Can you be charged for spreading a virus?", "Question 10", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,      
                    null, questionHint10, questionHint10[0]);
            if(questionHint10[qh10]=="Yes") //If the user clicks the correct answers
            {
                JOptionPane.showMessageDialog(null,"Correct");  //The program will display a dialog box saying "Correct"
                score++;    //The score varaible will increment by itself +1
                questions++;   //The questions varaible will increment by itself +1
            }
            else    //If the user clicks any button other than the correct answer 
            {
                //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
                JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is 'Yes'");
                questions++;    //The questions varaible will increment by itself +1
            }
        }
        else    //If the user clicks any button other than the correct answer or "Hint"
        {
            //The program will display a dialog box informing them that the answer is incorrect and will tell them the correct answer
            JOptionPane.showMessageDialog(null,"Incorrect, The correct answer is 'Yes'");
            questions++;    //The questions varaible will increment by itself +1
        }
        //This block of code will determine how many answers are correct and give a percent score
        if(questions==10)   //If the number of questions answered is equal to 10
        {
            //Print out their percent score and score out of 10
            JOptionPane.showMessageDialog(null,"Your got " + score + " out of 10 questions correct");
            double percent=(score/10)*100;
            JOptionPane.showMessageDialog(null,"Your  percent score is " + percent + "%");
            virus();
        }
    }
}

