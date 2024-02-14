package maria.anikina.logging;

import lombok.extern.slf4j.Slf4j;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Around("@annotation(Logging)")
	public Object executeOnAnyMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String nameMethod = proceedingJoinPoint.getSignature().getName();
		String nameClass = proceedingJoinPoint.getClass().getSimpleName();
		log.info("Метод " + nameMethod + " класса " + nameClass + " готов начать свою работу");
		Object result;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			log.warn("В методе " + nameMethod + " класса " + nameClass +
					" во время работы возникло исключение" + e.getMessage());
			throw e;
		}
		log.info("Метод " + nameMethod + " класса " + nameClass + " успешно завершил свою работу");
		return result;
	}
}
