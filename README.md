# -BSF-Home-Assignment

the framework is developed using below tools and technology 
1. java(java 11 or higher ) 
2. selenium 
3. cucumber 
4. junit
5. maven

Run test:
How to import Project 

1. clone project 
2. in eclipse click on file menu
3. select import option 
4. select existing maven project 
5. provide project path and click on finish 


1.To run test with eclipse
Need to install below eclipse plugin
1. cucumber eclipse plugin
2. in project go to runner package 
3. open testRunner.java
4. right click on file and select run with >> Junit test


to run from command line 
precondition: 
1. maven should be install on your machine 
2. maven class path should be configured 

how to run form command line 
1. on project root level double click on RunAssigment.bat file 

           or 
           
1. open terminal at POM.xml level and execute command mvn -Dtest=TestRunner -e test


Report is generated at below path 
1. Project target>>cucumber-reports(open report in chrome or Firefox browser )
2. for fail test screen shot is captured and to see screen shot click on Screenshot link 






