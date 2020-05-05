## UI Automation www.saucedemo.com

For UI automation I used Selenium WebDriver and Cucumber with JUnit. 
I wrote feature files in Gherkin language. 
I used Page Object Model design pattern to design my package folder structure.
I used Maven as a build automation tool, it helps me store and manage all my dependencies in pom.xml file. 
For Assertions I used Junit.And to synchronize my code I used implicit wait from Selenium. 
Also created configuration properties where I get the essential data. 
For reporting I used Cucumber html report which is located in the target folder. 
It generates BDD report with all the Scenario steps. 
And also created utilities package where I stored Driver and Config class. 
For Driver class I used Singleton design pattern, 
just to  use one driver instance in the whole framework. 
Triggering point of my framework is Cukes runner class. 
I execute tests using @tags inside the runner Class.
Also used Hooks class for tearing down scenarios and if scenario fails it takes screenshots.

API Automation www.jsonplaceholder.typicode.com

For API Automation I also used Cucumber JUnit and with RestAssured library I automated it. 
It is in the same framework. It has pages, step-definitions and feature file. 
I created API model classes to do proper mapping. 
And also used Jackson library for serialization and deserialization. 
I performed get,post, update, delete methods. Asserted with Junit. 

As an IDE I used IntelliJ, and all my scenarios were passing last time I ran :)
