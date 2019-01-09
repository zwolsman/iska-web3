var IskaContract = artifacts.require("./IskaContract.sol");

module.exports = function(deployer) {
  deployer.deploy(IskaContract);
};
