package com.ranga.Logger;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main(String args[]) throws IOException{

        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));

        LOGGER.info("What operation you want to preform.......\n");

        LOGGER.info("1.Interest Calculation\n2.Construction cost Estimation\nEnter your option : ");

        int op = Integer.parseInt(brin.readLine());

        if(op == 1){

            InterestCalculate i = new InterestCalculate();

            double interest = 0;

            LOGGER.info("\n1.Simple Interest\n2.Compond Interest\nEnter your option : ");

            int typeofInterest = Integer.parseInt(brin.readLine());

            double principal,rateofInterest,time,noOfTimesPerYear;

            LOGGER.info("\nEnter Principal Amount : ");

            principal = Double.parseDouble(brin.readLine());

            LOGGER.info("\nEnter Rate of Interest : ");

            rateofInterest = Double.parseDouble(brin.readLine());

            LOGGER.info("\nEnter Time period : ");

            time = Double.parseDouble(brin.readLine());

            if(typeofInterest == 2){

                LOGGER.info("\nEnter number of times interest to be calculated : ");

                noOfTimesPerYear = Double.parseDouble(brin.readLine());

                interest = i.compoundInterest(principal,time,rateofInterest,noOfTimesPerYear);

            }

            else {

                interest = i.simpleInterest(principal,time,rateofInterest);

            }

            LOGGER.info("\nTotal Interest : " + interest+" INR.\n");

            LOGGER.info("Total Amount : " + (principal+interest) + " INR.\n");

        }

        else{

            Estimate est = new Estimate();

            LOGGER.info("Enter the Area of the House : ");

            double area = Double.parseDouble(brin.readLine());

            LOGGER.info("\nMaterial Standards - Cost per Square Feet \n1.Normal Standard - 1200INR\n2.Above Standard - 1500INR\n3.High Standard - 1800INR\n4.High Standard with fully Automated - 2500INR\n");

            LOGGER.info("\nEnter  your option : ");

            int standard = Integer.parseInt(brin.readLine());



            LOGGER.info("Do you want Fully Automated home?(y/n)");

            String str = brin.readLine();

            boolean fullyautomated = false;

            if(str.charAt(0) == 'y')

                fullyautomated = true;

            double estimatedcost = est.estimateHouse(area, standard, fullyautomated);

            LOGGER.info("Estimated cost for Construction is "+estimatedcost + " INR\n");

        }

        brin.close();

    }

}