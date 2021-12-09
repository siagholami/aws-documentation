# Listener configurations for Classic Load Balancers<a name="using-elb-listenerconfig-quickref"></a>

The following tables summarizes the listener settings that you can use to configure your Classic Load Balancers\.


**HTTP/HTTPS load balancer**  

| Use case | Front\-end protocol | Front\-end options | Back\-end protocol | Back\-end options | Notes | 
| --- | --- | --- | --- | --- | --- | 
| Basic HTTP load balancer | HTTP | NA | HTTP | NA |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/using-elb-listenerconfig-quickref.html)  | 
| Secure website or application using Elastic Load Balancing to offload SSL decryption | HTTPS | [SSL negotiation](elb-ssl-security-policy.md) | HTTP | NA |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/using-elb-listenerconfig-quickref.html)  | 
| Secure website or application using end\-to\-end encryption | HTTPS | [SSL negotiation](elb-ssl-security-policy.md) | HTTPS | Back\-end authentication |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/using-elb-listenerconfig-quickref.html)  | 


**TCP/SSL load balancer**  

| Use case | Front\-end protocol | Front\-end options | Back\-end protocol | Back\-end options | Notes | 
| --- | --- | --- | --- | --- | --- | 
| Basic TCP load balancer | TCP | NA | TCP | NA |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/using-elb-listenerconfig-quickref.html)  | 
| Secure website or application using Elastic Load Balancing to offload SSL decryption | SSL | [SSL negotiation](elb-ssl-security-policy.md) | TCP | NA |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/using-elb-listenerconfig-quickref.html)  | 
| Secure website or application using end\-to\-end encryption with Elastic Load Balancing | SSL | [SSL negotiation](elb-ssl-security-policy.md) | SSL | Back\-end authentication |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/using-elb-listenerconfig-quickref.html)  | 