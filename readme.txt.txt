**************************************************************
*Alpharetta FBLA Desktop Application Programming 2013: Readme*
**************************************************************


//////////////////////////////////////////////////

Table of Contents:

//////////////////////////////////////////////////


System Requirements:

Design Overview:

Code Documentation:

User Manual:


//////////////////////////////////////////////////

System Requirements

//////////////////////////////////////////////////


Microsoft Windows Operating system XP, Vista, 7 or equivalent

Required programs: Java 6 required, .txt file editor (notepad or equivalent)

Disk Space: least 1mb of free Disk Space


//////////////////////////////////////////////////

Design Overview

//////////////////////////////////////////////////


This application was written in NetBeansIDE 7.2.1 using a Swing GUI.

It splits different functionality into seperate windows to simplify each window into easily understood segments

Only employers with knowledge of their employer ID can change the data, but any user can view and save reports

Employees can be viewed, evaluated, and reported through a simple and visual table interface

Employee, Employer, Evaluation, and FieldPlacement data are all stored in CSV text files


//////////////////////////////////////////////////

Code Documentation

//////////////////////////////////////////////////


Menu.java(Main window)


  public class Menu extends javax.swing.JFrame {
      //Central Menu for user

    public Menu() throws IOException {
            //initialize Swing and data

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          //Create a newEmployee Window
  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Create a newEmployer Window

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Create a EmployeeList

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Lets Employer Login to their profile

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Create new FindEmplyerID Window

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Create new Reports page

    public static void fileCreate() throws IOException
        //Create files and folders if the do not exist


EmployeeList.java  


  public class EmployeeList extends javax.swing.JFrame {
      //Displays all employees for a specified company

    public EmployeeList() throws IOException {
        //Create EmployeeList with no employer

    public EmployeeList(String employer) throws IOException {
        //Create EmployeeList with set Employer

    public void initEmployeeList(String employer) throws IOException
        //Set the EmployeeList's data to Employees of given Employer 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Creates Evaluation Form for selected Employee from Table

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Close EmpoyeeList

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Run report for selected Employee from table


EmployeeReport.java


  public class EmployeeReport extends javax.swing.JFrame {
      //Displays and saves report for individual employees  

    public EmployeeReport() {
        //Initialize data with no specified employee

    public EmployeeReport(Employee e) throws IOException {
        //initialize data with specified employee

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Display the employee's report

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Exit window
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Save employee report to folder for their company, and generate any missing folders


FindEmployerID.java


  public class FindEmployerID extends javax.swing.JFrame {
      //Allows user to find forgoten employer ID's

    public FindEmployerID() {
        //Initialize data

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Find Employer and display their ID

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Exit window


NewEmployee.java


  public class NewEmployee extends javax.swing.JFrame {
  	//Allows user to create new employees

    public NewEmployee() throws IOException {
        //Creates new Employee with no Employer

    public NewEmployee(String employerID) throws IOException {
        //Create new Employee with specified Employer

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Exit window

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Create new employee with specified data

    public static boolean conflict(String str, String Employer) throws IOException
        //Check all existing employees to see if employee of same name exists at company


NewEmployer.java


  public class NewEmployer extends javax.swing.JFrame {
	//Allows user to create new employer

    public NewEmployer() {
        //Initialize data

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Create new employer with given data

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Exit

    public static boolean conflict(String str) throws IOException
        //Check to make sure Employer does not already exist


Reports.java


  public class Reports extends javax.swing.JFrame {
	//Allows user to generate and save reports by employer, score, or overall

    public Reports() {
        //initialize Reports

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Convery displayed text into a text document, then open it

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Display employees grouped by Employer

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Display employees sorted by average score

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //display all employees
 
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Exit window

    public static String employeeReport(String employeeID) throws IOException
        //Generate a string that makes up an individual employee's report


EvaluationForm.java


  public class EvaluationForm extends javax.swing.JFrame {
    //allows user to evaluate employees based on 4 criteria and overall

    public EvaluationForm() throws IOException{
        //Initialize with nothing specified

    EvaluationForm(String string) throws IOException{
        //Initialize for specific Evaluation

    EvaluationForm(Employee emp, Employer empr) throws IOException{
        //Initialize for specified employee and employer

    x25 - private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //Scoring button

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Exit window
	
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Save Evaluation, if passes all data tests

    public void average()
        //Calculate the average from given ratings and display
 
 
Employee.java


  public class Employee {
  	//Employee

    Employee(String ID) throws IOException
        //Create employee with specified ID

    Employee(String ID, int index) throws IOException
        //Create employee with data that matches specified index
 
    Employee(String Name,String email,String phoneNumber,String cellNumber,String streetAddress,String city,String zipCode,String employer) throws IOException
        //Create a new employee with all data given

     public void save() throws IOException
        //Write employee's data to CSV file
   
     private String randID() throws IOException
        //Generate random ID that does not already exist

     private String newID()
        //Generate 6 digit ID number

     public String getData(int i)
        //return data at specified index


Employer.java


  public class Employer {
	//Employer

    Employer(String ID) throws IOException
        //Generate employer with specified ID
 
    Employer(String name,String address,String city,String state, String zipCode,String phoneNumber,String email,String contactPerson) throws IOException
        //Create employer with all data specified

    public void save() throws IOException
        //Write data to CSV files

    public String randID() throws IOException
        //Generate random unique ID

    private String newID()
        //Generate 6 digit ID

    public String getData(int i)
        //Return specified data index


Evaluation.java


  public class Evaluation {
	//Evaluation

    Evaluation(String ID) throws IOException
        //Create Evaluation with given ID number

    Evaluation(Employee emp, String empr) throws IOException
        //Create a new Evaluation with given Employee and Employer
    
    Evaluation(String ID, int num) throws IOException
        //Create new Evaluation based on given string at specified index
 
    public void save() throws IOException
        //Write in data for a new Evaluation

    public String getData(int i)
        //Returns data requested

    public Employee getEmployee() throws IOException
        //Return the empoyee that goes with the Evaluation

    public Employer getEmployer() throws IOException
        //Return the employer that goes with the Evaluation

    public void update(int k,int q,int h,int b,int o, boolean e, double a, String kc, String qc, String hc, String bc, String oc, String nd, String empID, String emprID) throws IOException
        //Update data for this evaluation(not yes written to CSV files)

    private String randID() throws IOException
        //Generate randomized ID that does not already exist (1,000,000 possible)

    private String newID()
        //Create a 6 digit ID number


FieldPlacement.java


  public class FieldPlacement {
	//Field Placement

    FieldPlacement() throws IOException
        //Create new FieldPlacement storing all fields

    FieldPlacement(String ID, int i) throws IOException
        //Create new FieldPlacement with either Employee or Employer given (0 or 1)

    FieldPlacement(String Employee, String Employer) throws IOException
        //Create and store new Field Placement with given values

    public void save() throws IOException
        //store fieldplacement in FPs.csv

    public String getData(int i, int j)
        //return data at requested index from all fieldsplacements
    
    public String getData(int i)
        //return data at requested index from most recent fieldplacement

    public Employer getEmployer(String str) throws IOException
        //Get employer from specified field placement

    public ArrayList<String[]> getFields()
        //return list of all Field placements


//////////////////////////////////////////////////

User Manual

//////////////////////////////////////////////////


Upon first use, the application will create two directories, one to store the CSV data files and one for Reports.
--Do not modify any files stored in the CSVFiles directory

To begin using the appplication, create a new Employer by filling out the requested fields.
You will be given an Employer ID number, which is used to login to each Employer's profile.
--If you forget an Employer's ID, you can use the Find ID window by typing in the Employer's name

Once you are logged in as an Employer, you can create new Employees by using the New Employee button 
and filling out the requested information

To Evaluate Employees and get their individual Employee Reports, click the Employee List button.
This will open a new window with a table containing all of your employees, their ID number, name, average score, next date, and recommendations

To Evaluate an Employee, select the row they are in and click the Evaluate button.
This will open a new window containing 5 sets of 5 buttons, one set for each of 5 evaluation criteria.
You will also be able to comment on each of the 5 criteria by writing in the text boxes below the buttons.
You must set the next Evaluation date by changing the "next date" field to your desired next evaluation date.
--if not changed, you will be prompted to set a next date before you can save
To save an Evaluation, click the Save button.
Upon saving, you will be prompted if you want to Recommend or Reject this employee for employment. 
Click the button that coresponds to your desired choice, or cancel to continue evaluationg 

To run a report for an individual employee, Click Employee List, then select the desired Employee from the list.
Click report to go to the Employee Report window.
--An employee must have been evaluated to have a report.
In the Employee Report window, you can either Display or Save the report.
Displaying the report shows your employee's data from their Evaluation.
Saving the report will store their Evaluation data in a .txt file, in the EvaluatuonReport\EmployeeReport\ folder, under the name of the company the Employee works for
It will then open the file for ease of reading, printing, or other manipulations.

To run a report for all Employees, go back to the main menu, and click the Reports button
This will open a window with options "Employer", "Score", "Employee", and "Save"
Employer will generate and display a report for all employees, grouped by their employer
Score will generate and display a report for all employees with Evaluations, sorted from highest to lowest
Employee will generate and display a report for all employees
Save will take the current displayed report type, and save is as "Report" plus the report type in the EvaluationReport folder.
Save will also open the saved file for ease of reading, printing, or other manipulations.
--Save will overwrite any previous reports of that type stored in EvaluationReport.


