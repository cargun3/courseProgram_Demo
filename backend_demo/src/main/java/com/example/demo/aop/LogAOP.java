package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {

	private static final Logger logger = LoggerFactory.getLogger(LogAOP.class);
	private static String type = "";
	
	@Before("execution(* com..*Controller.*(..)) or "
			+ "execution(* com..*Service.*(..))")
	public void before(JoinPoint j) {
		type = j.getSignature().getDeclaringTypeName();
        if (type.indexOf("Controller") > -1) {
    		logger.info("===========================================\trestAPI Controller ����\t=====================================");
        }else if (type.indexOf("Service") > -1) {
            logger.info("===========================================\trestAPI Service ����\t=====================================");
        }
		logger.info(j.getTarget()+"");
		logger.info("Method:\t"+j.getSignature().getName());
		Object args[] = j.getArgs();
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				logger.info(i+" ��° �� :\t"+args[i]);
			}
		}
	}

}
