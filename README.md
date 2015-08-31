Using etcd to increment the counter and perform load balancing

*******************************************************************
Requirement:

You need to use etcdÂ as distributed storage for the counter using this etcd Java library. 
Store the counter value in the etcd and increment and update the counter back to etcd whenever its GET API gets called.

You will be running two instances of the digital wallet service on one EC2 virtual machine using the same ports: xxxxÂ and xxxx. 
Both instances will be talking to a cluster of etcd and share the same key for the counter so that the counter data will be consistent across the two instances.
Last, create an ELB (elastic load balancer) in your EC2 environment and add the two instances to the ELB so that all incoming requests to the ELB hostname will get load-balanced between the two instances.
