/*
 * [CareersQuiz.java]
 * A multiple-choice quiz that tests a user's understanding of several computing careers
 * Author: Matthew Sekirin
 * February 28th, 2019
 */

import java.util.Scanner;

class CareersQuiz {
  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    // Instructions at beginning of quiz
    System.out.println("Welcome to the Computing Careers Quiz!" + 
                       "\nYou will be asked ten multiple choice questions with four possible answers each. " + 
                       "Every question has only one correct answer.\nAfter reading a question and the options " +
                       "you have for answering it, type the letter that corresponds to the choice " + 
                       "you would like to pick (i.e. a, b, c or d)" + 
                       "\nAfter some questions, you may choose to see a detailed explanation of the answer." +
                       "\nAt the end of the quiz, you will be given a chance to play again. Press ENTER to continue");
    input.nextLine();
    
    // Before starting the quiz, get the user's name, prompting for it again if it is not made up of letters and spaces
    System.out.println("Let's begin!\n Please enter your name: ");
    int len;
    boolean valid;
    String name;
    char ch;
    do {
      valid = true;
      name = input.nextLine();
      len = name.length();
      for (int i = 0; i < len; i++) {
        ch = name.charAt(i);
        if (!(Character.isLetter(ch) || (ch == ' '))) {
          valid = false;
        }
      }
      if (!valid) {
        System.out.println("Please enter a valid name");
      }
    } while (!valid);
    
    // Initiate arrays containing quiz answers, questions, choices, and reasonings behind the right answer
    String[] answers = {"c", "a", "d", "b", "b", "d", "b", "b", "c", "b"};
    String[] questions = {"Which of the following is NOT a typical responsibility of a Bioinformatics Database Developer?",
      "What is the primary duty of a Computer Network Architect?",
      "Which of the following best describes an important similarity between a Clinical Informatics Specialist " + 
        "and a Bioinformatics Developer?", 
      "Which of the following is NOT a main type of Computer Systems Analysts? The descriptions are provided as clues.",
      "The average salaries of a Computer Network Architect and Information Security Analyst are: ",
      "Which of the following is true about a GIS Developer: ",
      "This career often requires a Master’s Degree in Computer Science (or something similar), " + 
        "strong mathematics skills, especially in areas such as point cloud processing, 3D modeling and advanced " + 
        "interactive algorithms, and good programing skills in computer graphics and GPU programming: ",
      "The two largest employers (#1, #2) of Information Security Analysts in the US (and likely in Canada) are... ",
      "Which of the following statement regarding the possible impacts of signal processing " + 
        "(and therefore a signal processing engineer) are true and benefit society as a whole?" +
        "\nI. In health care, allowing the analysis and deciphering of medical images such as X-rays, MRIs and CT scans" +
        "\nII. Allowing for the expansion of computing power and data storing capabilities" +
        "\nIII. In finance, allowing messages to be sent financial data to be interpreted in new ways, " + 
        "which can aid in making decisions in the stock market" + 
        "\nIV. Allowing practically all consumer electronics such as " + 
        "smartphones, wearable devices and digital home assistants to function properly and optimally",
      "A job offer at Instagram and Interaptix Augmented Reality (the latter deals with virtual reality) are both " + 
        "looking for a specific professional. What is most likely the name of the position " + 
        "that they are trying to fill, considering the nature of these two companies?"};
    String[][] choices = {
      {"Developing and implementing new database structures and interfaces related to next-generation sequencing",
        "Updating data from external databases", "Independently developing, testing, and supporting web-based solutions " +
        "for processing and analyzing scientific data that will be made available to the public", 
        "Coordinating the input of researchers and personally adding additional data into the database"},
      {"Planning and designing data communications networks such as LANs, WANs, and intranets", 
        "Managing, supporting, building and repairing data communications networks such as LANs, WANs, and intranets",
        "Researching new networking technologies for the future benefit of their organization",
        "Adjusting a businesses’ networking strategy in compliance with its technological needs and entrepreneurial goals"},
      {"They both deal with building user interfaces and teaching individuals, especially staff, to use them properly", 
        "They must both know a lot of vocabulary about large information systems and customer relation databases", 
        "They both analyze and recommend enhancements to clinical processes to ensure an optimal level of patient care",
        "They both allow the transition between data such as paper records into computer systems to be made " +
        "more easily and meaningfully"},
      {"Systems designers/architects - Find technical solutions that satisfy a company’s/organization's " + 
        "requirements and long-term goals", "Embedded systems technician - Improving existing components such as " + 
        "printed circuit boards by testing them", "Software quality assurance analysts - Test, diagnose and document " +
        "problems in computer systems as part of the software development process", 
        "Programmer analysts - Write code for software they designed that meets their employers' or clients' needs"}, 
      {"In Canada, $68 000 and $88 000 (CAD) respectively, in the US—$86 000 and $96 000 (USD)",
        "In Canada, $88 000 and $68 000 (CAD) respectively, in the US—$86 000 and $96 000 (USD)",
        "In Canada, $86 000 and $96 000 (CAD) respectively, in the US—$68 000 and $88 000 (USD)",
        "In Canada, $68 000 and $88 000 (CAD) respectively, in the US—$96 000 and $68 000 (USD)"},
      {"The opportunities for this career are growing now more than ever, and the competition is overall " +
        "becoming more intense", "It is very difficult to switch career paths once a GIS Developer " + 
        "since it is difficult to find a career related to geographical knowledge", 
        "There are not many prospects in natural resource management and environmental initiatives because this is " + 
        "primarily the work of conservation scientists and foresters", "Urban and regional planning has a lot of " + 
        "opportunity for growth because of the importance of urban development and land use at all government levels"},
      {"Digital Signal Processing Engineer", "Computer Vision Engineer", "Graphic Designer", "3D Animator"},
      {"Management of Companies and Enterprises, Information", "Computer systems design and related services, " + 
        "Finance and Insurance", "Finance and Insurance, Administrative and Support Services", 
        "Management of companies and enterprises, Computer systems design and related services"},
      {"Only IV", "I and III only", "I, II and IV", "All of the above"},
      {"Digital Signal Processing Engineer", "Computer Vision Engineer", "Computer Network Architect", 
        "Computer Systems Analyst"},
    };
    String[] soln = {"A bioinformatics database developer is not as much concerned with the internet and " +
        "getting information across to the masses independently as closely working with a team of software/database " + 
        "developers and biology researchers, usually in a major study.", 
      "b) is the description of Network Administrators and Engineers, c) is not a main responsibility, and d) is completely unrelated", 
      "a) and c) are not responsibilities of a Bioinformatics Developer, and d) is not the most important similarity",
      "While embedded systems may be part of what a computer systems analyst does, b) is much too specific " + 
        "and doesn’t make much sense (improving something by testing it?). This job title doesn’t exist. " + 
        "Also, something in this area would be more like something an Electrical Technician would do.", "",
      "In the US, the government sector was the largest source of revenue for GIS businesses in 2017. " +
        "As regarding a), this career is arguably not as prestigious as it used to be because of new software " +
        "that does a large part of the job for you, lowering educational standards and salary. " +
        "b) is incorrect because a GIS developer usually has a lot of transferable data science skills, " + 
        "and so is c) since the professionals mentioned rely on GIS technology to " + 
        "do many things like map forests and identify shifts in land use.", "",
      "All the choices present key employers of information security analysts, but the two largest of 100 000 jobs " +
       "in 2016 were “Computer systems design and related services” at 28% and “Finance and Insurance” at 19%",
      "III is an impact of signal processing, but is simply a tool for individuals and businesses to make more money.\n" + 
        "Some cool links that help explain the other options:\n" + 
        "https://signalprocessingsociety.org/publications-resources/blog/automation-coming-research\n" + 
        "https://www.youtube.com/watch?v=_BjoMt5o4jk\n" + "https://www.youtube.com/watch?v=rFNjg63j4Lo\n",
      "The most correct answer is a computer vision engineer, who is skilled in 3D reconstruction, " +
       "object/image detection and recognition which are essential in dealing with images and videos " + 
       "that social media deals with as well as in virtual reality, which is essentially a three dimensional simulation."};  

