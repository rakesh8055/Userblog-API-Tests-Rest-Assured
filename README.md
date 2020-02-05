# Userblog-API-Tests-Rest-Assured

Given Test Scenario to Automate:
1) Search for the user.
2) Use the details fetched to make a search for the posts written by the user.
3) For each post, fetch the comments and validate if the emails in the comment
   section are in the proper format.
4) Think of various scenarios for the test workflow, all the things that can go wrong.
5) Upload your test to Github
6) Execute the tests successfully on Circle CI.

Validations & Approach:

- Tried to maintain abstraction while creating each testcase.
- Used Data Provider for injecting data into testcase.
- For Each GET response Content type, Status Code & Response Time(5 seconds) is validated
- Json schema is validated for '/users', '/posts', '/comments'
- Email format validated using regex - ^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$
- Report NG configured to get intuitive reports.
    reports are in 'target/surefire-reports/html/index.html'   