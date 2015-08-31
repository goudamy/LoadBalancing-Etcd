package hello

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request._
import org.springframework.context.annotation.Configuration
import java.net.URI
import com.justinsb.etcd.EtcdClient;
import com.justinsb.etcd.EtcdClientException;
import com.justinsb.etcd.EtcdResult;

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan
class HelloConfig {
var counter=0
var client = new EtcdClient(URI.create("http://172.31.0.230:4001"))

@RequestMapping(value = Array("/api/v1/counter"))
def etcd() : String = { 
  val key = "/009417148/counter"
  var result:EtcdResult = client.get(key)
  if (result == null)
 {
   counter=counter+1
   var counter1 = counter.toString
   result = this.client.set(key,counter1 )
 }
 else
 {
   var value1 = result.node.value
   counter=value1.toInt
   counter=counter+1
   var counter1 = counter.toString   
   result = this.client.set(key, counter1)
   
 }
 "Counter "+counter
}

}