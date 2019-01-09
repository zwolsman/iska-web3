import React, { Component } from "react";

class DrizzleComp extends Component {
  state = { kms: 0, addr: "unkown" };

  contract = {};
  componentDidMount() {
    const { drizzle, drizzleState } = this.props;

    const { IskaContract } = drizzle.contracts;
    this.contract = IskaContract;

    const addr = drizzleState.accounts[0];

    const dataKey = IskaContract.methods.getKmStand.cacheCall();
    this.setState({ dataKey, addr });
  }
  render() {
    const { IskaContract } = this.props.drizzleState.contracts;

    // using the saved `dataKey`, get the variable we're interested in
    const kms = IskaContract.getKmStand[this.state.dataKey];

    return (
      <div>
        <h1>Hello there</h1>
        <p>
          You are logged in as <code>{this.state.addr}</code>
        </p>
        <p>Saved kms: {kms && kms.value}</p>
        <hr />

        <div class="row">
          <label for="newkm">Enter new km</label>
          <input
            id="newkm"
            type="number"
            value={this.state.kms}
            onChange={this.numberChange}
          />
          <input
            style={{ marginLeft: 16 }}
            class="button-primary"
            type="submit"
            value="Save"
            onClick={this.saveKms}
          />
        </div>
      </div>
    );
  }

  numberChange = event => {
    const { value } = event.target;
    this.setState({ kms: value });
  };

  saveKms = () => {
    const newKms = this.state.kms;
    const method = this.contract.methods.updateKmStand(newKms);
    console.log(method);

    method.send().then(result => console.log(result));
  };
}

export default DrizzleComp;
