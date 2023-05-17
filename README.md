# JPP-Tech-assignment
This is the solution project of the assignment given in the first round of interview at JPP Tech for Java Developer position.

Requirement: To develop a spring boot project to take input as .csv file in which a company's employees details are present and convert it into an ID card as .pdf format for each of the employee.

To test the working of the code:
1. Clone the repo in your local system.
2. Import the project as "Existing Maven Projects".

![image](https://github.com/Shivam-Saini-SS/JPP-Tech-assignment/assets/76945575/8b6ea745-8ddd-4dc1-967b-bef83cce5117)

3. Select the project root directory where you have cloned the github repo.
4. Run the Main class as Java Application.

![image](https://github.com/Shivam-Saini-SS/JPP-Tech-assignment/assets/76945575/254226db-d62d-4680-8267-a9cf6fb251c1)

5. Use a tool like Postman or cURL to send a POST request to `http://localhost:8080/generateIdCards` with the `csvFilePath` parameter containing the path to your CSV file.

![image](https://github.com/Shivam-Saini-SS/JPP-Tech-assignment/assets/76945575/e73959fb-8372-48ea-b6d7-50aa008fe608)

6. Once "ID cards generated successfully." prompt is received, check the root directory for results.


![image](https://github.com/Shivam-Saini-SS/JPP-Tech-assignment/assets/76945575/b41d37e0-a09c-4bf1-8cd1-ab141c61ac26)

![image](https://github.com/Shivam-Saini-SS/JPP-Tech-assignment/assets/76945575/a82bccf6-3c7d-4899-9701-dfecc3782115)

Sample .csv file with employee details:

![image](https://github.com/Shivam-Saini-SS/JPP-Tech-assignment/assets/76945575/2f91ed72-b18e-4533-84b7-5ab34761cee8)

Here, in the column "E" the paths of the employee profile photos are given, which would be passed as a parameter in the service class of code (this can be modified as per need). For testing purpose, the required resources like .csv file and employee profile photos are already present in the resources folder of the source code.