    // The actual quiz
    String usrAns;
    String seeCorrect;
    String again;
    int score;
    do {
      score = 0;
      for (int i = 0; i < 10; i++) {
        // Output the questions and choices
        System.out.println("\n" + (i + 1) + ". " + questions[i]);
        System.out.println("a) " + choices[i][0] + "\nb) " + choices[i][1] + "\nc) " + choices[i][2] + "\nd) " + choices[i][3]);
        // Get the user's answer, prompting for it again if it is not valid (not a, b, c or d)
        do {
          valid = true;
          usrAns = input.next();
          valid = (usrAns.equals("a")) || (usrAns.equals("b")) || (usrAns.equals("c")) || (usrAns.equals("d"));
          if (!valid) {
            System.out.println("Please enter a valid answer (a, b, c, or d): ");
          }
        } while (!valid);
          
        // Tell the user if their answer was correct and provide them with a chance to see the right answer
        if (usrAns.equals(answers[i])) {
          System.out.println("Congratulations, " + name + "! You entered " + usrAns + ", the correct answer");
          score++;
        } else {
          System.out.println("Nice try, " + name + ". Would you like to see the right answer " + 
                             "and the reasoning behind it, if applicable? (y/n): ");
          do {
            seeCorrect = input.next();
            input.nextLine(); // avoid nextLineBlues
          } while (!((seeCorrect.equals("y")) || (seeCorrect.equals("n"))));
          
          if (seeCorrect.equals("y")) {
            System.out.println("The correct answer is " + answers[i] + ". " + soln[i]);
            System.out.println("Press ENTER to continue: ");
            input.nextLine();
          }
        }
      }
      
      // Output the score and provide the user with a chance to re-take the quiz
      System.out.println("");
      System.out.println("Thank you for taking the quiz. Your score is " + score + " out of 10.\n" +
                         "Would you like to play again? (y/n): ");
      do {
        again = input.next();
      } while (!((again.equals("y")) || (again.equals("n"))));
    } while (again.equals("y"));
    
    System.out.println("\nGreat effort, " + name + ". Hopefully you learned something."); // final message
    
    input.close();
  }
}