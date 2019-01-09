import React, { Component } from "react";
import Iska from "./DrizzleComp";
// import drizzle functions and contract artifact
import { Drizzle, generateStore } from "drizzle";
import IskaContract from "./IskaContract.json";

// let drizzle know what contracts we want
const options = { contracts: [IskaContract] };

// setup the drizzle store and drizzle
const drizzleStore = generateStore(options);
const drizzle = new Drizzle(options, drizzleStore);

class App extends Component {
  state = { loading: true, drizzleState: null };

  componentDidMount() {
    // subscribe to changes in the store
    this.unsubscribe = drizzle.store.subscribe(() => {
      // every time the store updates, grab the state from drizzle
      const drizzleState = drizzle.store.getState();

      // check to see if it's ready, if so, update local component state
      if (drizzleState.drizzleStatus.initialized) {
        this.setState({ loading: false, drizzleState });
      }
    });
  }

  componentWillUnmount() {
    this.unsubscribe();
  }

  render() {
    if (this.state.loading) return <p>Loading...</p>;
    return (
      <div class="container">
        <Iska drizzle={drizzle} drizzleState={this.state.drizzleState} />
      </div>
    );
  }
}

export default App;
