package com.example.apigateway.filter;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter; import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered; import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange; import reactor.core.publisher.Mono;
@Component
public class LoggingFilter implements GlobalFilter, Ordered {
 private static final Logger log=LoggerFactory.getLogger(LoggingFilter.class);
 public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
  String method=exchange.getRequest().getMethod().name();
  String path=exchange.getRequest().getURI().getPath();
  log.info("Incoming request: {} {}",method,path);
  return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("Completed request: {} {} -> {}",method,path,exchange.getResponse().getStatusCode())));
 }
 public int getOrder(){ return -1; }
}