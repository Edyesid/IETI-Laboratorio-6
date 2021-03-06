# IETI Laboratorio 6

## Escuela Colombia de ingenieria Julio Garavito

## Edwin Yesid Rodriguez Maldonado

### Part 1: Task Planner API V1

1. Create a new Spring Boot project using the Spring Initializr (https://start.spring.io/). Include the *Spring Web* dependency.

2. Create a Plain Old Java Object (POJO) to map the model for a *User* of the Task Planner PWA.

3. Create an interface to define the contract of the *UserService* class. This service will handle all users' functionality:

[](img/interface.png)

4. Implement the UserService contract. For now, it is enough to have dummy implementations returning mock responses.

5. Configure your application so that you can inject the services implementations anywhere in your project. Use the annotations *@Service* and *@Autowired*. Check the official documentation and the following example as guidance:
https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html

6. Implement a REST controller named *UserController* to expose the services. Use the following resource as example:
https://spring.io/guides/tutorials/rest/

![](img/controller.png)

7. Inject the *UserService* on the controller and redirect the requests to the service.

8. Test your application locally: Use for example the __bootRun__ Gradle task to run the embedded server. Then try to reach your endpoints. 

### Part 2: Containerize and deploy your backend

1. Create a *dockerhub* account if you don't have one. Follow the steps here: https://docs.docker.com/docker-hub/

2. Read about docker. You can use the following quickstart guide: https://docs.docker.com/get-started/. Then, create a file named *Dockerfile* (without any extension) at the root folder of your java project. Add the following contents:

![](img/dockerfile.png)

3. Assemble your artifact and make sure that a jar file was generated under the *build/libs* folder.

    ```bash
        gradle build
    ```

4. Build the container image using the following command. Replace __<dockerhub_user>__ with your dockerhub user account. Don??t forget the period at the end of the command. It indicates the path where the Dockerfile and the image context can be found. Remember to run this command at the root level of the project.

    ```bash
    docker build -t <dockerhub_user>/ieti-backend .
    ```
	
	![](img/docker1.png)
	

5. Make sure you can run the container locally and it works as expected.

    ```bash
    docker run -p 8080:8080 <dockerhub_user>/ieti-backend
    ```
	
	![](img/docker2.png)

6. Push the image to the dockerhub registry:

    ```bash
    docker push <dockerhub_user>/ieti-backend
    ```
	
	![](img/docker3.png)

7. Deploy your container to Azure. Use the steps in the following guide but referencing the image you just created:
https://docs.microsoft.com/en-us/azure/container-instances/container-instances-quickstart-portal. Have in mind the port you are using for your app (default is 8080) and configur it in the networking section.

8. Check you can reach the endpoints through the FQDN. The URL should be similar to this: http://ieti-backend.eastus.azurecontainer.io:8080/

__Note:__ In case you don't have access to an Azure account, read the following tutorial to deploy containers to heroku:

https://devcenter.heroku.com/articles/container-registry-and-runtime

![](img/heroku1.png)
![](img/heroku2.png)
![](img/heroku3.png)
![](img/heroku4.png)
![](img/heroku5.png)
![](img/heroku6.png)

### Part 3: Consume the Task Planner API from a React JS App

1. Implement the lifecycle method *componentDidMount()* on a React component that displays the Users list. Inside the method use the function fetch to retrieve the User list from the API. For now, returning some sample data from the backend would be enough.
    ```javascript
    class App extends Component {
    
        constructor(props) {
            super(props);
            this.state = {
                userList: [],
            };
        }

        componentDidMount() {
            fetch('REPLACE-API-URL')
                .then(response => response.json())
                .then(data => {
                    let userList = [];
                    data.items.forEach(function (user) {
                        usersList.push({
                           //Implement this part
                        })
    
                    });
                    this.setState({userList: userList});
                });
        }

        render() {
            return (
                <div>
                    <!-- Implement a React compontent to render the list -->
                    <UserList usersList={this.state.usersList}/>
                </div>
            );
        }
    }

    export default App;
    ```

__TIP__ In order to test your application I recommend Firefox browser. You must install the following plugin to avoid CORS validation restriction:

 https://addons.mozilla.org/en-US/firefox/addon/cors-everywhere/
