pragma solidity ^0.5.0;

contract IskaContract {
    
    mapping(address => uint) kmStanden;

    function updateKmStand(uint n) public {
        address owner = msg.sender;

        require(kmStanden[owner] < n, "Je kan geen lagere km stand doorgeven");

        kmStanden[owner] = n;
    }

    function getKmStand() public view returns(uint) {
        return kmStanden[msg.sender];
    }
}