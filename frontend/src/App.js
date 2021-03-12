import React from 'react';

class App extends React.Component {

  render() {
      return (
          <div>
              <button onClick={this.componentDidMount}>
                presiona
              </button>
          </div>
      );
  }
  componentDidMount() {
      fetch("https://quiet-harbor-67565.herokuapp.com/users", 
      {method: "GET",
         headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => response.text())
        .then(data => {          
          console.log(data);
        })
  }
}

export default App;
