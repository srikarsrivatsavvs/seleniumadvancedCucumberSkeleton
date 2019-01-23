Feature: login feature
Scenario: valid user will login
Given login url is of the demoshop 
When user enters <username> as username
And user enters <password> as password
And user clicks login
Then user is <result>

Examples:
|username|password|result|
|usjfkd@iasudj.com|ieujkffns|invalid|
