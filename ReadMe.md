# API testing using RestAssured

## PreRequisite to run the tests

1. json-server (For more details please refer https://github.com/typicode/json-server)

    install json-server using npm:

        npm install -g json-server

2. db-people.json

    json file that contains test data of 100 people.

3. start json server using db-people json file

    go to the directory where db-people.json file is present

    run command:
    `json-server --watch db-people.json`

    Expected Output:
    ```
    \{^_^}/ hi!

      Loading db-people.json
      Done

      Resources
      http://localhost:3000/people

      Home
      http://localhost:3000
    ```

4. Launch Home (http://localhost:3000) for the supported HTTP method

5. Launch Resources (http://localhost:3000/people) for the resources.

## Tests are developed using RestAssured. Please import the project and run the tests.